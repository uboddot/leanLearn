package com.leanlearn.backend.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VociServiceTest {

    @Autowired
    private VociService vociService;

    @Test
    void basicServiceTest() {
        assertTrue(vociService.getAllWords().size() == 2);
    }

}
