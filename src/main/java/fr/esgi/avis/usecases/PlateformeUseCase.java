package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Plateforme;
import fr.esgi.avis.business.Jeu;

import java.util.List;

public interface PlateformeUseCase {

    List<Plateforme> recupererPlateformes();

    Plateforme recupererPlateforme(Long id);

    List<Plateforme> recupererParNom(String nom);

    List<Jeu> recupererJeux(Long id);

    PlateformeDtoOut ajouterPlateforme (PlateformeDtoIn plateformeDtoIn);
}
