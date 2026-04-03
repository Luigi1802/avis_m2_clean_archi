package fr.esgi.avis.repository;

import fr.esgi.avis.entity.ClassificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationRepository extends JpaRepository<ClassificationEntity, Long> {
}