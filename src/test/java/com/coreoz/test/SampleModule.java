package com.coreoz.test;

import com.coreoz.test.cache.SampleServiceCached;
import com.google.inject.AbstractModule;

import java.time.Clock;

public class SampleModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Clock.class).toInstance(Clock.systemDefaultZone());
        bind(SampleServiceCached.class);
    }
}
