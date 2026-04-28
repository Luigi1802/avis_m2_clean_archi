package fr.esgi.avis.application.usecases;

import fr.esgi.avis.application.dto.in.JeuDtoIn;
import fr.esgi.avis.application.dto.out.JeuDtoOut;
import fr.esgi.avis.application.ports.in.CreateJeuUseCase;
import fr.esgi.avis.application.ports.out.JeuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implémentation du use case CreateJeuUseCase
 */
@Service
@AllArgsConstructor
public class CreateJeuService implements CreateJeuUseCase {

    private final JeuRepository jeuRepository;

    @Override
    public JeuDtoOut createJeu(JeuDtoIn jeuDtoIn) {
        // Créer un JeuDtoOut avec les données du JeuDtoIn
        JeuDtoOut jeuDtoOut = new JeuDtoOut(
            jeuDtoIn.plateformeIds(),
            jeuDtoIn.genreId(),
            null, // id sera généré par la DB
            jeuDtoIn.nom(),
            jeuDtoIn.editeurId(),
            jeuDtoIn.dateDeSortie(),
            jeuDtoIn.description(),
            jeuDtoIn.prix(),
            jeuDtoIn.classificationId(),
            jeuDtoIn.image()
        );
        return jeuRepository.save(jeuDtoOut);
    }
}

