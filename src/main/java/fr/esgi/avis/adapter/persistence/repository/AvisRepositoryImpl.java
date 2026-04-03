package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.AvisEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.AvisJpaRepository;
import fr.esgi.avis.application.dto.out.AvisDtoOut;
import fr.esgi.avis.application.mappers.AvisMapper;
import fr.esgi.avis.application.ports.out.AvisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de AvisRepository - Respecte SOLID-D (Dependency Inversion)
 */
@Repository
@AllArgsConstructor
public class AvisRepositoryImpl implements AvisRepository {

    private final AvisJpaRepository avisJpaRepository;
    private final AvisMapper avisMapper;

    @Override
    public List<AvisDtoOut> findAll() {
        return avisMapper.toDto(avisJpaRepository.findAll());
    }

    @Override
    public Optional<AvisDtoOut> findById(Long id) {
        return avisJpaRepository.findById(id).map(avisMapper::toDto);
    }

    @Override
    public AvisDtoOut save(AvisDtoOut avisDtoOut) {
        AvisEntity entity = avisMapper.toEntity(
            new fr.esgi.avis.application.dto.in.AvisDtoIn(
                avisDtoOut.description(),
                avisDtoOut.jeuId(),
                avisDtoOut.note(),
                avisDtoOut.joueurId(),
                avisDtoOut.moderateurId(),
                avisDtoOut.dateDEnvoi()
            )
        );
        if (avisDtoOut.id() != null) {
            entity.setId(avisDtoOut.id());
        }
        AvisEntity saved = avisJpaRepository.save(entity);
        return avisMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        avisJpaRepository.deleteById(id);
    }

    @Override
    public List<AvisDtoOut> findByJeuId(Long jeuId) {
        return avisMapper.toDto(avisJpaRepository.findByJeuId(jeuId));
    }

    @Override
    public List<AvisDtoOut> findByJoueurId(Long joueurId) {
        return avisMapper.toDto(avisJpaRepository.findByJoueurId(joueurId));
    }

    @Override
    public List<AvisDtoOut> findByModerateurId(Long moderateurId) {
        return avisMapper.toDto(avisJpaRepository.findByModerateurId(moderateurId));
    }
}

