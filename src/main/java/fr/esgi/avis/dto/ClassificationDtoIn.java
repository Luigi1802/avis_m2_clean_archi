package fr.esgi.avis.dto;

import fr.esgi.avis.business.Classification;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Classification}
 */
@Value
public class ClassificationDtoIn implements Serializable {
    String nom;
    String couleurRGB;
}