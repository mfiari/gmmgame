/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.evenement;

import mfiari.gmm.game.combat.Combat;
import mfiari.gmm.game.GmmJeu;
import mfiari.gmm.game.Vues;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.objet.Objet;
import mfiari.gmm.game.perso.Ennemie;
import mfiari.gmm.game.ville.Endroit;
import java.util.ArrayList;
import mfiari.lib.game.condition.Condition;
import mfiari.lib.game.evenements.Evenement;
import mfiari.lib.game.evenements.EvenementDialogue;
import mfiari.lib.game.jeu.Jeu;
import mfiari.lib.game.personnage.Gens;


/**
 *
 * @author mike
 */
public class EvenementCombat extends Evenement {

    private ArrayList<EvenementDialogue> evenDialogue;
    private ArrayList<Condition> conditions;
    private ArrayList<EvenementDialogue> warning;
    private ListeDePerso adversaire;
    private int pointeur;

    public EvenementCombat () {
        this.evenDialogue = new ArrayList<> ();
        this.conditions = new ArrayList<> ();
        this.warning = new ArrayList<> ();
        this.adversaire = new ListeDePerso ();
        this.pointeur=0;
    }

    public EvenementCombat (Endroit endroitDeLevenement, Gens personneAquiParler, Objet objet, String titre) {
        super(endroitDeLevenement, personneAquiParler, objet, titre);
        this.evenDialogue = new ArrayList<> ();
        this.conditions = new ArrayList<> ();
        this.warning = new ArrayList<> ();
        this.adversaire = new ListeDePerso ();
        this.pointeur=0;
    }

    public ListeDePerso getAdversaire () {
        return this.adversaire;
    }

    public void ajouterAdversaire (Ennemie e) {
        this.adversaire.ajouterPerso(e);
    }

    public void ajouterEvenementDialogue (EvenementDialogue e, Condition c, EvenementDialogue w) {
        this.evenDialogue.add(e);
        this.warning.add(w);
        this.conditions.add(c);
    }

    public Condition getCondition () {
        return this.conditions.get(this.pointeur);
    }

    public EvenementDialogue getDialogue () {
        return this.evenDialogue.get(this.pointeur);
    }

    public EvenementDialogue getWarning () {
        return this.warning.get(this.pointeur);
    }

    public void conditionReussi () {
        this.pointeur++;
    }

    @Override
    public boolean estFini () {
        return this.pointeur == this.conditions.size();
    }

    public void activeEvenement(GmmJeu jeu) {
        Combat c = new Combat (jeu.getEquipe(), this.getAdversaire(), jeu, true);
        Vues.createVue(c);
        c.combat2(this);
    }

    @Override
    public void activeEvenement(Jeu jeu) {
        this.activeEvenement((GmmJeu)jeu);
    }


}
