/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lis.domain;
import org.springframework.stereotype.Component;
import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Component public class DomainCatalog {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String systemName(){return "知华 LIS 实验室检验协同平台";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String sceneName(){return "样本、检验、质控与报告时效";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public List<SeedItem> seedItems(){return List.of(
        new SeedItem("LIS-20260801-001","急诊生化批次优先检验","处理中","生化检验组","紧急"),
        new SeedItem("LIS-20260801-002","危急值结果双人复核","待处理","审核发布组","高"),
        new SeedItem("LIS-20260801-003","血常规室内质控复盘","已完成","质量管理组","中"),
        new SeedItem("LIS-20260801-004","外送样本物流跟踪","处理中","样本服务组","高"));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public List<String> recommendedActions(){return List.of("优先处理急诊与临床标记样本","复核危急值通知闭环与接收记录","检查质控偏差和样本链路完整性");}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record SeedItem(String recordNo,String title,String status,String owner,String priority){}
}
