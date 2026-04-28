package fr.esgi.avis.adapter.controllers;

import fr.esgi.avis.adapter.controllers.dto.JoueurAuthResponse;
import fr.esgi.avis.application.dto.in.JoueurDtoIn;
import fr.esgi.avis.application.dto.out.JoueurDtoOut;
import fr.esgi.avis.application.ports.in.AuthJoueurUseCase;
import fr.esgi.avis.application.security.JwtService;
import fr.esgi.avis.application.security.Role;
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
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<JoueurAuthResponse> login(@RequestParam String pseudo,
                                                    @RequestParam String motDePasse) {
        return authJoueurUseCase.loginJoueur(pseudo, motDePasse)
                .map(joueur -> filterJoueurResponse(joueur,
                        jwtService.generateToken(joueur.pseudo(), Role.JOUEUR)))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/register")
    public ResponseEntity<JoueurAuthResponse> register(@RequestBody JoueurDtoIn joueurDtoIn) {
        JoueurDtoOut created = authJoueurUseCase.registerJoueur(joueurDtoIn);
        String token = jwtService.generateToken(created.pseudo(), Role.JOUEUR);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(filterJoueurResponse(created, token));
    }

    private JoueurAuthResponse filterJoueurResponse(JoueurDtoOut joueur, String token) {
        return new JoueurAuthResponse(
                joueur.id(),
                joueur.pseudo(),
                joueur.email(),
                joueur.dateDeNaissance(),
                joueur.avatarId(),
                token
        );
    }
}

