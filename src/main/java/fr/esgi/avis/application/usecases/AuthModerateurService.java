package fr.esgi.avis.application.usecases;

import fr.esgi.avis.application.dto.in.ModerateurDtoIn;
import fr.esgi.avis.application.dto.out.ModerateurDtoOut;
import fr.esgi.avis.application.ports.in.AuthModerateurUseCase;
import fr.esgi.avis.application.ports.out.ModerateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implémentation du use case AuthModerateurUseCase
 * Respecte SOLID-S et SOLID-D
 */
@Service
@AllArgsConstructor
public class AuthModerateurService implements AuthModerateurUseCase {

    private final ModerateurRepository moderateurRepository;

    @Override
    public Optional<ModerateurDtoOut> loginModerateur(String pseudo, String motDePasse) {
        // Récupérer le modérateur par pseudo
        Optional<ModerateurDtoOut> moderateur = moderateurRepository.findByPseudo(pseudo);

        // Vérifier le mot de passe (simple vérification pour la démo)
        if (moderateur.isPresent() && moderateur.get().motDePasse().equals(motDePasse)) {
            return moderateur;
        }

        return Optional.empty();
    }

    @Override
    public ModerateurDtoOut registerModerateur(ModerateurDtoIn moderateurDtoIn) {
        // Vérifier que le pseudo n'existe pas déjà
        if (moderateurRepository.findByPseudo(moderateurDtoIn.pseudo()).isPresent()) {
            throw new IllegalArgumentException("Ce pseudo est déjà utilisé");
        }

        // Vérifier que l'email n'existe pas déjà
        if (moderateurRepository.findByEmail(moderateurDtoIn.email()).isPresent()) {
            throw new IllegalArgumentException("Cet email est déjà utilisé");
        }

        // Créer le nouveau ModerateurDtoOut
        ModerateurDtoOut moderateurDtoOut = new ModerateurDtoOut(
            null, // id sera généré par la DB
            moderateurDtoIn.motDePasse(),
            moderateurDtoIn.pseudo(),
            moderateurDtoIn.email(),
            moderateurDtoIn.numeroDeTelephone()
        );

        return moderateurRepository.save(moderateurDtoOut);
    }
}

