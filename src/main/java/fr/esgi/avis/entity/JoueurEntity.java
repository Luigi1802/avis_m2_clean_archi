package fr.esgi.avis.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "joueur")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class JoueurEntity extends UtilisateurEntity {

    @OneToOne(mappedBy = "joueur", cascade = CascadeType.ALL)
    private AvatarEntity avatar;

    private LocalDate dateDeNaissance;

    @OneToMany(mappedBy = "joueur", cascade = CascadeType.ALL)
    private List<AvisEntity> avis;
}