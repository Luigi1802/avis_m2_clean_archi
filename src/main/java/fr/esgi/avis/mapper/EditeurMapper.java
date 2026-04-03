package fr.esgi.avis.mapper;

import fr.esgi.avis.business.Editeur;
import fr.esgi.avis.entity.EditeurEntity;

import java.util.List;

public class EditeurMapper {

    public static Editeur toBusinessObject(EditeurEntity entity) {
        if (entity == null) return null;

        Editeur editeur = new Editeur();
        editeur.setId(entity.getId());
        editeur.setNom(entity.getNom());
        editeur.setJeux(
                entity.getJeux() == null ? List.of() :
                        entity.getJeux().stream()
                        .map(JeuMapper::toBusinessObjectSansEditeur)
                        .toList()
        );
        return editeur;
    }

    public static EditeurEntity toEntity(Editeur editeur) {
        if (editeur == null) return null;

        EditeurEntity entity = new EditeurEntity();
        entity.setId(editeur.getId());
        entity.setNom(editeur.getNom());
        entity.setJeux(
                editeur.getJeux() == null ? List.of() :
                        editeur.getJeux().stream()
                        .map(JeuMapper::toEntitySansEditeur)
                        .toList()
        );
        return entity;
    }

    public static Editeur toBusinessObjectSansJeux(EditeurEntity entity) {
        if (entity == null) return null;

        Editeur editeur = new Editeur();
        editeur.setId(entity.getId());
        editeur.setNom(entity.getNom());
        editeur.setJeux(List.of());
        return editeur;
    }
}