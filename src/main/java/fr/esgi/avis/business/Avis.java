package fr.esgi.avis.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Avis {
    private Long id;

    private String description;

    private Jeu jeu;

    private Float note;

    private Joueur joueur;

    private Moderateur moderateur;

    private LocalDateTime dateDEnvoi;
}
