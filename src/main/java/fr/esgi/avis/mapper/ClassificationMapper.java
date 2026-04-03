package fr.esgi.avis.mapper;

import fr.esgi.avis.dto.ClassificationDtoIn;
import fr.esgi.avis.dto.ClassificationDtoOut;
import fr.esgi.avis.entity.ClassificationEntity;

import java.util.List;

public class ClassificationMapper {

    // DtoIn → Entity
    public static ClassificationEntity toEntity(ClassificationDtoIn dto) {
        if (dto == null) return null;

        ClassificationEntity entity = new ClassificationEntity();
        entity.setNom(dto.nom());
        entity.setCouleurRGB(dto.couleurRGB());

        return entity;
    }

    // Entity → DtoOut
    public static ClassificationDtoOut toDto(ClassificationEntity entity) {
        if (entity == null) return null;

        return new ClassificationDtoOut(
                entity.getJeux() == null ? List.of() :
                        entity.getJeux().stream()
                        .map(jeu -> jeu.getId())
                        .toList(),
                entity.getId(),
                entity.getNom(),
                entity.getCouleurRGB()
        );
    }
}