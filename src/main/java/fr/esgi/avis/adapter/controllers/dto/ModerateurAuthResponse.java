package fr.esgi.avis.adapter.controllers.dto;

import java.io.Serializable;

/**
 * Réponse sécurisée pour l'authentification d'un Modérateur
 * Exclut explicitement le mot de passe
 */
public record ModerateurAuthResponse(
    Long id,
    String pseudo,
    String email,
    String numeroDeTelephone,
    String token
) implements Serializable {
}

