package fr.esgi.avis.repository;

import fr.esgi.avis.entity.JoueurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<JoueurEntity, Long> {
}