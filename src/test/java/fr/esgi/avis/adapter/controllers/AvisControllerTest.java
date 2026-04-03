package fr.esgi.avis.adapter.controllers;

import fr.esgi.avis.application.dto.in.AvisDtoIn;
import fr.esgi.avis.application.dto.out.AvisDtoOut;
import fr.esgi.avis.application.ports.in.CreateAvisUseCase;
import fr.esgi.avis.application.ports.in.GetAvisUseCase;
import fr.esgi.avis.application.ports.in.ModerateAvisUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvisControllerTest {

    @Mock
    private GetAvisUseCase getAvisUseCase;

    @Mock
    private CreateAvisUseCase createAvisUseCase;

    @Mock
    private ModerateAvisUseCase moderateAvisUseCase;

    @InjectMocks
    private AvisController avisController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAvis() {
        // Given
        List<AvisDtoOut> avis = List.of(
            new AvisDtoOut(
                1L,
                "Excellent jeu, très immersif !",
                1L,
                9.5f,
                1L,
                1L,
                LocalDateTime.of(2026, 3, 24, 12, 0, 0)
            ),
            new AvisDtoOut(
                2L,
                "Bons graphismes, mais répétitif",
                2L,
                7.0f,
                2L,
                1L,
                LocalDateTime.of(2026, 3, 29, 12, 0, 0)
            )
        );
        when(getAvisUseCase.getAllAvis()).thenReturn(avis);

        // When
        ResponseEntity<List<AvisDtoOut>> result = avisController.getAllAvis();

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(2, result.getBody().size());
        assertEquals(1L, result.getBody().get(0).id());
        assertEquals(9.5f, result.getBody().get(0).note());
        assertEquals(2L, result.getBody().get(1).id());
        assertEquals(7.0f, result.getBody().get(1).note());
        verify(getAvisUseCase, times(1)).getAllAvis();
    }

    @Test
    void testGetAvisByIdSuccess() {
        // Given
        AvisDtoOut avis = new AvisDtoOut(
            1L,
            "Chef-d'œuvre",
            3L,
            10.0f,
            1L,
            1L,
            LocalDateTime.of(2026, 4, 1, 12, 0, 0)
        );
        when(getAvisUseCase.getAvisById(1L)).thenReturn(Optional.of(avis));

        // When
        ResponseEntity<AvisDtoOut> result = avisController.getAvisById(1L);

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(10.0f, result.getBody().note());
        assertEquals("Chef-d'œuvre", result.getBody().description());
        verify(getAvisUseCase, times(1)).getAvisById(1L);
    }

    @Test
    void testGetAvisByIdNotFound() {
        // Given
        when(getAvisUseCase.getAvisById(999L)).thenReturn(Optional.empty());

        // When
        ResponseEntity<AvisDtoOut> result = avisController.getAvisById(999L);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        verify(getAvisUseCase, times(1)).getAvisById(999L);
    }

    @Test
    void testGetAvisByJeu() {
        // Given
        List<AvisDtoOut> avis = List.of(
            new AvisDtoOut(
                1L,
                "Excellent jeu",
                1L,
                9.5f,
                1L,
                1L,
                LocalDateTime.of(2026, 3, 24, 12, 0, 0)
            )
        );
        when(getAvisUseCase.getAvisByJeu(1L)).thenReturn(avis);

        // When
        ResponseEntity<List<AvisDtoOut>> result = avisController.getAvisByJeu(1L);

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(1, result.getBody().size());
        assertEquals(1L, result.getBody().get(0).jeuId());
        verify(getAvisUseCase, times(1)).getAvisByJeu(1L);
    }

    @Test
    void testGetAvisByJoueur() {
        // Given
        List<AvisDtoOut> avis = List.of(
            new AvisDtoOut(
                1L,
                "Très bon",
                1L,
                9.5f,
                1L,
                1L,
                LocalDateTime.of(2026, 3, 24, 12, 0, 0)
            ),
            new AvisDtoOut(
                3L,
                "Magnifique",
                3L,
                10.0f,
                1L,
                1L,
                LocalDateTime.of(2026, 4, 1, 12, 0, 0)
            )
        );
        when(getAvisUseCase.getAvisByJoueur(1L)).thenReturn(avis);

        // When
        ResponseEntity<List<AvisDtoOut>> result = avisController.getAvisByJoueur(1L);

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(2, result.getBody().size());
        assertEquals(1L, result.getBody().get(0).joueurId());
        assertEquals(1L, result.getBody().get(1).joueurId());
        verify(getAvisUseCase, times(1)).getAvisByJoueur(1L);
    }

    @Test
    void testCreateAvis() {
        // Given
        AvisDtoIn avisDtoIn = new AvisDtoIn(
            "Histoire incroyable",
            4L,
            8.5f,
            2L,
            1L,
            LocalDateTime.of(2026, 4, 2, 12, 0, 0)
        );
        AvisDtoOut avisDtoOut = new AvisDtoOut(
            4L,
            "Histoire incroyable",
            4L,
            8.5f,
            2L,
            1L,
            LocalDateTime.of(2026, 4, 2, 12, 0, 0)
        );
        when(createAvisUseCase.createAvis(avisDtoIn)).thenReturn(avisDtoOut);

        // When
        ResponseEntity<AvisDtoOut> result = avisController.createAvis(avisDtoIn);

        // Then
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(8.5f, result.getBody().note());
        assertEquals(4L, result.getBody().jeuId());
        assertEquals(2L, result.getBody().joueurId());
        verify(createAvisUseCase, times(1)).createAvis(avisDtoIn);
    }

    @Test
    void testModerateAvis() {
        // Given
        AvisDtoIn avisDtoIn = new AvisDtoIn(
            "Avis modéré",
            1L,
            8.0f,
            1L,
            1L,
            LocalDateTime.of(2026, 4, 2, 12, 0, 0)
        );
        AvisDtoOut avisDtoOut = new AvisDtoOut(
            1L,
            "Avis modéré",
            1L,
            8.0f,
            1L,
            1L,
            LocalDateTime.of(2026, 4, 2, 12, 0, 0)
        );
        when(moderateAvisUseCase.moderateAvis(1L, avisDtoIn)).thenReturn(avisDtoOut);

        // When
        ResponseEntity<AvisDtoOut> result = avisController.moderateAvis(1L, avisDtoIn);

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Avis modéré", result.getBody().description());
        assertEquals(8.0f, result.getBody().note());
        verify(moderateAvisUseCase, times(1)).moderateAvis(1L, avisDtoIn);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme
