package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Jeu;
import fr.esgi.avis.business.Genre;
import fr.esgi.avis.dto.GenreDtoIn;
import fr.esgi.avis.dto.GenreDtoOut;

import java.util.List;

public interface GenreUseCase {

    List<Genre> recupererGenres();

    Genre recupererGenre(Long id);

    List<Genre> recupererParNom(String nom);

    List<Jeu> recupererJeux(Long id);

    GenreDtoOut ajouterGenre (GenreDtoIn genreDtoIn);

    GenreDtoOut modifierGenre (GenreDtoIn genreDtoIn);

    void supprimerGenre(Long id);
}
