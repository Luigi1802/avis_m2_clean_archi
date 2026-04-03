package fr.esgi.avis.application.dto.out;

import fr.esgi.avis.domain.business.Classification;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Classification}
 */
public record ClassificationDtoOut(List<Long> jeuxIds, Long id, String nom, String couleurRGB) implements Serializable {
}