package fr.esgi.avis.application.dto.in;


import fr.esgi.avis.domain.business.Genre;

import java.io.Serializable;

/**
 * DTO for {@link Genre}
 */
public record GenreDtoIn(String nom) implements Serializable {
}