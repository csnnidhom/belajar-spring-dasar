package com.belajar.spring;

import com.belajar.spring.data.Bar;
import com.belajar.spring.data.Foo;
import com.belajar.spring.data.FooBar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Slf4j
@Configuration
public class DependsOnConfigration {
    @Lazy
    @Bean
    @DependsOn({
            "bar"
    })
    public Foo foo(){
        log.info("Create new Foo");
        return new Foo();
    }

    @Bean
    public Bar bar(){
        log.info("Create new Bar");
        return new Bar();
    }

}
