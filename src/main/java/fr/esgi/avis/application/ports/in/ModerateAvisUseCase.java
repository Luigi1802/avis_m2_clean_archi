package fr.esgi.avis.application.ports.in;

import fr.esgi.avis.application.dto.in.AvisDtoIn;
import fr.esgi.avis.application.dto.out.AvisDtoOut;

/**
 * Port IN - Use Case: Modérer un avis (Modérateur)
 */
public interface ModerateAvisUseCase {
    AvisDtoOut moderateAvis(Long avisId, AvisDtoIn avisDtoIn);
}

