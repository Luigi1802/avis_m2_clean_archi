package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Avatar;
import fr.esgi.avis.business.Joueur;

import java.util.List;

public interface JoueurUseCase {
    Joueur recupererJoueur(Long id);

    Joueur recupererJoueurParAvatar(Avatar avatar);

    List<Joueur> recupererJoueurs();

    JoueurDtoOut ajouterJoueur(JoueurDtoIn joueurDtoIn);
    
    JoueurDtoOut modifierJoueur(JoueurDtoIn joueurDtoIn);

    void supprimerJoueur(Long id);
}
