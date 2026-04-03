package fr.esgi.avis.adapter.persistence.repository.jpa;

import fr.esgi.avis.adapter.persistence.entity.AvisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvisJpaRepository extends JpaRepository<AvisEntity, Long> {
    List<AvisEntity> findByJeuId(Long jeuId);

    List<AvisEntity> findByJoueurId(Long joueurId);

    List<AvisEntity> findByModerateurId(Long moderateurId);
}