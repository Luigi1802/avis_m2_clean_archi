package fr.esgi.avis.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class JeuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message="Merci de préciser le nom du jeu")
    @Column(name = "nom", nullable = false)
    private String nom;

    private LocalDate dateDeSortie;

    private String description;

    private float prix;

    private String image;

    @ManyToOne
    private EditeurEntity editeur;

    @ManyToOne
    private GenreEntity genre;

    @ManyToOne
    private ClassificationEntity classification;

    @ManyToMany
    @ToString.Exclude
    private List<PlateformeEntity> plateformes;
}