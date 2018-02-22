/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.demarrage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import mfiari.gmm.game.objet.Objet_endroit_observable;
import mfiari.gmm.game.objet.Objet_endroit_classique;
import mfiari.gmm.game.objet.Objet_endroit_coffre;
import mfiari.gmm.game.objet.Objets;
import mfiari.gmm.game.objet.Objet_endroit_passage;
import mfiari.gmm.game.objet.TypeObjet;
import mfiari.gmm.game.ville.Endroit;
import mfiari.gmm.game.ville.Endroits;
import mfiari.gmm.game.ville.Sol;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import mfiari.lib.game.liste.ListeDEndroit;
import mfiari.lib.game.objet.ObjetEndroit;
import mfiari.lib.game.personnage.Gens;
import mfiari.lib.game.position.Position;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author mike
 */
public class CreationVille {

    private ArrayList<Endroit> carte_gmm;

    public CreationVille () {
        this.carte_gmm = new ArrayList<> ();
        
        this.modificationSalle();
        this.modificationBatiment();
        this.modificationQuartier();
        this.modificationVille();
        this.modificationSousZone();
        this.modificationZone();
        this.modificationPays();
        
        this.carte_gmm.add(Endroits.continent);
        this.carte_gmm.add(Endroits.zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.bas_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.maisonMok_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.bas_maisonMok_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.bas_maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.maisonVard_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.bas_maisonVard_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.salle_bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.cour_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.zoneBatcity_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.batcity_zoneBatcity_zoneMedicoru_continent);
        this.carte_gmm.add(Endroits.grandeForet);
        this.carte_gmm.add(Endroits.village_guerrier);
        this.carte_gmm.add(Endroits.fort_bandit);
        this.carte_gmm.add(Endroits.immortalis);
        this.carte_gmm.add(Endroits.foret_vivante);
        this.carte_gmm.add(Endroits.foret_sorciere);
        this.carte_gmm.add(Endroits.temple_goroku);
        this.carte_gmm.add(Endroits.montagne_felin);
        this.carte_gmm.add(Endroits.temple_foudroineau);
        this.carte_gmm.add(Endroits.defendere);
        this.carte_gmm.add(Endroits.village_oiseau);
        this.carte_gmm.add(Endroits.village_serpent);
        this.carte_gmm.add(Endroits.temple_guimelard);
        this.carte_gmm.add(Endroits.temple_espancien);
        this.carte_gmm.add(Endroits.mausole_fuleau);
        this.carte_gmm.add(Endroits.temple_galactika);
        this.carte_gmm.add(Endroits.temple_medicoru);
        this.carte_gmm.add(Endroits.village_felin);

    }

