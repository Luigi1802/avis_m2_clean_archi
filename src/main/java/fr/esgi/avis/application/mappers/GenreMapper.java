package fr.esgi.avis.application.mappers;

import fr.esgi.avis.adapter.persistence.entity.GenreEntity;
import fr.esgi.avis.application.dto.in.GenreDtoIn;
import fr.esgi.avis.application.dto.out.GenreDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * Mapper pour Genre - Respecte SOLID-S (Single Responsibility)
 * Responsabilité unique : convertir GenreEntity ↔ GenreDtoIn/Out
 */
@Mapper(componentModel = SPRING)
public interface GenreMapper {

    @Mapping(target = "id", ignore = true)
    GenreEntity toEntity(GenreDtoIn dto);

    GenreDtoOut toDto(GenreEntity entity);

    List<GenreEntity> toEntity(List<GenreDtoIn> dtoList);

    List<GenreDtoOut> toDto(List<GenreEntity> entityList);
}

