package fr.esgi.avis.mapper;

import fr.esgi.avis.business.Joueur;
import fr.esgi.avis.entity.JoueurEntity;

import java.util.List;

public class JoueurMapper {

    public static Joueur toBusinessObject(JoueurEntity entity) {
        if (entity == null) return null;
        Joueur joueur = new Joueur();
        joueur.setId(entity.getId());
        joueur.setMotDePasse(entity.getMotDePasse());
        joueur.setPseudo(entity.getPseudo());
        joueur.setEmail(entity.getEmail());

        joueur.setDateDeNaissance(entity.getDateDeNaissance());
        joueur.setAvatar(AvatarMapper.toBusinessObject(entity.getAvatar()));
        joueur.setAvis(entity.getAvis() == null ? List.of() :
                entity.getAvis().stream()
                        .map(AvisMapper::toBusinessObject)
                        .toList());
        return joueur;
    }

    public static JoueurEntity toEntity(Joueur joueur) {
        if (joueur == null) return null;
        JoueurEntity entity = new JoueurEntity();
        entity.setId(joueur.getId());
        entity.setMotDePasse(joueur.getMotDePasse());
        entity.setPseudo(joueur.getPseudo());
        entity.setEmail(joueur.getEmail());
        entity.setDateDeNaissance(joueur.getDateDeNaissance());
        entity.setAvatar(AvatarMapper.toEntity(joueur.getAvatar()));
        entity.setAvis(joueur.getAvis() == null ? List.of() :
                joueur.getAvis().stream()
                        .map(AvisMapper::toEntity)
                        .toList());
        return entity;
    }
}