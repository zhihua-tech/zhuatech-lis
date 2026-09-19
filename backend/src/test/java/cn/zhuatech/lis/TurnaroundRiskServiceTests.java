/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lis;import cn.zhuatech.lis.service.TurnaroundRiskService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class TurnaroundRiskServiceTests{private final TurnaroundRiskService s=new TurnaroundRiskService();/**
                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                    */
@Test void escalatesCriticalLateTest(){var r=s.forecast(new TurnaroundRiskService.Request("S1",40,60,20,5,1,true,true));assertEquals("CRITICAL",r.status());}/**
                                                                                                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                 */
@Test void keepsFastQueueOnTime(){var r=s.forecast(new TurnaroundRiskService.Request("S2",5,60,2,5,2,true,false));assertEquals("ON_TIME",r.status());}}
