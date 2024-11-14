package com.coreoz.test;

import com.google.inject.AbstractModule;

import java.time.Clock;

public class SampleModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Clock.class).toInstance(Clock.systemDefaultZone());
        bind(SampleService.class);
    }
}
