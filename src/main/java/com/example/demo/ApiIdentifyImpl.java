package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ApiIdentifyImpl implements ApiIdentify {

    // Simulamos una base de datos de identidades con un mapa (HashMap)
    private final Map<String, Boolean> identityDatabase;

    // Constructor que inicializa la base de datos simulada
    public ApiIdentifyImpl() {
        identityDatabase = new HashMap<>();
        // Datos simulados, puedes modificar estos valores
        identityDatabase.put("12345678", true);  // CI válido
        identityDatabase.put("87654321", true);  // CI válido
        identityDatabase.put("99999999", false); // CI no válido
    }

    //Implementación del metodo de la interfaz ApiIdentify
    @Override
    public Boolean verify(String ci) {
        // Busca en la base de datos simulada si el CI existe
        return identityDatabase.getOrDefault(ci, false);
    }
}
