package com.belajar.spring;

import com.belajar.spring.data.Foo;
import com.belajar.spring.processor.FooBeanFactoryPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

public class BeanFactoryPostProcessorTest {

    @Component
    @Import({
            FooBeanFactoryPostProcessor.class
    })
    public static class TestConfiguration{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testBeanFactoryPostProcessor() {
        Foo foo = applicationContext.getBean(Foo.class);

        Assertions.assertNotNull(foo);
    }
}
