package fr.esgi.avis.application.usecases;

import fr.esgi.avis.application.dto.out.AvisDtoOut;
import fr.esgi.avis.application.ports.in.GetAvisUseCase;
import fr.esgi.avis.application.ports.out.AvisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation du use case GetAvisUseCase
 */
@Service
@AllArgsConstructor
public class GetAvisService implements GetAvisUseCase {

    private final AvisRepository avisRepository;

    @Override
    public List<AvisDtoOut> getAllAvis() {
        return avisRepository.findAll();
    }

    @Override
    public Optional<AvisDtoOut> getAvisById(Long id) {
        return avisRepository.findById(id);
    }

    @Override
    public List<AvisDtoOut> getAvisByJeu(Long jeuId) {
        return avisRepository.findByJeuId(jeuId);
    }

    @Override
    public List<AvisDtoOut> getAvisByJoueur(Long joueurId) {
        return avisRepository.findByJoueurId(joueurId);
    }
}

