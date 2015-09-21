/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.demarrage;

import mfiari.gmm.game.liste.ListeTec;
import mfiari.gmm.game.technique.Techniques;

/**
 *
 * @author mike
 */
public class CreationTechnique {

    private ListeTec listeDeTec = new ListeTec ();

    public CreationTechnique () {
        this.creeTechnique();
        this.listeDeTec.ajoutTec(Techniques.agilite);
        this.listeDeTec.ajoutTec(Techniques.attaquePuissante);
        this.listeDeTec.ajoutTec(Techniques.coupDEpee);
        this.listeDeTec.ajoutTec(Techniques.coupDeCorne);
        this.listeDeTec.ajoutTec(Techniques.coupDePiedSaute);
        this.listeDeTec.ajoutTec(Techniques.coupDeQueue);
        this.listeDeTec.ajoutTec(Techniques.couteau);
        this.listeDeTec.ajoutTec(Techniques.eau);
        this.listeDeTec.ajoutTec(Techniques.feu);
        this.listeDeTec.ajoutTec(Techniques.fleche);
        this.listeDeTec.ajoutTec(Techniques.foudre);
        this.listeDeTec.ajoutTec(Techniques.griffe);
        this.listeDeTec.ajoutTec(Techniques.jetFlamme);
        this.listeDeTec.ajoutTec(Techniques.lame);
        this.listeDeTec.ajoutTec(Techniques.lance);
        this.listeDeTec.ajoutTec(Techniques.morsure);
        this.listeDeTec.ajoutTec(Techniques.morsurePoison);
        this.listeDeTec.ajoutTec(Techniques.soin);
        this.listeDeTec.ajoutTec(Techniques.ultrason);
        this.listeDeTec.ajoutTec(Techniques.vampirisme);
        this.listeDeTec.ajoutTec(Techniques.voler);
    }

    private void creeTechnique () {

    }

    public ListeTec getListeTec () {
        return this.listeDeTec;
    }

}
