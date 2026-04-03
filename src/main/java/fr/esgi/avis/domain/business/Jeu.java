package fr.esgi.avis.domain.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jeu {

    private List<Plateforme> plateformes;

    private Genre genre;

    private Long id;

    private String nom;

    private Editeur editeur;

    private LocalDate dateDeSortie;

    private String description;

    private float prix;

    private Classification classification;

    private String image;
}
