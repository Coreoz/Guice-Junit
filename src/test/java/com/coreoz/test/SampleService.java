package com.coreoz.test;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class SampleService {
    private static int count = 0;

    @Inject
    public SampleService() {
        SampleService.count++;
    }
}
