package fr.esgi.avis.adapter.controllers;

import fr.esgi.avis.application.dto.in.JoueurDtoIn;
import fr.esgi.avis.application.dto.out.JoueurDtoOut;
import fr.esgi.avis.application.ports.in.AuthJoueurUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JoueurAuthControllerTest {

    @Mock
    private AuthJoueurUseCase authJoueurUseCase;

    @InjectMocks
    private JoueurAuthController joueurAuthController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginSuccess() {
        // Given
        JoueurDtoOut joueurDtoOut = new JoueurDtoOut(
            1L,
            LocalDate.of(1995, 5, 15),
            List.of(),
            null,
            "motDePasse",
            "AliceGamer",
            "alice@example.com"
        );
        when(authJoueurUseCase.loginJoueur("AliceGamer", "motDePasse"))
            .thenReturn(Optional.of(joueurDtoOut));

        // When
        ResponseEntity<?> result = joueurAuthController.login("AliceGamer", "motDePasse");

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        verify(authJoueurUseCase, times(1)).loginJoueur("AliceGamer", "motDePasse");
    }

    @Test
    void testLoginFailure() {
        // Given
        when(authJoueurUseCase.loginJoueur("InvalidPseudo", "wrongPassword"))
            .thenReturn(Optional.empty());

        // When
        ResponseEntity<?> result = joueurAuthController.login("InvalidPseudo", "wrongPassword");

        // Then
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
        verify(authJoueurUseCase, times(1)).loginJoueur("InvalidPseudo", "wrongPassword");
    }

    @Test
    void testRegisterSuccess() {
        // Given
        JoueurDtoIn joueurDtoIn = new JoueurDtoIn(
            null,
            LocalDate.of(1990, 10, 20),
            "motDePasse",
            "BobPlayer",
            "bob@example.com"
        );
        JoueurDtoOut joueurDtoOut = new JoueurDtoOut(
            2L,
            LocalDate.of(1990, 10, 20),
            List.of(),
            null,
            "motDePasse",
            "BobPlayer",
            "bob@example.com"
        );
        when(authJoueurUseCase.registerJoueur(joueurDtoIn))
            .thenReturn(joueurDtoOut);

        // When
        ResponseEntity<?> result = joueurAuthController.register(joueurDtoIn);

        // Then
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertNotNull(result.getBody());
        verify(authJoueurUseCase, times(1)).registerJoueur(joueurDtoIn);
    }
}
