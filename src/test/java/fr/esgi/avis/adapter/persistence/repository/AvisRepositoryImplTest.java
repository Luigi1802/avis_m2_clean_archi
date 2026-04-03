package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.AvisEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.AvisJpaRepository;
import fr.esgi.avis.application.dto.in.AvisDtoIn;
import fr.esgi.avis.application.dto.out.AvisDtoOut;
import fr.esgi.avis.application.mappers.AvisMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvisRepositoryImplTest {

    @Mock
    private AvisJpaRepository avisJpaRepository;

    @Mock
    private AvisMapper avisMapper;

    @InjectMocks
    private AvisRepositoryImpl avisRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllSuccess() {
        // Given
        AvisEntity avis1 = new AvisEntity();
        avis1.setId(1L);
        avis1.setNote(9.5f);

        AvisEntity avis2 = new AvisEntity();
        avis2.setId(2L);
        avis2.setNote(8.0f);

        AvisDtoOut dto1 = new AvisDtoOut(1L, "Excellent", 1L, 9.5f, 1L, 1L, LocalDateTime.now());
        AvisDtoOut dto2 = new AvisDtoOut(2L, "Bon", 2L, 8.0f, 2L, 1L, LocalDateTime.now());

        when(avisJpaRepository.findAll()).thenReturn(List.of(avis1, avis2));
        when(avisMapper.toDto(List.of(avis1, avis2))).thenReturn(List.of(dto1, dto2));

        // When
        List<AvisDtoOut> result = avisRepository.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(9.5f, result.get(0).note());
        assertEquals(8.0f, result.get(1).note());
        verify(avisJpaRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdSuccess() {
        // Given
        AvisEntity avisEntity = new AvisEntity();
        avisEntity.setId(1L);
        avisEntity.setNote(9.5f);

        AvisDtoOut avisDtoOut = new AvisDtoOut(1L, "Excellent", 1L, 9.5f, 1L, 1L, LocalDateTime.now());

        when(avisJpaRepository.findById(1L)).thenReturn(Optional.of(avisEntity));
        when(avisMapper.toDto(avisEntity)).thenReturn(avisDtoOut);

        // When
        Optional<AvisDtoOut> result = avisRepository.findById(1L);

        // Then
        assertTrue(result.isPresent());
        assertEquals(9.5f, result.get().note());
        verify(avisJpaRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        when(avisJpaRepository.findById(999L)).thenReturn(Optional.empty());

        // When
        Optional<AvisDtoOut> result = avisRepository.findById(999L);

        // Then
        assertFalse(result.isPresent());
        verify(avisJpaRepository, times(1)).findById(999L);
    }

    @Test
    void testSaveSuccess() {
        // Given
        AvisDtoOut avisDtoOut = new AvisDtoOut(
            null,
            "Jeu fantastique",
            1L,
            10.0f,
            1L,
            1L,
            LocalDateTime.now()
        );

        AvisEntity avisEntity = new AvisEntity();
        avisEntity.setDescription("Jeu fantastique");

        AvisEntity savedEntity = new AvisEntity();
        savedEntity.setId(3L);
        savedEntity.setNote(10.0f);

        AvisDtoOut savedDto = new AvisDtoOut(3L, "Jeu fantastique", 1L, 10.0f, 1L, 1L, LocalDateTime.now());

        when(avisMapper.toEntity(any(AvisDtoIn.class))).thenReturn(avisEntity);
        when(avisJpaRepository.save(avisEntity)).thenReturn(savedEntity);
        when(avisMapper.toDto(savedEntity)).thenReturn(savedDto);

        // When
        AvisDtoOut result = avisRepository.save(avisDtoOut);

        // Then
        assertNotNull(result);
        assertEquals(3L, result.id());
        verify(avisJpaRepository, times(1)).save(avisEntity);
    }

    @Test
    void testDeleteById() {
        // When
        avisRepository.deleteById(1L);

        // Then
        verify(avisJpaRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindByJeuId() {
        // Given
        AvisEntity avis = new AvisEntity();
        avis.setId(1L);
        avis.setNote(9.5f);

        AvisDtoOut dto = new AvisDtoOut(1L, "Excellent", 1L, 9.5f, 1L, 1L, LocalDateTime.now());

        when(avisJpaRepository.findByJeuId(1L)).thenReturn(List.of(avis));
        when(avisMapper.toDto(List.of(avis))).thenReturn(List.of(dto));

        // When
        List<AvisDtoOut> result = avisRepository.findByJeuId(1L);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).jeuId());
        verify(avisJpaRepository, times(1)).findByJeuId(1L);
    }

    @Test
    void testFindByJoueurId() {
        // Given
        AvisEntity avis = new AvisEntity();
        avis.setId(2L);
        avis.setNote(8.5f);

        AvisDtoOut dto = new AvisDtoOut(2L, "Bon jeu", 2L, 8.5f, 1L, 1L, LocalDateTime.now());

        when(avisJpaRepository.findByJoueurId(1L)).thenReturn(List.of(avis));
        when(avisMapper.toDto(List.of(avis))).thenReturn(List.of(dto));

        // When
        List<AvisDtoOut> result = avisRepository.findByJoueurId(1L);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).joueurId());
        verify(avisJpaRepository, times(1)).findByJoueurId(1L);
    }
}

