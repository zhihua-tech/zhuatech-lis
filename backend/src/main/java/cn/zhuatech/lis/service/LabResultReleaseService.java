/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lis.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class LabResultReleaseService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.patientAndSpecimenMatched()) blockers.add("患者与标本身份不匹配");
        if (!request.specimenChainOfCustodyComplete()) blockers.add("标本接收与流转链不完整");
        if (!request.analyzerQcPassed()) blockers.add("分析仪质量控制未通过");
        if (!request.calibrationCurrent()) blockers.add("校准状态已过期");
        if (!request.unitsAndReferenceRangeValidated()) blockers.add("单位或参考区间未验证");
        if (request.criticalResult() && !request.criticalNotificationCompleted()) blockers.add("危急结果未完成通知");
        if (request.criticalResult() && !request.criticalNotificationAcknowledged()) blockers.add("危急结果通知未确认");
        if (request.specialistReviewRequired() && !request.specialistReviewCompleted()) blockers.add("专科复核未完成");
        if (!blockers.isEmpty()) {
            actions.add("阻断结果发布并关闭标本、质控或患者安全缺口");
            return new Assessment(Decision.BLOCKED, blockers, actions);
        }
        if (!request.deltaCheckResolved() || !request.correctedResultAuditReady()) {
            if (!request.deltaCheckResolved()) actions.add("完成历史结果差异复核");
            if (!request.correctedResultAuditReady()) actions.add("启用更正结果通知和版本追溯");
            return new Assessment(Decision.REVIEW, blockers, actions);
        }
        actions.add("发布检验结果并归档质控、复核、通知和版本证据");
        return new Assessment(Decision.RELEASE, blockers, actions);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String accessionId, boolean patientAndSpecimenMatched,
                          boolean specimenChainOfCustodyComplete, boolean analyzerQcPassed,
                          boolean calibrationCurrent, boolean deltaCheckResolved,
                          boolean unitsAndReferenceRangeValidated, boolean criticalResult,
                          boolean criticalNotificationCompleted, boolean criticalNotificationAcknowledged,
                          boolean specialistReviewRequired, boolean specialistReviewCompleted,
                          boolean correctedResultAuditReady) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Assessment(Decision decision, List<String> blockers, List<String> actions) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Decision { RELEASE, REVIEW, BLOCKED }
}
