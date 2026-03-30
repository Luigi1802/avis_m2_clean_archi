package fr.esgi.avis.dto;

import fr.esgi.avis.business.Genre;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Genre}
 */
@Value
public class GenreDtoIn implements Serializable {
    String nom;
}