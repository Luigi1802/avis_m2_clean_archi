package fr.esgi.avis.dto;

import fr.esgi.avis.business.Genre;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Genre}
 */
@Value
public class GenreDtoOut implements Serializable {
    Long id;
    String nom;
    List<Long> jeuxIds;
}