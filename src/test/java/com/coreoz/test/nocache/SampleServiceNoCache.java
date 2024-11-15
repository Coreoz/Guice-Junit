package com.coreoz.test.nocache;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class SampleServiceNoCache {
    static int creationCount = 0;

    @Inject
    public SampleServiceNoCache() {
        creationCount += 1;
    }
}
