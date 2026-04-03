package fr.esgi.avis.application.dto.in;

import fr.esgi.avis.domain.business.Classification;

import java.io.Serializable;

/**
 * DTO for {@link Classification}
 */
public record ClassificationDtoIn(String nom, String couleurRGB) implements Serializable {
}