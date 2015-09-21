/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.ville;

import mfiari.gmm.game.liste.ListeDEnnemi;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.perso.Ennemie;
import mfiari.gmm.game.perso.Personnage;
import mfiari.lib.game.interfaces.ISol;
import mfiari.lib.game.interfaces.ville.ISalle;
import mfiari.lib.game.personnage.Gens;
import mfiari.lib.game.personnage.Habitant;

/**
 *
 * @author mike
 */
public class Salle extends Batiments implements ISalle {

    private ListeDePerso personnages;
    private ListeDEnnemi ennemies;
    private Sol sol;

    public Salle () {   
    }

    public Salle (String nom, int positionX, int positionY,int longueur, int largeur) {
        super(nom, positionX, positionY, longueur, largeur, 0, 0);
        this.personnages = new ListeDePerso ();
        this.ennemies = new ListeDEnnemi ();
    }

    @Override
    public void ajouterPersonnage (Personnage p) {
        this.personnages.ajouterPerso(p);
    }

    @Override
    public void ajouterEnnemie (Ennemie e) {
        this.ennemies.ajoutEnnemi(e);
    }

    @Override
    public void ajouterHabitant (Habitant h) {
        this.personnages.ajouterHabitant(h);
    }

    @Override
    public void enleverHabitant (Habitant h) {
        this.personnages.enleverHabitant(h);
    }
    
    @Override
    public void setSol (ISol sol) {
        this.sol = (Sol)sol;
    }
    
    @Override
    public Sol getSol () {
        return this.sol;
    }

    @Override
    public Gens aGens (int i, int j) {
        if (this.personnages.aHabitant(i, j)!=null) {
            return this.personnages.aHabitant(i, j);
        }
        if (this.personnages.aPerso(i, j)!=null) {
            return this.personnages.aPerso(i, j);
        }
        /*if (this.ennemies.aEnnemie(i, j)!=null) {
            return true;
        }*/
        return null;
    }

}
