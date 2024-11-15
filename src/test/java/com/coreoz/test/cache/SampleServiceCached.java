package com.coreoz.test.cache;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class SampleServiceCached {
    static int creationCount = 0;

    @Inject
    public SampleServiceCached() {
        creationCount += 1;
    }
}
