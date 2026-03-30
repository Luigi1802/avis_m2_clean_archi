package fr.esgi.avis.dto;

import fr.esgi.avis.business.Moderateur;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Moderateur}
 */
@Value
public class ModerateurDtoIn implements Serializable {
    String numeroDeTelephone;
    String motDePasse;
    String pseudo;
    String email;
}