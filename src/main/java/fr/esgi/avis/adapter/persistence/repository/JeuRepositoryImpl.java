package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.JeuEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.JeuJpaRepository;
import fr.esgi.avis.application.dto.out.JeuDtoOut;
import fr.esgi.avis.application.mappers.JeuMapper;
import fr.esgi.avis.application.ports.out.JeuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de JeuRepository
 */
@Repository
@AllArgsConstructor
public class JeuRepositoryImpl implements JeuRepository {

    private final JeuJpaRepository jeuJpaRepository;
    private final JeuMapper jeuMapper;

    @Override
    public List<JeuDtoOut> findAll() {
        return jeuMapper.toDto(jeuJpaRepository.findAll());
    }

    @Override
    public Optional<JeuDtoOut> findById(Long id) {
        return jeuJpaRepository.findById(id).map(jeuMapper::toDto);
    }

    @Override
    public JeuDtoOut save(JeuDtoOut jeuDtoOut) {
        JeuEntity entity = jeuMapper.toEntity(
            new fr.esgi.avis.application.dto.in.JeuDtoIn(
                jeuDtoOut.plateformeIds(),
                jeuDtoOut.genreId(),
                jeuDtoOut.nom(),
                jeuDtoOut.editeurId(),
                jeuDtoOut.dateDeSortie(),
                jeuDtoOut.description(),
                jeuDtoOut.prix(),
                jeuDtoOut.classificationId(),
                jeuDtoOut.image()
            )
        );
        if (jeuDtoOut.id() != null) {
            entity.setId(jeuDtoOut.id());
        }
        JeuEntity saved = jeuJpaRepository.save(entity);
        return jeuMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        jeuJpaRepository.deleteById(id);
    }

    @Override
    public List<JeuDtoOut> findByEditeurId(Long editeurId) {
        return jeuMapper.toDto(jeuJpaRepository.findByEditeurId(editeurId));
    }

    @Override
    public List<JeuDtoOut> findByGenreId(Long genreId) {
        return jeuMapper.toDto(jeuJpaRepository.findByGenreId(genreId));
    }
}

