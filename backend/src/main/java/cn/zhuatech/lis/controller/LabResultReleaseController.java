/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lis.controller;

import cn.zhuatech.lis.common.ApiResponse;
import cn.zhuatech.lis.service.LabResultReleaseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/lis")
public class LabResultReleaseController {
    private final LabResultReleaseService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LabResultReleaseController(LabResultReleaseService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/lab-result-release")
    public ApiResponse<LabResultReleaseService.Assessment> assess(
            @Valid @RequestBody LabResultReleaseService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
