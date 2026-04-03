package fr.esgi.avis.adapter.controllers;

import fr.esgi.avis.application.dto.in.JeuDtoIn;
import fr.esgi.avis.application.dto.out.JeuDtoOut;
import fr.esgi.avis.application.ports.in.CreateJeuUseCase;
import fr.esgi.avis.application.ports.in.GetJeuxUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour les Jeux
 * Respecte SOLID-D : injecte les use cases (ports in), pas les repositories
 */
@RestController
@RequestMapping("/api/jeux")
@AllArgsConstructor
public class JeuController {

    private final GetJeuxUseCase getJeuxUseCase;
    private final CreateJeuUseCase createJeuUseCase;

    @GetMapping
    public ResponseEntity<List<JeuDtoOut>> getAllJeux() {
        return ResponseEntity.ok(getJeuxUseCase.getAllJeux());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JeuDtoOut> getJeuById(@PathVariable Long id) {
        return getJeuxUseCase.getJeuById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/editeur/{editeurId}")
    public ResponseEntity<List<JeuDtoOut>> getJeuxByEditeur(@PathVariable Long editeurId) {
        return ResponseEntity.ok(getJeuxUseCase.getJeuxByEditeur(editeurId));
    }

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<List<JeuDtoOut>> getJeuxByGenre(@PathVariable Long genreId) {
        return ResponseEntity.ok(getJeuxUseCase.getJeuxByGenre(genreId));
    }

    @PostMapping
    public ResponseEntity<JeuDtoOut> createJeu(@RequestBody JeuDtoIn jeuDtoIn) {
        JeuDtoOut createdJeu = createJeuUseCase.createJeu(jeuDtoIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJeu);
    }
}

