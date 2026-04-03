package fr.esgi.avis.domain.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Joueur extends Utilisateur {
    private Avatar avatar;

    private LocalDate dateDeNaissance;

    private List<Avis> avis;
}