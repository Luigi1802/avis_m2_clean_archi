package fr.esgi.avis.business;

import java.time.LocalDate;
import java.util.List;

public class Plateforme {

    public Plateforme(String nom, LocalDate dateDeSortie) {
        this.nom = nom;
        this.dateDeSortie = dateDeSortie;
    }

    private Long id;

    private String nom;

    private List<Jeu> jeux;

    private LocalDate dateDeSortie;

    public List<Jeu> getJeux() {
        return jeux;
    }

    public void setJeux(List<Jeu> jeux) {
        this.jeux = jeux;
    }

    public LocalDate getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(LocalDate dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
