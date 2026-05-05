package com.leanlearn.backend.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class VociServiceTest {

    private final VociService vociService;

    VociServiceTest(VociService vociService) {
        this.vociService = vociService;
    }

    @Test
    void basicServiceTest() {
        assertEquals(2, vociService.getAllWords().size());
    }

}
