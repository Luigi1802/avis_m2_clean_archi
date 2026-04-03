package fr.esgi.avis.application.mappers;

import fr.esgi.avis.adapter.persistence.entity.AvisEntity;
import fr.esgi.avis.application.dto.in.AvisDtoIn;
import fr.esgi.avis.application.dto.out.AvisDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper pour Avis - Respecte SOLID-S (Single Responsibility)
 * Responsabilité unique : convertir AvisEntity ↔ AvisDtoIn/Out
 */
@Mapper(componentModel = "spring")
public interface AvisMapper {

    @Mapping(target = "id", ignore = true)
    AvisEntity toEntity(AvisDtoIn dto);

    AvisDtoOut toDto(AvisEntity entity);

    List<AvisEntity> toEntity(List<AvisDtoIn> dtoList);

    List<AvisDtoOut> toDto(List<AvisEntity> entityList);
}

