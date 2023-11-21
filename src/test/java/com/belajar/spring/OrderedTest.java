package com.belajar.spring;

import com.belajar.spring.data.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderedTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(OrderedConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testCar() {
        Car car = applicationContext.getBean(Car.class);

        Assertions.assertNotNull(car.getId());
        Assertions.assertTrue(car.getId().startsWith("PZN-"));
    }
}
