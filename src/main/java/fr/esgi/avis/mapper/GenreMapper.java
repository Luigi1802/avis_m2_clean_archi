package fr.esgi.avis.mapper;

import fr.esgi.avis.dto.GenreDtoIn;
import fr.esgi.avis.dto.GenreDtoOut;
import fr.esgi.avis.entity.GenreEntity;

import java.util.List;

public class GenreMapper {

    // DtoIn → Entity
    public static GenreEntity toEntity(GenreDtoIn dto) {
        if (dto == null) return null;

        GenreEntity entity = new GenreEntity();
        entity.setNom(dto.nom());

        return entity;
    }

    // Entity → DtoOut
    public static GenreDtoOut toDto(GenreEntity entity) {
        if (entity == null) return null;

        return new GenreDtoOut(
                entity.getId(),
                entity.getNom(),
                entity.getJeux() == null ? List.of() :
                        entity.getJeux().stream()
                        .map(jeu -> jeu.getId())
                        .toList()
        );
    }
}