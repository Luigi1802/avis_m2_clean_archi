package fr.esgi.avis.mapper;

import fr.esgi.avis.dto.AvatarDtoIn;
import fr.esgi.avis.dto.AvatarDtoOut;
import fr.esgi.avis.entity.AvatarEntity;
import fr.esgi.avis.entity.JoueurEntity;

public class AvatarMapper {

    public static AvatarEntity toEntity(AvatarDtoIn dto) {
        if (dto == null) return null;

        AvatarEntity entity = new AvatarEntity();
        entity.setNom(dto.nom());

        if (dto.joueurId() != null) {
            JoueurEntity joueur = new JoueurEntity();
            joueur.setId(dto.joueurId());
            entity.setJoueur(joueur);
        }

        return entity;
    }

    public static AvatarDtoOut toDto(AvatarEntity entity) {
        if (entity == null) return null;

        return new AvatarDtoOut(
                entity.getId(),
                entity.getNom(),
                entity.getJoueur() == null ? null : entity.getJoueur().getId()
        );
    }
}