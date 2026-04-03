package fr.esgi.avis.application.ports.out;

import fr.esgi.avis.application.dto.out.PlateformeDtoOut;

import java.util.List;
import java.util.Optional;

/**
 * Port OUT - Contrat pour la persistance des Plateformes
 * Respecte SOLID-D (Dependency Inversion) et SOLID-I (Interface Segregation)
 */
public interface PlateformeRepository {
    List<PlateformeDtoOut> findAll();

    Optional<PlateformeDtoOut> findById(Long id);

    PlateformeDtoOut save(PlateformeDtoOut plateformeDtoOut);

    void deleteById(Long id);

    Optional<PlateformeDtoOut> findByNom(String nom);
}

