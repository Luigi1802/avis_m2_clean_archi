package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.AvatarEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.AvatarJpaRepository;
import fr.esgi.avis.application.dto.in.AvatarDtoIn;
import fr.esgi.avis.application.dto.out.AvatarDtoOut;
import fr.esgi.avis.application.mappers.AvatarMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvatarRepositoryImplTest {

    @Mock
    private AvatarJpaRepository avatarJpaRepository;

    @Mock
    private AvatarMapper avatarMapper;

    @InjectMocks
    private AvatarRepositoryImpl avatarRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByIdSuccess() {
        // Given
        AvatarEntity avatarEntity = new AvatarEntity();
        avatarEntity.setId(1L);
        avatarEntity.setNom("Warrior");

        AvatarDtoOut avatarDtoOut = new AvatarDtoOut(1L, "Warrior", null);

        when(avatarJpaRepository.findById(1L)).thenReturn(Optional.of(avatarEntity));
        when(avatarMapper.toDto(avatarEntity)).thenReturn(avatarDtoOut);

        // When
        Optional<AvatarDtoOut> result = avatarRepository.findById(1L);

        // Then
        assertTrue(result.isPresent());
        assertEquals("Warrior", result.get().nom());
        verify(avatarJpaRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        when(avatarJpaRepository.findById(999L)).thenReturn(Optional.empty());

        // When
        Optional<AvatarDtoOut> result = avatarRepository.findById(999L);

        // Then
        assertFalse(result.isPresent());
        verify(avatarJpaRepository, times(1)).findById(999L);
    }

    @Test
    void testFindByJoueurIdSuccess() {
        // Given
        AvatarEntity avatarEntity = new AvatarEntity();
        avatarEntity.setId(1L);
        avatarEntity.setNom("Mage");

        AvatarDtoOut avatarDtoOut = new AvatarDtoOut(1L, "Mage", 1L);

        when(avatarJpaRepository.findByJoueurId(1L)).thenReturn(Optional.of(avatarEntity));
        when(avatarMapper.toDto(avatarEntity)).thenReturn(avatarDtoOut);

        // When
        Optional<AvatarDtoOut> result = avatarRepository.findByJoueurId(1L);

        // Then
        assertTrue(result.isPresent());
        assertEquals("Mage", result.get().nom());
        assertEquals(1L, result.get().joueurId());
        verify(avatarJpaRepository, times(1)).findByJoueurId(1L);
    }

    @Test
    void testFindByJoueurIdNotFound() {
        // Given
        when(avatarJpaRepository.findByJoueurId(999L)).thenReturn(Optional.empty());

        // When
        Optional<AvatarDtoOut> result = avatarRepository.findByJoueurId(999L);

        // Then
        assertFalse(result.isPresent());
        verify(avatarJpaRepository, times(1)).findByJoueurId(999L);
    }

    @Test
    void testSaveSuccess() {
        // Given
        AvatarDtoOut avatarDtoOut = new AvatarDtoOut(null, "Knight", null);
        AvatarEntity avatarEntity = new AvatarEntity();
        avatarEntity.setNom("Knight");

        AvatarEntity savedEntity = new AvatarEntity();
        savedEntity.setId(2L);
        savedEntity.setNom("Knight");

        AvatarDtoOut savedDto = new AvatarDtoOut(2L, "Knight", null);

        when(avatarMapper.toEntity(any(AvatarDtoIn.class))).thenReturn(avatarEntity);
        when(avatarJpaRepository.save(avatarEntity)).thenReturn(savedEntity);
        when(avatarMapper.toDto(savedEntity)).thenReturn(savedDto);

        // When
        AvatarDtoOut result = avatarRepository.save(avatarDtoOut);

        // Then
        assertNotNull(result);
        assertEquals(2L, result.id());
        assertEquals("Knight", result.nom());
        verify(avatarJpaRepository, times(1)).save(avatarEntity);
    }

    @Test
    void testDeleteById() {
        // When
        avatarRepository.deleteById(1L);

        // Then
        verify(avatarJpaRepository, times(1)).deleteById(1L);
    }
}

