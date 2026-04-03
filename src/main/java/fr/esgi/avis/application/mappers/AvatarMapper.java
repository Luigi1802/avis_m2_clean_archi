package fr.esgi.avis.application.mappers;

import fr.esgi.avis.adapter.persistence.entity.AvatarEntity;
import fr.esgi.avis.application.dto.in.AvatarDtoIn;
import fr.esgi.avis.application.dto.out.AvatarDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper pour Avatar - Respecte SOLID-S (Single Responsibility)
 * Responsabilité unique : convertir AvatarEntity ↔ AvatarDtoIn/Out
 */
@Mapper(componentModel = "spring")
public interface AvatarMapper {

    @Mapping(target = "id", ignore = true)
    AvatarEntity toEntity(AvatarDtoIn dto);

    AvatarDtoOut toDto(AvatarEntity entity);

    List<AvatarEntity> toEntity(List<AvatarDtoIn> dtoList);

    List<AvatarDtoOut> toDto(List<AvatarEntity> entityList);
}

