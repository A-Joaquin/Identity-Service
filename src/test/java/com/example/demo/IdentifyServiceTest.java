package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IdentifyServiceTest {

    private ApiIdentify apiIdentify;
    private IdentifyService identifyService;

    @BeforeEach
    void setUp() {
        // Crear un mock de ApiIdentify
        apiIdentify = Mockito.mock(ApiIdentify.class);

        // Inicializar IdentifyService con el mock de ApiIdentify
        identifyService = new IdentifyService(apiIdentify);
    }

    @Test
    void verifyIdentity_CIExists() {
        // Simular que el CI "12345678" existe
        IdentifyRequestDto requestDto = new IdentifyRequestDto("12345678");
        when(apiIdentify.verify(requestDto.ci())).thenReturn(true);

        // Ejecutar el mtodo y verificar que devuelve true
        assertTrue(identifyService.verifyIdentity(requestDto));

        // Verificar que el mtodo verify() de ApiIdentify fue llamado correctamente
        verify(apiIdentify).verify(requestDto.ci());
    }

    @Test
    void verifyIdentity_CIDoesNotExist() {
        // Simular que el CI "00000000" no existe
        IdentifyRequestDto requestDto = new IdentifyRequestDto("00000000");
        when(apiIdentify.verify(requestDto.ci())).thenReturn(false);

        // Ejecutar el mtodo y verificar que devuelve false
        assertFalse(identifyService.verifyIdentity(requestDto));

        // Verificar que el mtodo verify() de ApiIdentify fue llamado correctamente
        verify(apiIdentify).verify(requestDto.ci());
    }
}
