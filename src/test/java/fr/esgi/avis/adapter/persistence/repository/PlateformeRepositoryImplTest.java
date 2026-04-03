package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.PlateformeEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.PlateformeJpaRepository;
import fr.esgi.avis.application.dto.in.PlateformeDtoIn;
import fr.esgi.avis.application.dto.out.PlateformeDtoOut;
import fr.esgi.avis.application.mappers.PlateformeMapper;
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

class PlateformeRepositoryImplTest {

    @Mock
    private PlateformeJpaRepository plateformeJpaRepository;

    @Mock
    private PlateformeMapper plateformeMapper;

    @InjectMocks
    private PlateformeRepositoryImpl plateformeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllSuccess() {
        // Given
        PlateformeEntity plateforme1 = new PlateformeEntity();
        plateforme1.setId(1L);
        plateforme1.setNom("PC");

        PlateformeEntity plateforme2 = new PlateformeEntity();
        plateforme2.setId(2L);
        plateforme2.setNom("PlayStation 5");

        PlateformeDtoOut dto1 = new PlateformeDtoOut(1L, "PC", null, LocalDate.of(1981, 8, 12));
        PlateformeDtoOut dto2 = new PlateformeDtoOut(2L, "PlayStation 5", null, LocalDate.of(2020, 11, 12));

        when(plateformeJpaRepository.findAll()).thenReturn(List.of(plateforme1, plateforme2));
        when(plateformeMapper.toDto(List.of(plateforme1, plateforme2))).thenReturn(List.of(dto1, dto2));

        // When
        List<PlateformeDtoOut> result = plateformeRepository.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("PC", result.get(0).nom());
        assertEquals("PlayStation 5", result.get(1).nom());
        verify(plateformeJpaRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdSuccess() {
        // Given
        PlateformeEntity plateformeEntity = new PlateformeEntity();
        plateformeEntity.setId(1L);
        plateformeEntity.setNom("Xbox Series X");

        PlateformeDtoOut platformeDtoOut = new PlateformeDtoOut(1L, "Xbox Series X", null, LocalDate.of(2020, 11, 10));

        when(plateformeJpaRepository.findById(1L)).thenReturn(Optional.of(plateformeEntity));
        when(plateformeMapper.toDto(plateformeEntity)).thenReturn(platformeDtoOut);

        // When
        Optional<PlateformeDtoOut> result = plateformeRepository.findById(1L);

        // Then
        assertTrue(result.isPresent());
        assertEquals("Xbox Series X", result.get().nom());
        verify(plateformeJpaRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        when(plateformeJpaRepository.findById(999L)).thenReturn(Optional.empty());

        // When
        Optional<PlateformeDtoOut> result = plateformeRepository.findById(999L);

        // Then
        assertFalse(result.isPresent());
        verify(plateformeJpaRepository, times(1)).findById(999L);
    }

    @Test
    void testSaveSuccess() {
        // Given
        PlateformeDtoOut platformeDtoOut = new PlateformeDtoOut(null, "Nintendo Switch", null, LocalDate.of(2017, 3, 3));
        PlateformeEntity plateformeEntity = new PlateformeEntity();
        plateformeEntity.setNom("Nintendo Switch");

        PlateformeEntity savedEntity = new PlateformeEntity();
        savedEntity.setId(4L);
        savedEntity.setNom("Nintendo Switch");

        PlateformeDtoOut savedDto = new PlateformeDtoOut(4L, "Nintendo Switch", null, LocalDate.of(2017, 3, 3));

        when(plateformeMapper.toEntity(any(PlateformeDtoIn.class))).thenReturn(plateformeEntity);
        when(plateformeJpaRepository.save(plateformeEntity)).thenReturn(savedEntity);
        when(plateformeMapper.toDto(savedEntity)).thenReturn(savedDto);

        // When
        PlateformeDtoOut result = plateformeRepository.save(platformeDtoOut);

        // Then
        assertNotNull(result);
        assertEquals(4L, result.id());
        assertEquals("Nintendo Switch", result.nom());
        verify(plateformeJpaRepository, times(1)).save(plateformeEntity);
    }

    @Test
    void testDeleteById() {
        // When
        plateformeRepository.deleteById(1L);

        // Then
        verify(plateformeJpaRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindByNom() {
        // Given
        PlateformeEntity plateformeEntity = new PlateformeEntity();
        plateformeEntity.setId(1L);
        plateformeEntity.setNom("PC");

        PlateformeDtoOut platformeDtoOut = new PlateformeDtoOut(1L, "PC", null, LocalDate.of(1981, 8, 12));

        when(plateformeJpaRepository.findByNom("PC")).thenReturn(Optional.of(plateformeEntity));
        when(plateformeMapper.toDto(plateformeEntity)).thenReturn(platformeDtoOut);

        // When
        Optional<PlateformeDtoOut> result = plateformeRepository.findByNom("PC");

        // Then
        assertTrue(result.isPresent());
        assertEquals("PC", result.get().nom());
        verify(plateformeJpaRepository, times(1)).findByNom("PC");
    }
}

