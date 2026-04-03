package fr.esgi.avis.application.usecases;

import fr.esgi.avis.application.dto.in.JoueurDtoIn;
import fr.esgi.avis.application.dto.out.JoueurDtoOut;
import fr.esgi.avis.application.ports.in.AuthJoueurUseCase;
import fr.esgi.avis.application.ports.out.JoueurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implémentation du use case AuthJoueurUseCase
 */
@Service
@AllArgsConstructor
public class AuthJoueurService implements AuthJoueurUseCase {

    private final JoueurRepository joueurRepository;

    @Override
    public Optional<JoueurDtoOut> loginJoueur(String pseudo, String motDePasse) {
        // Récupérer le joueur par pseudo
        Optional<JoueurDtoOut> joueur = joueurRepository.findByPseudo(pseudo);

        // Vérifier le mot de passe (simple vérification pour la démo)
        if (joueur.isPresent() && joueur.get().motDePasse().equals(motDePasse)) {
            return joueur;
        }

        return Optional.empty();
    }

    @Override
    public JoueurDtoOut registerJoueur(JoueurDtoIn joueurDtoIn) {
        // Vérifier que le pseudo n'existe pas déjà
        if (joueurRepository.findByPseudo(joueurDtoIn.pseudo()).isPresent()) {
            throw new IllegalArgumentException("Ce pseudo est déjà utilisé");
        }

        // Vérifier que l'email n'existe pas déjà
        if (joueurRepository.findByEmail(joueurDtoIn.email()).isPresent()) {
            throw new IllegalArgumentException("Cet email est déjà utilisé");
        }

        // Créer le nouveau JoueurDtoOut
        JoueurDtoOut joueurDtoOut = new JoueurDtoOut(
            joueurDtoIn.avatarId(),
            joueurDtoIn.dateDeNaissance(),
            null, // avis initialement vide
            null, // id sera généré par la DB
            joueurDtoIn.motDePasse(),
            joueurDtoIn.pseudo(),
            joueurDtoIn.email()
        );

        return joueurRepository.save(joueurDtoOut);
    }
}

