package com.coreoz.test.cache;

import com.coreoz.test.GuiceTest;
import com.coreoz.test.SampleModule;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@GuiceTest(SampleModule.class)
public class GuiceWithCacheBTest {
    @Inject
    SampleServiceCached sampleService;

    @Test
    public void verify_that_cache_service_instance_is_reused() {
        Assertions.assertThat(sampleService).isNotNull();
        Assertions.assertThat(SampleServiceCached.creationCount).isEqualTo(1);
    }
}
