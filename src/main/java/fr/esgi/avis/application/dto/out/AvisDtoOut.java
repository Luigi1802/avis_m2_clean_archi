package fr.esgi.avis.application.dto.out;
import fr.esgi.avis.domain.business.Avis;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Avis}
 */
public record AvisDtoOut(Long id, String description, Long jeuId, Float note, Long joueurId, Long moderateurId,
                         LocalDateTime dateDEnvoi) implements Serializable {
}