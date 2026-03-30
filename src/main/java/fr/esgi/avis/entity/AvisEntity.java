package fr.esgi.avis.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "avis")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AvisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "jeu_id")
    private JeuEntity jeu;

    private Float note;

    @ManyToOne
    @JoinColumn(name = "joueur_id")
    private JoueurEntity joueur;

    @ManyToOne
    @JoinColumn(name = "moderateur_id")
    private ModerateurEntity moderateur;

    private LocalDateTime dateDEnvoi;
}