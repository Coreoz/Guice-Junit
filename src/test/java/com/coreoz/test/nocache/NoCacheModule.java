package com.coreoz.test.nocache;

import com.google.inject.AbstractModule;

public class NoCacheModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SampleServiceNoCache.class);
    }
}
