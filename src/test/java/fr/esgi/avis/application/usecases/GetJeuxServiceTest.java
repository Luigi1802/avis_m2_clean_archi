package fr.esgi.avis.application.usecases;

import fr.esgi.avis.application.dto.out.JeuDtoOut;
import fr.esgi.avis.application.ports.out.JeuRepository;
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

class GetJeuxServiceTest {

    @Mock
    private JeuRepository jeuRepository;

    @InjectMocks
    private GetJeuxService getJeuxService;

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
            ),
            new JeuDtoOut(
                List.of(1L),
                2L,
                2L,
                "FIFA 23",
                2L,
                LocalDate.of(2022, 9, 30),
                "Jeu de football",
                49.99f,
                1L,
                null
            )
        );
        when(jeuRepository.findAll()).thenReturn(jeux);

        // When
        List<JeuDtoOut> result = getJeuxService.getAllJeux();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Assassin's Creed Valhalla", result.get(0).nom());
        assertEquals("FIFA 23", result.get(1).nom());
        verify(jeuRepository, times(1)).findAll();
    }

    @Test
    void testGetAllJeuxEmpty() {
        // Given
        when(jeuRepository.findAll()).thenReturn(List.of());

        // When
        List<JeuDtoOut> result = getJeuxService.getAllJeux();

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(jeuRepository, times(1)).findAll();
    }

    @Test
    void testGetJeuByIdSuccess() {
        // Given
        JeuDtoOut jeu = new JeuDtoOut(
            List.of(1L),
            1L,
            1L,
            "Assassin's Creed Valhalla",
            1L,
            LocalDate.of(2020, 11, 10),
            "Un jeu d'action-aventure",
            59.99f,
            4L,
            null
        );
        when(jeuRepository.findById(1L)).thenReturn(Optional.of(jeu));

        // When
        Optional<JeuDtoOut> result = getJeuxService.getJeuById(1L);

        // Then
        assertTrue(result.isPresent());
        assertEquals("Assassin's Creed Valhalla", result.get().nom());
        verify(jeuRepository, times(1)).findById(1L);
    }

    @Test
    void testGetJeuByIdNotFound() {
        // Given
        when(jeuRepository.findById(999L)).thenReturn(Optional.empty());

        // When
        Optional<JeuDtoOut> result = getJeuxService.getJeuById(999L);

        // Then
        assertFalse(result.isPresent());
        verify(jeuRepository, times(1)).findById(999L);
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
        when(jeuRepository.findByEditeurId(1L)).thenReturn(jeux);

        // When
        List<JeuDtoOut> result = getJeuxService.getJeuxByEditeur(1L);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).editeurId());
        verify(jeuRepository, times(1)).findByEditeurId(1L);
    }

    @Test
    void testGetJeuxByEditeurEmpty() {
        // Given
        when(jeuRepository.findByEditeurId(999L)).thenReturn(List.of());

        // When
        List<JeuDtoOut> result = getJeuxService.getJeuxByEditeur(999L);

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(jeuRepository, times(1)).findByEditeurId(999L);
    }

    @Test
    void testGetJeuxByGenre() {
        // Given
        List<JeuDtoOut> jeux = List.of(
            new JeuDtoOut(
                List.of(1L),
                2L,
                2L,
                "FIFA 23",
                2L,
                LocalDate.of(2022, 9, 30),
                "Jeu de football",
                49.99f,
                1L,
                null
            )
        );
        when(jeuRepository.findByGenreId(2L)).thenReturn(jeux);

        // When
        List<JeuDtoOut> result = getJeuxService.getJeuxByGenre(2L);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(2L, result.get(0).genreId());
        verify(jeuRepository, times(1)).findByGenreId(2L);
    }

    @Test
    void testGetJeuxByGenreEmpty() {
        // Given
        when(jeuRepository.findByGenreId(999L)).thenReturn(List.of());

        // When
        List<JeuDtoOut> result = getJeuxService.getJeuxByGenre(999L);

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(jeuRepository, times(1)).findByGenreId(999L);
    }
}

