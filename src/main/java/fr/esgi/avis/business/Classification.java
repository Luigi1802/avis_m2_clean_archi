package fr.esgi.avis.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classification {

    private List<Jeu> jeux;

    private Long id;

    private String nom;

    private String couleurRGB;
}
