package fr.esgi.avis.application.ports.in;

import fr.esgi.avis.application.dto.in.AvisDtoIn;
import fr.esgi.avis.application.dto.out.AvisDtoOut;

/**
 * Port IN - Use Case: Créer/Rédiger un avis (Joueur)
 * Respecte SOLID-D et SOLID-I
 */
public interface CreateAvisUseCase {
    AvisDtoOut createAvis(AvisDtoIn avisDtoIn);
}

