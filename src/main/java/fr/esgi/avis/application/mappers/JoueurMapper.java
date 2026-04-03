package fr.esgi.avis.application.mappers;

import fr.esgi.avis.adapter.persistence.entity.JoueurEntity;
import fr.esgi.avis.application.dto.in.JoueurDtoIn;
import fr.esgi.avis.application.dto.out.JoueurDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * Mapper pour Joueur
 */
@Mapper(componentModel = SPRING)
public interface JoueurMapper {

    @Mapping(target = "id", ignore = true)
    JoueurEntity toEntity(JoueurDtoIn dto);

    @Mapping(target = "avatarId", source = "avatar.id")
    JoueurDtoOut toDto(JoueurEntity entity);

    List<JoueurEntity> toEntity(List<JoueurDtoIn> dtoList);

    List<JoueurDtoOut> toDto(List<JoueurEntity> entityList);
}
