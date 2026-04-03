package fr.esgi.avis.application.dto.in;

import fr.esgi.avis.domain.business.Avatar;

import java.io.Serializable;

/**
 * DTO for {@link Avatar}
 */
public record AvatarDtoIn(String nom, Long joueurId) implements Serializable {
}