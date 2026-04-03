package fr.esgi.avis.adapter.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ClassificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message="Merci de préciser le nom de la classification")
    @Column(name = "nom", nullable = false, unique = true)
    private String nom;

    private String couleurRGB;

    @OneToMany(mappedBy="classification")
    @ToString.Exclude
    private List<JeuEntity> jeux;

}