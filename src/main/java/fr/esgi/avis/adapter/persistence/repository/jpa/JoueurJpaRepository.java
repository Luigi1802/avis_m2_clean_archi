package fr.esgi.avis.adapter.persistence.repository.jpa;

import fr.esgi.avis.adapter.persistence.entity.JoueurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoueurJpaRepository extends JpaRepository<JoueurEntity, Long> {
    Optional<JoueurEntity> findByPseudo(String pseudo);

    Optional<JoueurEntity> findByEmail(String email);
}