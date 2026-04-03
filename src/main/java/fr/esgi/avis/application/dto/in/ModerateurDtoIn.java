package fr.esgi.avis.application.dto.in;

import fr.esgi.avis.domain.business.Moderateur;

import java.io.Serializable;

/**
 * DTO for {@link Moderateur}
 */
public record ModerateurDtoIn(String numeroDeTelephone, String motDePasse, String pseudo,
                              String email) implements Serializable {
}