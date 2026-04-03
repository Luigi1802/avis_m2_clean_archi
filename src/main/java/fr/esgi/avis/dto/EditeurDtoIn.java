package fr.esgi.avis.dto;

import fr.esgi.avis.business.Editeur;

import java.io.Serializable;

/**
 * DTO for {@link Editeur}
 */
public record EditeurDtoIn(String nom) implements Serializable {
}