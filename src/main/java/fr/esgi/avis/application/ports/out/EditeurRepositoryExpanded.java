package fr.esgi.avis.application.ports.out;

import fr.esgi.avis.application.dto.out.EditeurDtoOut;

import java.util.List;
import java.util.Optional;

/**
 * Port OUT EXPANDED - Interface étendue pour EditeurRepository
 * (l'existante EditeurRepository sera complétée avec ces méthodes)
 * Respecte SOLID-D (Dependency Inversion) et SOLID-I (Interface Segregation)
 */
public interface EditeurRepositoryExpanded extends EditeurRepository {
    Optional<EditeurDtoOut> findById(Long id);

    EditeurDtoOut save(EditeurDtoOut editeurDtoOut);

    void deleteById(Long id);

    Optional<EditeurDtoOut> findByNom(String nom);
}

