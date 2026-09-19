/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lis.controller;import cn.zhuatech.lis.common.ApiResponse;import cn.zhuatech.lis.service.TurnaroundRiskService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/lis/insights/turnaround-risk") public class TurnaroundRiskController{private final TurnaroundRiskService service;/**
                                                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                        */
public TurnaroundRiskController(TurnaroundRiskService service){this.service=service;}/**
                                                                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                             */
@PostMapping ApiResponse<TurnaroundRiskService.Result> forecast(@Valid @RequestBody TurnaroundRiskService.Request r){return ApiResponse.ok(service.forecast(r));}}
