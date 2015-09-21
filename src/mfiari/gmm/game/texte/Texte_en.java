/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.texte;

/**
 *
 * @author mike
 */
public class Texte_en extends Texte{

    public Texte_en () {
        
        /**********     VARIABLE UTILISE DANS gmm.combat     **********/
        this.impossible = "impossible";
        this.pv = "lp";
        this.pm = "mp";
        this.pasObjet = "no object";
        this.vide = "empty";
        this.etatAffecte = "état affecté";
        this.pasTechnique = "no technique";
        this.surQuiUtiliser = "on which teamate do you want to use it ?";
        this.volRate = "steal missed";
        this.rienAvoler = "nothing to steal";
        /**********     FIN VARIABLE UTILISE DANS gmm.combat     **********/
        
        this.professeur = "teacher";
        
        /**********     VARIABLE UTILISE DANS gmm.menu     **********/
        this.suivant = "next";
        this.nouvellePartie = "new game";
        this.continuer = "continue";
        this.extra = "extra";
        this.haut = "up";
        this.bas = "down";
        this.droite = "right";
        this.gauche = "left";
        this.action = "action";
        this.menu = "menu";
        this.queFaire = "What do you want to do?";
        this.oui = "yes";
        this.non = "no";
        this.quelEstVotreNom = "What is your name?";
        this.entrerUnNom = "tape a name";
        this.sauvegarde = "save";
        this.tempsjeu = "game time";
        this.surQuelPartieSauvegarder = "On which game do you want to save ?";
        this.quitter = "quit";
        /**********     FIN VARIABLE UTILISE DANS gmm.menu     **********/
        
        /**********     VARIABLE UTILISE DANS gmm.vueConsole_combat     **********/
   
        this.attaquer = "attack";
        this.examiner = "analyse";
        this.objet = "object";
        this.seProteger = "protect yourself";
        this.perso = "perso";
        this.retour = "return";
        this.quiAttaquer = "who do you want to attack";
        this.quelTecUtilise = "which skills do you want to use";
        this.expRecu = "exp receive";
        this.argentRecu = " pièce d'or receive";
        this.pieceOr = "pièces d'or";
        this.niv = "level";

        /**********     FIN VARIABLE UTILISE DANS gmm.vueConsole_combat     **********/

        /**********     VARIABLE UTILISE DANS gmm.vueConsole_menu     **********/

        this.etat = "state";
        this.technique = "skills";
        this.quete = "quete";
        this.equiper = "equiper";
        this.cuisine = "cook";
        this.configuration = "configuration";
        this.sauvegarder = "save";
        this.objetDivers = "all object";
        this.arme = "weapon";
        this.armure = "armure";
        this.chapeau = "hat";
        this.botte = "boots";
        this.accessoire = "accessory";
        this.objetRare = "rare object";
        this.quelPersoChoisir = "which perso do you want to choose";
        this.force = "strong";
        this.def = "defense";
        this.magie = "magic";
        this.res = "res";
        this.vit = "speed";
        this.prec = "prec";
        this.agi = "agi";
        this.exp = "exp";
        this.nivSuiv = "next level";

        /**********     FIN VARIABLE UTILISE DANS gmm.vueConsole_menu     **********/
    }

    @Override
    public String vousRecevez(String objet) {
        return "You receive " + objet;
    }

    @Override
    public String auTourDe(String perso) {
        return "turn to " + perso;
    }

    @Override
    public String attaque(String attaquant, String attaquer) {
        return attaquant + " attack " + attaquer;
    }

    @Override
    public String rateAttaque(String perso) {
        return perso + " miss his attack";
    }

    @Override
    public String esquiveAttaque(String perso) {
        return perso + " evade the attack";
    }

    @Override
    public String estKO(String perso) {
        return perso + " is K.O";
    }

    @Override
    public String recoitDegat(String perso, int degat) {
        return perso + " receive " + degat + " damage";
    }

    @Override
    public String utilise(String attaquant, String technique) {
        return attaquant + " use" + technique;
    }

    @Override
    public String utiliseSur(String attaquant, String technique, String attaquer) {
        return attaquant + " use " + technique + " on " + attaquer;
    }

    @Override
    public String examine(String examinateur, String examiner) {
        return examinateur + " analyse " + examiner;
    }

    @Override
    public String dejaEnForme(String perso) {
        return perso + " already ok";                                                                                                    
    }

    @Override
    public String seMetEnGarde(String perso) {
        return perso + " se met en garde";
    }

    @Override
    public String monteDeNiveau(String perso) {
        return perso + " level up";
    }
    
    @Override
    public String pereDe (String perso) {
        return perso + "'s father";
    }
    
    @Override
    public String mereDe (String perso) {
        return perso + "'s mother";
    }
    
    /**********     FONCTION DE CreationEvenement.java     *********/
    
