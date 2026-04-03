package fr.esgi.avis.adapter.controllers;

import fr.esgi.avis.application.dto.in.ModerateurDtoIn;
import fr.esgi.avis.application.dto.out.ModerateurDtoOut;
import fr.esgi.avis.application.ports.in.AuthModerateurUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur REST pour l'authentification des Modérateurs
 * Respecte SOLID-D : injecte les use cases (ports in)
 */
@RestController
@RequestMapping("/api/auth/moderateur")
@AllArgsConstructor
public class ModerateurAuthController {

    private final AuthModerateurUseCase authModerateurUseCase;

    @PostMapping("/login")
    public ResponseEntity<ModerateurDtoOut> login(@RequestParam String pseudo, @RequestParam String motDePasse) {
        return authModerateurUseCase.loginModerateur(pseudo, motDePasse)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/register")
    public ResponseEntity<ModerateurDtoOut> register(@RequestBody ModerateurDtoIn moderateurDtoIn) {
        ModerateurDtoOut createdModerateur = authModerateurUseCase.registerModerateur(moderateurDtoIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModerateur);
    }
}

