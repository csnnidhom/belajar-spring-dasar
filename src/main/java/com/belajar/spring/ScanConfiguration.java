package com.belajar.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "com.belajar.spring.configuration"
})
public class ScanConfiguration {
}
