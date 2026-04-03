package fr.esgi.avis.application.usecases;

import fr.esgi.avis.application.dto.out.JeuDtoOut;
import fr.esgi.avis.application.ports.in.GetJeuxUseCase;
import fr.esgi.avis.application.ports.out.JeuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation du use case GetJeuxUseCase
 */
@Service
@AllArgsConstructor
public class GetJeuxService implements GetJeuxUseCase {

    private final JeuRepository jeuRepository;

    @Override
    public List<JeuDtoOut> getAllJeux() {
        return jeuRepository.findAll();
    }

    @Override
    public Optional<JeuDtoOut> getJeuById(Long id) {
        return jeuRepository.findById(id);
    }

    @Override
    public List<JeuDtoOut> getJeuxByEditeur(Long editeurId) {
        return jeuRepository.findByEditeurId(editeurId);
    }

    @Override
    public List<JeuDtoOut> getJeuxByGenre(Long genreId) {
        return jeuRepository.findByGenreId(genreId);
    }
}

