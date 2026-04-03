package fr.esgi.avis.application.usecases;

import fr.esgi.avis.application.dto.in.JoueurDtoIn;
import fr.esgi.avis.application.dto.out.JoueurDtoOut;
import fr.esgi.avis.application.ports.out.JoueurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthJoueurServiceTest {

    @Mock
    private JoueurRepository joueurRepository;

    @InjectMocks
    private AuthJoueurService authJoueurService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginJoueurSuccess() {
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
        when(joueurRepository.findByPseudo("AliceGamer"))
            .thenReturn(Optional.of(joueurDtoOut));

        // When
        Optional<JoueurDtoOut> result = authJoueurService.loginJoueur("AliceGamer", "motDePasse");

        // Then
        assertTrue(result.isPresent());
        assertEquals("AliceGamer", result.get().pseudo());
        assertEquals("alice@example.com", result.get().email());
        verify(joueurRepository, times(1)).findByPseudo("AliceGamer");
    }

    @Test
    void testLoginJoueurIncorrectPassword() {
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
        when(joueurRepository.findByPseudo("AliceGamer"))
            .thenReturn(Optional.of(joueurDtoOut));

        // When
        Optional<JoueurDtoOut> result = authJoueurService.loginJoueur("AliceGamer", "wrongPassword");

        // Then
        assertFalse(result.isPresent());
        verify(joueurRepository, times(1)).findByPseudo("AliceGamer");
    }

    @Test
    void testLoginJoueurNotFound() {
        // Given
        when(joueurRepository.findByPseudo("UnknownJoueur"))
            .thenReturn(Optional.empty());

        // When
        Optional<JoueurDtoOut> result = authJoueurService.loginJoueur("UnknownJoueur", "anyPassword");

        // Then
        assertFalse(result.isPresent());
        verify(joueurRepository, times(1)).findByPseudo("UnknownJoueur");
    }

    @Test
    void testRegisterJoueurSuccess() {
        // Given
        JoueurDtoIn joueurDtoIn = new JoueurDtoIn(
            null,
            LocalDate.of(1990, 10, 20),
            "newPassword",
            "BobPlayer",
            "bob@example.com"
        );
        when(joueurRepository.findByPseudo("BobPlayer")).thenReturn(Optional.empty());
        when(joueurRepository.findByEmail("bob@example.com")).thenReturn(Optional.empty());
        when(joueurRepository.save(any(JoueurDtoOut.class)))
            .thenAnswer(invocation -> invocation.getArgument(0));

        // When
        JoueurDtoOut result = authJoueurService.registerJoueur(joueurDtoIn);

        // Then
        assertNotNull(result);
        assertEquals("BobPlayer", result.pseudo());
        assertEquals("bob@example.com", result.email());
        verify(joueurRepository, times(1)).findByPseudo("BobPlayer");
        verify(joueurRepository, times(1)).findByEmail("bob@example.com");
        verify(joueurRepository, times(1)).save(any(JoueurDtoOut.class));
    }

    @Test
    void testRegisterJoueurPseudoAlreadyExists() {
        // Given
        JoueurDtoIn joueurDtoIn = new JoueurDtoIn(
            null,
            LocalDate.of(1990, 10, 20),
            "password",
            "ExistingPseudo",
            "new@example.com"
        );
        JoueurDtoOut existingJoueur = new JoueurDtoOut(
            1L,
            LocalDate.of(1995, 5, 15),
            List.of(),
            null,
            "password",
            "ExistingPseudo",
            "existing@example.com"
        );
        when(joueurRepository.findByPseudo("ExistingPseudo"))
            .thenReturn(Optional.of(existingJoueur));

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            authJoueurService.registerJoueur(joueurDtoIn);
        });
        verify(joueurRepository, times(1)).findByPseudo("ExistingPseudo");
        verify(joueurRepository, never()).save(any());
    }

    @Test
    void testRegisterJoueurEmailAlreadyExists() {
        // Given
        JoueurDtoIn joueurDtoIn = new JoueurDtoIn(
            null,
            LocalDate.of(1990, 10, 20),
            "password",
            "NewPseudo",
            "existing@example.com"
        );
        JoueurDtoOut existingJoueur = new JoueurDtoOut(
            1L,
            LocalDate.of(1995, 5, 15),
            List.of(),
            null,
            "password",
            "OldPseudo",
            "existing@example.com"
        );
        when(joueurRepository.findByPseudo("NewPseudo")).thenReturn(Optional.empty());
        when(joueurRepository.findByEmail("existing@example.com"))
            .thenReturn(Optional.of(existingJoueur));

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            authJoueurService.registerJoueur(joueurDtoIn);
        });
        verify(joueurRepository, times(1)).findByPseudo("NewPseudo");
        verify(joueurRepository, times(1)).findByEmail("existing@example.com");
        verify(joueurRepository, never()).save(any());
    }
}

