package fr.esgi.avis.application.ports.in;

import fr.esgi.avis.application.dto.out.JeuDtoOut;

import java.util.List;
import java.util.Optional;

/**
 * Port IN - Use Case: Récupérer les jeux
 */
public interface GetJeuxUseCase {
    List<JeuDtoOut> getAllJeux();

    Optional<JeuDtoOut> getJeuById(Long id);

    List<JeuDtoOut> getJeuxByEditeur(Long editeurId);

    List<JeuDtoOut> getJeuxByGenre(Long genreId);
}

