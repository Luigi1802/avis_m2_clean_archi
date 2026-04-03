package fr.esgi.avis.mapper;

import fr.esgi.avis.dto.EditeurDtoIn;
import fr.esgi.avis.dto.EditeurDtoOut;
import fr.esgi.avis.entity.EditeurEntity;

import java.util.List;

public class EditeurMapper {

    public static EditeurEntity toEntity(EditeurDtoIn dto) {
        if (dto == null) return null;

        EditeurEntity entity = new EditeurEntity();
        entity.setNom(dto.nom());

        return entity;
    }

    public static EditeurDtoOut toDto(EditeurEntity entity) {
        if (entity == null) return null;

        return new EditeurDtoOut(
                entity.getId(),
                entity.getNom(),
                entity.getJeux() == null ? List.of() :
                        entity.getJeux().stream()
                        .map(jeu -> jeu.getId())
                        .toList()
        );
    }
}