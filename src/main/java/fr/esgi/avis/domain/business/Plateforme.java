package fr.esgi.avis.domain.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plateforme {

    private Long id;

    private String nom;

    private List<Jeu> jeux;

    private LocalDate dateDeSortie;
}
