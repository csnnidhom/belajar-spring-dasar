package com.belajar.spring.aplication;

import com.belajar.spring.data.Bar;
import com.belajar.spring.data.Foo;
import com.belajar.spring.listener.AppStartingListener;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FooAplication {

    @Bean
    public Foo foo(){
        return new Foo();
    }

//    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooAplication.class);
//
//        Foo foo = applicationContext.getBean(Foo.class);
//        System.out.println(foo);
//    }

//    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(FooAplication.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
//        springApplication.setListeners(List.of(new AppStartingListener()));
//
//        ConfigurableApplicationContext applicationContext = springApplication.run(args);
//
//        Foo foo = applicationContext.getBean(Foo.class);
//        System.out.println(foo);
//
//    }
}
