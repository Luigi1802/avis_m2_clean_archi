package fr.esgi.avis.dto;

import fr.esgi.avis.business.Plateforme;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Plateforme}
 */
public record PlateformeDtoIn(String nom, LocalDate dateDeSortie) implements Serializable {
}