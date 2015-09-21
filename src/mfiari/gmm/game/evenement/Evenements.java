/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.evenement;

import mfiari.gmm.game.perso.Personnages;
import mfiari.gmm.game.ville.Endroits;
import mfiari.lib.game.evenements.EvenementChoix;
import mfiari.lib.game.evenements.EvenementDialogue;
import mfiari.lib.game.evenements.EvenementQuete;
import mfiari.lib.game.evenements.EvenementQueteAnnexe;

/**
 *
 * @author mike
 */
public class Evenements {

    public static EvenementQuete jeu = new EvenementQuete("jeu");
    public static EvenementQuete chapitre1 = new EvenementQuete("chapitre1");
    public static EvenementQuete ecole = new EvenementQuete(true, 
            Endroits.ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'ecole");
    public static EvenementDialogue debut = new EvenementDialogue(
            Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'ecole_1");
    public static EvenementDialogue cours = new EvenementDialogue(
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'ecole_2");
    public static EvenementCombat baseAttaque = new EvenementCombat(
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'ecole_3");
    public static EvenementCombat baseDefense = new EvenementCombat(
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'ecole_4");
    public static EvenementSpecial potionPourCour = new EvenementSpecial(
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'ecole_5");
    public static EvenementCombat baseObjet = new EvenementCombat(
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'ecole_6");
    public static EvenementDialogue finCours = new EvenementDialogue(
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'ecole_7");
    public static EvenementSpecial soinApresCour = new EvenementSpecial(
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'ecole_8");
    public static EvenementChoix choixQueteEntrainementAvecVardEtMok = new EvenementChoix(
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'ecole_9");
    public static EvenementQueteAnnexe entrainementAvecVardEtMok = new EvenementQueteAnnexe(true, null,
            Personnages.mok, null, "l'entrainement");
    public static EvenementSpecial vardEtMokDansLequipe = new EvenementSpecial(
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'entrainement_1");
    public static EvenementDialogue entrerDansParcDentrainement = new EvenementDialogue(
            Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'entrainement_2");
    public static EvenementDialogue discussionAvantCombat = new EvenementDialogue(
            Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'entrainement_3");
    public static EvenementCombat premierCombat = new EvenementCombat(
            Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'entrainement_4");
    public static EvenementDialogue discussionentreCombat = new EvenementDialogue(
            Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'entrainement_5");
    public static EvenementCombat combatContreRenardEtLapin = new EvenementCombat(
            Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'entrainement_6");
    public static EvenementDialogue discussionAvantCombatContreCerf = new EvenementDialogue(
            Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'entrainement_7");
    public static EvenementSpecial soinAvantCombatContreCerf = new EvenementSpecial(
            Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'entrainement_8");
    public static EvenementDialogue discussionAvantCombatContreCerf2 = new EvenementDialogue(
            Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'entrainement_9");
    public static EvenementDialogue discussionAvantCombatContreCerf3 = new EvenementDialogue(
            Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'entrainement_10");
    public static EvenementCombat combatContreCerf = new EvenementCombat(
            Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'entrainement_11");
    public static EvenementDialogue discussionApresCombatContreCerf = new EvenementDialogue(
            Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'entrainement_12");
    public static EvenementSpecial nuitApresCombatContreCerf = new EvenementSpecial(
            Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent,
            null, null, "l'entrainement_13");
    public static EvenementQuete examen = new EvenementQuete(true, 
            Endroits.ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'examen");
    public static EvenementDialogue discussionAvecMaman = new EvenementDialogue(
            Endroits.bas_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'examen_1");
    public static EvenementDialogue discussionAcheterEpeeMarco = new EvenementDialogue(
            Endroits.magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'examen_2");
    public static EvenementSpecial acheterEpeeMarco = new EvenementSpecial(
            Endroits.magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'examen_3");
    public static EvenementDialogue discussionEpreuve1 = new EvenementDialogue(
            Endroits.chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'examen_4");
    public static EvenementCombat epreuve1 = new EvenementCombat(
            Endroits.chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'examen_5");
    public static EvenementDialogue discussionEpreuve2 = new EvenementDialogue(
            Endroits.chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'examen_6");
    public static EvenementCombat epreuve2 = new EvenementCombat(
            Endroits.chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'examen_7");
    public static EvenementDialogue discussionEpreuve3 = new EvenementDialogue(
            Endroits.chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'examen_8");
    public static EvenementCombat epreuve3 = new EvenementCombat(
            Endroits.chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'examen_9");
    public static EvenementDialogue discussionFinEpreuve = new EvenementDialogue(
            Endroits.chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'examen_10");
    public static EvenementSpecial livreEnnemie = new EvenementSpecial(
            Endroits.chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'examen_11");
    public static EvenementQuete pemiereMission = new EvenementQuete(true, 
            Endroits.chateau_quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent, null,
            null, "premiere mission");
    public static EvenementDialogue parlerARoman = new EvenementDialogue(Personnages.roman, "premiere mission_1");
    public static EvenementSpecial equipeMission = new EvenementSpecial(
            Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "premiere mission_2");
    public static EvenementDialogue batcity = new EvenementDialogue(null, "premiere mission_3");
    public static EvenementDialogue parlerPretreBatcity = new EvenementDialogue(null, "premiere mission_4");
    public static EvenementCombat combatContreChauveSourie = new EvenementCombat(null, null, null, "premiere mission_5");
    public static EvenementQueteAnnexe aidePaysan = new EvenementQueteAnnexe(true, null, Personnages.mok, null,
            "aide paysan");
    public static EvenementDialogue discussionAidePaysan = new EvenementDialogue(null, "aide paysan_1");
    public static EvenementCombat combatAidePaysan = new EvenementCombat(null, null, null, "aide paysan_2");
    public static EvenementQuete lattaque = new EvenementQuete(true, 
            Endroits.zoneMedieville_zoneMedicoru_continent, null, null, "l'attaque");
    public static EvenementDialogue fumeeDeMedieville = new EvenementDialogue(
            Endroits.zoneMedieville_zoneMedicoru_continent, null, null, "l'attaque_1");
    public static EvenementSpecial romanQuitteLequipe = new EvenementSpecial(
            Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'attaque_2");
    public static EvenementCombat lattaqueCombat1 = new EvenementCombat(
            Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'attaque_3");
    public static EvenementDialogue lattaque_dialogue1 = new EvenementDialogue(
            Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'attaque_4");
    public static EvenementCombat lattaqueCombat2 = new EvenementCombat(
            Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'attaque_5");
    public static EvenementDialogue lattaque_dialogue2 = new EvenementDialogue(
            Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'attaque_6");
    public static EvenementDialogue lattaque_dialogueYuanEtMorgane = new EvenementDialogue(
            Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'attaque_7");
    public static EvenementCombat yuanEtMorgane = new EvenementCombat(
            Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, null, null, "l'attaque_8");
}
