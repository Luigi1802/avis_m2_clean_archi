package fr.esgi.avis.mapper;

import fr.esgi.avis.business.Genre;
import fr.esgi.avis.entity.GenreEntity;

import java.util.List;

public class GenreMapper {

    public static Genre toBusinessObject(GenreEntity entity) {
        if (entity == null) return null;

        Genre genre = new Genre();
        genre.setId(entity.getId());
        genre.setNom(entity.getNom());
        genre.setJeux(
                entity.getJeux() == null ? List.of() :
                        entity.getJeux().stream()
                        .map(JeuMapper::toBusinessObjectSansGenre)
                        .toList()
        );
        return genre;
    }

    public static GenreEntity toEntity(Genre genre) {
        if (genre == null) return null;

        GenreEntity entity = new GenreEntity();
        entity.setId(genre.getId());
        entity.setNom(genre.getNom());
        entity.setJeux(
                genre.getJeux() == null ? List.of() :
                        genre.getJeux().stream()
                        .map(JeuMapper::toEntitySansGenre)
                        .toList()
        );
        return entity;
    }

    // Sans jeux pour couper la récursion depuis JeuMapper
    public static Genre toBusinessObjectSansJeux(GenreEntity entity) {
        if (entity == null) return null;

        Genre genre = new Genre();
        genre.setId(entity.getId());
        genre.setNom(entity.getNom());
        genre.setJeux(List.of());
        return genre;
    }
}
