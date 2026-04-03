package fr.esgi.avis.application.mappers;

import fr.esgi.avis.adapter.persistence.entity.EditeurEntity;
import fr.esgi.avis.application.dto.in.EditeurDtoIn;
import fr.esgi.avis.application.dto.out.EditeurDtoOut;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditeurMapper {

    EditeurEntity toEntity(EditeurDtoIn dto);

    EditeurDtoOut toDto(EditeurEntity entity);

    List<EditeurEntity> toEntity(List<EditeurDtoIn> editeurDtoIn);

    List<EditeurDtoOut> toDto(List<EditeurEntity> editeurEntity);
}