package fr.esgi.avis.repository;

import fr.esgi.avis.entity.EditeurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditeurRepository extends JpaRepository<EditeurEntity, Long> {
}