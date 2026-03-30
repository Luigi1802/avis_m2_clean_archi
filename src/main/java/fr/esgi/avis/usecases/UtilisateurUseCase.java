package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Utilisateur;

import java.util.List;

public interface UtilisateurUseCase {
    Utilisateur recupererUtilisateur(Long id);

    List<Utilisateur> recupererUtilisateurs();

    Utilisateur recupererUtilisateurParEmail(String email);

    Utilisateur recupererUtilisateurParPseudo(String pseudo);

    UtilisateurDtoOut ajouterUtilisateur(UtilisateurDtoIn utilisateurDtoIn);

    void supprimerUtilisateur(Long id);
}
