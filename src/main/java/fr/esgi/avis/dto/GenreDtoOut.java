package fr.esgi.avis.dto;

import fr.esgi.avis.business.Genre;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Genre}
 */
public record GenreDtoOut(Long id, String nom, List<Long> jeuxIds) implements Serializable {
}