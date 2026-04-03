package fr.esgi.avis.dto;

import fr.esgi.avis.business.Classification;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Classification}
 */
public record ClassificationDtoOut(List<Long> jeuxIds, Long id, String nom, String couleurRGB) implements Serializable {
}