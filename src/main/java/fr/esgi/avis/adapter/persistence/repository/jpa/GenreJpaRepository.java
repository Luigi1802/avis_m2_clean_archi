package fr.esgi.avis.adapter.persistence.repository.jpa;

import fr.esgi.avis.adapter.persistence.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreJpaRepository extends JpaRepository<GenreEntity, Long> {
    Optional<GenreEntity> findByNom(String nom);
}