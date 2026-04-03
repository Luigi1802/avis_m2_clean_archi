package fr.esgi.avis.mapper;

import fr.esgi.avis.dto.JeuDtoIn;
import fr.esgi.avis.dto.JeuDtoOut;
import fr.esgi.avis.entity.*;

import java.util.List;

public class JeuMapper {

    public static JeuEntity toEntity(JeuDtoIn dto) {
        if (dto == null) return null;

        JeuEntity entity = new JeuEntity();
        entity.setNom(dto.nom());
        entity.setDateDeSortie(dto.dateDeSortie());
        entity.setDescription(dto.description());
        entity.setPrix(dto.prix());
        entity.setImage(dto.image());

        if (dto.editeurId() != null) {
            EditeurEntity editeur = new EditeurEntity();
            editeur.setId(dto.editeurId());
            entity.setEditeur(editeur);
        }

        if (dto.genreId() != null) {
            GenreEntity genre = new GenreEntity();
            genre.setId(dto.genreId());
            entity.setGenre(genre);
        }

        if (dto.classificationId() != null) {
            ClassificationEntity classification = new ClassificationEntity();
            classification.setId(dto.classificationId());
            entity.setClassification(classification);
        }

        if (dto.plateformeIds() != null) {
            List<PlateformeEntity> plateformes = dto.plateformeIds().stream()
                    .map(id -> {
                        PlateformeEntity plateforme = new PlateformeEntity();
                        plateforme.setId(id);
                        return plateforme;
                    })
                    .toList();
            entity.setPlateformes(plateformes);
        }

        return entity;
    }

    public static JeuDtoOut toDto(JeuEntity entity) {
        if (entity == null) return null;

        return new JeuDtoOut(
                entity.getPlateformes() == null ? List.of() :
                        entity.getPlateformes().stream()
                        .map(PlateformeEntity::getId)
                        .toList(),
                entity.getGenre() == null ? null : entity.getGenre().getId(),
                entity.getId(),
                entity.getNom(),
                entity.getEditeur() == null ? null : entity.getEditeur().getId(),
                entity.getDateDeSortie(),
                entity.getDescription(),
                entity.getPrix(),
                entity.getClassification() == null ? null : entity.getClassification().getId(),
                entity.getImage()
        );
    }
}