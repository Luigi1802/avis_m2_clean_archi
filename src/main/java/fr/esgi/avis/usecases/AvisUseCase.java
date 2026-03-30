package fr.esgi.avis.usecases;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.business.Jeu;
import fr.esgi.avis.business.Joueur;
import fr.esgi.avis.dto.AvisDtoIn;
import fr.esgi.avis.dto.AvisDtoOut;

import java.time.LocalDate;
import java.util.List;

public interface AvisUseCase {
    Avis recupererAvis(Long id);

    List<Avis> recupererAvisParJeu(Jeu jeu);

    List<Avis> recupererAvisParNote(Float note);

    List<Avis> recupererAvisParJoueur(Joueur joueur);

    List<Avis> recupererAvis();

    List<Avis> recupererAvisParDate(LocalDate date);

    AvisDtoOut ajouterAvis(AvisDtoIn avisDtoIn);

    void supprimerAvis(Long id);
}
