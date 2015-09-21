/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.ville;

import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.perso.Ennemie;
import mfiari.gmm.game.perso.Personnage;
import mfiari.lib.game.objet.ObjetEndroit;
import mfiari.lib.game.personnage.Gens;
import mfiari.lib.game.personnage.Habitant;
import mfiari.lib.game.position.Position;

/**
 *
 * @author mike
 */
abstract public class Endroit extends mfiari.lib.game.ville.Endroit {
    
    private String nom;
    private int positionX;
    private int positionY;
    private int longueur;
    private int largeur;
    
    public Endroit () {
        
    }

    public Endroit (String nom, int positionX, int positionY,int longueur, int largeur) {
        super(nom, positionX, positionY, longueur, largeur);
        this.nom = nom;
        this.positionX=positionX;
        this.positionY=positionY;
        this.largeur=largeur;
        this.longueur=longueur;
    }

    @Override
    public String getNom () {
        return this.nom;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public int getLongueur () {
        return this.longueur;
    }

    @Override
    public int getLargeur () {
        return this.largeur;
    }

    public abstract Endroit aEndroit (int i, int j);

    public abstract Gens aGens (int i, int j);

    public void ajouterPersonnage (Personnage p) {
    }

    public void enleverPersonnage (Personnage p) {
    }

    public void ajouterEnnemie (Ennemie e) {
    }

    public void ajouterHabitant (Habitant h) {
    }

    public void enleverHabitant (Habitant h) {
    }

    public void ajouterBatiment (Batiments b) {
    }

    public ObjetEndroit aObjetEndroit (int i, int j) {
        return super.aObjetEndroit(new Position(i, j));
    }

    public abstract void entrer (ListeDePerso equipe);

}
