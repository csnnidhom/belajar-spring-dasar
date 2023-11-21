package com.belajar.spring.aplication;

import com.belajar.spring.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WithoutSpringBootTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(FooAplication.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testWithoutSpringBoot() {
        Foo foo = applicationContext.getBean(Foo.class);

    }
}
