package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.AvatarEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.AvatarJpaRepository;
import fr.esgi.avis.application.dto.out.AvatarDtoOut;
import fr.esgi.avis.application.mappers.AvatarMapper;
import fr.esgi.avis.application.ports.out.AvatarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Implémentation de AvatarRepository - Respecte SOLID-D (Dependency Inversion)
 */
@Repository
@AllArgsConstructor
public class AvatarRepositoryImpl implements AvatarRepository {

    private final AvatarJpaRepository avatarJpaRepository;
    private final AvatarMapper avatarMapper;

    @Override
    public Optional<AvatarDtoOut> findById(Long id) {
        return avatarJpaRepository.findById(id).map(avatarMapper::toDto);
    }

    @Override
    public Optional<AvatarDtoOut> findByJoueurId(Long joueurId) {
        return avatarJpaRepository.findByJoueurId(joueurId).map(avatarMapper::toDto);
    }

    @Override
    public AvatarDtoOut save(AvatarDtoOut avatarDtoOut) {
        AvatarEntity entity = avatarMapper.toEntity(
            new fr.esgi.avis.application.dto.in.AvatarDtoIn(
                avatarDtoOut.nom(),
                avatarDtoOut.joueurId()
            )
        );
        if (avatarDtoOut.id() != null) {
            entity.setId(avatarDtoOut.id());
        }
        AvatarEntity saved = avatarJpaRepository.save(entity);
        return avatarMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        avatarJpaRepository.deleteById(id);
    }
}

