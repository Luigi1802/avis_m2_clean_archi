package fr.esgi.avis.repository;

import fr.esgi.avis.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {
}