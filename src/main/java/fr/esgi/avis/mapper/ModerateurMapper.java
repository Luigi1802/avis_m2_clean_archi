package fr.esgi.avis.mapper;

import fr.esgi.avis.business.Moderateur;
import fr.esgi.avis.entity.ModerateurEntity;

public class ModerateurMapper {

    public static Moderateur toBusinessObject(ModerateurEntity entity) {
        if (entity == null) return null;
        Moderateur moderateur = new Moderateur();
        moderateur.setId(entity.getId());
        moderateur.setMotDePasse(entity.getMotDePasse());
        moderateur.setPseudo(entity.getPseudo());
        moderateur.setEmail(entity.getEmail());
        moderateur.setNumeroDeTelephone(entity.getNumeroDeTelephone());
        return moderateur;
    }

    public static ModerateurEntity toEntity(Moderateur moderateur) {
        if (moderateur == null) return null;
        ModerateurEntity entity = new ModerateurEntity();
        entity.setId(moderateur.getId());
        entity.setMotDePasse(moderateur.getMotDePasse());
        entity.setPseudo(moderateur.getPseudo());
        entity.setEmail(moderateur.getEmail());
        entity.setNumeroDeTelephone(moderateur.getNumeroDeTelephone());
        return entity;
    }
}