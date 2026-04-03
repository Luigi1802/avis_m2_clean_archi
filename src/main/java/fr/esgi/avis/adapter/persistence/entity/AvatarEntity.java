package fr.esgi.avis.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
