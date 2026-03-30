package fr.esgi.avis.dto;

import fr.esgi.avis.business.Utilisateur;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Utilisateur}
 */
@Value
public class UtilisateurDtoOut implements Serializable {
    Long id;
    String motDePasse;
    String pseudo;
    String email;
}