package fr.esgi.avis.mapper;

import fr.esgi.avis.business.Utilisateur;
import fr.esgi.avis.entity.UtilisateurEntity;

public class UtilisateurMapper {

    public static Utilisateur toBusinessObject(UtilisateurEntity entity) {
        if (entity == null) return null;
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(entity.getId());
        utilisateur.setMotDePasse(entity.getMotDePasse());
        utilisateur.setPseudo(entity.getPseudo());
        utilisateur.setEmail(entity.getEmail());
        return utilisateur;
    }

    public static UtilisateurEntity toEntity(Utilisateur utilisateur) {
        if (utilisateur == null) return null;
        UtilisateurEntity entity = new UtilisateurEntity();
        entity.setId(utilisateur.getId());
        entity.setMotDePasse(utilisateur.getMotDePasse());
        entity.setPseudo(utilisateur.getPseudo());
        entity.setEmail(utilisateur.getEmail());
        return entity;
    }
}
