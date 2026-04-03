package fr.esgi.avis.adapter.persistence.repository.jpa;

import fr.esgi.avis.adapter.persistence.entity.ModerateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModerateurJpaRepository extends JpaRepository<ModerateurEntity, Long> {
    Optional<ModerateurEntity> findByPseudo(String pseudo);

    Optional<ModerateurEntity> findByEmail(String email);
}