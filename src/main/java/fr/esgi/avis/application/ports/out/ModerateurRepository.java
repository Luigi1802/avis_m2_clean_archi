package fr.esgi.avis.application.ports.out;

import fr.esgi.avis.application.dto.out.ModerateurDtoOut;

import java.util.List;
import java.util.Optional;

/**
 * Port OUT - Contrat pour la persistance des Modérateurs
 */
public interface ModerateurRepository {
    List<ModerateurDtoOut> findAll();

    Optional<ModerateurDtoOut> findById(Long id);

    Optional<ModerateurDtoOut> findByPseudo(String pseudo);

    Optional<ModerateurDtoOut> findByEmail(String email);

    ModerateurDtoOut save(ModerateurDtoOut moderateurDtoOut);

    void deleteById(Long id);
}

