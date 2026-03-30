package fr.esgi.avis.dto;

import fr.esgi.avis.business.Jeu;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Jeu}
 */
@Value
public class JeuDtoOut implements Serializable {
    List<Long> plateformeIds;
    Long genreId;
    Long id;
    String nom;
    Long editeurId;
    LocalDate dateDeSortie;
    String description;
    float prix;
    Long classificationId;
    String image;
}