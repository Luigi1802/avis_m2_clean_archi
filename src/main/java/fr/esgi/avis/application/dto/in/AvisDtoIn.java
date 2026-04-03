package fr.esgi.avis.application.dto.in;

import fr.esgi.avis.domain.business.Avis;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Avis}
 */
public record AvisDtoIn(String description, Long jeuId, Float note, Long joueurId, Long moderateurId,
                        LocalDateTime dateDEnvoi) implements Serializable {
}