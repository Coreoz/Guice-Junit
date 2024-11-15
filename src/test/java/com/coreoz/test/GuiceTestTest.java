package com.coreoz.test;

import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;

@GuiceTest(SampleModule.class)
class GuiceTestTest {
    @Inject
    Clock clock;

    @Test
    public void verify_that_clock_object_is_injected() {
        Assertions.assertThat(clock).isNotNull();
    }
}
