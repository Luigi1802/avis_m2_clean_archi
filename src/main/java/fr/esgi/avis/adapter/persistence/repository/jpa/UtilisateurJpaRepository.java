package fr.esgi.avis.adapter.persistence.repository.jpa;

import fr.esgi.avis.adapter.persistence.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurJpaRepository extends JpaRepository<UtilisateurEntity, Long> {
}