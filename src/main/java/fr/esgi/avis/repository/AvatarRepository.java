package fr.esgi.avis.repository;

import fr.esgi.avis.entity.AvatarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<AvatarEntity, Long> {
}