package com.leanlearn.backend.controller;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

import com.leanlearn.backend.model.Voci;
import com.leanlearn.backend.services.VociService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureRestTestClient
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class VociControllerTest {

    private final RestTestClient restClient;

    VociControllerTest(RestTestClient restClient) {
        this.restClient = restClient;
    }

    @MockitoBean
    private VociService vociService;

    @Test
    void shouldReturnStatusOkAndJsonContentType() {

        when(vociService.getAllWords()).thenReturn(List.of(new Voci("a", "a")));

        restClient.get().uri("/api/voci")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .json("[{\"original\":\"a\",\"translation\":\"a\"}]");
    }

}
