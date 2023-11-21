package com.belajar.spring;

import com.belajar.spring.data.Car;
import com.belajar.spring.processor.IdGeneratorBeanPostProcessor;
import com.belajar.spring.processor.PrefixIdGeneratorBeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        Car.class,
        PrefixIdGeneratorBeanPostProcessor.class,
        IdGeneratorBeanPostProcessor.class
})
public class OrderedConfiguration {
}
