package fr.esgi.avis.mapper;


import fr.esgi.avis.business.Avis;
import fr.esgi.avis.entity.AvisEntity;

public class AvisMapper {

    public static Avis toBusinessObject(AvisEntity entity) {
        if (entity == null) return null;
        Avis avis = new Avis();
        avis.setId(entity.getId());
        avis.setDescription(entity.getDescription());
        avis.setNote(entity.getNote());
        avis.setDateDEnvoi(entity.getDateDEnvoi());
        // pas de mapping récursif joueur/moderateur ici pour éviter les cycles
        return avis;
    }

    public static AvisEntity toEntity(Avis avis) {
        if (avis == null) return null;
        AvisEntity entity = new AvisEntity();
        entity.setId(avis.getId());
        entity.setDescription(avis.getDescription());
        entity.setNote(avis.getNote());
        entity.setDateDEnvoi(avis.getDateDEnvoi());
        entity.setJoueur(JoueurMapper.toEntity(avis.getJoueur()));
        entity.setModerateur(ModerateurMapper.toEntity(avis.getModerateur()));
        return entity;
    }
}