/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.texte;

/**
 *
 * @author mike
 */
public class Texte_fr extends Texte{

    public Texte_fr () {
        
        /**********     VARIABLE UTILISE DANS gmm.combat     **********/
        this.impossible = "impossible";
        this.pv = "pv";
        this.pm = "pm";
        this.pasObjet = "pas d'objet";
        this.vide = "vide";
        this.etatAffecte = "état affecté";
        this.pasTechnique = "pas de technique";
        this.surQuiUtiliser = " sur qui l'utiliser ?";
        this.volRate = "vol raté";
        this.rienAvoler = "rien à voler";
        
        /**********     FIN VARIABLE UTILISE DANS gmm.combat     **********/
        this.professeur = "professeur";
        
        /**********     VARIABLE UTILISE DANS gmm.menu     **********/
        this.suivant = "suivant";
        this.nouvellePartie = "nouvelle partie";
        this.continuer = "continuer";
        this.extra = "extra";
        this.haut = "haut";
        this.bas = "bas";
        this.droite = "droite";
        this.gauche = "gauche";
        this.action = "action";
        this.menu = "menu";
        this.queFaire = "Que faire?";
        this.oui = "oui";
        this.non = "non";
        this.quelEstVotreNom = "Quel est votre nom?";
        this.entrerUnNom = "entrer un nom";
        this.sauvegarde = "sauvegarde";
        this.tempsjeu = "temps de jeu";
        this.surQuelPartieSauvegarder = "Sur quel partie voulez vous sauvegarder ?";
        this.quitter = "quitter";
        /**********     FIN VARIABLE UTILISE DANS gmm.menu     **********/
        
        /**********     VARIABLE UTILISE DANS gmm.vueConsole_combat     **********/
   
        this.attaquer = "attaquer";
        this.examiner = "examiner";
        this.objet = "objet";
        this.seProteger = "se proteger";
        this.perso = "perso";
        this.retour = "retour";
        this.quiAttaquer = "qui attaquer?";
        this.quelTecUtilise = "quel technique utiliser?";
        this.expRecu = "exp reçu";
        this.argentRecu = " pièce d'or reçu";
        this.pieceOr = "pièces d'or";
        this.niv = "niv";

        /**********     FIN VARIABLE UTILISE DANS gmm.vueConsole_combat     **********/

        /**********     VARIABLE UTILISE DANS gmm.vueConsole_menu     **********/

        this.etat = "état";
        this.technique = "technique";
        this.quete = "quete";
        this.equiper = "equiper";
        this.cuisine = "cuisine";
        this.configuration = "configuration";
        this.sauvegarder = "sauvegarder";
        this.objetDivers = "objet divers";
        this.arme = "arme";
        this.armure = "armure";
        this.chapeau = "chapeau";
        this.botte = "botte";
        this.accessoire = "accessoire";
        this.objetRare = "objet rare";
        this.quelPersoChoisir = "quel perso choisir?";
        this.force = "force";
        this.def = "defense";
        this.magie = "magie";
        this.res = "res";
        this.vit = "vit";
        this.prec = "prec";
        this.agi = "agi";
        this.exp = "exp";
        this.nivSuiv = "niv suiv";

        /**********     FIN VARIABLE UTILISE DANS gmm.vueConsole_menu     **********/
    }
    
    @Override
    public String vousRecevez(String objet) {
        return "Vous recevez "+ objet;
    }

    @Override
    public String auTourDe(String perso) {
        return "au tour de " + perso;
    }

    @Override
    public String attaque(String attaquant, String attaquer) {
        return attaquant + " attaque " + attaquer;
    }

    @Override
    public String rateAttaque(String perso) {
        return perso + " rate son attaque";
    }

    @Override
    public String esquiveAttaque(String perso) {
        return perso + " esquive l'attaque";
    }

    @Override
    public String estKO(String perso) {
        return perso + " est K.O";
    }

    @Override
    public String recoitDegat(String perso, int degat) {
        return perso + " reçoit " + degat + " degat";
    }

    @Override
    public String utilise(String attaquant, String technique) {
        return attaquant + " utilise" + technique;
    }

    @Override
    public String utiliseSur(String attaquant, String technique, String attaquer) {
        return attaquant + " utilise " + technique + " sur " + attaquer;
    }

    @Override
    public String examine(String examinateur, String examiner) {
        return examinateur + " examine " + examiner;
    }

    @Override
    public String dejaEnForme(String perso) {
        return perso + " deja en forme";                                                                                                    
    }

    @Override
    public String seMetEnGarde(String perso) {
        return perso + " se met en garde";
    }

    @Override
    public String monteDeNiveau(String perso) {
        return perso + " monte de niveau";
    }
    
    @Override
    public String pereDe (String perso) {
        return "père de " + perso;
    }
    
    @Override
    public String mereDe (String perso) {
        return "mère de " + perso;
    }
    
    /**********     FONCTION DE CreationEvenement.java     *********/
    
