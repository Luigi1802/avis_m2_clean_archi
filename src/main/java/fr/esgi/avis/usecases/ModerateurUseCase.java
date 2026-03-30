package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Moderateur;
import fr.esgi.avis.dto.ModerateurDtoIn;
import fr.esgi.avis.dto.ModerateurDtoOut;

import java.util.List;

public interface ModerateurUseCase {
    Moderateur recupererModerateur(Long id);

    Moderateur recupererModerateurParNumeroDeTelephone(String numeroDeTelephone);

    List<Moderateur> recupererModerateurs();

    ModerateurDtoOut ajouterModerateur(ModerateurDtoIn moderateurDtoIn);

    ModerateurDtoOut modifierModerateur(ModerateurDtoIn moderateurDtoIn);

    void supprimerModerateur(Long id);
}
