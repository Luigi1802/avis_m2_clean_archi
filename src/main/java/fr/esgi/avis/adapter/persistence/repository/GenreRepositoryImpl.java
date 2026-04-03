package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.GenreEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.GenreJpaRepository;
import fr.esgi.avis.application.dto.out.GenreDtoOut;
import fr.esgi.avis.application.mappers.GenreMapper;
import fr.esgi.avis.application.ports.out.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de GenreRepository - Respecte SOLID-D (Dependency Inversion)
 */
@Repository
@AllArgsConstructor
public class GenreRepositoryImpl implements GenreRepository {

    private final GenreJpaRepository genreJpaRepository;
    private final GenreMapper genreMapper;

    @Override
    public List<GenreDtoOut> findAll() {
        return genreMapper.toDto(genreJpaRepository.findAll());
    }

    @Override
    public Optional<GenreDtoOut> findById(Long id) {
        return genreJpaRepository.findById(id).map(genreMapper::toDto);
    }

    @Override
    public GenreDtoOut save(GenreDtoOut genreDtoOut) {
        GenreEntity entity = genreMapper.toEntity(
            new fr.esgi.avis.application.dto.in.GenreDtoIn(genreDtoOut.nom())
        );
        if (genreDtoOut.id() != null) {
            entity.setId(genreDtoOut.id());
        }
        GenreEntity saved = genreJpaRepository.save(entity);
        return genreMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        genreJpaRepository.deleteById(id);
    }

    @Override
    public Optional<GenreDtoOut> findByNom(String nom) {
        return genreJpaRepository.findByNom(nom).map(genreMapper::toDto);
    }
}