    private void modificationSalle () {
        
        Endroits.bas_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_passage (TypeObjet.porte, 2, 5, Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 1, 1));
        Endroits.bas_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.table, 2,3));
        Endroits.bas_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_passage (TypeObjet.escalier_montant, 0, 0,
                Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 0, 1));
        Endroits.bas_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.setSol(Sol.bois);
        

        Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage(
                TypeObjet.escalier_descendant, 0, 0, Endroits.bas_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 0, 1));
        Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique(TypeObjet.lit, 2, 5));
        Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.setSol(Sol.bois);

        
        Endroits.bas_maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_passage (TypeObjet.porte, 2, 5, Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 2, 1));
        Endroits.bas_maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_observable(TypeObjet.etagere, 0, 2, "c'est plein de livre sur la magie"));
        Endroits.bas_maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_observable(TypeObjet.etagere, 0, 3, "c'est plein de livre sur la magie"));
        Endroits.bas_maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_observable(TypeObjet.etagere, 0, 4, "c'est plein de livre sur la magie"));
        Endroits.bas_maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique(TypeObjet.bureau, 4, 1));
        Endroits.bas_maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique(TypeObjet.lit, 1, 0));
        Endroits.bas_maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.setSol(Sol.bois);
        

        
        Endroits.bas_maisonMok_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_passage (TypeObjet.porte, 2, 5, Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 3, 2));
        Endroits.bas_maisonMok_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.table, 2,2));
        Endroits.bas_maisonMok_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.setSol(Sol.bois);
        

        
        Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_passage (TypeObjet.porte, 5, 2, Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 1, 8));
        Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_passage (TypeObjet.porte, 5, 3, Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 1, 8));
        Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage(
                TypeObjet.chemin, 0, 2, Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 5, 4));
        Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage(
                TypeObjet.chemin, 0, 3, Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 5, 5));
        Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 0,1));
        Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 1,1));
        Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 1,2));
        Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 1,4));
        Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 0,4));
        Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.setSol(Sol.bois);

        Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage(
                TypeObjet.porte, 5,4, Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 0, 2));
        Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage(
                TypeObjet.porte, 5,5, Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 0, 3));
        for (int i=0 ; i<6 ; i++) {
            Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                    new Objet_endroit_classique (TypeObjet.arbre, 0,i));
        }
        for (int i=0 ; i<6 ; i++) {
            Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                    new Objet_endroit_classique (TypeObjet.arbre, 9,i));
        }
        Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 2,1));
        Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 1,3));
        Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 5,3));
        Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 5,6));
        Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 4,7));
        Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 0,6));
        for (int i=0 ; i<8 ; i++) {
            if (i!=6) {
                Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                        new Objet_endroit_passage (TypeObjet.chemin, 0, i,
                   Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 5, i));
            }
        }
        Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.setSol(Sol.herbe);

        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 0,0));
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 0,1));
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 1,0));
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 2,1));
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 5,0));
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 0,6));
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 0,9));
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 4,9));
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 5,9));
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 1,9));
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 4,3));
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.arbre, 5, 6));
        for (int i=0 ; i<8 ; i++) {
            if (i!=6) {
                Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                        new Objet_endroit_passage (TypeObjet.chemin, 5, i,
                   Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 0, i));
            }
        }
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.grand_chene, 1,4));
        Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.setSol(Sol.herbe);

        Endroits.salle_bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage(
                TypeObjet.porte, 3,0, Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 1, 8));
        for (int i=2 ; i<6 ; i++) {
            Endroits.salle_bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                    new Objet_endroit_observable(TypeObjet.etagere, 1, i, "c'est plein de livre"));
        }
        for (int i=2 ; i<6 ; i++) {
            Endroits.salle_bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                    new Objet_endroit_observable(TypeObjet.etagere, 5, i, "c'est plein de livre"));
        }
        for (int i=1 ; i<5 ; i++) {
            Endroits.salle_bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                    new Objet_endroit_observable(TypeObjet.etagere, i, 9, "c'est plein de livre"));
        }
        Endroits.salle_bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_coffre(TypeObjet.etagere, 0, 9, "coffre", Objets.potion));
        Endroits.salle_bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.setSol(Sol.bois);
        

        Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage(
                TypeObjet.porte, 2,0, Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 2, 8));
        for (int i=2 ; i<6 ; i++) {
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                    new Objet_endroit_classique (TypeObjet.place, 1,i));
        }
        for (int i=2 ; i<6 ; i++) {
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                    new Objet_endroit_classique (TypeObjet.place, 4,i));
        }
        Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage (
                TypeObjet.porte, 0,7, Endroits.cour_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 4, 1));
        Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.setSol(Sol.bois);

        Endroits.cour_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage(
                TypeObjet.porte, 5,1,Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 1, 7));
        Endroits.cour_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.setSol(Sol.bois);

        Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage(
                TypeObjet.porte, 0,2, Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 3, 1));
        Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage(
                TypeObjet.porte, 4,0, Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 1, 0));
        Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 3,1));
        Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 3,2));
        Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 3,3));
        Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 4,1));
        Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 4,3));
        Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.setSol(Sol.bois);


        Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage(
                TypeObjet.porte, 2,0, Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 5, 0));
        Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_passage (
                TypeObjet.porte, 0,0, Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 3, 0));
        Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique(TypeObjet.bureau, 3,1));
        Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 3,2));
        Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 3,3));
        Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 4,1));
        Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.bureau, 4,3));
        Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.lit, 2,4));
        Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
                new Objet_endroit_classique (TypeObjet.lit, 1,4));
        Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.setSol(Sol.bois);


    }

    private void modificationBatiment () {

        Endroits.maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.setNbSalle(1, 1, 1);
        Endroits.maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.bas_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 0);
        Endroits.maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 1);
        
        Endroits.maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.bas_maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 0);
        
        Endroits.maisonMok_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.bas_maisonMok_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 0);
        
        Endroits.maisonVard_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.bas_maisonVard_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 0);

        Endroits.bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.salle_bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 0);

        Endroits.ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 0);
        Endroits.ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.cour_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 0);

        Endroits.magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 0);
        Endroits.auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 0);

        Endroits.parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 0);
        Endroits.parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 0);
        Endroits.parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterSalle(
                Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 0);


   }

   private void modificationQuartier () {

       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterBatiment(
               Endroits.maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterBatiment(
               Endroits.maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterBatiment(
               Endroits.maisonMok_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterBatiment(
               Endroits.maisonVard_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 0, 2));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 0, 6));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 0, 7));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 4, 0));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 5, 0));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 4, 9));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 5, 9));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(new Objet_endroit_classique(TypeObjet.mur, 0, 1));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
              new Objet_endroit_passage (TypeObjet.porte, 5, 4, Endroits.zoneMedieville_zoneMedicoru_continent, 0, 1));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
              new Objet_endroit_passage (TypeObjet.porte, 5, 5, Endroits.zoneMedieville_zoneMedicoru_continent, 0, 1));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.chemin, 0, 0, Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 5, 0));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.chemin, 0, 3, Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 5, 3));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.chemin, 0, 4, Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 5, 4));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.chemin, 0, 5, Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 5, 5));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.chemin, 0, 8, Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 5, 8));
       Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.chemin, 0, 9, Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, 5, 9));

       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterBatiment(
               Endroits.bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterBatiment(
               Endroits.parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterBatiment(
               Endroits.ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterBatiment(
               Endroits.magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterBatiment(
               Endroits.auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 0, 1));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 0, 2));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 0, 3));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 0, 6));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 0, 7));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 0, 9));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 5, 2));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 5, 7));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.arbre, 5, 8));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.fontaine, 2, 4));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_classique(TypeObjet.fontaine, 2, 5));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.porte, 1, 0, Endroits.zoneMedieville_zoneMedicoru_continent, 0, 1));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.porte, 2, 0, Endroits.zoneMedieville_zoneMedicoru_continent, 0, 1));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.chemin, 5, 0, Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 0, 0));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.chemin, 5, 3, Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 0, 3));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.chemin, 5, 4, Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 0, 4));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.chemin, 5, 5, Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 0, 5));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.chemin, 5, 8, Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 0, 8));
       Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent.ajouterObjetEndroit(
               new Objet_endroit_passage (TypeObjet.chemin, 5, 9, Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, 0, 9));
   }

    private void modificationVille() {
        Endroits.medieville_zoneMedieville_zoneMedicoru_continent.ajouterQuartier(
                Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        Endroits.medieville_zoneMedieville_zoneMedicoru_continent.ajouterQuartier(
                Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        Endroits.medieville_zoneMedieville_zoneMedicoru_continent.ajouterQuartier(
                Endroits.quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent);
    }

    private void modificationSousZone () {
        Endroits.zoneMedieville_zoneMedicoru_continent.ajouterVille(Endroits.medieville_zoneMedieville_zoneMedicoru_continent);
    }

    private void modificationZone () {
        Endroits.zoneMedicoru_continent.ajouterSousZone(Endroits.zoneGrandeForet1_zoneMedicoru_continent);
        Endroits.zoneMedicoru_continent.ajouterSousZone(Endroits.zoneGrandeForet2_zoneMedicoru_continent);
        Endroits.zoneMedicoru_continent.ajouterSousZone(Endroits.zoneGrandeForet3_zoneMedicoru_continent);
        Endroits.zoneMedicoru_continent.ajouterSousZone(Endroits.zoneBatcity_zoneMedicoru_continent);
        Endroits.zoneMedicoru_continent.ajouterSousZone(Endroits.zoneMedieville_zoneMedicoru_continent);
        Endroits.zoneMedicoru_continent.ajouterSousZone(Endroits.zoneGrandeForet4_zoneMedicoru_continent);
        Endroits.zoneMedicoru_continent.ajouterSousZone(Endroits.zonePlage_zoneMedicoru_continent);
        Endroits.zoneMedicoru_continent.ajouterSousZone(Endroits.zoneTempleMedicoru_zoneMedicoru_continent);
        Endroits.zoneMedicoru_continent.ajouterSousZone(Endroits.zoneGrandeForet5_zoneMedicoru_continent);
    }

    private void modificationPays () {
        Endroits.continent.ajouterZone(Endroits.zoneMedicoru_continent);   
    }

    public ArrayList<Endroit> getEndroit () {
        return this.carte_gmm;
    }
    
    public void createXMLFile () {
        ListeDEndroit endroits = new ListeDEndroit();
        endroits.ajouterEndroit(Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.bas_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.bas_maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.bas_maisonMok_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.bas_maisonVard_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.salle_bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.cour_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.batcity_zoneBatcity_zoneMedicoru_continent);
        endroits.ajouterEndroit(Endroits.grandeForet);
        endroits.ajouterEndroit(Endroits.village_guerrier);
        endroits.ajouterEndroit(Endroits.fort_bandit);
        endroits.ajouterEndroit(Endroits.immortalis);
        endroits.ajouterEndroit(Endroits.foret_sorciere);
        endroits.ajouterEndroit(Endroits.temple_goroku);
        endroits.ajouterEndroit(Endroits.foret_vivante);
        endroits.ajouterEndroit(Endroits.montagne_felin);
        endroits.ajouterEndroit(Endroits.temple_foudroineau);
        endroits.ajouterEndroit(Endroits.defendere);
        endroits.ajouterEndroit(Endroits.village_oiseau);
        endroits.ajouterEndroit(Endroits.village_serpent);
        endroits.ajouterEndroit(Endroits.temple_guimelard);
        endroits.ajouterEndroit(Endroits.temple_espancien);
        endroits.ajouterEndroit(Endroits.mausole_fuleau);
        endroits.ajouterEndroit(Endroits.temple_galactika);
        endroits.ajouterEndroit(Endroits.temple_medicoru);
        endroits.ajouterEndroit(Endroits.village_felin);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            
            for (int k = 0 ; k < endroits.size() ; k++) {
                mfiari.lib.game.ville.Endroit e = (mfiari.lib.game.ville.Endroit) endroits.getEndroit(k);
                Document doc = db.newDocument();
                Element endroitElement = doc.createElement("endroit");
                endroitElement.setAttribute("nom", e.getNom());
                endroitElement.setAttribute("longueur", String.valueOf(e.getLongueur()));
                endroitElement.setAttribute("largeur", String.valueOf(e.getLongueur()));
                endroitElement.setAttribute("positionx", String.valueOf(e.getPosition().getPositionX()));
                endroitElement.setAttribute("positiony", String.valueOf(e.getPosition().getPositionY()));
                endroitElement.setAttribute("type", "route");
                /*endroitElement.setAttribute("terrain", e.getTerrain().getType().toString());*/
                
                Element solElement = doc.createElement("sol");
                solElement.setAttribute("type", "herbe");
                endroitElement.appendChild(solElement);
                
                Element objetEndroitsElement = doc.createElement("objet_endroits");
                Element batimentsElement = doc.createElement("batiments");
                Element gensElement = doc.createElement("gens");
                for (int i = 0; i < e.getLargeur(); i++) {
                    for (int j = 0; j < e.getLongueur(); j++) {
                        Position p = new Position(i, j);
                        if (e.aEndroit(p) != null) {
                            mfiari.lib.game.ville.Endroit batiment = (mfiari.lib.game.ville.Endroit)e.aEndroit(p);
                            Element batimentElement = doc.createElement("batiment");
                            /*batimentElement.setAttribute("type", this.getNomImageBatimentByClass(batiment));*/
                            batimentElement.setAttribute("positionx", String.valueOf(p.getPositionX()));
                            batimentElement.setAttribute("positiony", String.valueOf(p.getPositionY()));
                            batimentsElement.appendChild(batimentElement);
                        } else if (e.aGens(p) != null) {
                            Gens gens = e.aGens(p);
                            Element habitantElement = doc.createElement("habitant");
                            habitantElement.setAttribute("nom", gens.getNom());
                            habitantElement.setAttribute("positionx", String.valueOf(p.getPositionX()));
                            habitantElement.setAttribute("positiony", String.valueOf(p.getPositionY()));
                            gensElement.appendChild(habitantElement);
                        } else if (e.aObjetEndroit(p) != null) {
                            ObjetEndroit objet_endroit = e.aObjetEndroit(p);
                            Element objetEndroitElement = doc.createElement("objet_endroit");
                            objetEndroitElement.setAttribute("type", objet_endroit.getType().toString());
                            objetEndroitElement.setAttribute("positionx", String.valueOf(p.getPositionX()));
                            objetEndroitElement.setAttribute("positiony", String.valueOf(p.getPositionY()));
                            objetEndroitsElement.appendChild(objetEndroitElement);
                        }
                    }
                }
                endroitElement.appendChild(objetEndroitsElement);
                endroitElement.appendChild(batimentsElement);
                endroitElement.appendChild(gensElement);
                doc.appendChild(endroitElement);
                
                FileWriter fileWriter = new FileWriter(new File("media/endroits/"+k+".xml"));
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

                transformer.transform(new DOMSource(doc), new StreamResult(fileWriter));
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CreationVille.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException | TransformerException ex) {
            throw new RuntimeException("Error converting to String", ex);
        } catch (IOException ex) {
            Logger.getLogger(CreationVille.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    

}
