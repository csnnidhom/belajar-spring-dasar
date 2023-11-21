package com.belajar.spring;

import com.belajar.spring.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({
        "com.belajar.spring.service",
        "com.belajar.spring.repository",
        "com.belajar.spring.configuration"
})

@Import(MultiFoo.class)
public class ComponentConfiguration {
}
