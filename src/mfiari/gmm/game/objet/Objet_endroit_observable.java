/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.objet;

import mfiari.lib.game.objet.ObjetEndroit;

/**
 *
 * @author mike
 */
public class Objet_endroit_observable extends ObjetEndroit {

    private String description;

    public Objet_endroit_observable (TypeObjet nom, int positionX, int positionY, String description) {
        super(nom, positionX, positionY);
        this.description = description;
    }

    public String observer () {
        return this.description;
    }
}
