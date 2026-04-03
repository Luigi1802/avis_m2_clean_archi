package fr.esgi.avis.application.ports.out;

import fr.esgi.avis.application.dto.out.AvatarDtoOut;

import java.util.Optional;

/**
 * Port OUT - Contrat pour la persistance des Avatars
 */
public interface AvatarRepository {
    Optional<AvatarDtoOut> findById(Long id);

    Optional<AvatarDtoOut> findByJoueurId(Long joueurId);

    AvatarDtoOut save(AvatarDtoOut avatarDtoOut);

    void deleteById(Long id);
}

