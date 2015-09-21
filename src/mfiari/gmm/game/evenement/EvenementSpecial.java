/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.evenement;

import mfiari.gmm.game.GmmJeu;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.objet.Objet;
import mfiari.gmm.game.perso.Personnage;
import mfiari.gmm.game.ville.Endroit;
import mfiari.lib.game.evenements.Evenement;
import mfiari.lib.game.jeu.Jeu;
import mfiari.lib.game.liste.ListeObjet;
import mfiari.lib.game.personnage.Gens;

/**
 *
 * @author mike
 */
public class EvenementSpecial extends Evenement {

    private ListeObjet objets;
    private ListeDePerso persosAajouter;
    private ListeDePerso persosAenlever;
    private boolean soin;

    public EvenementSpecial () {
        this.objets = new ListeObjet ();
        this.persosAajouter = new ListeDePerso ();
        this.persosAenlever = new ListeDePerso ();
        this.soin = false;
    }

    public EvenementSpecial (Endroit endroitDeLevenement, Gens personneAquiParler, Objet objet, String titre) {
        super(endroitDeLevenement, personneAquiParler, objet, titre);
        this.objets = new ListeObjet ();
        this.persosAajouter = new ListeDePerso ();
        this.persosAenlever = new ListeDePerso ();
        this.soin = false;
    }

    public void ajouterPersoAajouter (Personnage p) {
        this.persosAajouter.ajouterPerso(p);
    }

    public void ajouterPersoAenlever (Personnage p) {
        this.persosAenlever.ajouterPerso(p);
    }

    public void ajouterObjet (Objet o) {
        this.objets.ajoutObjet(o);
    }

    public void soignerEquipe () {
        this.soin = true;
    }

    public void activeEvenement (GmmJeu jeu) {
        for (int i=0 ; i< this.objets.size() ; i++) {
            jeu.getEquipe().getSac().acheter(this.objets.getObjet(i), 1
                    /*this.objets.getObjet(i).getQuantite()*/);
            jeu.setAffichage("vous recevez " + this.objets.getObjet(i).getQuantite() + " " +
                    this.objets.getObjet(i).getNom());
        }
        if (this.soin) {
            jeu.getEquipe().soin();
            jeu.setAffichage("vos PV et vos PM ont été restaurer.");
        }
        for (int i=0 ; i< this.persosAajouter.size() ; i++) {
            jeu.getEquipe().ajouterPerso(this.persosAajouter.getPersonnage(i));
            jeu.setAffichage(this.persosAajouter.getPersonnage(i).getNom() + " a rejoin le groupe");
        }
        for (int i=0 ; i<this.persosAenlever.size() ; i++) {
            jeu.getEquipe().ajouterPerso(jeu.getEquipe().getPersonnage(this.persosAenlever.getPersonnage(i).getNom()));
            jeu.setAffichage(this.persosAenlever.getPersonnage(i).getNom() + " a quitter le groupe");
        }

    }

    @Override
    public void activeEvenement(Jeu jeu) {
        this.activeEvenement((GmmJeu)jeu);
    }



}
