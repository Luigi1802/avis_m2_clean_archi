package fr.esgi.avis.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Joueur {
    private Avatar avatar;

    private LocalDate dateDeNaissance;

    private List<Avis> avis;
}
