package fr.esgi.avis.application.ports.out;

import fr.esgi.avis.application.dto.out.EditeurDtoOut;

import java.util.List;
import java.util.Optional;

/**
 * Port OUT - Contrat pour la persistance des Editeurs
 */
public interface EditeurRepository {
    List<EditeurDtoOut> findAll();

    Optional<EditeurDtoOut> findById(Long id);

    EditeurDtoOut save(EditeurDtoOut editeurDtoOut);

    void deleteById(Long id);

    Optional<EditeurDtoOut> findByNom(String nom);
}

