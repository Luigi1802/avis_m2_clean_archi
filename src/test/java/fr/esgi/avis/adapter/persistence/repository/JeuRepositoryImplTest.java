package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.JeuEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.JeuJpaRepository;
import fr.esgi.avis.application.dto.in.JeuDtoIn;
import fr.esgi.avis.application.dto.out.JeuDtoOut;
import fr.esgi.avis.application.mappers.JeuMapper;
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

class JeuRepositoryImplTest {

    @Mock
    private JeuJpaRepository jeuJpaRepository;

    @Mock
    private JeuMapper jeuMapper;

    @InjectMocks
    private JeuRepositoryImpl jeuRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllSuccess() {
        // Given
        JeuEntity jeu1 = new JeuEntity();
        jeu1.setId(1L);
        jeu1.setNom("FIFA 23");

        JeuEntity jeu2 = new JeuEntity();
        jeu2.setId(2L);
        jeu2.setNom("Assassin's Creed Valhalla");

        JeuDtoOut dto1 = new JeuDtoOut(
            List.of(1L), 1L, 1L, "FIFA 23", 2L,
            LocalDate.of(2022, 9, 30), "Football", 49.99f, 1L, null
        );
        JeuDtoOut dto2 = new JeuDtoOut(
            List.of(1L, 2L), 1L, 2L, "Assassin's Creed Valhalla", 1L,
            LocalDate.of(2020, 11, 10), "Action", 59.99f, 4L, null
        );

        when(jeuJpaRepository.findAll()).thenReturn(List.of(jeu1, jeu2));
        when(jeuMapper.toDto(List.of(jeu1, jeu2))).thenReturn(List.of(dto1, dto2));

        // When
        List<JeuDtoOut> result = jeuRepository.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("FIFA 23", result.get(0).nom());
        assertEquals("Assassin's Creed Valhalla", result.get(1).nom());
        verify(jeuJpaRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdSuccess() {
        // Given
        JeuEntity jeuEntity = new JeuEntity();
        jeuEntity.setId(1L);
        jeuEntity.setNom("FIFA 23");

        JeuDtoOut jeuDtoOut = new JeuDtoOut(
            List.of(1L), 1L, 1L, "FIFA 23", 2L,
            LocalDate.of(2022, 9, 30), "Football", 49.99f, 1L, null
        );

        when(jeuJpaRepository.findById(1L)).thenReturn(Optional.of(jeuEntity));
        when(jeuMapper.toDto(jeuEntity)).thenReturn(jeuDtoOut);

        // When
        Optional<JeuDtoOut> result = jeuRepository.findById(1L);

        // Then
        assertTrue(result.isPresent());
        assertEquals("FIFA 23", result.get().nom());
        verify(jeuJpaRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        when(jeuJpaRepository.findById(999L)).thenReturn(Optional.empty());

        // When
        Optional<JeuDtoOut> result = jeuRepository.findById(999L);

        // Then
        assertFalse(result.isPresent());
        verify(jeuJpaRepository, times(1)).findById(999L);
    }

    @Test
    void testSaveSuccess() {
        // Given
        JeuDtoOut jeuDtoOut = new JeuDtoOut(
            List.of(1L, 2L), 1L, null, "The Witcher 3", 3L,
            LocalDate.of(2015, 5, 19), "RPG", 29.99f, 4L, null
        );

        JeuEntity jeuEntity = new JeuEntity();
        jeuEntity.setNom("The Witcher 3");

        JeuEntity savedEntity = new JeuEntity();
        savedEntity.setId(3L);
        savedEntity.setNom("The Witcher 3");

        JeuDtoOut savedDto = new JeuDtoOut(
            List.of(1L, 2L), 1L, 3L, "The Witcher 3", 3L,
            LocalDate.of(2015, 5, 19), "RPG", 29.99f, 4L, null
        );

        when(jeuMapper.toEntity(any(JeuDtoIn.class))).thenReturn(jeuEntity);
        when(jeuJpaRepository.save(jeuEntity)).thenReturn(savedEntity);
        when(jeuMapper.toDto(savedEntity)).thenReturn(savedDto);

        // When
        JeuDtoOut result = jeuRepository.save(jeuDtoOut);

        // Then
        assertNotNull(result);
        assertEquals(3L, result.id());
        assertEquals("The Witcher 3", result.nom());
        verify(jeuJpaRepository, times(1)).save(jeuEntity);
    }

    @Test
    void testDeleteById() {
        // When
        jeuRepository.deleteById(1L);

        // Then
        verify(jeuJpaRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindByEditeurId() {
        // Given
        JeuEntity jeu = new JeuEntity();
        jeu.setId(1L);
        jeu.setNom("Assassin's Creed Valhalla");

        JeuDtoOut dto = new JeuDtoOut(
            List.of(1L, 2L), 1L, 1L, "Assassin's Creed Valhalla", 1L,
            LocalDate.of(2020, 11, 10), "Action", 59.99f, 4L, null
        );

        when(jeuJpaRepository.findByEditeurId(1L)).thenReturn(List.of(jeu));
        when(jeuMapper.toDto(List.of(jeu))).thenReturn(List.of(dto));

        // When
        List<JeuDtoOut> result = jeuRepository.findByEditeurId(1L);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).editeurId());
        verify(jeuJpaRepository, times(1)).findByEditeurId(1L);
    }

    @Test
    void testFindByGenreId() {
        // Given
        JeuEntity jeu = new JeuEntity();
        jeu.setId(2L);
        jeu.setNom("FIFA 23");

        JeuDtoOut dto = new JeuDtoOut(
            List.of(1L), 2L, 2L, "FIFA 23", 2L,
            LocalDate.of(2022, 9, 30), "Football", 49.99f, 1L, null
        );

        when(jeuJpaRepository.findByGenreId(2L)).thenReturn(List.of(jeu));
        when(jeuMapper.toDto(List.of(jeu))).thenReturn(List.of(dto));

        // When
        List<JeuDtoOut> result = jeuRepository.findByGenreId(2L);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(2L, result.get(0).genreId());
        verify(jeuJpaRepository, times(1)).findByGenreId(2L);
    }
}

