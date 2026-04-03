package fr.esgi.avis.application.dto.out;

import fr.esgi.avis.domain.business.Plateforme;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Plateforme}
 */
public record PlateformeDtoOut(Long id, String nom, List<Long> jeuxIds,
                               LocalDate dateDeSortie) implements Serializable {
}