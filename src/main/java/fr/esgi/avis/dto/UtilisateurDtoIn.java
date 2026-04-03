package fr.esgi.avis.dto;

import fr.esgi.avis.business.Utilisateur;

import java.io.Serializable;

/**
 * DTO for {@link Utilisateur}
 */
public record UtilisateurDtoIn(String motDePasse, String pseudo, String email) implements Serializable {
}