    @Override
    public String getParoleCreationEvenementDialogue1 () {
        return "Get up, it's time for you to go to school";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue2 () {
        return "Oh, alright dad";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue3 () {
        return "It's time to go to school";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue4 () {
        return "Hello everybody";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue5 () {
        return "You know that tomoro you will have exam to become a novice.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue6 () {
        return "Today, we'll see the basic again";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue7 (String perso) {
        return perso + " you start";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue8 () {
        return "That's it, we review the basic. If you want further information, come to see me.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue9 () {
        return "Good luck for tomorow. The lesson is over";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue10 () {
        return "This training park is useful for training yourself because yhere are monster in it";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue11 () {
        return "without go out of the village, but we can't win experience.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue12 () {
        return "But it should not stop you to go there to test your level and your habilities.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue13 () {
        return "And sometimes there are stronger monster who came.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue14 () {
        return "heu... How can I see my habilities?";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue15 () {
        return "You have to open the menu by pressing the 6 button and go in the state menu.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue16 () {
        return "alright, I'm ready now.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue17 () {
        return "It's good timing, here come a monster.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue18 () {
        return "I'm ready to kick every monster who are here ass.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue19 () {
        return "Lets's verify what's your saying, there a lot of monster here wainting for us.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue20 () {
        return "Another victory. Is there any stronger monster here?";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue21 () {
        return "Today, there are the cerf, he is very powerful. Wanna try?";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue22 () {
        return "Yep!! Where is this cerf";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue23 () {
        return "In the middle of the forest near of the great chene";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue24 () {
        return "Alright then, let's go";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue25 () {
        return "Wait a minute! We should heal ourself first";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue26 () {
        return "yeah I'm en pleine forme. Let's kick this cerf ass.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue27 () {
        return "Wait! pfiou he is too exiting";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue28 () {
        return "This is him.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue29 () {
        return "Let's go";
    }
    
    @Override
    public String getParoleCreationEvenementCombat1 () {
        return "We're gonna see commandes that you can use while your fighting.";
    }
    
    @Override
    public String getParoleCreationEvenementCombat2 () {
        return "We're gonna begin by attacking. Break the target by using attaquer(touch 1).";
    }
    
    @Override
    public String getParoleCreationEvenementCombat3 () {
        return "You must attack the target (press the touch 1)! Try again.";
    }
    
    @Override
    public String getParoleCreationEvenementCombat4 () {
        return "Now we're gonna see how to defend ourself. You're gonna stop those attack.";
    }
    
    @Override
    public String getParoleCreationEvenementCombat5 () {
        return "You didn't stop the attack! Try again.";
    }
    
    @Override
    public String getParoleCreationEvenementCombat6 () {
        return "We learn to attack and defend ourself but sometimes it happens";
    }
    
    @Override
    public String getParoleCreationEvenementCombat7 () {
        return "that you receive hit even if your in defense or that";
    }
    
    @Override
    public String getParoleCreationEvenementCombat8 () {
        return "our attack are not strong enough to hurt the ennemy.";
    }
    
    @Override
    public String getParoleCreationEvenementCombat9 () {
        return "When it happens, you should use objects. Try to stop this attack";
    }
    
    @Override
    public String getParoleCreationEvenementCombat10 () {
        return "When you lose life point, you better should heal yourself. You can do that by taking a potion from your objects (press button 4).";
    }
    
    @Override
    public String getParoleCreationEvenementCombat11 () {
        return "You must use a potion (press button 4).";
    }
    
    @Override
    public String getParoleCreationEvenementCombat12 () {
        return "You can analyse the habilities of the ennemie by using examiner (press button 5).";
    }
    
    @Override
    public String getParoleCreationEvenementCombat13 () {
        return "There are two now, the battle will be more difficult.";
    }
    
    @Override
    public String getParoleCreationEvenementCombat14 () {
        return "Don't forget that I am a wizard, my magic attack are stronger that my physical attack.";
    }
    
    @Override
    public String getParoleCreationEvenementChoix1 (String perso) {
        return "he "+ perso +".";
    }
    
    @Override
    public String getParoleCreationEvenementChoix2 (String perso) {
        return perso + " and me want to go do some fight at the training park.";
    }
    
    @Override
    public String getParoleCreationEvenementChoix3 () {
        return "Do you want to come with us?";
    }
    /**********     FIN FONCTION DE CreationEvenement.java     *********/
    
    /**********     FONCTIONS DE CreationPerso.java             **********/
    
    @Override
    public String getCreationHabitant1 () {
        return "I have to do shopping today.";
    }
    
    @Override
    public String getCreationHabitant2 () {
        return "If you don't leave now you'll be late for school.";
    }
    
    @Override
    public String getCreationHabitant3 (String perso) {
        return "Hello " + perso + ", How are you today?";
    }
    
    @Override
    public String getCreationHabitant4 () {
        return "We're garding the door to avoid intrusions";
    }
    
    @Override
    public String getCreationHabitant5 () {
        return "We always have to be careful";
    }
    
    /**********     FIN FONCTIONS DE CreationPerso.java         **********/

}
