package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.EditeurEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.EditeurJpaRepository;
import fr.esgi.avis.application.dto.in.EditeurDtoIn;
import fr.esgi.avis.application.dto.out.EditeurDtoOut;
import fr.esgi.avis.application.mappers.EditeurMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EditeurRepositoryImplTest {

    @Mock
    private EditeurJpaRepository editeurJpaRepository;

    @Mock
    private EditeurMapper editeurMapper;

    @InjectMocks
    private EditeurRepositoryImpl editeurRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllSuccess() {
        // Given
        EditeurEntity editeur1 = new EditeurEntity();
        editeur1.setId(1L);
        editeur1.setNom("Ubisoft");

        EditeurEntity editeur2 = new EditeurEntity();
        editeur2.setId(2L);
        editeur2.setNom("Electronic Arts");

        EditeurDtoOut dto1 = new EditeurDtoOut(1L, "Ubisoft", null);
        EditeurDtoOut dto2 = new EditeurDtoOut(2L, "Electronic Arts", null);

        when(editeurJpaRepository.findAll()).thenReturn(List.of(editeur1, editeur2));
        when(editeurMapper.toDto(List.of(editeur1, editeur2))).thenReturn(List.of(dto1, dto2));

        // When
        List<EditeurDtoOut> result = editeurRepository.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Ubisoft", result.get(0).nom());
        assertEquals("Electronic Arts", result.get(1).nom());
        verify(editeurJpaRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdSuccess() {
        // Given
        EditeurEntity editeurEntity = new EditeurEntity();
        editeurEntity.setId(1L);
        editeurEntity.setNom("Ubisoft");

        EditeurDtoOut editeurDtoOut = new EditeurDtoOut(1L, "Ubisoft", null);

        when(editeurJpaRepository.findById(1L)).thenReturn(Optional.of(editeurEntity));
        when(editeurMapper.toDto(editeurEntity)).thenReturn(editeurDtoOut);

        // When
        Optional<EditeurDtoOut> result = editeurRepository.findById(1L);

        // Then
        assertTrue(result.isPresent());
        assertEquals("Ubisoft", result.get().nom());
        verify(editeurJpaRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        when(editeurJpaRepository.findById(999L)).thenReturn(Optional.empty());

        // When
        Optional<EditeurDtoOut> result = editeurRepository.findById(999L);

        // Then
        assertFalse(result.isPresent());
        verify(editeurJpaRepository, times(1)).findById(999L);
    }

    @Test
    void testSaveSuccess() {
        // Given
        EditeurDtoOut editeurDtoOut = new EditeurDtoOut(null, "Nintendo", null);
        EditeurEntity editeurEntity = new EditeurEntity();
        editeurEntity.setNom("Nintendo");

        EditeurEntity savedEntity = new EditeurEntity();
        savedEntity.setId(3L);
        savedEntity.setNom("Nintendo");

        EditeurDtoOut savedDto = new EditeurDtoOut(3L, "Nintendo", null);

        when(editeurMapper.toEntity(any(EditeurDtoIn.class))).thenReturn(editeurEntity);
        when(editeurJpaRepository.save(editeurEntity)).thenReturn(savedEntity);
        when(editeurMapper.toDto(savedEntity)).thenReturn(savedDto);

        // When
        EditeurDtoOut result = editeurRepository.save(editeurDtoOut);

        // Then
        assertNotNull(result);
        assertEquals(3L, result.id());
        assertEquals("Nintendo", result.nom());
        verify(editeurJpaRepository, times(1)).save(editeurEntity);
    }

    @Test
    void testDeleteById() {
        // When
        editeurRepository.deleteById(1L);

        // Then
        verify(editeurJpaRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindByNom() {
        // Given
        EditeurEntity editeurEntity = new EditeurEntity();
        editeurEntity.setId(1L);
        editeurEntity.setNom("Ubisoft");

        EditeurDtoOut editeurDtoOut = new EditeurDtoOut(1L, "Ubisoft", null);

        when(editeurJpaRepository.findByNom("Ubisoft")).thenReturn(Optional.of(editeurEntity));
        when(editeurMapper.toDto(editeurEntity)).thenReturn(editeurDtoOut);

        // When
        Optional<EditeurDtoOut> result = editeurRepository.findByNom("Ubisoft");

        // Then
        assertTrue(result.isPresent());
        assertEquals("Ubisoft", result.get().nom());
        verify(editeurJpaRepository, times(1)).findByNom("Ubisoft");
    }
}

