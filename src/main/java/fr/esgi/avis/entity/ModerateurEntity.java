package fr.esgi.avis.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "moderateur")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ModerateurEntity extends UtilisateurEntity {

    private String numeroDeTelephone;
}