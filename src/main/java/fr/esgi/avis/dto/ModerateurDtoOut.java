package fr.esgi.avis.dto;

import fr.esgi.avis.business.Moderateur;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Moderateur}
 */
@Value
public class ModerateurDtoOut implements Serializable {
    String numeroDeTelephone;
    Long id;
    String motDePasse;
    String pseudo;
    String email;
}