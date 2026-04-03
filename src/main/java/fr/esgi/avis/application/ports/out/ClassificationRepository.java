package fr.esgi.avis.application.ports.out;

import fr.esgi.avis.application.dto.out.ClassificationDtoOut;

import java.util.List;
import java.util.Optional;

/**
 * Port OUT - Contrat pour la persistance des Classifications
 * Respecte SOLID-D (Dependency Inversion) et SOLID-I (Interface Segregation)
 */
public interface ClassificationRepository {
    List<ClassificationDtoOut> findAll();

    Optional<ClassificationDtoOut> findById(Long id);

    ClassificationDtoOut save(ClassificationDtoOut classificationDtoOut);

    void deleteById(Long id);

    Optional<ClassificationDtoOut> findByNom(String nom);
}

