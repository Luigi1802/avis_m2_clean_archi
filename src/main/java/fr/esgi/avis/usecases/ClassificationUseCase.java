package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Classification;
import fr.esgi.avis.business.Jeu;

import java.util.List;

public interface ClassificationUseCase {

    List<Classification> recupererClassifications();

    Classification recupererClassification(Long id);

    List<Classification> recupererParNom(String nom);

    List<Jeu> recupererJeux(Long id);

    ClassificationDtoOut ajouterClassification (ClassificationDtoIn classificationDtoIn);
}
