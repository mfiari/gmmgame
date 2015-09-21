package mfiari.gmm.game;


import mfiari.gmm.game.demarrage.Demarrage;
import mfiari.lib.game.swing.Ecran;

/* demo du jeu G.M.M */

class jeu {

    //programme principale du jeu, permet de jouer au jeu
    public static void main(String args[]) {
        Ecran ecran = new Ecran("G.M.M");
        Demarrage d = new Demarrage ();
        Vues.createVue(d);
        d.jeu();
    }

}
