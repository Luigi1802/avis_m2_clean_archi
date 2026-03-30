package fr.esgi.avis.business;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Avis}
 */
@Value
public class AvisDtoOut implements Serializable {
    Long id;
    String description;
    Long jeuId;
    Float note;
    Long joueurId;
    Long moderateurId;
    LocalDateTime dateDEnvoi;
}