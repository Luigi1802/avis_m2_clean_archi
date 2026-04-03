package fr.esgi.avis.application.usecases;

import fr.esgi.avis.application.dto.in.AvisDtoIn;
import fr.esgi.avis.application.dto.out.AvisDtoOut;
import fr.esgi.avis.application.ports.in.CreateAvisUseCase;
import fr.esgi.avis.application.ports.out.AvisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Implémentation du use case CreateAvisUseCase
 * Respecte SOLID-S et SOLID-D
 */
@Service
@AllArgsConstructor
public class CreateAvisService implements CreateAvisUseCase {

    private final AvisRepository avisRepository;

    @Override
    public AvisDtoOut createAvis(AvisDtoIn avisDtoIn) {
        // Validation métier : vérifier note entre 0 et 5, etc.
        if (avisDtoIn.note() < 0 || avisDtoIn.note() > 5) {
            throw new IllegalArgumentException("La note doit être entre 0 et 5");
        }

        AvisDtoOut avisDtoOut = new AvisDtoOut(
            null, // id sera généré par la DB
            avisDtoIn.description(),
            avisDtoIn.jeuId(),
            avisDtoIn.note(),
            avisDtoIn.joueurId(),
            avisDtoIn.moderateurId(),
            LocalDateTime.now() // date d'envoi actuelle
        );
        return avisRepository.save(avisDtoOut);
    }
}

