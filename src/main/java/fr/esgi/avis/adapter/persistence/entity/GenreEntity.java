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
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message="Merci de préciser le nom du genre")
    @Column(name = "nom", nullable = false, unique = true)
    private String nom;

    @OneToMany(mappedBy="genre")
    @ToString.Exclude
    private List<JeuEntity> jeux;
}