package fr.esgi.avis.application.ports.out;

import fr.esgi.avis.application.dto.out.JoueurDtoOut;

import java.util.List;
import java.util.Optional;

/**
 * Port OUT - Contrat pour la persistance des Joueurs
 * Respecte SOLID-D (Dependency Inversion)
 */
public interface JoueurRepository {
    List<JoueurDtoOut> findAll();

    Optional<JoueurDtoOut> findById(Long id);

    Optional<JoueurDtoOut> findByPseudo(String pseudo);

    Optional<JoueurDtoOut> findByEmail(String email);

    JoueurDtoOut save(JoueurDtoOut joueurDtoOut);

    void deleteById(Long id);
}

