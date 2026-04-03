package fr.esgi.avis.dto;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.business.Joueur;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link Joueur}
 */
public record JoueurDtoIn(Long avatarId, LocalDate dateDeNaissance, String motDePasse, String pseudo,
                          String email) implements Serializable {
}