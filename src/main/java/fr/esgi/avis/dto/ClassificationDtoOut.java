package fr.esgi.avis.dto;

import fr.esgi.avis.business.Classification;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Classification}
 */
@Value
public class ClassificationDtoOut implements Serializable {
    List<Long> jeuxIds;
    Long id;
    String nom;
    String couleurRGB;
}