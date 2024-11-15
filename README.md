Guice JUnit
==========
TODO Guice & JUnit 5

Installation
------------
With Maven:
```xml
<dependency>
  <groupId>com.coreoz</groupId>
  <artifactId>guice-junit</artifactId>
  <version>1.0.0</version>
</dependency>
```

Getting started
---------------
Declare a Guice module dedicated for tests, or use an existing module:
```java
public class SampleModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Clock.class).toInstance(Clock.systemDefaultZone());
    }
}
```

Make a JUnit test inject module members:
```java
@GuiceTest(SampleModule.class)
class SampleTest {
    @Inject
    Clock clock;

    @Test
    public void verify_that_clock_object_is_injected() {
        Assertions.assertThat(clock).isNotNull();
    }
}
```
