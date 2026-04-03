package fr.esgi.avis.application.dto.in;

import fr.esgi.avis.domain.business.Plateforme;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Plateforme}
 */
public record PlateformeDtoIn(String nom, LocalDate dateDeSortie) implements Serializable {
}