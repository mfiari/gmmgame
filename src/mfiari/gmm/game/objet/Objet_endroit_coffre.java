/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.objet;

/**
 *
 * @author mike
 */
public class Objet_endroit_coffre extends Objet_endroit_observable{

    private Objet objet;

    public Objet_endroit_coffre (TypeObjet nom, int positionX, int positionY, String description, Objet obj) {
        super(nom, positionX, positionY, description);
        this.objet = obj;
    }

    public Objet ouvrir () {
        return this.objet;
    }
}
