package fr.esgi.avis.adapter.controllers;

import fr.esgi.avis.adapter.controllers.dto.ModerateurAuthResponse;
import fr.esgi.avis.application.dto.in.ModerateurDtoIn;
import fr.esgi.avis.application.dto.out.ModerateurDtoOut;
import fr.esgi.avis.application.ports.in.AuthModerateurUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ModerateurAuthControllerTest {

    @Mock
    private AuthModerateurUseCase authModerateurUseCase;

    @InjectMocks
    private ModerateurAuthController moderateurAuthController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginSuccess() {
        // Given
        ModerateurDtoOut moderateurDtoOut = new ModerateurDtoOut(
            "0123456789",
            1L,
            "motDePasse",
            "ModAdmin",
            "mod@avis.com"
        );
        when(authModerateurUseCase.loginModerateur("ModAdmin", "motDePasse"))
            .thenReturn(Optional.of(moderateurDtoOut));

        // When
        ResponseEntity<?> result = moderateurAuthController.login("ModAdmin", "motDePasse");

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        verify(authModerateurUseCase, times(1)).loginModerateur("ModAdmin", "motDePasse");
    }

    @Test
    void testLoginFailure() {
        // Given
        when(authModerateurUseCase.loginModerateur("InvalidPseudo", "wrongPassword"))
            .thenReturn(Optional.empty());

        // When
        ResponseEntity<?> result = moderateurAuthController.login("InvalidPseudo", "wrongPassword");

        // Then
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
        verify(authModerateurUseCase, times(1)).loginModerateur("InvalidPseudo", "wrongPassword");
    }

    @Test
    void testRegisterSuccess() {
        // Given
        ModerateurDtoIn moderateurDtoIn = new ModerateurDtoIn(
            "0123456789",
            "motDePasse",
            "NewMod",
            "newmod@avis.com"
        );
        ModerateurDtoOut moderateurDtoOut = new ModerateurDtoOut(
            "0123456789",
            2L,
            "motDePasse",
            "NewMod",
            "newmod@avis.com"
        );
        when(authModerateurUseCase.registerModerateur(moderateurDtoIn))
            .thenReturn(moderateurDtoOut);

        // When
        ResponseEntity<?> result = moderateurAuthController.register(moderateurDtoIn);

        // Then
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertNotNull(result.getBody());
        verify(authModerateurUseCase, times(1)).registerModerateur(moderateurDtoIn);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme