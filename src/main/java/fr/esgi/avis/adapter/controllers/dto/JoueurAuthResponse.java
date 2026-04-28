package fr.esgi.avis.adapter.controllers.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Réponse sécurisée pour l'authentification d'un Joueur
 * Exclut explicitement le mot de passe
 */
public record JoueurAuthResponse(
    Long id,
    String pseudo,
    String email,
    LocalDate dateDeNaissance,
    Long avatarId,
    String token
) implements Serializable {
}

