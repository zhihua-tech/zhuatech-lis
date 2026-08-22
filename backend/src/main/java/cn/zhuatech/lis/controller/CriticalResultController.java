/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lis.controller;

import cn.zhuatech.lis.common.ApiResponse;
import cn.zhuatech.lis.service.CriticalResultService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/critical-result")
public class CriticalResultController {
    private final CriticalResultService service;
    public CriticalResultController(CriticalResultService service) { this.service = service; }
    @PostMapping
    ApiResponse<CriticalResultService.EscalationResult> evaluate(
        @Valid @RequestBody CriticalResultService.EscalationRequest request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
