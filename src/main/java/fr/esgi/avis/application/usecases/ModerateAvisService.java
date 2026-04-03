package fr.esgi.avis.application.usecases;

import fr.esgi.avis.application.dto.in.AvisDtoIn;
import fr.esgi.avis.application.dto.out.AvisDtoOut;
import fr.esgi.avis.application.ports.in.ModerateAvisUseCase;
import fr.esgi.avis.application.ports.out.AvisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implémentation du use case ModerateAvisUseCase
 */
@Service
@AllArgsConstructor
public class ModerateAvisService implements ModerateAvisUseCase {

    private final AvisRepository avisRepository;

    @Override
    public AvisDtoOut moderateAvis(Long avisId, AvisDtoIn avisDtoIn) {
        // Récupérer l'avis existant
        AvisDtoOut existingAvis = avisRepository.findById(avisId)
            .orElseThrow(() -> new IllegalArgumentException("Avis not found with id: " + avisId));

        // Mettre à jour avec les données du modérateur
        AvisDtoOut updatedAvis = new AvisDtoOut(
            existingAvis.id(),
            avisDtoIn.description(),
            existingAvis.jeuId(),
            avisDtoIn.note(),
            existingAvis.joueurId(),
            avisDtoIn.moderateurId(), // Le modérateur met à jour son ID
            existingAvis.dateDEnvoi()
        );

        return avisRepository.save(updatedAvis);
    }
}

