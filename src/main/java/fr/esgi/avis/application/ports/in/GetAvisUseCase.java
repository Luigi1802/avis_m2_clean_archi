package fr.esgi.avis.application.ports.in;

import fr.esgi.avis.application.dto.out.AvisDtoOut;

import java.util.List;
import java.util.Optional;

/**
 * Port IN - Use Case: Récupérer les avis
 * Respecte SOLID-D et SOLID-I
 */
public interface GetAvisUseCase {
    List<AvisDtoOut> getAllAvis();

    Optional<AvisDtoOut> getAvisById(Long id);

    List<AvisDtoOut> getAvisByJeu(Long jeuId);

    List<AvisDtoOut> getAvisByJoueur(Long joueurId);
}

