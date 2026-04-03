package fr.esgi.avis.repository;

import fr.esgi.avis.entity.ModerateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModerateurRepository extends JpaRepository<ModerateurEntity, Long> {
}