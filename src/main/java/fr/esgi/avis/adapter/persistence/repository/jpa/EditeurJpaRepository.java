package fr.esgi.avis.adapter.persistence.repository.jpa;

import fr.esgi.avis.adapter.persistence.entity.EditeurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EditeurJpaRepository extends JpaRepository<EditeurEntity, Long> {
    Optional<EditeurEntity> findByNom(String nom);
}