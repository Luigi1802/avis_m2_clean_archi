package fr.esgi.avis.application.mappers;

import fr.esgi.avis.adapter.persistence.entity.ModerateurEntity;
import fr.esgi.avis.application.dto.in.ModerateurDtoIn;
import fr.esgi.avis.application.dto.out.ModerateurDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper pour Modérateur - Respecte SOLID-S (Single Responsibility)
 * Responsabilité unique : convertir ModerateurEntity ↔ ModerateurDtoIn/Out
 */
@Mapper(componentModel = "spring")
public interface ModerateurMapper {

    @Mapping(target = "id", ignore = true)
    ModerateurEntity toEntity(ModerateurDtoIn dto);

    ModerateurDtoOut toDto(ModerateurEntity entity);

    List<ModerateurEntity> toEntity(List<ModerateurDtoIn> dtoList);

    List<ModerateurDtoOut> toDto(List<ModerateurEntity> entityList);
}

