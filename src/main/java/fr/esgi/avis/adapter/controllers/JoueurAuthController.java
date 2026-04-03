package fr.esgi.avis.adapter.controllers;

import fr.esgi.avis.application.dto.in.JoueurDtoIn;
import fr.esgi.avis.application.dto.out.JoueurDtoOut;
import fr.esgi.avis.application.ports.in.AuthJoueurUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur REST pour l'authentification des Joueurs
 * Respecte SOLID-D : injecte les use cases (ports in)
 */
@RestController
@RequestMapping("/api/auth/joueur")
@AllArgsConstructor
public class JoueurAuthController {

    private final AuthJoueurUseCase authJoueurUseCase;

    @PostMapping("/login")
    public ResponseEntity<JoueurDtoOut> login(@RequestParam String pseudo, @RequestParam String motDePasse) {
        return authJoueurUseCase.loginJoueur(pseudo, motDePasse)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/register")
    public ResponseEntity<JoueurDtoOut> register(@RequestBody JoueurDtoIn joueurDtoIn) {
        JoueurDtoOut createdJoueur = authJoueurUseCase.registerJoueur(joueurDtoIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJoueur);
    }
}

