package fr.esgi.avis.entity;

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
public class PlateformeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message="Merci de préciser le nom de la plateforme")
    @Column(name = "nom", nullable = false, unique = true)
    private String nom;

    private LocalDate dateDeSortie;

    @ManyToMany(mappedBy="plateformes")
    @ToString.Exclude
    private List<JeuEntity> jeux;

}