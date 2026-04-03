package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.ClassificationEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.ClassificationJpaRepository;
import fr.esgi.avis.application.dto.out.ClassificationDtoOut;
import fr.esgi.avis.application.mappers.ClassificationMapper;
import fr.esgi.avis.application.ports.out.ClassificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de ClassificationRepository - Respecte SOLID-D (Dependency Inversion)
 */
@Repository
@AllArgsConstructor
public class ClassificationRepositoryImpl implements ClassificationRepository {

    private final ClassificationJpaRepository classificationJpaRepository;
    private final ClassificationMapper classificationMapper;

    @Override
    public List<ClassificationDtoOut> findAll() {
        return classificationMapper.toDto(classificationJpaRepository.findAll());
    }

    @Override
    public Optional<ClassificationDtoOut> findById(Long id) {
        return classificationJpaRepository.findById(id).map(classificationMapper::toDto);
    }

    @Override
    public ClassificationDtoOut save(ClassificationDtoOut classificationDtoOut) {
        ClassificationEntity entity = classificationMapper.toEntity(
            new fr.esgi.avis.application.dto.in.ClassificationDtoIn(
                classificationDtoOut.nom(),
                classificationDtoOut.couleurRGB()
            )
        );
        if (classificationDtoOut.id() != null) {
            entity.setId(classificationDtoOut.id());
        }
        ClassificationEntity saved = classificationJpaRepository.save(entity);
        return classificationMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        classificationJpaRepository.deleteById(id);
    }

    @Override
    public Optional<ClassificationDtoOut> findByNom(String nom) {
        return classificationJpaRepository.findByNom(nom).map(classificationMapper::toDto);
    }
}

