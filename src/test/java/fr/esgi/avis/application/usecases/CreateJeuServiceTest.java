package fr.esgi.avis.application.usecases;

import fr.esgi.avis.application.dto.in.JeuDtoIn;
import fr.esgi.avis.application.dto.out.JeuDtoOut;
import fr.esgi.avis.application.ports.out.JeuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateJeuServiceTest {

    @Mock
    private JeuRepository jeuRepository;

    @InjectMocks
    private CreateJeuService createJeuService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateJeuSuccess() {
        // Given
        JeuDtoIn jeuDtoIn = new JeuDtoIn(
            List.of(1L, 2L),
            1L,
            "Assassin's Creed Valhalla",
            1L,
            LocalDate.of(2020, 11, 10),
            "Un jeu d'action-aventure historique",
            59.99f,
            4L,
            null
        );
        JeuDtoOut jeuDtoOut = new JeuDtoOut(
            List.of(1L, 2L),
            1L,
            1L,
            "Assassin's Creed Valhalla",
            1L,
            LocalDate.of(2020, 11, 10),
            "Un jeu d'action-aventure historique",
            59.99f,
            4L,
            null
        );
        when(jeuRepository.save(any(JeuDtoOut.class))).thenReturn(jeuDtoOut);

        // When
        JeuDtoOut result = createJeuService.createJeu(jeuDtoIn);

        // Then
        assertNotNull(result);
        assertEquals("Assassin's Creed Valhalla", result.nom());
        assertEquals(59.99f, result.prix());
        assertEquals(1L, result.id());
        verify(jeuRepository, times(1)).save(any(JeuDtoOut.class));
    }

    @Test
    void testCreateJeuWithValidData() {
        // Given
        JeuDtoIn jeuDtoIn = new JeuDtoIn(
            List.of(1L),
            2L,
            "FIFA 23",
            2L,
            LocalDate.of(2022, 9, 30),
            "Jeu de football",
            49.99f,
            1L,
            null
        );
        JeuDtoOut jeuDtoOut = new JeuDtoOut(
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
        );
        when(jeuRepository.save(any(JeuDtoOut.class))).thenReturn(jeuDtoOut);

        // When
        JeuDtoOut result = createJeuService.createJeu(jeuDtoIn);

        // Then
        assertNotNull(result);
        assertEquals("FIFA 23", result.nom());
        assertEquals(49.99f, result.prix());
        assertEquals(2L, result.editeurId());
        assertEquals(2L, result.genreId());
        verify(jeuRepository, times(1)).save(any(JeuDtoOut.class));
    }

    @Test
    void testCreateJeuWithMultiplePlatformes() {
        // Given
        JeuDtoIn jeuDtoIn = new JeuDtoIn(
            List.of(1L, 2L, 3L),
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
            List.of(1L, 2L, 3L),
            1L,
            3L,
            "The Witcher 3",
            3L,
            LocalDate.of(2015, 5, 19),
            "RPG fantastique",
            29.99f,
            4L,
            null
        );
        when(jeuRepository.save(any(JeuDtoOut.class))).thenReturn(jeuDtoOut);

        // When
        JeuDtoOut result = createJeuService.createJeu(jeuDtoIn);

        // Then
        assertNotNull(result);
        assertEquals(3, result.plateformeIds().size());
        assertTrue(result.plateformeIds().contains(1L));
        assertTrue(result.plateformeIds().contains(2L));
        assertTrue(result.plateformeIds().contains(3L));
        verify(jeuRepository, times(1)).save(any(JeuDtoOut.class));
    }
}

