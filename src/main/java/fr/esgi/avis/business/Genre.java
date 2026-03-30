package fr.esgi.avis.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    private Long id;

    private String nom;

    private List<Jeu> jeux;
}
