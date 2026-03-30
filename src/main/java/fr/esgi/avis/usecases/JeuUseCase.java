package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Jeu;

import java.util.List;

public interface JeuUseCase {

    List<Jeu> recupererJeux();

    Jeu recupererJeu(Long id);

    List<Jeu> recupererParNom(String nom);
}