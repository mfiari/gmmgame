/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.ville;


/**
 *
 * @author mike
 */
public class Endroits {

    public static Pays continent = new Pays("continent", 5, 3, 102, 100);
    public static Zone zoneMedicoru_continent = new Zone("zone de medicoru", 0, 0, 3, 2);
    public static SousZone zoneMedieville_zoneMedicoru_continent = new SousZone("zone de medieville", 1, 1, 10, 6);
    public static ville medieville_zoneMedieville_zoneMedicoru_continent = new ville("medieville", 10, 11, 1, 3);
    public static Quartier quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent =
            new Quartier("quartier habitant medieville", 0, 0, 10, 6);
    public static Maison maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent =
            new Maison("maison de Marco", 1, 0, 1, 1, 1);
    public static Salle bas_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("rez de chausse maison marco", 0, 0, 6, 5);
    public static Salle chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("chambre de marco", 0, 0, 6, 5);
    public static Maison maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent =
            new Maison("maison de Pepe", 2, 0, 1, 1, 0);
    public static Salle bas_maisonPepe_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("rez de chausse maison pepe", 0, 0, 6, 5);
    public static Maison maisonMok_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent =
            new Maison("maison de Mok", 3, 1, 1, 1, 0);
    public static Salle bas_maisonMok_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("rez de chausse maison mok", 0, 0, 6, 5);
    public static Maison maisonVard_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent =
            new Maison("maison de Vard", 2, 8, 1, 1, 0);
    public static Salle bas_maisonVard_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("rez de chausse maison vard", 0, 0, 6, 5);
    public static Quartier quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Quartier("quartier principal", 0, 0, 10, 6);
    public static Batiment bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Batiment("bibliotheque", 1, 9, 1, 1, 0, 0);
    public static Salle salle_bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("rez de chausse bibliotheque", 0, 0, 10, 6);
    public static Maison ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Maison("ecole", 2, 9, 1, 1, 0);
    public static Salle salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("salle de classe", 0, 0, 10, 6);
    public static Salle cour_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("cour", 0, 0, 10, 6);
    public static Maison parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Maison("parc d'entrainement", 0, 8, 1, 1, 0);
    public static Salle salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("entre parc d'entrainement", 0, 0, 10, 6);
    public static Salle zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("Zone1 parc d'entrainement", 0, 0, 10, 6);
    public static Salle zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("Zone2 parc d'entrainement", 0, 0, 10, 6);
    public static magasin magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new magasin("magasin", 4, 1, 1, 2, 0);
    public static Salle salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("salle magasin medieville", 0, 0, 5, 5);
    public static Maison auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Maison("auberge medieville", 5, 1, 1, 1, 0);
    public static Salle salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent =
            new Salle("salle auberge medieville", 0, 0, 5, 5);
    public static Quartier quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent =
            new Quartier("quartier chateau", 0, 0, 10, 10);
    public static Batiment chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent =
            new Batiment("chateau de medieville", 4, 3, -1, 2, 20, 20);
    public static SousZone zoneBatcity_zoneMedicoru_continent = new SousZone("zone de batcity", 1, 0, 10, 6);
    public static ville batcity_zoneBatcity_zoneMedicoru_continent = new ville("Batcity", 10, 11, 0, 0);
    public static SousZone zoneTempleMedicoru_zoneMedicoru_continent = new SousZone("zone de medieville", 2, 1, 10, 6);
    public static SousZone zonePlage_zoneMedicoru_continent = new SousZone("zone de medieville", 2, 0, 10, 6);
    public static SousZone zoneGrandeForet1_zoneMedicoru_continent = new SousZone("zone de medieville", 0, 0, 10, 6);
    public static SousZone zoneGrandeForet2_zoneMedicoru_continent = new SousZone("zone de medieville", 0, 1, 10, 6);
    public static SousZone zoneGrandeForet3_zoneMedicoru_continent = new SousZone("zone de medieville", 0, 2, 10, 6);
    public static SousZone zoneGrandeForet4_zoneMedicoru_continent = new SousZone("zone de medieville", 1, 2, 10, 6);
    public static SousZone zoneGrandeForet5_zoneMedicoru_continent = new SousZone("zone de medieville", 2, 2, 10, 6);
    public static ville grandeForet = new ville("grande foret", 10, 11, 0, 0);
    public static ville village_guerrier = new ville("village des guerrier", 10, 11, 0, 0);
    public static ville fort_bandit = new ville("fort des bandits", 10, 11, 0, 0);
    public static ville immortalis = new ville("Immortalis", 10, 11, 0, 0);
    public static ville foret_sorciere = new ville("Foret aux sorciere", 10, 11, 0, 0);
    public static ville temple_goroku = new ville("Temple de Goroku", 10, 11, 0, 0);
    public static ville foret_vivante = new ville("Foret vivante", 10, 11, 0, 0);
    public static ville montagne_felin = new ville("Montagne aux felin", 10, 11, 0, 0);
    public static ville temple_foudroineau = new ville("Temple de Foudroineau", 10, 11, 0, 0);
    public static ville defendere = new ville("Defendere", 10, 11, 0, 0);
    public static ville village_oiseau = new ville("village des oiseau", 10, 11, 0, 0);
    public static ville village_serpent = new ville("village des serpent", 10, 11, 0, 0);
    public static ville temple_guimelard = new ville("Temple de Guimelard", 10, 11, 0, 0);
    public static ville temple_espancien = new ville("Temple d'Espancien", 10, 11, 0, 0);
    public static ville mausole_fuleau = new ville("Mausolé de Fuleau", 10, 11, 0, 0);
    public static ville temple_galactika = new ville("Temple de Galactika", 10, 11, 0, 0);
    public static ville temple_medicoru = new ville("Temple de Medicoru", 10, 11, 0, 0);
    public static ville village_felin = new ville("village des félins", 10, 11, 0, 0);
}
