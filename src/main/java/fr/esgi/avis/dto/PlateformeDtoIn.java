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
public class PlateformeDtoIn implements Serializable {
    String nom;
    LocalDate dateDeSortie;
}