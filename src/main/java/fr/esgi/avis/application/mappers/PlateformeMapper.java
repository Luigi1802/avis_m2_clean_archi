package fr.esgi.avis.application.mappers;

import fr.esgi.avis.adapter.persistence.entity.PlateformeEntity;
import fr.esgi.avis.application.dto.in.PlateformeDtoIn;
import fr.esgi.avis.application.dto.out.PlateformeDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * Mapper pour Plateforme
 */
@Mapper(componentModel = SPRING)
public interface PlateformeMapper {

    @Mapping(target = "id", ignore = true)
    PlateformeEntity toEntity(PlateformeDtoIn dto);

    @Mapping(target = "jeuxIds", expression = "java(entity.getJeux() != null ? entity.getJeux().stream().map(j -> j.getId()).collect(java.util.stream.Collectors.toList()) : null)")
    PlateformeDtoOut toDto(PlateformeEntity entity);

    List<PlateformeEntity> toEntity(List<PlateformeDtoIn> dtoList);

    List<PlateformeDtoOut> toDto(List<PlateformeEntity> entityList);
}
