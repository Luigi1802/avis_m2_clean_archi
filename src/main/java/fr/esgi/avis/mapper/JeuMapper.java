package fr.esgi.avis.mapper;

import fr.esgi.avis.business.Jeu;
import fr.esgi.avis.entity.JeuEntity;

import java.util.List;

public class JeuMapper {

    public static Jeu toBusinessObject(JeuEntity entity) {
        if (entity == null) return null;

        Jeu jeu = new Jeu();
        jeu.setId(entity.getId());
        jeu.setNom(entity.getNom());
        jeu.setDateDeSortie(entity.getDateDeSortie());
        jeu.setDescription(entity.getDescription());
        jeu.setPrix(entity.getPrix());
        jeu.setImage(entity.getImage());
        jeu.setEditeur(EditeurMapper.toBusinessObjectSansJeux(entity.getEditeur()));
        jeu.setGenre(GenreMapper.toBusinessObjectSansJeux(entity.getGenre()));
        jeu.setClassification(ClassificationMapper.toBusinessObjectSansJeux(entity.getClassification()));
        jeu.setPlateformes(
                entity.getPlateformes() == null ? List.of() :
                        entity.getPlateformes().stream()
                        .map(PlateformeMapper::toBusinessObjectSansJeux)
                        .toList()
        );
        return jeu;
    }

    public static JeuEntity toEntity(Jeu jeu) {
        if (jeu == null) return null;

        JeuEntity entity = new JeuEntity();
        entity.setId(jeu.getId());
        entity.setNom(jeu.getNom());
        entity.setDateDeSortie(jeu.getDateDeSortie());
        entity.setDescription(jeu.getDescription());
        entity.setPrix(jeu.getPrix());
        entity.setImage(jeu.getImage());
        entity.setEditeur(EditeurMapper.toEntity(jeu.getEditeur()));
        entity.setGenre(GenreMapper.toEntity(jeu.getGenre()));
        entity.setClassification(ClassificationMapper.toEntity(jeu.getClassification()));
        entity.setPlateformes(
                jeu.getPlateformes() == null ? List.of() :
                        jeu.getPlateformes().stream()
                        .map(PlateformeMapper::toEntity)
                        .toList()
        );
        return entity;
    }

    public static Jeu toBusinessObjectSansEditeur(JeuEntity entity) {
        if (entity == null) return null;

        Jeu jeu = new Jeu();
        jeu.setId(entity.getId());
        jeu.setNom(entity.getNom());
        jeu.setDateDeSortie(entity.getDateDeSortie());
        jeu.setDescription(entity.getDescription());
        jeu.setPrix(entity.getPrix());
        jeu.setImage(entity.getImage());
        jeu.setEditeur(null);
        jeu.setGenre(GenreMapper.toBusinessObjectSansJeux(entity.getGenre()));
        jeu.setClassification(ClassificationMapper.toBusinessObjectSansJeux(entity.getClassification()));
        jeu.setPlateformes(
                entity.getPlateformes() == null ? List.of() :
                        entity.getPlateformes().stream()
                        .map(PlateformeMapper::toBusinessObjectSansJeux)
                        .toList()
        );
        return jeu;
    }

    public static Jeu toBusinessObjectSansGenre(JeuEntity entity) {
        if (entity == null) return null;

        Jeu jeu = new Jeu();
        jeu.setId(entity.getId());
        jeu.setNom(entity.getNom());
        jeu.setDateDeSortie(entity.getDateDeSortie());
        jeu.setDescription(entity.getDescription());
        jeu.setPrix(entity.getPrix());
        jeu.setImage(entity.getImage());
        jeu.setEditeur(EditeurMapper.toBusinessObjectSansJeux(entity.getEditeur()));
        jeu.setGenre(null);
        jeu.setClassification(ClassificationMapper.toBusinessObjectSansJeux(entity.getClassification()));
        jeu.setPlateformes(
                entity.getPlateformes() == null ? List.of() :
                        entity.getPlateformes().stream()
                        .map(PlateformeMapper::toBusinessObjectSansJeux)
                        .toList()
        );
        return jeu;
    }

    public static Jeu toBusinessObjectSansPlateforme(JeuEntity entity) {
        if (entity == null) return null;

        Jeu jeu = new Jeu();
        jeu.setId(entity.getId());
        jeu.setNom(entity.getNom());
        jeu.setDateDeSortie(entity.getDateDeSortie());
        jeu.setDescription(entity.getDescription());
        jeu.setPrix(entity.getPrix());
        jeu.setImage(entity.getImage());
        jeu.setEditeur(EditeurMapper.toBusinessObjectSansJeux(entity.getEditeur()));
        jeu.setGenre(GenreMapper.toBusinessObjectSansJeux(entity.getGenre()));
        jeu.setClassification(ClassificationMapper.toBusinessObjectSansJeux(entity.getClassification()));
        jeu.setPlateformes(List.of());
        return jeu;
    }

    public static JeuEntity toEntitySansEditeur(Jeu jeu) {
        if (jeu == null) return null;

        JeuEntity entity = new JeuEntity();
        entity.setId(jeu.getId());
        entity.setNom(jeu.getNom());
        entity.setDateDeSortie(jeu.getDateDeSortie());
        entity.setDescription(jeu.getDescription());
        entity.setPrix(jeu.getPrix());
        entity.setImage(jeu.getImage());
        entity.setEditeur(null);
        entity.setGenre(GenreMapper.toEntity(jeu.getGenre()));
        entity.setClassification(ClassificationMapper.toEntity(jeu.getClassification()));
        entity.setPlateformes(
                jeu.getPlateformes() == null ? List.of() :
                        jeu.getPlateformes().stream()
                        .map(PlateformeMapper::toEntity)
                        .toList()
        );
        return entity;
    }

    public static JeuEntity toEntitySansGenre(Jeu jeu) {
        if (jeu == null) return null;

        JeuEntity entity = new JeuEntity();
        entity.setId(jeu.getId());
        entity.setNom(jeu.getNom());
        entity.setDateDeSortie(jeu.getDateDeSortie());
        entity.setDescription(jeu.getDescription());
        entity.setPrix(jeu.getPrix());
        entity.setImage(jeu.getImage());
        entity.setEditeur(EditeurMapper.toEntity(jeu.getEditeur()));
        entity.setGenre(null);
        entity.setClassification(ClassificationMapper.toEntity(jeu.getClassification()));
        entity.setPlateformes(
                jeu.getPlateformes() == null ? List.of() :
                        jeu.getPlateformes().stream()
                        .map(PlateformeMapper::toEntity)
                        .toList()
        );
        return entity;
    }

    public static JeuEntity toEntitySansPlateforme(Jeu jeu) {
        if (jeu == null) return null;

        JeuEntity entity = new JeuEntity();
        entity.setId(jeu.getId());
        entity.setNom(jeu.getNom());
        entity.setDateDeSortie(jeu.getDateDeSortie());
        entity.setDescription(jeu.getDescription());
        entity.setPrix(jeu.getPrix());
        entity.setImage(jeu.getImage());
        entity.setEditeur(EditeurMapper.toEntity(jeu.getEditeur()));
        entity.setGenre(GenreMapper.toEntity(jeu.getGenre()));
        entity.setClassification(ClassificationMapper.toEntity(jeu.getClassification()));
        entity.setPlateformes(List.of());
        return entity;
    }
}