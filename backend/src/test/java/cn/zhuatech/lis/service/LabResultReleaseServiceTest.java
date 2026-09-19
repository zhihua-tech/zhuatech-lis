/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lis.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class LabResultReleaseServiceTest {
    private final LabResultReleaseService service = new LabResultReleaseService();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void releasesControlledResult() {
        var result = service.assess(new LabResultReleaseService.Request("L1", true, true, true, true,
                true, true, true, true, true, true, true, true));
        assertThat(result.decision()).isEqualTo(LabResultReleaseService.Decision.RELEASE);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void reviewsDeltaAndCorrectionGaps() {
        var result = service.assess(new LabResultReleaseService.Request("L2", true, true, true, true,
                false, true, false, false, false, false, false, false));
        assertThat(result.actions()).hasSize(2);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksUnsafeResult() {
        var result = service.assess(new LabResultReleaseService.Request("L3", false, false, false, false,
                true, false, true, false, false, true, false, true));
        assertThat(result.blockers()).hasSize(8);
    }
}
