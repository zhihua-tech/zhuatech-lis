/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.lis.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LabResultReleaseServiceTest {
    private final LabResultReleaseService service = new LabResultReleaseService();
    @Test void releasesControlledResult() {
        var result = service.assess(new LabResultReleaseService.Request("L1", true, true, true, true,
                true, true, true, true, true, true, true, true));
        assertThat(result.decision()).isEqualTo(LabResultReleaseService.Decision.RELEASE);
    }
    @Test void reviewsDeltaAndCorrectionGaps() {
        var result = service.assess(new LabResultReleaseService.Request("L2", true, true, true, true,
                false, true, false, false, false, false, false, false));
        assertThat(result.actions()).hasSize(2);
    }
    @Test void blocksUnsafeResult() {
        var result = service.assess(new LabResultReleaseService.Request("L3", false, false, false, false,
                true, false, true, false, false, true, false, true));
        assertThat(result.blockers()).hasSize(8);
    }
}
