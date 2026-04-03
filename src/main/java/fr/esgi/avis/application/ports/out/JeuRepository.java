package fr.esgi.avis.application.ports.out;

import fr.esgi.avis.application.dto.out.JeuDtoOut;

import java.util.List;
import java.util.Optional;

/**
 * Port OUT - Contrat pour la persistance des Jeux
 */
public interface JeuRepository {
    List<JeuDtoOut> findAll();

    Optional<JeuDtoOut> findById(Long id);

    JeuDtoOut save(JeuDtoOut jeuDtoOut);

    void deleteById(Long id);

    List<JeuDtoOut> findByEditeurId(Long editeurId);

    List<JeuDtoOut> findByGenreId(Long genreId);
}

