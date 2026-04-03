package fr.esgi.avis.application.dto.out;

import fr.esgi.avis.domain.business.Jeu;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Jeu}
 */
public record JeuDtoOut(List<Long> plateformeIds, Long genreId, Long id, String nom, Long editeurId,
                        LocalDate dateDeSortie, String description, float prix, Long classificationId,
                        String image) implements Serializable {
}