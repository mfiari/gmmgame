/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.ville;

import mfiari.gmm.game.liste.ListeDePerso;
import java.util.ArrayList;
import mfiari.lib.game.liste.ListeDeGens;
import mfiari.lib.game.personnage.Gens;
import mfiari.lib.game.personnage.Personnage;
import mfiari.lib.game.position.Orientation;
import mfiari.lib.game.position.Position;
/**
 *
 * @author mike
 */
public class SousZone extends Endroit {
    
    private ArrayList<ville> villes;

    public SousZone (String nom, int positionX, int positionY, int longueur, int largeur) {

        super(nom, positionX, positionY, longueur, largeur);
        this.villes = new ArrayList<>();
    }

    public void ajouterVille (ville v) {
        this.villes.add(v);
    }

    public ArrayList<ville> getVilles () {
        return this.villes;
    }

    public Endroit aEndroit (int i, int j) {
        for (int k=0 ; k<this.villes.size(); k++) {
            if (this.villes.get(k).getPositionX()==i && this.villes.get(k).getPositionY()==j) {
                return this.villes.get(k);
            }
        }
        return null;
    }

    public Gens aGens (int i, int j) {
        return null;
    }

    public void entrer (ListeDePerso equipe) {

    }

    @Override
    public mfiari.lib.game.ville.Endroit aEndroit(Position p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Gens aGens(Position p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personnage aPersonnage(int i, int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personnage aPersonnage(int i, int j, Orientation orientation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void entrer(Personnage equipe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListeDeGens getGens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
