package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Avatar;
import fr.esgi.avis.business.Joueur;
import fr.esgi.avis.dto.AvatarDtoIn;
import fr.esgi.avis.dto.AvatarDtoOut;

import java.util.List;

public interface AvatarUseCase {
    Avatar recupererAvatar(Long id);

    List<Avatar> recupererAvatars();

    Avatar recupererAvatarParNom();

    Avatar recupererAvatarParJoueur(Joueur joueur);

    AvatarDtoOut ajouterAvatar(AvatarDtoIn avatarDtoIn);

    AvatarDtoOut modifierAvatar(AvatarDtoIn avatarDtoIn);

    void supprimerAvatar(Long id);
}
