package fr.esgi.avis.repository;

import fr.esgi.avis.entity.PlateformeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateformeRepository extends JpaRepository<PlateformeEntity, Long> {
}