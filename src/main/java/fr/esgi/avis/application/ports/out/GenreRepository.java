package fr.esgi.avis.application.ports.out;

import fr.esgi.avis.application.dto.out.GenreDtoOut;

import java.util.List;
import java.util.Optional;

/**
 * Port OUT - Contrat pour la persistance des Genres
 */
public interface GenreRepository {
    List<GenreDtoOut> findAll();

    Optional<GenreDtoOut> findById(Long id);

    GenreDtoOut save(GenreDtoOut genreDtoOut);

    void deleteById(Long id);

    Optional<GenreDtoOut> findByNom(String nom);
}

