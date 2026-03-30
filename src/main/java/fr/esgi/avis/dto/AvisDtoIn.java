package fr.esgi.avis.dto;

import fr.esgi.avis.business.Avis;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Avis}
 */
@Value
public class AvisDtoIn implements Serializable {
    String description;
    Long jeuId;
    Float note;
    Long joueurId;
    Long moderateurId;
    LocalDateTime dateDEnvoi;
}