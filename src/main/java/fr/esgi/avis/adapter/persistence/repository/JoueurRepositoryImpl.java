package fr.esgi.avis.adapter.persistence.repository;

import fr.esgi.avis.adapter.persistence.entity.JoueurEntity;
import fr.esgi.avis.adapter.persistence.repository.jpa.JoueurJpaRepository;
import fr.esgi.avis.application.dto.in.JoueurDtoIn;
import fr.esgi.avis.application.dto.out.JoueurDtoOut;
import fr.esgi.avis.application.mappers.JoueurMapper;
import fr.esgi.avis.application.ports.out.JoueurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de JoueurRepository - Respecte SOLID-D (Dependency Inversion)
 */
@Repository
@AllArgsConstructor
public class JoueurRepositoryImpl implements JoueurRepository {

    private final JoueurJpaRepository joueurJpaRepository;
    private final JoueurMapper joueurMapper;

    @Override
    public List<JoueurDtoOut> findAll() {
        return joueurMapper.toDto(joueurJpaRepository.findAll());
    }

    @Override
    public Optional<JoueurDtoOut> findById(Long id) {
        return joueurJpaRepository.findById(id).map(joueurMapper::toDto);
    }

    @Override
    public Optional<JoueurDtoOut> findByPseudo(String pseudo) {
        return joueurJpaRepository.findByPseudo(pseudo).map(joueurMapper::toDto);
    }

    @Override
    public Optional<JoueurDtoOut> findByEmail(String email) {
        return joueurJpaRepository.findByEmail(email).map(joueurMapper::toDto);
    }

    @Override
    public JoueurDtoOut save(JoueurDtoOut joueurDtoOut) {
        JoueurEntity entity = joueurMapper.toEntity(
            new JoueurDtoIn(
                joueurDtoOut.avatarId(),
                joueurDtoOut.dateDeNaissance(),
                joueurDtoOut.motDePasse(),
                joueurDtoOut.pseudo(),
                joueurDtoOut.email()
            )
        );
        if (joueurDtoOut.id() != null) {
            entity.setId(joueurDtoOut.id());
        }
        JoueurEntity saved = joueurJpaRepository.save(entity);
        return joueurMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        joueurJpaRepository.deleteById(id);
    }
}

