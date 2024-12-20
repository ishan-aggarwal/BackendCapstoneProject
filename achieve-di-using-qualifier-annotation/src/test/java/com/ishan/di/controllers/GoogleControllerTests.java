package com.ishan.di.controllers;

import com.ishan.di.dtos.SecretDto;
import com.ishan.di.services.GoogleKeyVault;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class GoogleControllerTests {

    @Autowired
    private GoogleController googleController;

    @MockitoBean
    private GoogleKeyVault googleKeyVault;


    @Test
    @DisplayName("Testcase to check if you are doing DI using IKeyVault only and not by adding GoogleKeyVault in GoogleController")
    public void testStoreSecretThroughGoogleController() {
        // Arrange
        SecretDto secretDto = new SecretDto();
        secretDto.setName("testName");
        secretDto.setValue("testValue");

        // Act
        googleController.storeSecret(secretDto);

        // Assert
        verify(googleKeyVault, times(0)).saveSecret("secretName", "secretValue");
    }
}