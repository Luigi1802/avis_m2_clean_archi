package fr.esgi.avis.dto;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.business.Joueur;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link Joueur}
 */
@Value
public class JoueurDtoOut implements Serializable {
    Long avatarId;
    LocalDate dateDeNaissance;
    List<AvisDto> avis;
    Long id;
    String motDePasse;
    String pseudo;
    String email;

    /**
     * DTO for {@link Avis}
     */
    @Value
    public static class AvisDto implements Serializable {
        Long id;
        LocalDateTime dateDEnvoi;
    }
}