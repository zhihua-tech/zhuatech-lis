/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lis.controller;

import cn.zhuatech.lis.common.ApiResponse;
import cn.zhuatech.lis.service.CriticalResultService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/admin/critical-result")
public class CriticalResultController {
    private final CriticalResultService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public CriticalResultController(CriticalResultService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping
    ApiResponse<CriticalResultService.EscalationResult> evaluate(
        @Valid @RequestBody CriticalResultService.EscalationRequest request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
