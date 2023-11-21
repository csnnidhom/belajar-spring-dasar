package configurationproperties;

import com.belajar.spring.converter.StringToDateConverter;
import com.belajar.spring.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class )
public class ConfigurationPropertiesTest {

    @Autowired
    private ApplicationProperties properties;

    @Autowired
    private ConversionService conversionService;

    @Test
    void testConversionService() {
        Assertions.assertTrue(conversionService.canConvert(String.class, Date.class));
        Assertions.assertTrue(conversionService.canConvert(String.class, Date.class));

        Duration result = conversionService.convert("10s", Duration.class);
        Assertions.assertEquals(Duration.ofSeconds(10), result);
    }

    @Test
    void testConfigurationProperties() {
        Assertions.assertEquals("Belajar Spring Boot", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.isProductionMode());
    }

    @Test
    void testDatabaseProperties() {
        Assertions.assertEquals("nidhom", properties.getDatabase().getUsername());
        Assertions.assertEquals("rahasia", properties.getDatabase().getPassword());
        Assertions.assertEquals("belajar", properties.getDatabase().getDatabase());
        Assertions.assertEquals("jdbc:contoh", properties.getDatabase().getUrl());
    }

    @Test
    void testCollectionProperties() {
        Assertions.assertEquals(Arrays.asList("products","customers","categories"), properties.getDatabase().getWhiteListTable());
        Assertions.assertEquals(100, properties.getDatabase().getMaxTableSize().get("products"));
        Assertions.assertEquals(100, properties.getDatabase().getMaxTableSize().get("customers"));
        Assertions.assertEquals(100,properties.getDatabase().getMaxTableSize().get("categories"));
    }

    @Test
    void testEmbededCollection() {
        Assertions.assertEquals("default", properties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("default role", properties.getDefaultRoles().get(0).getName());
        Assertions.assertEquals("guest", properties.getDefaultRoles().get(1).getId());
        Assertions.assertEquals("guest role", properties.getDefaultRoles().get(1).getName());

        Assertions.assertEquals("admin", properties.getRoles().get("admin").getId());
        Assertions.assertEquals("admin role", properties.getRoles().get("admin").getName());
        Assertions.assertEquals("finance", properties.getRoles().get("finance").getId());
        Assertions.assertEquals("finance role", properties.getRoles().get("finance").getName());
    }

    @Test
    void testDuration() {
        Assertions.assertEquals(Duration.ofSeconds(10), properties.getDefaultTimeOut());
    }

    @Test
    void testCustomConverter() {
        Date expireDate = properties.getExpireDate();

        var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Assertions.assertEquals("2023-09-11", dateFormat.format(expireDate));
    }

    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    @Import(StringToDateConverter.class)
    public static class TestApplication{

        @Bean
        public ConversionService conversionService(StringToDateConverter stringToDateConverter){
            ApplicationConversionService conversionService = new ApplicationConversionService();
            conversionService.addConverter(stringToDateConverter);
            return conversionService;
        }

    }
}
