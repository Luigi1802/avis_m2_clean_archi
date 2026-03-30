package fr.esgi.avis.business;

import java.util.List;

public class Editeur {

    public Editeur(String nom, List<Jeu> jeux) {
        this.nom = nom;
    }

    private Long id;

    private String nom;

    private List<Jeu> jeux;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Jeu> getJeux() {
        return jeux;
    }

    public void setJeux(List<Jeu> jeux) {
        this.jeux = jeux;
    }
}