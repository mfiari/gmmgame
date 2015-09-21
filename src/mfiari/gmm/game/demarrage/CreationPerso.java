/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.demarrage;

import mfiari.gmm.game.perso.D_UNI;
import mfiari.gmm.game.perso.Personnages;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.menu.Stat;
import mfiari.gmm.game.technique.Techniques;
import mfiari.gmm.game.ville.Endroits;
import mfiari.lib.game.personnage.Habitant;
import mfiari.lib.game.position.Orientation;
import mfiari.lib.game.position.Position;
//import java.util.ArrayList;

/**
 *
 * @author mike
 */
public class CreationPerso {

    private ListeDePerso listePerso;
    //private ArrayList <habitant> habitants;
    private ListeDePerso equipe;

    public CreationPerso (boolean partie) {
        this.listePerso = new ListeDePerso () ;
        this.equipe = new ListeDePerso ();
        this.creationHabitant();
        this.listePerso.ajouterPerso(Personnages.marco);
        this.listePerso.ajouterPerso(Personnages.vard);
        this.listePerso.ajouterPerso(Personnages.mok);
        this.listePerso.ajouterPerso(Personnages.blake);
        this.listePerso.ajouterPerso(Personnages.roman);
        this.listePerso.ajouterPerso(Personnages.alexis);
        this.listePerso.ajouterPerso(Personnages.bulzator);
        this.listePerso.ajouterPerso(Personnages.conan);
        this.listePerso.ajouterPerso(Personnages.cross);
        this.listePerso.ajouterPerso(Personnages.cynthia);
        this.listePerso.ajouterPerso(Personnages.edson);
        this.listePerso.ajouterPerso(Personnages.espancien);
        this.listePerso.ajouterPerso(Personnages.foudroineau);
        this.listePerso.ajouterPerso(Personnages.fuleau);
        this.listePerso.ajouterPerso(Personnages.galactika);
        this.listePerso.ajouterPerso(Personnages.garrucha);
        this.listePerso.ajouterPerso(Personnages.goroku);
        this.listePerso.ajouterPerso(Personnages.guimelar);
        this.listePerso.ajouterPerso(Personnages.lola);
        this.listePerso.ajouterPerso(Personnages.medicoru);
        this.listePerso.ajouterPerso(Personnages.oisillon);
        this.listePerso.ajouterPerso(Personnages.pepe);
        this.listePerso.ajouterPerso(Personnages.roberto);
        this.listePerso.ajouterPerso(Personnages.sony);
        this.listePerso.ajouterPerso(Personnages.tom);
        this.listePerso.ajouterPerso(Personnages.typhon);
    }

    public CreationPerso () {
        this.listePerso = new ListeDePerso () ;
        this.equipe = new ListeDePerso ();

        this.creationPersoPrincipal();
        this.creationPersonnages();
        this.creationD_UNI();
        this.creationHabitant();
        
        this.listePerso.ajouterPerso(Personnages.marco);
        this.listePerso.ajouterPerso(Personnages.vard);
        this.listePerso.ajouterPerso(Personnages.mok);
        this.listePerso.ajouterPerso(Personnages.blake);
        this.listePerso.ajouterPerso(Personnages.roman);
        this.listePerso.ajouterPerso(Personnages.alexis);
        this.listePerso.ajouterPerso(Personnages.bulzator);
        this.listePerso.ajouterPerso(Personnages.conan);
        this.listePerso.ajouterPerso(Personnages.cross);
        this.listePerso.ajouterPerso(Personnages.cynthia);
        this.listePerso.ajouterPerso(Personnages.edson);
        this.listePerso.ajouterPerso(Personnages.espancien);
        this.listePerso.ajouterPerso(Personnages.foudroineau);
        this.listePerso.ajouterPerso(Personnages.fuleau);
        this.listePerso.ajouterPerso(Personnages.galactika);
        this.listePerso.ajouterPerso(Personnages.garrucha);
        this.listePerso.ajouterPerso(Personnages.goroku);
        this.listePerso.ajouterPerso(Personnages.guimelar);
        this.listePerso.ajouterPerso(Personnages.lola);
        this.listePerso.ajouterPerso(Personnages.medicoru);
        this.listePerso.ajouterPerso(Personnages.oisillon);
        this.listePerso.ajouterPerso(Personnages.pepe);
        this.listePerso.ajouterPerso(Personnages.roberto);
        this.listePerso.ajouterPerso(Personnages.sony);
        this.listePerso.ajouterPerso(Personnages.tom);
        this.listePerso.ajouterPerso(Personnages.typhon);

        this.equipe.ajouterPerso(Personnages.marco);

        /*this.listePerso.ajouterHabitant(this.mamanDeMarco);
        this.listePerso.ajouterHabitant(this.papaDeMarco);
        this.listePerso.ajouterHabitant(this.homme_quartierHabitant_medieville);
        this.listePerso.ajouterHabitant(this.gardeDroite_quartierHabitant_medieville);
        this.listePerso.ajouterHabitant(this.gardeGauche_quartierHabitant_medieville);*/
    }

