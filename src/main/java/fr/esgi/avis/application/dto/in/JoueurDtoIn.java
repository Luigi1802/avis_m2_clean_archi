package fr.esgi.avis.application.dto.in;

import fr.esgi.avis.domain.business.Joueur;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Joueur}
 */
public record JoueurDtoIn(Long avatarId, LocalDate dateDeNaissance, String motDePasse, String pseudo,
                          String email) implements Serializable {
}