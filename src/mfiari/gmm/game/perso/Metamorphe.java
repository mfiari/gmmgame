/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.perso;

import mfiari.gmm.game.liste.ListeTec;
import mfiari.gmm.game.objet.TypeObjet;

/**
 *
 * @author mike
 */
public class Metamorphe extends Personnage{

    private ListeTec attMetamorphe;
    private ListeTec tecMetamorphe;

    public Metamorphe (String nom, String capacite, String classe, int niv, double pv, int pm, int force,
            int def, int magie, int res, int vit, int prec, int agi, int exp, int expNivSup,
            TypeObjet main, TypeObjet corps, TypeObjet tete, TypeObjet pied, TypeObjet acc1, TypeObjet acc2) {
        super(nom, capacite, classe, niv, pv, pm, force, def, magie, res, vit, prec, agi, exp, expNivSup,
            main, corps, tete, pied, acc1, acc2);
        
        this.attMetamorphe = new ListeTec ();
        this.tecMetamorphe = new ListeTec ();
    }

    public ListeTec getAttMetamorph () {
        return this.attMetamorphe;
    }

    public ListeTec getTecMetamorph () {
        return this.tecMetamorphe;
    }
}
