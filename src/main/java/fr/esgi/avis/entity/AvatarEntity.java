package fr.esgi.avis.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "avatar")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AvatarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToOne
    @JoinColumn(name = "joueur_id")
    private JoueurEntity joueur;
}
