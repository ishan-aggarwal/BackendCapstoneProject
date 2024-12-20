package com.ishan.di.controllers;

import com.ishan.di.dtos.SecretDto;
import com.ishan.di.services.IKeyVault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/impl/api/google/secrets")
public class GoogleController {

    @Autowired
    @Qualifier("googlekvimpl")
    private IKeyVault keyVault;

    @PostMapping
    public void storeSecret(@RequestBody SecretDto secret) {
        keyVault.saveSecret(secret.getName(), secret.getValue());
    }

    @GetMapping("/{name}")
    public String getSecret(@PathVariable("name") String secretName) {
        return keyVault.retrieveSecret(secretName);
    }
}