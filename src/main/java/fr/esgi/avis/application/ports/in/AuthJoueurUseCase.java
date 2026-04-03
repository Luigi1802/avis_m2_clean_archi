package fr.esgi.avis.application.ports.in;

import fr.esgi.avis.application.dto.in.JoueurDtoIn;
import fr.esgi.avis.application.dto.out.JoueurDtoOut;

import java.util.Optional;

/**
 * Port IN - Use Case: Connexion Joueur
 * Respecte SOLID-D et SOLID-I
 */
public interface AuthJoueurUseCase {
    Optional<JoueurDtoOut> loginJoueur(String pseudo, String motDePasse);

    JoueurDtoOut registerJoueur(JoueurDtoIn joueurDtoIn);
}

