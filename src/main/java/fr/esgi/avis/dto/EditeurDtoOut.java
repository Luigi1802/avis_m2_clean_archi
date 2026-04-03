package fr.esgi.avis.dto;

import fr.esgi.avis.business.Editeur;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Editeur}
 */
public record EditeurDtoOut(Long id, String nom, List<Long> jeuxIds) implements Serializable {
}