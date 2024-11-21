package com.coreoz.test;

import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.time.Clock;

@GuiceTest(SampleModule.class)
class GuiceTestTest {
    @Inject
    Clock clock;

    boolean beforeEachInjection = false;

    @BeforeEach
    public void before_test() throws NoSuchAlgorithmException {
        if (clock != null) {
            beforeEachInjection = true;
        }
    }

    @Test
    public void verify_that_clock_object_is_injected() {
        Assertions.assertThat(clock).isNotNull();
    }

    @Test
    public void verify_that_beforeEach_is_called_after_guice_injection() {
        Assertions.assertThat(beforeEachInjection).isTrue();
    }
}
