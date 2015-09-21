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
public class Zone extends Endroit {
    
    private ArrayList<SousZone> sousZones;

    public Zone (String nom, int positionX, int positionY, int longueur, int largeur) {

        super(nom, positionX, positionY, longueur, largeur);
        this.sousZones = new ArrayList<SousZone>();
    }

    public void ajouterSousZone (SousZone v) {
        this.sousZones.add(v);
    }

    public ArrayList<SousZone> getSousZones () {
        return this.sousZones;
    }

    public Endroit aEndroit (int i, int j) {
        for (int k=0 ; k<this.sousZones.size(); k++) {
            if (this.sousZones.get(k).getPositionX()==i && this.sousZones.get(k).getPositionY()==j) {
                return this.sousZones.get(k);
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
