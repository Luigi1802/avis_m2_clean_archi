package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Editeur;
import fr.esgi.avis.business.Jeu;

import java.util.List;

public interface EditeurUseCase {

    List<Editeur> recupererEditeurs();

    Editeur recupererEditeur(Long id);

    List<Editeur> recupererParNom(String nom);

    List<Jeu> recupererJeux(Long id);

    EditeurDtoOut ajouterEditeur (EditeurDtoIn editeurDtoIn);
}
