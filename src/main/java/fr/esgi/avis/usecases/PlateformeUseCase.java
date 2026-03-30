package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Plateforme;
import fr.esgi.avis.business.Jeu;

import java.time.LocalDate;
import java.util.List;

public interface PlateformeUseCase {

    List<Plateforme> recupererPlateformes();

    Plateforme recupererPlateforme(Long id);

    List<Plateforme> recupererParNom(String nom);

    List<Plateforme> recupererParDateDeSortie(LocalDate date);

    List<Jeu> recupererJeux(Long id);

    PlateformeDtoOut ajouterPlateforme (PlateformeDtoIn plateformeDtoIn);

    PlateformeDtoOut modifierPlateforme (PlateformeDtoIn plateformeDtoIn);

    void supprimerPlateforme(Long id);
}
