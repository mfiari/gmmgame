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
import mfiari.lib.game.interfaces.ville.IQuartier;
import mfiari.lib.game.liste.ListeDEndroit;
import mfiari.lib.game.liste.ListeDeBatiment;
import mfiari.lib.game.liste.ListeDeGens;
import mfiari.lib.game.personnage.Gens;
import mfiari.lib.game.personnage.Habitant;
import mfiari.lib.game.position.Orientation;
import mfiari.lib.game.position.Position;

/**
 *
 * @author mike
 */
public class Quartier extends Endroit implements IQuartier {
    
    //private ListeDeBatiment batiments;
    private ListeDEndroit<Batiments> batiments;
    private ListeDePerso personnages;
    private ListeDEnnemi ennemies;
    private ISol sol;

    public Quartier () {
    }

    public Quartier (String nom, int positionX, int positionY,int longueur, int largeur) {
        super(nom, positionX, positionY, longueur, largeur);
        this.batiments = new ListeDEndroit<>();
        this.personnages = new ListeDePerso ();
        this.ennemies = new ListeDEnnemi ();
        this.sol = Sol.terre;
    }

    @Override
    public void ajouterPersonnage (Personnage p) {
        this.personnages.ajouterPerso(p);
    }

    @Override
    public void enleverPersonnage (Personnage p) {
        this.personnages.enleverPerso(p);
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
    public void ajouterBatiment (Batiments b) {
        this.batiments.ajouterEndroit(b);
    }

    /*public ListeDeBatiment getBatiments() {
        return this.batiments;
    }*/

    @Override
    public Endroit aEndroit (int i, int j) {
        for (int k = 0 ; k < this.batiments.size() ; k++) {
            if (this.batiments.getEndroit(k).getPositionX() == i && this.batiments.getEndroit(k).getPositionY() == j) {
                return this.batiments.getEndroit(k);
            }
        }
        return null;
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

    @Override
    public void entrer (ListeDePerso equipe) {
        
    }

    @Override
    public mfiari.lib.game.ville.Endroit aEndroit(Position p) {
        for (int k = 0 ; k < this.batiments.size() ; k++) {
            if (this.batiments.getEndroit(k).getPosition().equalsXY(p)) {
                return this.batiments.getEndroit(k);
            }
        }
        return null;
    }

    @Override
    public Gens aGens(Position p) {
        return null;
    }

    @Override
    public mfiari.lib.game.personnage.Personnage aPersonnage(int i, int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public mfiari.lib.game.personnage.Personnage aPersonnage(int i, int j, Orientation orientation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void entrer(mfiari.lib.game.personnage.Personnage equipe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListeDeBatiment getBatiments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSol(ISol sol) {
        this.sol = sol;
    }

    @Override
    public Sol getSol() {
        return (Sol)this.sol;
    }

    @Override
    public ListeDeGens getGens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
