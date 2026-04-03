package fr.esgi.avis.dto;

import fr.esgi.avis.business.Moderateur;

import java.io.Serializable;

/**
 * DTO for {@link Moderateur}
 */
public record ModerateurDtoOut(String numeroDeTelephone, Long id, String motDePasse, String pseudo,
                               String email) implements Serializable {
}