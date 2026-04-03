package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.ClassificationEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.ClassificationJpaRepository;
import fr.esgi.avis.application.dto.in.ClassificationDtoIn;
import fr.esgi.avis.application.dto.out.ClassificationDtoOut;
import fr.esgi.avis.application.mappers.ClassificationMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClassificationRepositoryImplTest {

    @Mock
    private ClassificationJpaRepository classificationJpaRepository;

    @Mock
    private ClassificationMapper classificationMapper;

    @InjectMocks
    private ClassificationRepositoryImpl classificationRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllSuccess() {
        // Given
        ClassificationEntity classif1 = new ClassificationEntity();
        classif1.setId(1L);
        classif1.setNom("PEGI 3");

        ClassificationEntity classif2 = new ClassificationEntity();
        classif2.setId(2L);
        classif2.setNom("PEGI 18");

        ClassificationDtoOut dto1 = new ClassificationDtoOut(null, 1L, "PEGI 3", "#00FF00");
        ClassificationDtoOut dto2 = new ClassificationDtoOut(null, 2L, "PEGI 18", "#FF0000");

        when(classificationJpaRepository.findAll()).thenReturn(List.of(classif1, classif2));
        when(classificationMapper.toDto(List.of(classif1, classif2))).thenReturn(List.of(dto1, dto2));

        // When
        List<ClassificationDtoOut> result = classificationRepository.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("PEGI 3", result.get(0).nom());
        assertEquals("PEGI 18", result.get(1).nom());
        verify(classificationJpaRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdSuccess() {
        // Given
        ClassificationEntity classifEntity = new ClassificationEntity();
        classifEntity.setId(1L);
        classifEntity.setNom("PEGI 7");

        ClassificationDtoOut classifDtoOut = new ClassificationDtoOut(null, 1L, "PEGI 7", "#FFFF00");

        when(classificationJpaRepository.findById(1L)).thenReturn(Optional.of(classifEntity));
        when(classificationMapper.toDto(classifEntity)).thenReturn(classifDtoOut);

        // When
        Optional<ClassificationDtoOut> result = classificationRepository.findById(1L);

        // Then
        assertTrue(result.isPresent());
        assertEquals("PEGI 7", result.get().nom());
        verify(classificationJpaRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        when(classificationJpaRepository.findById(999L)).thenReturn(Optional.empty());

        // When
        Optional<ClassificationDtoOut> result = classificationRepository.findById(999L);

        // Then
        assertFalse(result.isPresent());
        verify(classificationJpaRepository, times(1)).findById(999L);
    }

    @Test
    void testSaveSuccess() {
        // Given
        ClassificationDtoOut classifDtoOut = new ClassificationDtoOut(null, null, "PEGI 12", "#FFA500");
        ClassificationEntity classifEntity = new ClassificationEntity();
        classifEntity.setNom("PEGI 12");

        ClassificationEntity savedEntity = new ClassificationEntity();
        savedEntity.setId(3L);
        savedEntity.setNom("PEGI 12");

        ClassificationDtoOut savedDto = new ClassificationDtoOut(null, 3L, "PEGI 12", "#FFA500");

        when(classificationMapper.toEntity(any(ClassificationDtoIn.class))).thenReturn(classifEntity);
        when(classificationJpaRepository.save(classifEntity)).thenReturn(savedEntity);
        when(classificationMapper.toDto(savedEntity)).thenReturn(savedDto);

        // When
        ClassificationDtoOut result = classificationRepository.save(classifDtoOut);

        // Then
        assertNotNull(result);
        assertEquals(3L, result.id());
        assertEquals("PEGI 12", result.nom());
        verify(classificationJpaRepository, times(1)).save(classifEntity);
    }

    @Test
    void testDeleteById() {
        // When
        classificationRepository.deleteById(1L);

        // Then
        verify(classificationJpaRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindByNom() {
        // Given
        ClassificationEntity classifEntity = new ClassificationEntity();
        classifEntity.setId(1L);
        classifEntity.setNom("PEGI 3");

        ClassificationDtoOut classifDtoOut = new ClassificationDtoOut(null, 1L, "PEGI 3", "#00FF00");

        when(classificationJpaRepository.findByNom("PEGI 3")).thenReturn(Optional.of(classifEntity));
        when(classificationMapper.toDto(classifEntity)).thenReturn(classifDtoOut);

        // When
        Optional<ClassificationDtoOut> result = classificationRepository.findByNom("PEGI 3");

        // Then
        assertTrue(result.isPresent());
        assertEquals("PEGI 3", result.get().nom());
        verify(classificationJpaRepository, times(1)).findByNom("PEGI 3");
    }
}

