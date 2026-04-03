package fr.esgi.avis.dto;

import fr.esgi.avis.business.Jeu;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Jeu}
 */
public record JeuDtoIn(List<Long> plateformeIds, Long genreId, String nom, Long editeurId, LocalDate dateDeSortie,
                       String description, float prix, Long classificationId, String image) implements Serializable {
}