package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ApiIdentifyImpl implements ApiIdentify {

    private final Map<String, Boolean> identityDatabase;

    // Inyectamos la configuración desde IdentityProperties
    public ApiIdentifyImpl(IdentityProperties identityProperties) {
        this.identityDatabase = identityProperties.getDatabase();
    }

    @Override
    public Boolean verify(String ci) {
        // Busca en la base de datos simulada si el CI existe
        return identityDatabase.getOrDefault(ci, false);
    }
}
