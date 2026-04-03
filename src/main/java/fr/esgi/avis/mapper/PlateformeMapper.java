package fr.esgi.avis.mapper;

import fr.esgi.avis.business.Plateforme;
import fr.esgi.avis.entity.PlateformeEntity;

import java.util.List;

public class PlateformeMapper {

    public static Plateforme toBusinessObject(PlateformeEntity entity) {
        if (entity == null) return null;

        Plateforme plateforme = new Plateforme();
        plateforme.setId(entity.getId());
        plateforme.setNom(entity.getNom());
        plateforme.setDateDeSortie(entity.getDateDeSortie());
        plateforme.setJeux(
                entity.getJeux() == null ? List.of() :
                        entity.getJeux().stream()
                        .map(JeuMapper::toBusinessObjectSansPlateforme)
                        .toList()
        );
        return plateforme;
    }

    public static PlateformeEntity toEntity(Plateforme plateforme) {
        if (plateforme == null) return null;

        PlateformeEntity entity = new PlateformeEntity();
        entity.setId(plateforme.getId());
        entity.setNom(plateforme.getNom());
        entity.setDateDeSortie(plateforme.getDateDeSortie());
        entity.setJeux(
                plateforme.getJeux() == null ? List.of() :
                        plateforme.getJeux().stream()
                        .map(JeuMapper::toEntitySansPlateforme)
                        .toList()
        );
        return entity;
    }

    // Sans jeux pour couper la récursion depuis JeuMapper
    public static Plateforme toBusinessObjectSansJeux(PlateformeEntity entity) {
        if (entity == null) return null;

        Plateforme plateforme = new Plateforme();
        plateforme.setId(entity.getId());
        plateforme.setNom(entity.getNom());
        plateforme.setDateDeSortie(entity.getDateDeSortie());
        plateforme.setJeux(List.of());
        return plateforme;
    }
}
