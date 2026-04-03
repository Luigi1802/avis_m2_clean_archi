package fr.esgi.avis.dto;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.business.Joueur;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link Joueur}
 */
public record JoueurDtoOut(Long avatarId, LocalDate dateDeNaissance, List<AvisDtoOut> avis, Long id, String motDePasse,
                           String pseudo, String email) implements Serializable {
}