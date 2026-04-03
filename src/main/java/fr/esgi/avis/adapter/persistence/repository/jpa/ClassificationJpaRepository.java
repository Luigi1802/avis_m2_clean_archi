package fr.esgi.avis.adapter.persistence.repository.jpa;

import fr.esgi.avis.adapter.persistence.entity.ClassificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassificationJpaRepository extends JpaRepository<ClassificationEntity, Long> {
    Optional<ClassificationEntity> findByNom(String nom);
}