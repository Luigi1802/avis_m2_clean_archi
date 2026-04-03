package fr.esgi.avis.application.dto.out;

import fr.esgi.avis.domain.business.Moderateur;

import java.io.Serializable;

/**
 * DTO for {@link Moderateur}
 */
public record ModerateurDtoOut(String numeroDeTelephone, Long id, String motDePasse, String pseudo,
                               String email) implements Serializable {
}