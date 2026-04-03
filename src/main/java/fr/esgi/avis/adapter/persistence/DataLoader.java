package fr.esgi.avis.adapter.persistence;

import fr.esgi.avis.adapter.persistence.entity.*;
import fr.esgi.avis.adapter.persistence.repository.jpa.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final EditeurJpaRepository editeurJpaRepository;
    private final GenreJpaRepository genreJpaRepository;
    private final ClassificationJpaRepository classificationJpaRepository;
    private final PlateformeJpaRepository plateformeJpaRepository;
    private final JeuJpaRepository jeuJpaRepository;
    private final JoueurJpaRepository joueurJpaRepository;
    private final ModerateurJpaRepository moderateurJpaRepository;
    private final AvatarJpaRepository avatarJpaRepository;
    private final AvisJpaRepository avisJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        // Créer des éditeurs
        EditeurEntity ubisoft = new EditeurEntity();
        ubisoft.setNom("Ubisoft");
        editeurJpaRepository.save(ubisoft);

        EditeurEntity ea = new EditeurEntity();
        ea.setNom("Electronic Arts");
        editeurJpaRepository.save(ea);

        EditeurEntity nintendo = new EditeurEntity();
        nintendo.setNom("Nintendo");
        editeurJpaRepository.save(nintendo);

        EditeurEntity cdProjekt = new EditeurEntity();
        cdProjekt.setNom("CD Projekt Red");
        editeurJpaRepository.save(cdProjekt);

        // Créer des genres
        GenreEntity action = new GenreEntity();
        action.setNom("Action");
        genreJpaRepository.save(action);

        GenreEntity aventure = new GenreEntity();
        aventure.setNom("Aventure");
        genreJpaRepository.save(aventure);

        GenreEntity rpg = new GenreEntity();
        rpg.setNom("RPG");
        genreJpaRepository.save(rpg);

        GenreEntity sport = new GenreEntity();
        sport.setNom("Sport");
        genreJpaRepository.save(sport);

        // Créer des classifications
        ClassificationEntity pegi3 = new ClassificationEntity();
        pegi3.setNom("PEGI 3");
        pegi3.setCouleurRGB("#00FF00");
        classificationJpaRepository.save(pegi3);

        ClassificationEntity pegi7 = new ClassificationEntity();
        pegi7.setNom("PEGI 7");
        pegi7.setCouleurRGB("#FFFF00");
        classificationJpaRepository.save(pegi7);

        ClassificationEntity pegi12 = new ClassificationEntity();
        pegi12.setNom("PEGI 12");
        pegi12.setCouleurRGB("#FFA500");
        classificationJpaRepository.save(pegi12);

        ClassificationEntity pegi18 = new ClassificationEntity();
        pegi18.setNom("PEGI 18");
        pegi18.setCouleurRGB("#FF0000");
        classificationJpaRepository.save(pegi18);

        // Créer des plateformes
        PlateformeEntity pc = new PlateformeEntity();
        pc.setNom("PC");
        pc.setDateDeSortie(LocalDate.of(1981, 8, 12));
        plateformeJpaRepository.save(pc);

        PlateformeEntity playstation = new PlateformeEntity();
        playstation.setNom("PlayStation 5");
        playstation.setDateDeSortie(LocalDate.of(2020, 11, 12));
        plateformeJpaRepository.save(playstation);

        PlateformeEntity xbox = new PlateformeEntity();
        xbox.setNom("Xbox Series X");
        xbox.setDateDeSortie(LocalDate.of(2020, 11, 10));
        plateformeJpaRepository.save(xbox);

        PlateformeEntity switch_ = new PlateformeEntity();
        switch_.setNom("Nintendo Switch");
        switch_.setDateDeSortie(LocalDate.of(2017, 3, 3));
        plateformeJpaRepository.save(switch_);

        // Créer des jeux
        JeuEntity assassinsCreed = new JeuEntity();
        assassinsCreed.setNom("Assassin's Creed Valhalla");
        assassinsCreed.setDateDeSortie(LocalDate.of(2020, 11, 10));
        assassinsCreed.setDescription("Un jeu d'action-aventure historique dans l'ère viking");
        assassinsCreed.setPrix(59.99f);
        assassinsCreed.setEditeur(ubisoft);
        assassinsCreed.setGenre(action);
        assassinsCreed.setClassification(pegi18);
        assassinsCreed.setPlateformes(List.of(pc, playstation, xbox));
        jeuJpaRepository.save(assassinsCreed);

        JeuEntity fifa = new JeuEntity();
        fifa.setNom("FIFA 23");
        fifa.setDateDeSortie(LocalDate.of(2022, 9, 30));
        fifa.setDescription("Jeu de football ultime");
        fifa.setPrix(49.99f);
        fifa.setEditeur(ea);
        fifa.setGenre(sport);
        fifa.setClassification(pegi3);
        fifa.setPlateformes(List.of(pc, playstation, xbox));
        jeuJpaRepository.save(fifa);

        JeuEntity zelda = new JeuEntity();
        zelda.setNom("The Legend of Zelda: Breath of the Wild");
        zelda.setDateDeSortie(LocalDate.of(2017, 3, 3));
        zelda.setDescription("Aventure épique dans le royaume d'Hyrule");
        zelda.setPrix(39.99f);
        zelda.setEditeur(nintendo);
        zelda.setGenre(aventure);
        zelda.setClassification(pegi7);
        zelda.setPlateformes(List.of(switch_));
        jeuJpaRepository.save(zelda);

        JeuEntity witcher = new JeuEntity();
        witcher.setNom("The Witcher 3: Wild Hunt");
        witcher.setDateDeSortie(LocalDate.of(2015, 5, 19));
        witcher.setDescription("RPG fantastique avec choix moraux");
        witcher.setPrix(29.99f);
        witcher.setEditeur(cdProjekt);
        witcher.setGenre(rpg);
        witcher.setClassification(pegi18);
        witcher.setPlateformes(List.of(pc, playstation, xbox));
        jeuJpaRepository.save(witcher);

        // Créer des modérateurs
        ModerateurEntity mod1 = new ModerateurEntity();
        mod1.setPseudo("ModAdmin");
        mod1.setEmail("mod@avis.com");
        mod1.setMotDePasse("password");
        mod1.setNumeroDeTelephone("0123456789");
        moderateurJpaRepository.save(mod1);

        // Créer des joueurs avec avatars
        JoueurEntity alice = new JoueurEntity();
        alice.setPseudo("AliceGamer");
        alice.setEmail("alice@example.com");
        alice.setMotDePasse("password");
        alice.setDateDeNaissance(LocalDate.of(1995, 5, 15));

        AvatarEntity avatarAlice = new AvatarEntity();
        avatarAlice.setNom("Warrior");
        avatarAlice.setJoueur(alice);
        alice.setAvatar(avatarAlice);

        joueurJpaRepository.save(alice); // Saves avatar due to cascade

        JoueurEntity bob = new JoueurEntity();
        bob.setPseudo("BobPlayer");
        bob.setEmail("bob@example.com");
        bob.setMotDePasse("password");
        bob.setDateDeNaissance(LocalDate.of(1990, 10, 20));

        AvatarEntity avatarBob = new AvatarEntity();
        avatarBob.setNom("Mage");
        avatarBob.setJoueur(bob);
        bob.setAvatar(avatarBob);

        joueurJpaRepository.save(bob);

        // Créer des avis
        AvisEntity avis1 = new AvisEntity();
        avis1.setDescription("Excellent jeu, très immersif !");
        avis1.setNote(9.5f);
        avis1.setJeu(assassinsCreed);
        avis1.setJoueur(alice);
        avis1.setModerateur(mod1);
        avis1.setDateDEnvoi(LocalDateTime.now().minusDays(10));
        avisJpaRepository.save(avis1);

        AvisEntity avis2 = new AvisEntity();
        avis2.setDescription("Bons graphismes, mais un peu répétitif.");
        avis2.setNote(7.0f);
        avis2.setJeu(fifa);
        avis2.setJoueur(bob);
        avis2.setModerateur(mod1);
        avis2.setDateDEnvoi(LocalDateTime.now().minusDays(5));
        avisJpaRepository.save(avis2);

        AvisEntity avis3 = new AvisEntity();
        avis3.setDescription("Chef-d'œuvre de Nintendo !");
        avis3.setNote(10.0f);
        avis3.setJeu(zelda);
        avis3.setJoueur(alice);
        avis3.setModerateur(mod1);
        avis3.setDateDEnvoi(LocalDateTime.now().minusDays(2));
        avisJpaRepository.save(avis3);

        AvisEntity avis4 = new AvisEntity();
        avis4.setDescription("Histoire incroyable, mais difficile.");
        avis4.setNote(8.5f);
        avis4.setJeu(witcher);
        avis4.setJoueur(bob);
        avis4.setModerateur(mod1);
        avis4.setDateDEnvoi(LocalDateTime.now().minusDays(1));
        avisJpaRepository.save(avis4);
    }
}
