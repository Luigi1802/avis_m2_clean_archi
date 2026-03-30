package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Jeu;
import fr.esgi.avis.business.Genre;

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