    private void creationPersoPrincipal () {
        Personnages.marco.getAtt().ajoutTec(Techniques.coupDEpee);
        Personnages.marco.getTec().ajoutTec(Techniques.coupDEpee);
        Personnages.marco.setPosition(new Position(2, 4, 0, 
                Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.marco.setStat(new Stat(Personnages.marco, Personnages.marcoNiv100));
        /*this.jeu.changerNom("marco");
        this.marco.changerNom(this.jeu.getAffichage());
        this.jeu.setNomPersoPrincipal(this.jeu.getAffichage());*/
    }

    private void creationPersonnages () {
        Personnages.vard.getAtt().ajoutTec(Techniques.foudre);
        Personnages.vard.getTec().ajoutTec(Techniques.foudre);
        Personnages.vard.setPosition(new Position(4, 4, 0, 
                Endroits.ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.vard.setStat(new Stat(Personnages.vard, Personnages.vardNiv100));
        
        Personnages.mok.getAtt().ajoutTec(Techniques.attaquePuissante);
        Personnages.mok.getTec().ajoutTec(Techniques.attaquePuissante);
        Personnages.mok.setPosition(new Position(3, 4, 0, 
                Endroits.ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.mok.setStat(new Stat(Personnages.mok, Personnages.mokNiv100));
        
        Personnages.blake.getAtt().ajoutTec(Techniques.fleche);
        Personnages.blake.getTec().ajoutTec(Techniques.fleche);
        Personnages.blake.setPosition(new Position(3, 1, 0, 
                Endroits.ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.blake.setStat(new Stat(Personnages.blake, Personnages.blakeNiv100));
        
        Personnages.roman.getAtt().ajoutTec(Techniques.coupDEpee);
        Personnages.roman.getAtt().ajoutTec(Techniques.soin);
        Personnages.roman.getAtt().ajoutTec(Techniques.voler);
        Personnages.roman.getTec().ajoutTec(Techniques.coupDEpee);
        Personnages.roman.getTec().ajoutTec(Techniques.soin);
        Personnages.roman.getTec().ajoutTec(Techniques.voler);
        Personnages.roman.setPosition(new Position(4, 2, 0, 
                Endroits.chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.roman.setStat(new Stat(Personnages.roman, Personnages.romanNiv100));
        
        Personnages.alexis.setPosition(new Position(2, 4, 0, 
                Endroits.grandeForet, Orientation.droite));
        Personnages.alexis.setStat(new Stat(Personnages.alexis, Personnages.alexis));
        
        Personnages.conan.setPosition(new Position(2, 4, 0, 
                Endroits.defendere, Orientation.droite));
        Personnages.conan.setStat(new Stat(Personnages.conan, Personnages.conan));
        
        Personnages.cross.setPosition(new Position(2, 4, 0, 
                Endroits.immortalis, Orientation.droite));
        Personnages.cross.setStat(new Stat(Personnages.cross, Personnages.cross));
        
        Personnages.cynthia.setPosition(new Position(2, 4, 0, 
                Endroits.foret_sorciere, Orientation.droite));
        Personnages.cynthia.setStat(new Stat(Personnages.cynthia, Personnages.cynthia));
        
        Personnages.edson.setPosition(new Position(2, 4, 0, 
                Endroits.village_serpent, Orientation.droite));
        Personnages.edson.setStat(new Stat(Personnages.edson, Personnages.edson));
        
        Personnages.garrucha.setPosition(new Position(2, 4, 0, 
                Endroits.defendere, Orientation.droite));
        Personnages.garrucha.setStat(new Stat(Personnages.garrucha, Personnages.garrucha));
        
        Personnages.lola.setPosition(new Position(2, 4, 0, 
                Endroits.immortalis, Orientation.droite));
        Personnages.lola.setStat(new Stat(Personnages.lola, Personnages.lola));
        
        Personnages.oisillon.setPosition(new Position(2, 4, 0, 
                Endroits.village_oiseau, Orientation.droite));
        Personnages.oisillon.setStat(new Stat(Personnages.oisillon, Personnages.oisillon));
        
        Personnages.pepe.setPosition(new Position(8, 0, 0, 
                Endroits.bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.pepe.setStat(new Stat(Personnages.pepe, Personnages.pepe));
        
        Personnages.roberto.setPosition(new Position(2, 4, 0, 
                Endroits.defendere, Orientation.droite));
        Personnages.roberto.setStat(new Stat(Personnages.roberto, Personnages.roberto));
        
        Personnages.sony.setPosition(new Position(2, 4, 0, 
                Endroits.immortalis, Orientation.droite));
        Personnages.sony.setStat(new Stat(Personnages.sony, Personnages.sony));
        
        Personnages.tom.setPosition(new Position(2, 4, 0, 
                Endroits.grandeForet, Orientation.droite));
        Personnages.tom.setStat(new Stat(Personnages.tom, Personnages.tom));
    }

    private void creationD_UNI () {
        Personnages.bulzator.setPosition(new Position(2, 4, 0, 
                Endroits.temple_espancien, Orientation.droite));
        Personnages.bulzator.setStat(new Stat(Personnages.bulzator, Personnages.bulzator));
        //this.bulzator.setPosition(Endroits.temple_espancien);
        Personnages.espancien = new D_UNI(Personnages.espancien);
        Personnages.marco.setPosition(new Position(2, 4, 0, 
                Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.marco.setStat(new Stat(Personnages.marco, Personnages.marcoNiv100));
        //this.espancien.setPosition(Endroits.temple_espancien);
        Personnages.foudroineau = new D_UNI(Personnages.foudroineau);
        Personnages.marco.setPosition(new Position(2, 4, 0, 
                Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.marco.setStat(new Stat(Personnages.marco, Personnages.marcoNiv100));
        //this.foudroineau.setPosition(Endroits.temple_foudroineau);
        Personnages.fuleau = new D_UNI(Personnages.fuleau);
        Personnages.marco.setPosition(new Position(2, 4, 0, 
                Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.marco.setStat(new Stat(Personnages.marco, Personnages.marcoNiv100));
        //this.fuleau.setPosition(Endroits.mausole_fuleau);
        Personnages.galactika = new D_UNI(Personnages.galactika);
        Personnages.marco.setPosition(new Position(2, 4, 0, 
                Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.marco.setStat(new Stat(Personnages.marco, Personnages.marcoNiv100));
        //this.galactika.setPosition(Endroits.temple_galactika);
        Personnages.goroku = new D_UNI(Personnages.goroku);
        Personnages.marco.setPosition(new Position(2, 4, 0, 
                Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.marco.setStat(new Stat(Personnages.marco, Personnages.marcoNiv100));
        //this.goroku.setPosition(Endroits.temple_goroku);
        Personnages.guimelar = new D_UNI(Personnages.guimelar);
        Personnages.marco.setPosition(new Position(2, 4, 0, 
                Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.marco.setStat(new Stat(Personnages.marco, Personnages.marcoNiv100));
        //this.guimelar.setPosition(Endroits.temple_guimelard);
        Personnages.medicoru = new D_UNI(Personnages.medicoru);
        Personnages.marco.setPosition(new Position(2, 4, 0, 
                Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.marco.setStat(new Stat(Personnages.marco, Personnages.marcoNiv100));
        //this.medicoru.setPosition(Endroits.temple_medicoru);
        Personnages.typhon = new D_UNI(Personnages.typhon);
        Personnages.marco.setPosition(new Position(2, 4, 0, 
                Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.droite));
        Personnages.marco.setStat(new Stat(Personnages.marco, Personnages.marcoNiv100));
        //this.typhon.setPosition(Endroits.temple_medicoru);
        
        /*this.bulzator.setPositionX(4);
        this.bulzator.setPositionY(2);
        
        this.espancien.setPositionX(4);
        this.espancien.setPositionY(2);
        
        this.foudroineau.setPositionX(4);
        this.foudroineau.setPositionY(2);
        
        this.fuleau.setPositionX(4);
        this.fuleau.setPositionY(2);
        
        this.galactika.setPositionX(4);
        this.galactika.setPositionY(2);
        
        this.goroku.setPositionX(4);
        this.goroku.setPositionY(2);
        
        this.guimelar.setPositionX(4);
        this.guimelar.setPositionY(2);
        
        this.medicoru.setPositionX(4);
        this.medicoru.setPositionY(2);
        
        this.typhon.setPositionX(4);
        this.typhon.setPositionY(2);*/
    }

    private void creationHabitant () {
        /*this.mamanDeMarco = Habitants.mamanDeMarco;
        this.papaDeMarco = Habitants.papaDeMarco;
        this.homme_quartierHabitant_medieville = Habitants.homme_quartierHabitant_medieville;
        this.gardeDroite_quartierHabitant_medieville = Habitants.gardeDroite_quartierHabitant_medieville;
        this.gardeGauche_quartierHabitant_medieville = Habitants.gardeGauche_quartierHabitant_medieville;
        this.mamanDeMarco.changerNom(this.jeu.getTextes().mereDe(this.jeu.getNomPersoPrincipal()));
        this.mamanDeMarco.ajouterParole(this.jeu.getTextes().getCreationHabitant1());
        
        this.papaDeMarco.changerNom(this.jeu.getTextes().pereDe(this.jeu.getNomPersoPrincipal()));
        this.papaDeMarco.ajouterParole(this.jeu.getTextes().getCreationHabitant2());
        
        this.homme_quartierHabitant_medieville.ajouterParole(this.jeu.getTextes().getCreationHabitant3(this.marco.getNom()));
        
        this.gardeDroite_quartierHabitant_medieville.ajouterParole(this.jeu.getTextes().getCreationHabitant4());
        
        this.gardeGauche_quartierHabitant_medieville.ajouterParole(this.jeu.getTextes().getCreationHabitant5());*/
    }

    public ListeDePerso getPersos () {
        return this.listePerso;
    }

    public ListeDePerso getEquipe() {
        return this.equipe;
    }

    /*public ArrayList<habitant> getHabitants () {
        return this.habitants;
    }*/

}
