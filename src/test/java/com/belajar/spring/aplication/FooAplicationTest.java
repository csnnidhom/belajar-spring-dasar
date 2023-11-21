package com.belajar.spring.aplication;

import com.belajar.spring.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FooAplication.class)
class FooAplicationTest {

    @Autowired
    Foo foo;

    @Test
    void testSpringBoot() {
        Assertions.assertNotNull(foo);
    }
}