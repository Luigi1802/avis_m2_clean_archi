package fr.esgi.avis.mapper;

import fr.esgi.avis.business.Avatar;
import fr.esgi.avis.entity.AvatarEntity;

public class AvatarMapper {

    public static Avatar toBusinessObject(AvatarEntity entity) {
        if (entity == null) return null;
        Avatar avatar = new Avatar();
        avatar.setId(entity.getId());
        avatar.setNom(entity.getNom());
        return avatar;
    }

    public static AvatarEntity toEntity(Avatar avatar) {
        if (avatar == null) return null;
        AvatarEntity entity = new AvatarEntity();
        entity.setId(avatar.getId());
        entity.setNom(avatar.getNom());
        return entity;
    }
}