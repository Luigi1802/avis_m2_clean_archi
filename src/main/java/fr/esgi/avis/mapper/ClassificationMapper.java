package fr.esgi.avis.mapper;

import fr.esgi.avis.business.Classification;
import fr.esgi.avis.entity.ClassificationEntity;

import java.util.List;

public class ClassificationMapper {

    public static Classification toBusinessObject(ClassificationEntity entity) {
        if (entity == null) return null;

        Classification classification = new Classification();
        classification.setId(entity.getId());
        classification.setNom(entity.getNom());
        classification.setCouleurRGB(entity.getCouleurRGB());
        classification.setJeux(
                entity.getJeux() == null ? List.of() :
                        entity.getJeux().stream()
                        .map(JeuMapper::toBusinessObject)
                        .toList()
        );
        return classification;
    }

    public static ClassificationEntity toEntity(Classification classification) {
        if (classification == null) return null;

        ClassificationEntity entity = new ClassificationEntity();
        entity.setId(classification.getId());
        entity.setNom(classification.getNom());
        entity.setCouleurRGB(classification.getCouleurRGB());
        entity.setJeux(
                classification.getJeux() == null ? List.of() :
                        classification.getJeux().stream()
                        .map(JeuMapper::toEntity)
                        .toList()
        );
        return entity;
    }

    public static Classification toBusinessObjectSansJeux(ClassificationEntity entity) {
        if (entity == null) return null;

        Classification classification = new Classification();
        classification.setId(entity.getId());
        classification.setNom(entity.getNom());
        classification.setCouleurRGB(entity.getCouleurRGB());
        classification.setJeux(List.of());
        return classification;
    }
}