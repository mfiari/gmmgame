/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.objet;

import mfiari.gmm.game.perso.Personnage;
import mfiari.gmm.game.ville.Endroit;
import mfiari.lib.game.objet.ObjetEndroit;

/**
 *
 * @author mike
 */
public class Objet_endroit_passage extends ObjetEndroit {

    private Endroit endroit_dArrive;
    private int positionX_endroit;
    private int positionY_endroit;

    public Objet_endroit_passage (TypeObjet nom, int positionX, int positionY, Endroit e, int positionX_endroit,
            int positionY_endroit) {
        super(nom, positionX, positionY);
        this.endroit_dArrive = e;
        this.positionX_endroit = positionX_endroit;
        this.positionY_endroit = positionY_endroit;
    }

    public void prendre (Personnage p) {
        p.getPosition().setEndroit(this.endroit_dArrive);
        p.getPosition().setPositionX(this.positionX_endroit);
        p.getPosition().setPositionY(this.positionY_endroit);
    }

    public Endroit getEndroitDarive () {
        return this.endroit_dArrive;
    }
}
