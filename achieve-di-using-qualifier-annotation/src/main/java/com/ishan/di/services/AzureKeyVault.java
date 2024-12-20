package com.ishan.di.services;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service("azurekvimpl")
public class AzureKeyVault implements IKeyVault {
    private final Map<String, String> container;

    public AzureKeyVault() {
        this.container = new TreeMap<>();
    }

    @Override
    public void saveSecret(String secretName, String secretValue) {
        container.put(secretName, secretValue);
    }

    @Override
    public String retrieveSecret(String secretName) {
        return container.get(secretName);
    }
}