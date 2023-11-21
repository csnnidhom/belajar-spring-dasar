package com.belajar.spring;

import com.belajar.spring.data.User;
import com.belajar.spring.event.LoginSuccessEvent;
import com.belajar.spring.listener.LoginAgainSuccessListener;
import com.belajar.spring.listener.LoginSuccessListener;
import com.belajar.spring.listener.UserListener;
import com.belajar.spring.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class EventListenerTest {

    @Configuration
    @Import({
            UserService.class,
            LoginSuccessListener.class,
            LoginAgainSuccessListener.class,
            UserListener.class
    })
    public static class EventConfiguration{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(EventConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testEvent() {
        UserService userService = applicationContext.getBean(UserService.class);
        userService.login("nidhom", "nidhom");
        userService.login("nidhom", "salah");
        userService.login("chusnun", "salah");
    }
}
