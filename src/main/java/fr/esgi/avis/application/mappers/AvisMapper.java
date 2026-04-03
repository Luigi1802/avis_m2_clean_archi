package fr.esgi.avis.application.mappers;

import fr.esgi.avis.adapter.persistence.entity.AvisEntity;
import fr.esgi.avis.application.dto.in.AvisDtoIn;
import fr.esgi.avis.application.dto.out.AvisDtoOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * Mapper pour Avis - Respecte SOLID-S (Single Responsibility)
 * Responsabilité unique : convertir AvisEntity ↔ AvisDtoIn/Out
 */
@Mapper(componentModel = SPRING)
public interface AvisMapper {

    @Mapping(target = "id", ignore = true)
    AvisEntity toEntity(AvisDtoIn dto);

    @Mapping(target = "jeuId", source = "jeu.id")
    @Mapping(target = "joueurId", source = "joueur.id")
    @Mapping(target = "moderateurId", source = "moderateur.id")
    AvisDtoOut toDto(AvisEntity entity);

    List<AvisEntity> toEntity(List<AvisDtoIn> dtoList);

    List<AvisDtoOut> toDto(List<AvisEntity> entityList);
}
