package fr.esgi.avis.adapter.controllers;

import fr.esgi.avis.application.dto.in.AvisDtoIn;
import fr.esgi.avis.application.dto.out.AvisDtoOut;
import fr.esgi.avis.application.ports.in.CreateAvisUseCase;
import fr.esgi.avis.application.ports.in.GetAvisUseCase;
import fr.esgi.avis.application.ports.in.ModerateAvisUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour les Avis
 * Respecte SOLID-D : injecte les use cases (ports in), pas les repositories
 */
@RestController
@RequestMapping("/api/avis")
@AllArgsConstructor
public class AvisController {

    private final GetAvisUseCase getAvisUseCase;
    private final CreateAvisUseCase createAvisUseCase;
    private final ModerateAvisUseCase moderateAvisUseCase;

    @GetMapping
    public ResponseEntity<List<AvisDtoOut>> getAllAvis() {
        return ResponseEntity.ok(getAvisUseCase.getAllAvis());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvisDtoOut> getAvisById(@PathVariable Long id) {
        return getAvisUseCase.getAvisById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/jeu/{jeuId}")
    public ResponseEntity<List<AvisDtoOut>> getAvisByJeu(@PathVariable Long jeuId) {
        return ResponseEntity.ok(getAvisUseCase.getAvisByJeu(jeuId));
    }

    @GetMapping("/joueur/{joueurId}")
    public ResponseEntity<List<AvisDtoOut>> getAvisByJoueur(@PathVariable Long joueurId) {
        return ResponseEntity.ok(getAvisUseCase.getAvisByJoueur(joueurId));
    }

    @PostMapping
    public ResponseEntity<AvisDtoOut> createAvis(@RequestBody AvisDtoIn avisDtoIn) {
        AvisDtoOut createdAvis = createAvisUseCase.createAvis(avisDtoIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAvis);
    }

    @PutMapping("/{id}/moderate")
    public ResponseEntity<AvisDtoOut> moderateAvis(@PathVariable Long id, @RequestBody AvisDtoIn avisDtoIn) {
        AvisDtoOut moderatedAvis = moderateAvisUseCase.moderateAvis(id, avisDtoIn);
        return ResponseEntity.ok(moderatedAvis);
    }
}

