/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.extra;

import mfiari.gmm.game.Vues;
import mfiari.gmm.game.combat.Combat;
import mfiari.gmm.game.demarrage.CreationEnnemie;
import mfiari.gmm.game.demarrage.CreationObjet;
import mfiari.gmm.game.demarrage.CreationPerso;
import mfiari.gmm.game.demarrage.CreationTechnique;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.lib.game.controlleur.ControlleurVue;

/**
 *
 * @author mike
 */
public class DuelExtra extends ControlleurVue {

    private ListeDePerso persos;
    private ListeDePerso adv;
    private ListeDePerso equipeJ1;
    private ListeDePerso equipeJ2;
    private ListeDePerso equipeAdv;
    private CreationPerso creationPerso;
    private CreationEnnemie creationEnnemie;
    private CreationObjet creationObjet;
    private CreationTechnique creationTechnique;
    private String affichage;

    public DuelExtra() {
        this.creationPerso = new CreationPerso();
        this.creationEnnemie = new CreationEnnemie();
        /*this.creationObjet = new CreationObjet (null);*/
        this.creationTechnique = new CreationTechnique ();
        this.equipeJ1 = new ListeDePerso();
        this.equipeJ2 = new ListeDePerso();
        this.equipeAdv = new ListeDePerso();
        this.persos = this.creationPerso.getPersos();
        this.adv = this.creationEnnemie.getPersos();
    }
    
    public void setAffichage(String texte) {
        this.affichage = texte;
        this.pcsControlleurVue.firePropertyChange("affichage", null, null);
    }
    
    public String getAffichage() {
        return this.affichage;
    }
    
    public ListeDePerso getPersonnages () {
        return this.persos;
    }
    
    public ListeDePerso getEquipeJ1 () {
        return this.equipeJ1;
    }
    
    public ListeDePerso getEquipeAdv () {
        return this.equipeAdv;
    }
    
    public ListeDePerso getAdv () {
        return this.adv;
    }
    
    public void menu () {
        do {
            this.pcsControlleurVue.firePropertyChange("menuPrincipal", null, null);
            switch (choix) {
                case (1):
                    this.combatEnLigne();
                    break;
                case (2):
                    this.combatContrePC();
                    break;
                case (3):
                    this.combatMultiJoueur();
                    break;

            }
        } while (choix != 0);
    }

    private void combatEnLigne() {
        this.setAffichage("Le mode combat en ligne n'est pas disponible pour le moment");
    }

    private void combatContrePC() {
        do {
            this.pcsControlleurVue.firePropertyChange("combatSolo", null, null);
            switch (choix) {
                case (1):
                    /* 1 contre 1 */
                    this.choixPerso(1);
                    break;
                case (2):
                    /* 3 contre 3 */
                    this.choixPerso(3);
                    break;
                case (3):
                    /* 5 contre 5*/
                    this.choixPerso(5);
                    break;
                case (4):
                    /* combat contre boss */
                    this.choixPerso(4);
                    break;

            }
        } while (choix != 0);
    }

    private void combatMultiJoueur() {
        do {
            switch (choix) {
                case (1):
                    /* 1 contre 1 */
                    this.choixPerso(1);
                    this.choixPerso(1);
                    break;
                case (2):
                    /* 3 contre 3 */
                    this.choixPerso(3);
                    this.choixPerso(3);
                    break;
                case (3):
                    /* 5 contre 5*/
                    this.choixPerso(5);
                    this.choixPerso(5);
                    break;

            }
        } while (choix != 0);
    }

    private void choixPerso(int nbPerso) {
        /*if (this.jeu.confirmation("voulez vous charger une partie ?")) {
            Connexion c = new Connexion();
            int partie = c.parties();
            listeDePerso p = this.creationPerso.getPersos();
            listeDePerso listP = new listeDePerso();
            this.persos = c.chargerPersonnages(partie, p, this.creationTechnique.getListeTec(), this.creationObjet.getListeDObjet(), null);
        } else {
            this.persos.ajouterPerso(Personnages.marco_extra);
        }*/
        for (int i=0 ; i<nbPerso ; i++) {
            this.pcsControlleurVue.firePropertyChange("choixPersoJ1", null, null);
            if (this.choix != 0) {
                this.equipeJ1.ajouterPerso(this.persos.getPerso(this.choix - 1));
            }
            this.pcsControlleurVue.firePropertyChange("afficherPersoChoisit", null, null);
        }
        for (int i=0 ; i<nbPerso ; i++) {
            this.pcsControlleurVue.firePropertyChange("choixPersoJ2", null, null);
            this.equipeAdv.ajouterPerso(this.adv.getPerso(this.choix - 1));
            this.pcsControlleurVue.firePropertyChange("afficherPersoChoisit", null, null);
        }
        Combat combat = new Combat(equipeJ1, equipeAdv);
        Vues.createVue(combat);
        combat.combat();
    }
}
