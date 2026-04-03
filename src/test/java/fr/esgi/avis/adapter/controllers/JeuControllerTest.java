package fr.esgi.avis.adapter.controllers;

import fr.esgi.avis.application.dto.in.JeuDtoIn;
import fr.esgi.avis.application.dto.out.JeuDtoOut;
import fr.esgi.avis.application.ports.in.CreateJeuUseCase;
import fr.esgi.avis.application.ports.in.GetJeuxUseCase;
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

class JeuControllerTest {

    @Mock
    private GetJeuxUseCase getJeuxUseCase;

    @Mock
    private CreateJeuUseCase createJeuUseCase;

    @InjectMocks
    private JeuController jeuController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllJeux() {
        // Given
        List<JeuDtoOut> jeux = List.of(
            new JeuDtoOut(
                List.of(1L, 2L),
                1L,
                1L,
                "Assassin's Creed Valhalla",
                1L,
                LocalDate.of(2020, 11, 10),
                "Un jeu d'action-aventure",
                59.99f,
                4L,
                null
            )
        );
        when(getJeuxUseCase.getAllJeux()).thenReturn(jeux);

        // When
        ResponseEntity<List<JeuDtoOut>> result = jeuController.getAllJeux();

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(1, result.getBody().size());
        verify(getJeuxUseCase, times(1)).getAllJeux();
    }

    @Test
    void testGetJeuByIdSuccess() {
        // Given
        JeuDtoOut jeu = new JeuDtoOut(
            List.of(1L),
            1L,
            1L,
            "FIFA 23",
            2L,
            LocalDate.of(2022, 9, 30),
            "Jeu de football",
            49.99f,
            1L,
            null
        );
        when(getJeuxUseCase.getJeuById(1L)).thenReturn(Optional.of(jeu));

        // When
        ResponseEntity<JeuDtoOut> result = jeuController.getJeuById(1L);

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("FIFA 23", result.getBody().nom());
        verify(getJeuxUseCase, times(1)).getJeuById(1L);
    }

    @Test
    void testGetJeuByIdNotFound() {
        // Given
        when(getJeuxUseCase.getJeuById(999L)).thenReturn(Optional.empty());

        // When
        ResponseEntity<JeuDtoOut> result = jeuController.getJeuById(999L);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        verify(getJeuxUseCase, times(1)).getJeuById(999L);
    }

    @Test
    void testGetJeuxByEditeur() {
        // Given
        List<JeuDtoOut> jeux = List.of(
            new JeuDtoOut(
                List.of(1L, 2L, 3L),
                1L,
                1L,
                "Assassin's Creed Valhalla",
                1L,
                LocalDate.of(2020, 11, 10),
                "Un jeu d'action-aventure",
                59.99f,
                4L,
                null
            )
        );
        when(getJeuxUseCase.getJeuxByEditeur(1L)).thenReturn(jeux);

        // When
        ResponseEntity<List<JeuDtoOut>> result = jeuController.getJeuxByEditeur(1L);

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(1, result.getBody().size());
        verify(getJeuxUseCase, times(1)).getJeuxByEditeur(1L);
    }

    @Test
    void testGetJeuxByGenre() {
        // Given
        List<JeuDtoOut> jeux = List.of(
            new JeuDtoOut(
                List.of(1L),
                1L,
                1L,
                "FIFA 23",
                2L,
                LocalDate.of(2022, 9, 30),
                "Jeu de football",
                49.99f,
                1L,
                null
            )
        );
        when(getJeuxUseCase.getJeuxByGenre(4L)).thenReturn(jeux);

        // When
        ResponseEntity<List<JeuDtoOut>> result = jeuController.getJeuxByGenre(4L);

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(1, result.getBody().size());
        verify(getJeuxUseCase, times(1)).getJeuxByGenre(4L);
    }

    @Test
    void testCreateJeu() {
        // Given
        JeuDtoIn jeuDtoIn = new JeuDtoIn(
            List.of(1L, 2L),
            1L,
            "The Witcher 3",
            3L,
            LocalDate.of(2015, 5, 19),
            "RPG fantastique",
            29.99f,
            4L,
            null
        );
        JeuDtoOut jeuDtoOut = new JeuDtoOut(
            List.of(1L, 2L),
            3L,
            1L,
            "The Witcher 3",
            3L,
            LocalDate.of(2015, 5, 19),
            "RPG fantastique",
            29.99f,
            4L,
            null
        );
        when(createJeuUseCase.createJeu(jeuDtoIn)).thenReturn(jeuDtoOut);

        // When
        ResponseEntity<JeuDtoOut> result = jeuController.createJeu(jeuDtoIn);

        // Then
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals("The Witcher 3", result.getBody().nom());
        verify(createJeuUseCase, times(1)).createJeu(jeuDtoIn);
    }
}
