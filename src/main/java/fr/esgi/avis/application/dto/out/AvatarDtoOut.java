package fr.esgi.avis.application.dto.out;

import fr.esgi.avis.domain.business.Avatar;

import java.io.Serializable;

/**
 * DTO for {@link Avatar}
 */
public record AvatarDtoOut(Long id, String nom, Long joueurId) implements Serializable {
}