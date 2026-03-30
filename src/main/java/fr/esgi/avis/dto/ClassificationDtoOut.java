package fr.esgi.avis.dto;

import java.io.Serializable;

/**
 * DTO for {@link {@link fr.clelia.avis.business.Editeur}
 */
public record ClassificationDtoOut(
        Long id,
        String nom,
        String logo
) implements Serializable {


}
