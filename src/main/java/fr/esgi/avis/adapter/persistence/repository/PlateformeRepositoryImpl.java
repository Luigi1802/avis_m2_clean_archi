package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.PlateformeEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.PlateformeJpaRepository;
import fr.esgi.avis.application.dto.out.PlateformeDtoOut;
import fr.esgi.avis.application.mappers.PlateformeMapper;
import fr.esgi.avis.application.ports.out.PlateformeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de PlateformeRepository
 */
@Repository
@AllArgsConstructor
public class PlateformeRepositoryImpl implements PlateformeRepository {

    private final PlateformeJpaRepository plateformeJpaRepository;
    private final PlateformeMapper plateformeMapper;

    @Override
    public List<PlateformeDtoOut> findAll() {
        return plateformeMapper.toDto(plateformeJpaRepository.findAll());
    }

    @Override
    public Optional<PlateformeDtoOut> findById(Long id) {
        return plateformeJpaRepository.findById(id).map(plateformeMapper::toDto);
    }

    @Override
    public PlateformeDtoOut save(PlateformeDtoOut plateformeDtoOut) {
        PlateformeEntity entity = plateformeMapper.toEntity(
            new fr.esgi.avis.application.dto.in.PlateformeDtoIn(
                plateformeDtoOut.nom(),
                plateformeDtoOut.dateDeSortie()
            )
        );
        if (plateformeDtoOut.id() != null) {
            entity.setId(plateformeDtoOut.id());
        }
        PlateformeEntity saved = plateformeJpaRepository.save(entity);
        return plateformeMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        plateformeJpaRepository.deleteById(id);
    }

    @Override
    public Optional<PlateformeDtoOut> findByNom(String nom) {
        return plateformeJpaRepository.findByNom(nom).map(plateformeMapper::toDto);
    }
}

