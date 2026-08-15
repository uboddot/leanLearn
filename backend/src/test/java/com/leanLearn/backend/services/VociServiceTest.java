package com.leanLearn.backend.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.leanLearn.backend.model.Voci;
import com.leanLearn.backend.repository.VociRepository;

@ExtendWith(MockitoExtension.class)
class VociServiceTest {

    @Mock
    private VociRepository vociRepository;

    @Test
    void basicServiceTest() {
        when(vociRepository.findAll()).thenReturn(List.of(new Voci("danke", "kiitos"), new Voci("ich", "minä")));

        VociService vociService = new VociService(vociRepository);

        assertEquals(2, vociService.getAllWords().size());
    }

}
