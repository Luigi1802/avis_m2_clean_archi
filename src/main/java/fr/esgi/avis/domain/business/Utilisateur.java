package fr.esgi.avis.domain.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Utilisateur {
    private Long id;

    private String motDePasse;

    private String pseudo;

    private String email;
}