package com.coreoz.test;

import com.google.inject.Injector;
import com.google.inject.Module;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark a JUnit 5 test class for Guice injection using the method {@link Injector#injectMembers}.
 * The annotation interpretation will be performed by {@link GuiceTestRunner}.<br>
 * <br>
 * Usage:
 * <pre>
 * &#064;GuiceTest(GuiceModule.class)
 * public class MyTest {
 *     &#064;Inject
 *     private Service service;
 *
 *     &#064;Test
 *     public void test_something() {
 *         Assertions.assertThat(service).isNotNull();
 *     }
 * }
 * </pre>
 */
@ExtendWith(GuiceTestRunner.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface GuiceTest {
    /**
     * The Guice modules needed to execute the tests
     */
    Class<? extends Module>[] value();
    /**
     * If the injector created for the modules should be reused in other tests (or use the already created injector). Default <code>true</code>, so by default, the injector will be reused for each test using the same modules. This enables better performance to run the tests since the injector (and all the required injectable classes) will not be created for each test.
     */
    boolean cacheInjector() default true;
}
