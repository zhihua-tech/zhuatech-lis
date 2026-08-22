/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lis.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CriticalResultService {
    public EscalationResult evaluate(EscalationRequest request) {
        int score = request.resultSeverity() * 15
            + (request.acknowledged() ? 0 : 20)
            + Math.min(20, request.minutesSinceVerified() / 10)
            + (request.repeatConfirmed() ? 10 : 0)
            + ("ER".equals(request.patientLocation()) ? 10 : 0)
            + (request.clinicianReached() ? 0 : 20);
        score = Math.min(100, score);
        String status = score >= 80 ? "CRITICAL_ESCALATION"
            : score >= 50 ? "URGENT_NOTIFY" : "ROUTINE_FOLLOWUP";
        int escalationLevel = score >= 80 ? 3 : score >= 50 ? 2 : 1;
        List<String> actions = new ArrayList<>();
        if (!request.clinicianReached()) actions.add("升级联系科室二线与医疗总值班");
        if (!request.acknowledged()) actions.add("持续追踪临床确认并记录通知时间线");
        if (!request.repeatConfirmed() && request.resultSeverity() >= 4) actions.add("按检验规则完成复测或标本核验");
        if (actions.isEmpty()) actions.add("完成危急值闭环登记并进入质量回顾");
        return new EscalationResult(score, escalationLevel, status, actions);
    }

    public record EscalationRequest(@NotNull @Min(1) @Max(5) Integer resultSeverity,
        @NotNull Boolean acknowledged, @NotNull @Min(0) @Max(10000) Integer minutesSinceVerified,
        @NotNull Boolean repeatConfirmed,
        @NotNull @Pattern(regexp = "ER|INPATIENT|OUTPATIENT") String patientLocation,
        @NotNull Boolean clinicianReached) {}
    public record EscalationResult(int score, int escalationLevel, String status, List<String> actions) {}
}
