package fr.esgi.avis.application.ports.in;

import fr.esgi.avis.application.dto.in.JeuDtoIn;
import fr.esgi.avis.application.dto.out.JeuDtoOut;

/**
 * Port IN - Use Case: Créer/Ajouter un jeu (Modérateur)
 * Respecte SOLID-D et SOLID-I
 */
public interface CreateJeuUseCase {
    JeuDtoOut createJeu(JeuDtoIn jeuDtoIn);
}

