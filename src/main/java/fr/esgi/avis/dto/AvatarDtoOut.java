package fr.esgi.avis.dto;

import fr.esgi.avis.business.Avatar;

import java.io.Serializable;

/**
 * DTO for {@link Avatar}
 */
public record AvatarDtoOut(Long id, String nom, Long joueurId) implements Serializable {
}