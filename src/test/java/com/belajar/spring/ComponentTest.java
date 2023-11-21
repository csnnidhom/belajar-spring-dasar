package com.belajar.spring;

import com.belajar.spring.data.MultiFoo;
import com.belajar.spring.repository.CategoryRepository;
import com.belajar.spring.repository.CustomerRepository;
import com.belajar.spring.repository.ProductRepository;
import com.belajar.spring.service.CategoryService;
import com.belajar.spring.service.CustomerService;
import com.belajar.spring.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testComponent(){
        ProductService productService1 = applicationContext.getBean(ProductService.class);
        ProductService productService2 = applicationContext.getBean("productService",ProductService.class);

        Assertions.assertSame(productService1, productService2);
    }

    @Test
    void testConstructorDependencyInjection(){
        ProductService productService = applicationContext.getBean(ProductService.class);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

        Assertions.assertSame(productRepository, productService.getProductRepository());
    }
    @Test
    void testSetterDependencyInjection(){
        CategoryRepository categoryRepository = applicationContext.getBean(CategoryRepository.class);
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);

        Assertions.assertSame(categoryRepository, categoryService.getCategoryRepository());

    }

    @Test
    void testFieldDependencyIjection(){
        CustomerRepository normalCustomerRepository = applicationContext.getBean("normalCustomerRepository",CustomerRepository.class);
        CustomerRepository premiumCustomerRepository = applicationContext.getBean("premiumCustomerRepository",CustomerRepository.class);

        CustomerService customerService = applicationContext.getBean(CustomerService.class);

        Assertions.assertSame(normalCustomerRepository, customerService.getNormalCustomerRepository());
        Assertions.assertSame(premiumCustomerRepository, customerService.getPremiumCustomerRepository());
    }


    @Test
    void testObjectrovider() {
        MultiFoo multiFoo = applicationContext.getBean(MultiFoo.class);

        Assertions.assertEquals(3, multiFoo.getFoos().size());
    }
}
