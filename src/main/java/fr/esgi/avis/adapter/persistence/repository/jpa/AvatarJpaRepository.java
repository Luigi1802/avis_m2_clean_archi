package fr.esgi.avis.adapter.persistence.repository.jpa;

import fr.esgi.avis.adapter.persistence.entity.AvatarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvatarJpaRepository extends JpaRepository<AvatarEntity, Long> {
    Optional<AvatarEntity> findByJoueurId(Long joueurId);
}