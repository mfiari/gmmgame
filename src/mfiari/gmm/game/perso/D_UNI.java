/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.perso;

/**
 *
 * @author mike
 */
public class D_UNI extends Perso {

    private String capacite;

    public D_UNI (D_UNI d) {
        super(d);
    }
    public D_UNI (String nom, String capacite, int niv, double pv, int pm, int force,
            int def, int magie, int res, int vit, int prec, int agi, int exp, int expNivSup) {

        super(nom, niv, pv, pm, force, def, magie, res, vit, prec, agi, exp, 0,
            0, 0, null);
        this.capacite=capacite;
    }

    public String getCapacite() {
        return this.capacite;
    }
    

}
