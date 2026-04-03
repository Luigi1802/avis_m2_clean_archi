package fr.esgi.avis.repository;

import fr.esgi.avis.entity.AvisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisRepository extends JpaRepository<AvisEntity, Long> {
}