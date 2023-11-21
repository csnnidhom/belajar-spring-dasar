package com.belajar.spring;

import com.belajar.spring.configuration.BarConfiguration;
import com.belajar.spring.configuration.FooConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        FooConfiguration.class,
        BarConfiguration.class
})
public class MainConfiguration {
}