    @Override
    public String getParoleCreationEvenementDialogue1 () {
        return "Leve toi, c'est l'heure d'aller à l'école";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue2 () {
        return "oh, d'accord papa";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue3 () {
        return "bon c'est le moment d'aller à l'école";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue4 () {
        return "Bonjour à tous";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue5 () {
        return "Vous vous souvenez bien que demain c'est votre epreuve pour passer apprenti.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue6 () {
        return "aujourd'hui on va revoir les bases.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue7 (String perso) {
        return perso + " tu commence";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue8 () {
        return "he voila on a revu les bases. Si vous avez besoin de plus d'information, venez me voir.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue9 () {
        return "bonne chance pour demain. Le cour est terminer.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue10 () {
        return "ce parc d'entrainement est pratique car tu peut affronter des monstres";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue11 () {
        return "sans sortir du village, mais on ne peut pas gagner d'experience.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue12 () {
        return "Mais que cela ne t'empeche pas d'y aller pour tester ton niveau et tes capcités.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue13 () {
        return "Parfois il y a des nouveau monstres plus fort qui apparaissent.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue14 () {
        return "heu... comment fait-on deja pour regarder ses capaciter?";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue15 () {
        return "il faut ouvrir le menu en appuyant sur la touche 6 et aller dans etat";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue16 () {
        return "C'est bon je suis pret maintenant.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue17 () {
        return "Ca tombe bien voila un monstre.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue18 () {
        return "Je suis pret a botter les fesse de tous les monstres qui se trouve ici.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue19 () {
        return "Verifions ce que tu as dit, il y a encor des monstres qui nous attendent.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue20 () {
        return "Encor une victoire, n'y a t'il pas des monstres plus fort?";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue21 () {
        return "Aujourd'hui il y a le Cerf dans le parc d'entrainement, il est tres puissant. Tu veux essayer?";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue22 () {
        return "ouai!! il est ou ce Cerf?";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue23 () {
        return "Au milieu de la foret pres du grand chene";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue24 () {
        return "ok allons y";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue25 () {
        return "attend! on devrait se soigner d'abord";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue26 () {
        return "yeah je suis en pleine forme allons botter les fesse de ce Cerf.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue27 () {
        return "HE! pfiou il est trop exiter";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue28 () {
        return "C'est lui.";
    }
    
    @Override
    public String getParoleCreationEvenementDialogue29 () {
        return "Allons y";
    }
    
    @Override
    public String getParoleCreationEvenementCombat1 () {
        return "Nous allons voir les commandes que vous pouvez utiliser dans les combats.";
    }
    
    @Override
    public String getParoleCreationEvenementCombat2 () {
        return "Nous allons commencer par attaquer. Detruit la cible pour commencer en utilisant attaquer (touche 1).";
    }
    
    @Override
    public String getParoleCreationEvenementCombat3 () {
        return "vous devez attaquer la cible (appuyer sur la touche 1)! Recommencez.";
    }
    
    @Override
    public String getParoleCreationEvenementCombat4 () {
        return "maintenant nous allons apprendre a nous defendre. vous allez parer ces attaques";
    }
    
    @Override
    public String getParoleCreationEvenementCombat5 () {
        return "Vous n'avez pas parer l'attaque! Recommencez.";
    }
    
    @Override
    public String getParoleCreationEvenementCombat6 () {
        return "nous avons appris a attaquer et a parer mais parfois il arrive que";
    }
    
    @Override
    public String getParoleCreationEvenementCombat7 () {
        return "l'on recoivent des coups quand on est en defense ou ";
    }
    
    @Override
    public String getParoleCreationEvenementCombat8 () {
        return "que nos attaque ne soit pas assez puissante pour passer.";
    }
    
    @Override
    public String getParoleCreationEvenementCombat9 () {
        return "c'est a ce moment la que l'on utilise des objets. Essayer de parer cette attaque";
    }
    
    @Override
    public String getParoleCreationEvenementCombat10 () {
        return "quand vous perdez des point de vie il vaut mieux vous soignez. prenez une potion dans vos objets (en appuyant sur la touche 4).";
    }
    
    @Override
    public String getParoleCreationEvenementCombat11 () {
        return "vous devez utiliser un objet (appuyer sur la touche 4).";
    }
    
    @Override
    public String getParoleCreationEvenementCombat12 () {
        return "tu peut analyser les capacite de l'enemie en utilisant examiner (appuyer sur la touche 5).";
    }
    
    @Override
    public String getParoleCreationEvenementCombat13 () {
        return "il sont deux maintenant, le combat vas etre plus difficile.";
    }
    
    @Override
    public String getParoleCreationEvenementCombat14 () {
        return "n'oublie pas que je suis un magicien, mes attaques magique sont plus puissantes que mes attaques physique.";
    }
    
    @Override
    public String getParoleCreationEvenementChoix1 (String perso) {
        return "he "+ perso +".";
    }
    
    @Override
    public String getParoleCreationEvenementChoix2 (String perso) {
        return perso + " et moi on voulais aller faire quelque combat au parc d'entrainement.";
    }
    
    @Override
    public String getParoleCreationEvenementChoix3 () {
        return "tu veut venir avec nous?";
    }
    /**********     FIN FONCTION DE CreationEvenement.java     *********/
    
    /**********     FONCTIONS DE CreationPerso.java             **********/
    
    @Override
    public String getCreationHabitant1 () {
        return "je dois aller faire quelque course aujourd'hui.";
    }
    
    @Override
    public String getCreationHabitant2 () {
        return "si tu ne pars pas maintenant tu vas etre en retard.";
    }
    
    @Override
    public String getCreationHabitant3 (String perso) {
        return "Bonjour " + perso + ", comment ca va aujourd'hui?";
    }
    
    @Override
    public String getCreationHabitant4 () {
        return "On garde la porte pour eviter les intrusions";
    }
    
    @Override
    public String getCreationHabitant5 () {
        return "On doit toujours être attentif";
    }
    
    /**********     FIN FONCTIONS DE CreationPerso.java         **********/

}
