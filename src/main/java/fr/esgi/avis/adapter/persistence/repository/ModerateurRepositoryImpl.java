package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.ModerateurEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.ModerateurJpaRepository;
import fr.esgi.avis.application.dto.out.ModerateurDtoOut;
import fr.esgi.avis.application.mappers.ModerateurMapper;
import fr.esgi.avis.application.ports.out.ModerateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de ModerateurRepository - Respecte SOLID-D (Dependency Inversion)
 */
@Repository
@AllArgsConstructor
public class ModerateurRepositoryImpl implements ModerateurRepository {

    private final ModerateurJpaRepository moderateurJpaRepository;
    private final ModerateurMapper moderateurMapper;

    @Override
    public List<ModerateurDtoOut> findAll() {
        return moderateurMapper.toDto(moderateurJpaRepository.findAll());
    }

    @Override
    public Optional<ModerateurDtoOut> findById(Long id) {
        return moderateurJpaRepository.findById(id).map(moderateurMapper::toDto);
    }

    @Override
    public Optional<ModerateurDtoOut> findByPseudo(String pseudo) {
        return moderateurJpaRepository.findByPseudo(pseudo).map(moderateurMapper::toDto);
    }

    @Override
    public Optional<ModerateurDtoOut> findByEmail(String email) {
        return moderateurJpaRepository.findByEmail(email).map(moderateurMapper::toDto);
    }

    @Override
    public ModerateurDtoOut save(ModerateurDtoOut moderateurDtoOut) {
        ModerateurEntity entity = moderateurMapper.toEntity(
            new fr.esgi.avis.application.dto.in.ModerateurDtoIn(
                moderateurDtoOut.motDePasse(),
                moderateurDtoOut.pseudo(),
                moderateurDtoOut.email(),
                moderateurDtoOut.numeroDeTelephone()
            )
        );
        if (moderateurDtoOut.id() != null) {
            entity.setId(moderateurDtoOut.id());
        }
        ModerateurEntity saved = moderateurJpaRepository.save(entity);
        return moderateurMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        moderateurJpaRepository.deleteById(id);
    }
}

