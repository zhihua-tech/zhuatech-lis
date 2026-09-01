/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lis.controller;

import cn.zhuatech.lis.common.ApiResponse;
import cn.zhuatech.lis.service.LabResultReleaseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/lis")
public class LabResultReleaseController {
    private final LabResultReleaseService service;
    public LabResultReleaseController(LabResultReleaseService service) { this.service = service; }
    @PostMapping("/lab-result-release")
    public ApiResponse<LabResultReleaseService.Assessment> assess(
            @Valid @RequestBody LabResultReleaseService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
