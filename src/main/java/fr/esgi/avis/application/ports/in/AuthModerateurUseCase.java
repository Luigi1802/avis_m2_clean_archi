package fr.esgi.avis.application.ports.in;

import fr.esgi.avis.application.dto.in.ModerateurDtoIn;
import fr.esgi.avis.application.dto.out.ModerateurDtoOut;

import java.util.Optional;

/**
 * Port IN - Use Case: Connexion Modérateur
 * Respecte SOLID-D et SOLID-I
 */
public interface AuthModerateurUseCase {
    Optional<ModerateurDtoOut> loginModerateur(String pseudo, String motDePasse);

    ModerateurDtoOut registerModerateur(ModerateurDtoIn moderateurDtoIn);
}

