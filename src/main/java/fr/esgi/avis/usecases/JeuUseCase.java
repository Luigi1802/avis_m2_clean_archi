package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Jeu;

import java.time.LocalDate;
import java.util.List;

public interface JeuUseCase {

    List<Jeu> recupererJeux();

    Jeu recupererJeu(Long id);

    List<Jeu> recupererParNom(String nom);

    List<Jeu> recupererParDateDeSortie(LocalDate date);

    JeuDtoOut ajouterJeu (JeuDtoIn jeuDtoIn);

    JeuDtoOut modifierJeu (JeuDtoIn jeuDtoIn);

    void supprimerJeu(Long id);
}