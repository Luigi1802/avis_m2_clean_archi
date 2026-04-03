package fr.esgi.avis.adapter.controllers;

import fr.esgi.avis.adapter.controllers.dto.ModerateurAuthResponse;
import fr.esgi.avis.application.dto.in.ModerateurDtoIn;
import fr.esgi.avis.application.dto.out.ModerateurDtoOut;
import fr.esgi.avis.application.ports.in.AuthModerateurUseCase;
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

    /**
     * Authentifie un modérateur
     * @param pseudo pseudo du modérateur
     * @param motDePasse mot de passe (
     * @return Les informations du modérateur sans le mot de passe
     */
    @PostMapping("/login")
    public ResponseEntity<ModerateurAuthResponse> login(@RequestParam String pseudo, @RequestParam String motDePasse) {
        return authModerateurUseCase.loginModerateur(pseudo, motDePasse)
            .map(this::filterModerateurResponse)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    /**
     * Enregistre un nouveau modérateur
     * @param moderateurDtoIn les données du modérateur
     * @return Les informations du modérateur créé sans le mot de passe
     */
    @PostMapping("/register")
    public ResponseEntity<ModerateurAuthResponse> register(@RequestBody ModerateurDtoIn moderateurDtoIn) {
        ModerateurDtoOut createdModerateur = authModerateurUseCase.registerModerateur(moderateurDtoIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(filterModerateurResponse(createdModerateur));
    }

    /**
     * Filtre la réponse pour exclure les données sensibles
     */
    private ModerateurAuthResponse filterModerateurResponse(ModerateurDtoOut moderateurDtoOut) {
        return new ModerateurAuthResponse(
            moderateurDtoOut.id(),
            moderateurDtoOut.pseudo(),
            moderateurDtoOut.email(),
            moderateurDtoOut.numeroDeTelephone()
        );
    }
}

