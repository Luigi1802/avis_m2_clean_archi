package fr.esgi.avis.application.mappers;

import fr.esgi.avis.adapter.persistence.entity.AvatarEntity;
import fr.esgi.avis.application.dto.in.AvatarDtoIn;
import fr.esgi.avis.application.dto.out.AvatarDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * Mapper pour Avatar
 */
@Mapper(componentModel = SPRING)
public interface AvatarMapper {

    @Mapping(target = "id", ignore = true)
    AvatarEntity toEntity(AvatarDtoIn dto);

    AvatarDtoOut toDto(AvatarEntity entity);

    List<AvatarEntity> toEntity(List<AvatarDtoIn> dtoList);

    List<AvatarDtoOut> toDto(List<AvatarEntity> entityList);
}

