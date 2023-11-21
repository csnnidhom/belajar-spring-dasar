package com.belajar.spring.profileproperties;

import com.belajar.spring.profile.ProfileTest;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfilePropertiesTest.TestApplication.class)
@ActiveProfiles({
        "test", "production"
})
public class ProfilePropertiesTest {

    @Autowired
    private TestApplication.ProfilProperties properties;

    @Test
    void testProfileTest() {
        Assertions.assertEquals("Default", properties.getDefaultFile());
        Assertions.assertEquals("Test", properties.getTestFile());
        Assertions.assertEquals("Production", properties.getProductionFile());
    }

    @SpringBootApplication
    public static class TestApplication{

        @Getter
        @Component
        public static class ProfilProperties{
            @Value("${profile.default}")
            private String defaultFile;

            @Value("${profile.test}")
            private String testFile;

            @Value("${profile.production}")
            private String productionFile;
        }

    }

}
