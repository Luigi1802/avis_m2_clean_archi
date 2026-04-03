package fr.esgi.avis.dto;

import fr.esgi.avis.business.Genre;

import java.io.Serializable;

/**
 * DTO for {@link Genre}
 */
public record GenreDtoIn(String nom) implements Serializable {
}