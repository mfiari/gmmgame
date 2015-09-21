/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.demarrage;

import mfiari.gmm.game.objet.Objets;
import mfiari.lib.game.liste.ListeObjet;

/**
 *
 * @author mike
 */
public class CreationObjet {

    protected ListeObjet listeDObjet = new ListeObjet ();

    public CreationObjet () {
        this.creerObjet();
        this.creerArme();
        this.listeDObjet.ajoutObjet(Objets.antidote);
        this.listeDObjet.ajoutObjet(Objets.arcEnBois);
        this.listeDObjet.ajoutObjet(Objets.botteEnCuir);
        this.listeDObjet.ajoutObjet(Objets.cape);
        this.listeDObjet.ajoutObjet(Objets.chapeau);
        this.listeDObjet.ajoutObjet(Objets.epeeEnBois);
        this.listeDObjet.ajoutObjet(Objets.epeeEnFer);
        this.listeDObjet.ajoutObjet(Objets.ether);
        this.listeDObjet.ajoutObjet(Objets.hacheEnBois);
        this.listeDObjet.ajoutObjet(Objets.listeDennemi);
        this.listeDObjet.ajoutObjet(Objets.livreDeMagie);
        this.listeDObjet.ajoutObjet(Objets.potion);
        this.listeDObjet.ajoutObjet(Objets.renais);
        this.listeDObjet.ajoutObjet(Objets.vesteEnCuir);
    }

    private void creerObjet () {

    }

    private void creerArme () {

    }

    public ListeObjet getListeDObjet () {
        return this.listeDObjet;
    }

}
