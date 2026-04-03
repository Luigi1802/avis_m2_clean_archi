package fr.esgi.avis.application.mappers;

import fr.esgi.avis.adapter.persistence.entity.JeuEntity;
import fr.esgi.avis.application.dto.in.JeuDtoIn;
import fr.esgi.avis.application.dto.out.JeuDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * Mapper pour Jeu - Respecte SOLID-S (Single Responsibility)
 * Responsabilité unique : convertir JeuEntity ↔ JeuDtoIn/Out
 */
@Mapper(componentModel = SPRING)
public interface JeuMapper {

    @Mapping(target = "id", ignore = true)
    JeuEntity toEntity(JeuDtoIn dto);

    JeuDtoOut toDto(JeuEntity entity);

    List<JeuEntity> toEntity(List<JeuDtoIn> dtoList);

    List<JeuDtoOut> toDto(List<JeuEntity> entityList);
}

