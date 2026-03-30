package fr.esgi.avis.business;

import java.time.LocalDate;
import java.util.List;

public class Jeu {

    public Jeu(Genre genre, String nom, List<Plateforme> plateformes, Editeur editeur, LocalDate dateDeSortie, String description, float prix, Classification classification, String image) {
        this.genre = genre;
        this.nom = nom;
        this.plateformes = plateformes;
        this.editeur = editeur;
        this.dateDeSortie = dateDeSortie;
        this.description = description;
        this.prix = prix;
        this.classification = classification;
        this.image = image;
    }

    private List<Plateforme> plateformes;

    private Genre genre;

    private Long id;

    private String nom;

    private Editeur editeur;

    private LocalDate dateDeSortie;

    private String description;

    private float prix;

    private Classification classification;

    private String image;

    public List<Plateforme> getPlateformes() {
        return plateformes;
    }

    public void setPlateformes(List<Plateforme> plateformes) {
        this.plateformes = plateformes;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public LocalDate getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(LocalDate dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
