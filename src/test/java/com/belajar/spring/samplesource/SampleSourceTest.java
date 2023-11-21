package com.belajar.spring.samplesource;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = SampleSourceTest.Application.class)
public class SampleSourceTest {

    @Autowired
    private Application.SampleResource sampleResource;

    @Test
    void testSampleSource() {
        Assertions.assertEquals("property source", sampleResource.getName());
        Assertions.assertEquals(1,sampleResource.getVersion());
    }

    @SpringBootApplication
    @PropertySources({
            @PropertySource("classpath:/sample.properties")
    })
    public static class Application{

        @Component
        @Getter
        public static class SampleResource{
            @Value("${sample.name}")
            private String name;

            @Value("${sample.version}")
            private Integer version;
        }

    }

}
