package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.EditeurEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.EditeurJpaRepository;
import fr.esgi.avis.application.dto.out.EditeurDtoOut;
import fr.esgi.avis.application.mappers.EditeurMapper;
import fr.esgi.avis.application.ports.out.EditeurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EditeurRepositoryImpl implements EditeurRepository {

    private final EditeurJpaRepository editeurJpaRepository;
    private final EditeurMapper editeurMapper;

    @Override
    public List<EditeurDtoOut> findAll() {
        return editeurMapper.toDto(editeurJpaRepository.findAll());
    }

    @Override
    public Optional<EditeurDtoOut> findById(Long id) {
        return editeurJpaRepository.findById(id).map(editeurMapper::toDto);
    }

    @Override
    public EditeurDtoOut save(EditeurDtoOut editeurDtoOut) {
        EditeurEntity entity = editeurMapper.toEntity(
            new fr.esgi.avis.application.dto.in.EditeurDtoIn(editeurDtoOut.nom())
        );
        if (editeurDtoOut.id() != null) {
            entity.setId(editeurDtoOut.id());
        }
        EditeurEntity saved = editeurJpaRepository.save(entity);
        return editeurMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        editeurJpaRepository.deleteById(id);
    }

    @Override
    public Optional<EditeurDtoOut> findByNom(String nom) {
        return editeurJpaRepository.findByNom(nom).map(editeurMapper::toDto);
    }
}
