/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.texte;

/**
 *
 * @author mike
 */
abstract public class Texte {

    /**********     VARIABLE UTILISE DANS gmm.combat     **********/
    public String impossible;
    public String pv;
    public String pm;
    public String pasObjet;
    public String vide;
    public String etatAffecte;
    public String pasTechnique;
    public String surQuiUtiliser;
    public String volRate;
    public String rienAvoler;
    /**********     FIN VARIABLE UTILISE DANS gmm.combat     **********/
    
    /**********     VARIABLE UTILISE DANS gmm.menu     **********/
    public String suivant;
    public String nouvellePartie;
    public String continuer;
    public String extra;
    public String haut;
    public String bas;
    public String droite;
    public String gauche;
    public String action;
    public String menu;
    public String queFaire;
    public String oui;
    public String non;
    public String quelEstVotreNom;
    public String entrerUnNom;
    public String sauvegarde;
    public String tempsjeu;
    public String surQuelPartieSauvegarder;
    public String quitter;
    
    /**********     FIN VARIABLE UTILISE DANS gmm.menu     **********/
    
    /**********     VARIABLE UTILISE DANS gmm.vueConsole_combat     **********/
   
    public String attaquer;
    public String examiner;
    public String objet;
    public String seProteger;
    public String perso;
    public String retour;
    public String quiAttaquer;
    public String quelTecUtilise;
    public String expRecu;
    public String argentRecu;
    public String pieceOr;
    public String niv;
    
    /**********     FIN VARIABLE UTILISE DANS gmm.vueConsole_combat     **********/
    
    /**********     VARIABLE UTILISE DANS gmm.vueConsole_menu     **********/
   
    public String etat;
    public String technique;
    public String quete;
    public String equiper;
    public String cuisine;
    public String configuration;
    public String sauvegarder;
    public String objetDivers;
    public String arme;
    public String armure;
    public String chapeau;
    public String botte;
    public String accessoire;
    public String objetRare;
    public String quelPersoChoisir;
    public String force;
    public String def;
    public String magie;
    public String res;
    public String vit;
    public String prec;
    public String agi;
    public String exp;
    public String nivSuiv;
    
    /**********     FIN VARIABLE UTILISE DANS gmm.vueConsole_menu     **********/
    
    /***********     NON DES HABITANS     **********/
    
    public String professeur;
    
    /***********     FIN NON DES HABITANS     **********/

    public abstract String vousRecevez (String objet);

    public abstract String auTourDe (String perso);

    public abstract String attaque (String attaquant, String attaquer);

    public abstract String rateAttaque (String perso);

    public abstract String esquiveAttaque (String perso);

    public abstract String estKO (String perso);

    public abstract String recoitDegat (String perso, int degat);

    public abstract String utilise (String attaquant, String technique);

    public abstract String utiliseSur (String attaquant, String technique, String attaquer);

    public abstract String examine (String examinateur, String examiner);

    public abstract String dejaEnForme (String perso);
    
    public abstract String seMetEnGarde (String perso);

    public abstract String monteDeNiveau (String perso);
    
    public abstract String pereDe (String perso);
    
    public abstract String mereDe (String perso);
    
    /**********     FONCTIONS DE CreationEvenement.java     *********/
    
    public abstract String getParoleCreationEvenementDialogue1 ();
    
    public abstract String getParoleCreationEvenementDialogue2 ();
    
    public abstract String getParoleCreationEvenementDialogue3 ();
    
    public abstract String getParoleCreationEvenementDialogue4 ();
    
    public abstract String getParoleCreationEvenementDialogue5 ();
    
    public abstract String getParoleCreationEvenementDialogue6 ();
    
    public abstract String getParoleCreationEvenementDialogue7 (String nom);
    
    public abstract String getParoleCreationEvenementDialogue8 ();
    
    public abstract String getParoleCreationEvenementDialogue9 ();
    
    public abstract String getParoleCreationEvenementDialogue10 ();
    
    public abstract String getParoleCreationEvenementDialogue11 ();
    
    public abstract String getParoleCreationEvenementDialogue12 ();
    
    public abstract String getParoleCreationEvenementDialogue13 ();
    
    public abstract String getParoleCreationEvenementDialogue14 ();
    
    public abstract String getParoleCreationEvenementDialogue15 ();
    
    public abstract String getParoleCreationEvenementDialogue16 ();
    
    public abstract String getParoleCreationEvenementDialogue17 ();
    
    public abstract String getParoleCreationEvenementDialogue18 ();
    
    public abstract String getParoleCreationEvenementDialogue19 ();
    
    public abstract String getParoleCreationEvenementDialogue20 ();
    
    public abstract String getParoleCreationEvenementDialogue21 ();
    
    public abstract String getParoleCreationEvenementDialogue22 ();
    
    public abstract String getParoleCreationEvenementDialogue23 ();
    
    public abstract String getParoleCreationEvenementDialogue24 ();
    
    public abstract String getParoleCreationEvenementDialogue25 ();
    
    public abstract String getParoleCreationEvenementDialogue26 ();
    
    public abstract String getParoleCreationEvenementDialogue27 ();
    
    public abstract String getParoleCreationEvenementDialogue28 ();
    
    public abstract String getParoleCreationEvenementDialogue29 ();
    
    public abstract String getParoleCreationEvenementCombat1 ();
    
    public abstract String getParoleCreationEvenementCombat2 ();
    
    public abstract String getParoleCreationEvenementCombat3 ();
    
    public abstract String getParoleCreationEvenementCombat4 ();
    
    public abstract String getParoleCreationEvenementCombat5 ();
    
    public abstract String getParoleCreationEvenementCombat6 ();
    
    public abstract String getParoleCreationEvenementCombat7 ();
    
    public abstract String getParoleCreationEvenementCombat8 ();
    
    public abstract String getParoleCreationEvenementCombat9 ();
    
    public abstract String getParoleCreationEvenementCombat10 ();
    
    public abstract String getParoleCreationEvenementCombat11 ();
    
    public abstract String getParoleCreationEvenementCombat12 ();
    
    public abstract String getParoleCreationEvenementCombat13 ();
    
    public abstract String getParoleCreationEvenementCombat14 ();
    
    public abstract String getParoleCreationEvenementChoix1 (String perso);
    
    public abstract String getParoleCreationEvenementChoix2 (String perso);
    
    public abstract String getParoleCreationEvenementChoix3 ();
    
    /**********     FIN FONCTIONS DE CreationEvenement.java     **********/
    
    /**********     FONCTIONS DE CreationPerso.java             **********/
    
    public abstract String getCreationHabitant1 ();
    
    public abstract String getCreationHabitant2 ();
    
    public abstract String getCreationHabitant3 (String perso);
    
    public abstract String getCreationHabitant4 ();
    
    public abstract String getCreationHabitant5 ();
    
    /**********     FIN FONCTIONS DE CreationPerso.java         **********/

}
