package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.repository.jpa.EditeurJpaRepository;
import fr.esgi.avis.application.dto.out.EditeurDtoOut;
import fr.esgi.avis.application.mappers.EditeurMapper;
import fr.esgi.avis.application.ports.out.EditeurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EditeurRepositoryImpl implements EditeurRepository {

    private final EditeurJpaRepository editeurJpaRepository;
    private final EditeurMapper editeurMapper;

    @Override
    public List<EditeurDtoOut> findAll() {
        return editeurMapper.toDto(editeurJpaRepository.findAll());
    }
}
