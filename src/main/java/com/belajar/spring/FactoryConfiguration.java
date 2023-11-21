package com.belajar.spring;

import com.belajar.spring.client.PaymentGatewayClient;
import com.belajar.spring.factory.PaymentGatewayClientFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        PaymentGatewayClientFactoryBean.class
})
public class FactoryConfiguration {

}
