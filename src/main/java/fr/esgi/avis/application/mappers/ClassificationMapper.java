package fr.esgi.avis.application.mappers;

import fr.esgi.avis.adapter.persistence.entity.ClassificationEntity;
import fr.esgi.avis.application.dto.in.ClassificationDtoIn;
import fr.esgi.avis.application.dto.out.ClassificationDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * Mapper pour Classification - Respecte SOLID-S (Single Responsibility)
 * Responsabilité unique : convertir ClassificationEntity ↔ ClassificationDtoIn/Out
 */
@Mapper(componentModel = SPRING)
public interface ClassificationMapper {

    @Mapping(target = "id", ignore = true)
    ClassificationEntity toEntity(ClassificationDtoIn dto);

    ClassificationDtoOut toDto(ClassificationEntity entity);

    List<ClassificationEntity> toEntity(List<ClassificationDtoIn> dtoList);

    List<ClassificationDtoOut> toDto(List<ClassificationEntity> entityList);
}

