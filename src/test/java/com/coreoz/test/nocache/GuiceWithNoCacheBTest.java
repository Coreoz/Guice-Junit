package com.coreoz.test.nocache;

import com.coreoz.test.GuiceTest;
import com.coreoz.test.cache.SampleServiceCached;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@GuiceTest(value = NoCacheModule.class, cacheInjector = false)
public class GuiceWithNoCacheBTest {
    static int runCount = 0;

    @Inject
    SampleServiceNoCache sampleService;

    @Test
    public void verify_that_cache_service_instance_is_reused() {
        Assertions.assertThat(sampleService).isNotNull();
        if (GuiceWithNoCacheATest.runCount == 0) {
            Assertions.assertThat(SampleServiceNoCache.creationCount).isEqualTo(1);
        } else {
            Assertions.assertThat(SampleServiceNoCache.creationCount).isEqualTo(2);
        }
        runCount++;
    }
}
