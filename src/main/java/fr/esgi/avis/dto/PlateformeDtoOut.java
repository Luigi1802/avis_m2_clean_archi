package fr.esgi.avis.dto;

import fr.esgi.avis.business.Plateforme;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Plateforme}
 */
@Value
public class PlateformeDtoOut implements Serializable {
    Long id;
    String nom;
    List<Long> jeuxIds;
    LocalDate dateDeSortie;
}