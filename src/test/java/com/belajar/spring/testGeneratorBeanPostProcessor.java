package com.belajar.spring;

import com.belajar.spring.data.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testGeneratorBeanPostProcessor {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(GeneratorBeanPostProcessorConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testGenerator() {
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car.getId());
        Assertions.assertNotNull(car.getId());
    }
}
