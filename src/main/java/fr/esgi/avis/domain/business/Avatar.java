package fr.esgi.avis.domain.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Avatar {
    private Long id;

    private String nom;

    private Joueur joueur;
}

