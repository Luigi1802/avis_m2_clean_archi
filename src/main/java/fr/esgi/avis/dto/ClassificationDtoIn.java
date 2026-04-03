package fr.esgi.avis.dto;

import fr.esgi.avis.business.Classification;

import java.io.Serializable;

/**
 * DTO for {@link Classification}
 */
public record ClassificationDtoIn(String nom, String couleurRGB) implements Serializable {
}