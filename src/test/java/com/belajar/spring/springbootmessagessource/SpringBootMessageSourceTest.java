package com.belajar.spring.springbootmessagessource;

import com.belajar.spring.messageSource.MessageSourceTest;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringBootMessageSourceTest.TestAppplication.class)
public class SpringBootMessageSourceTest {

    @Autowired
    private TestAppplication.SampleResource sampleResource;

    @Test
    void testHelloNidhom() {
        Assertions.assertEquals("Hello Nidhom", sampleResource.helloNidhom(Locale.ENGLISH));
        Assertions.assertEquals("Halo Nidhom", sampleResource.helloNidhom(new Locale("in_ID")));
    }

    @SpringBootApplication
    public static class TestAppplication{

        @Component
        public static class SampleResource implements MessageSourceAware{

            @Setter
            private MessageSource messageSource;

            public String helloNidhom(Locale locale){
                return messageSource.getMessage("hello",new Object[]{"Nidhom"}, locale);
            }
        }

    }

}
