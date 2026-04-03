package fr.esgi.avis.application.dto.in;


import fr.esgi.avis.domain.business.Editeur;

import java.io.Serializable;

/**
 * DTO for {@link Editeur}
 */
public record EditeurDtoIn(String nom) implements Serializable {
}