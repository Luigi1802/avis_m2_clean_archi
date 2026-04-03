package fr.esgi.avis.application.dto.in;

import fr.esgi.avis.domain.business.Utilisateur;

import java.io.Serializable;

/**
 * DTO for {@link Utilisateur}
 */
public record UtilisateurDtoIn(String motDePasse, String pseudo, String email) implements Serializable {
}