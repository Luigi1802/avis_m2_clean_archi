package fr.esgi.avis.application.ports.out;

import fr.esgi.avis.application.dto.out.AvisDtoOut;

import java.util.List;
import java.util.Optional;

/**
 * Port OUT - Contrat pour la persistance des Avis
 */
public interface AvisRepository {
    List<AvisDtoOut> findAll();

    Optional<AvisDtoOut> findById(Long id);

    AvisDtoOut save(AvisDtoOut avisDtoOut);

    void deleteById(Long id);

    List<AvisDtoOut> findByJeuId(Long jeuId);

    List<AvisDtoOut> findByJoueurId(Long joueurId);

    List<AvisDtoOut> findByModerateurId(Long moderateurId);
}

