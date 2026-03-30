package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Moderateur;

import java.util.List;

public interface ModerateurUseCase {
    Moderateur recupererModerateur(Long id);

    Moderateur recupererModerateurParNumeroDeTelephone(String numeroDeTelephone);

    List<Moderateur> recupererModerateurs();

    ModerateurDtoOut ajouterModerateur(ModerateurDtoIn moderateurDtoIn);

    void supprimerModerateur(Moderateur moderateur);
}
