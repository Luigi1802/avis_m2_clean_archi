package fr.esgi.avis.adapter.persistence.repository.jpa;

import fr.esgi.avis.adapter.persistence.entity.PlateformeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlateformeJpaRepository extends JpaRepository<PlateformeEntity, Long> {
    Optional<PlateformeEntity> findByNom(String nom);
}