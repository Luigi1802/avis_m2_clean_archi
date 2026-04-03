package fr.esgi.avis.adapter.controllers;

import fr.esgi.avis.adapter.controllers.dto.JoueurAuthResponse;
import fr.esgi.avis.application.dto.in.JoueurDtoIn;
import fr.esgi.avis.application.dto.out.JoueurDtoOut;
import fr.esgi.avis.application.ports.in.AuthJoueurUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur REST pour l'authentification des Joueurs
 * Filtre du mot de passe dans les réponses via JoueurAuthResponse
 */
@RestController
@RequestMapping("/api/auth/joueur")
@AllArgsConstructor
public class JoueurAuthController {

    private final AuthJoueurUseCase authJoueurUseCase;

    /**
     * Authentifie un joueur
     * @param pseudo pseudo du joueur
     * @param motDePasse mot de passe
     * @return Les informations du joueur sans le mot de passe
     */
    @PostMapping("/login")
    public ResponseEntity<JoueurAuthResponse> login(@RequestParam String pseudo, @RequestParam String motDePasse) {
        return authJoueurUseCase.loginJoueur(pseudo, motDePasse)
            .map(this::filterJoueurResponse)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    /**
     * Enregistre un nouveau joueur
     * @param joueurDtoIn les données du joueur
     * @return Les informations du joueur créé sans le mot de passe
     */
    @PostMapping("/register")
    public ResponseEntity<JoueurAuthResponse> register(@RequestBody JoueurDtoIn joueurDtoIn) {
        JoueurDtoOut createdJoueur = authJoueurUseCase.registerJoueur(joueurDtoIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(filterJoueurResponse(createdJoueur));
    }

    /**
     * Filtre la réponse pour exclure le mot de passe
     */
    private JoueurAuthResponse filterJoueurResponse(JoueurDtoOut joueurDtoOut) {
        return new JoueurAuthResponse(
            joueurDtoOut.id(),
            joueurDtoOut.pseudo(),
            joueurDtoOut.email(),
            joueurDtoOut.dateDeNaissance(),
            joueurDtoOut.avatarId()
        );
    }
}

