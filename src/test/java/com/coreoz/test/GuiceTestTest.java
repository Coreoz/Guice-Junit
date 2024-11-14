package com.coreoz.test;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.*;

@GuiceTest(SampleModule.class)
class GuiceTestTest {
    @Inject
    Clock clock;

    @Test
    public void verify_that_clock_object_is_injected() {
        assertNotNull(clock);
    }
}
