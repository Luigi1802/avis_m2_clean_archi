package fr.esgi.avis.adapter.controllers;

import fr.esgi.avis.adapter.controllers.dto.ModerateurAuthResponse;
import fr.esgi.avis.application.dto.in.ModerateurDtoIn;
import fr.esgi.avis.application.dto.out.ModerateurDtoOut;
import fr.esgi.avis.application.ports.in.AuthModerateurUseCase;
import fr.esgi.avis.application.security.JwtService;
import fr.esgi.avis.application.security.Role;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur REST pour l'authentification des Modérateurs
 * Filtre du mot de passe dans les réponses via ModerateurAuthResponse
 */
@RestController
@RequestMapping("/api/auth/moderateur")
@AllArgsConstructor
public class ModerateurAuthController {

    private final AuthModerateurUseCase authModerateurUseCase;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<ModerateurAuthResponse> login(@RequestParam String pseudo,
                                                        @RequestParam String motDePasse) {
        return authModerateurUseCase.loginModerateur(pseudo, motDePasse)
                .map(mod -> filterModerateurResponse(mod,
                        jwtService.generateToken(mod.pseudo(), Role.MODERATEUR)))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/register")
    public ResponseEntity<ModerateurAuthResponse> register(@RequestBody ModerateurDtoIn moderateurDtoIn) {
        ModerateurDtoOut created = authModerateurUseCase.registerModerateur(moderateurDtoIn);
        String token = jwtService.generateToken(created.pseudo(), Role.MODERATEUR);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(filterModerateurResponse(created, token));
    }

    private ModerateurAuthResponse filterModerateurResponse(ModerateurDtoOut mod, String token) {
        return new ModerateurAuthResponse(
                mod.id(),
                mod.pseudo(),
                mod.email(),
                mod.numeroDeTelephone(),
                token
        );
    }
}

