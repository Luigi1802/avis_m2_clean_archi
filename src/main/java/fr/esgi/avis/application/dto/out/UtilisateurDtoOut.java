package fr.esgi.avis.application.dto.out;

import java.io.Serializable;

/**
 * DTO for {@link Utilisateur}
 */
public record UtilisateurDtoOut(Long id, String motDePasse, String pseudo, String email) implements Serializable {
}