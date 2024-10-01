package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "identity")
public class IdentityProperties {

    private Map<String, Boolean> database;

    public Map<String, Boolean> getDatabase() {
        return database;
    }

    public void setDatabase(Map<String, Boolean> database) {
        this.database = database;
    }
}
