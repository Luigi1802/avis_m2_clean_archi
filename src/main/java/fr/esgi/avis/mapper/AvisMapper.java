package fr.esgi.avis.mapper;

import fr.esgi.avis.dto.AvisDtoIn;
import fr.esgi.avis.dto.AvisDtoOut;
import fr.esgi.avis.entity.*;

public class AvisMapper {

    public static AvisEntity toEntity(AvisDtoIn dto) {
        if (dto == null) return null;

        AvisEntity entity = new AvisEntity();
        entity.setDescription(dto.description());
        entity.setNote(dto.note());
        entity.setDateDEnvoi(dto.dateDEnvoi());

        if (dto.jeuId() != null) {
            JeuEntity jeu = new JeuEntity();
            jeu.setId(dto.jeuId());
            entity.setJeu(jeu);
        }

        if (dto.joueurId() != null) {
            JoueurEntity joueur = new JoueurEntity();
            joueur.setId(dto.joueurId());
            entity.setJoueur(joueur);
        }

        if (dto.moderateurId() != null) {
            ModerateurEntity moderateur = new ModerateurEntity();
            moderateur.setId(dto.moderateurId());
            entity.setModerateur(moderateur);
        }

        return entity;
    }

    public static AvisDtoOut toDto(AvisEntity entity) {
        if (entity == null) return null;

        return new AvisDtoOut(
                entity.getId(),
                entity.getDescription(),
                entity.getJeu() == null ? null : entity.getJeu().getId(),
                entity.getNote(),
                entity.getJoueur() == null ? null : entity.getJoueur().getId(),
                entity.getModerateur() == null ? null : entity.getModerateur().getId(),
                entity.getDateDEnvoi()
        );
    }
}