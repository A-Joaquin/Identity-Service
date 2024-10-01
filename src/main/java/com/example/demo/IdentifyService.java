package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class IdentifyService {

    private final ApiIdentify apiIdentify;

    // Inyección del ApiIdentify
    public IdentifyService(ApiIdentify apiIdentify) {
        this.apiIdentify = apiIdentify;
    }

    // Modo que verifica si el CI existe usando el DTO
    public Boolean verifyIdentity(IdentifyRequestDto identifyRequestDto) {
        // Usamos el mtodo ci() del DTO para obtener el CI
        Boolean verifyResponse = apiIdentify.verify(identifyRequestDto.ci());
        return verifyResponse;
    }
}
