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

public class ville extends Endroit{
    
    private ArrayList<Quartier> quartiers;
    

    public ville (String nom, int positionX, int positionY, int longueur, int largeur) {

        super (nom, positionX, positionY, longueur, largeur);
        this.quartiers = new ArrayList<>();
    }

    public void ajouterQuartier (Quartier q) {
        this.quartiers.add(q);
    }

    public ArrayList<Quartier> getQuartiers () {
        return this.quartiers;
    }

    

    @Override
    public void entrer(ListeDePerso equipe) {
        equipe.setEndroit(this.quartiers.get(0));
        if (this.quartiers.get(0).getObjetEndroit(0).getPosition().getPositionX() == 0) {
            equipe.setPositionX(this.quartiers.get(0).getObjetEndroit(0).getPosition().getPositionX() + 1);
            equipe.setPositionY(this.quartiers.get(0).getObjetEndroit(0).getPosition().getPositionY());
        } else {
            if (this.quartiers.get(0).getObjetEndroit(0).getPosition().getPositionY() == 0) {
                equipe.setPositionX(this.quartiers.get(0).getPositionX());
                equipe.setPositionY(this.quartiers.get(0).getPositionY() + 1);
            } else {
                if (this.quartiers.get(0).getObjetEndroit(0).getPosition().getPositionX()
                        == this.quartiers.get(0).getLongueur()) {
                    equipe.setPositionX(this.quartiers.get(0).getPositionX() - 1);
                    equipe.setPositionY(this.quartiers.get(0).getPositionY());
                } else {
                    equipe.setPositionX(this.quartiers.get(0).getPositionX());
                    equipe.setPositionY(this.quartiers.get(0).getPositionY() - 1);
                }
            }
        }

    }

    public void sortir () {
        /*this.remove(this.ville);
        this.ville.removeAll();
        this.ville.setVisible(false);*/
    }

    public Endroit aEndroit (int i, int j) {
        return null;
    }

    public Gens aGens (int i, int j) {
        return null;
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
