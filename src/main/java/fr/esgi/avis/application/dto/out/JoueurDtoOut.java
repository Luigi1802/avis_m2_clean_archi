package fr.esgi.avis.application.dto.out;

import fr.esgi.avis.domain.business.Joueur;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Joueur}
 */
public record JoueurDtoOut(Long avatarId, LocalDate dateDeNaissance, List<AvisDtoOut> avis, Long id, String motDePasse,
                           String pseudo, String email) implements Serializable {
}