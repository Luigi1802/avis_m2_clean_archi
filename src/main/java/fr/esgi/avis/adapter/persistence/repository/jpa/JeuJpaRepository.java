package fr.esgi.avis.adapter.persistence.repository.jpa;

import fr.esgi.avis.adapter.persistence.entity.JeuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JeuJpaRepository extends JpaRepository<JeuEntity, Long> {
    List<JeuEntity> findByEditeurId(Long editeurId);

    List<JeuEntity> findByGenreId(Long genreId);
}