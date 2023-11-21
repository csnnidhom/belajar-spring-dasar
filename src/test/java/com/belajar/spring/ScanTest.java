package com.belajar.spring;

import com.belajar.spring.data.Bar;
import com.belajar.spring.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScanTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ScanConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testScan(){
        Foo foo = applicationContext.getBean(Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);
    }
}
