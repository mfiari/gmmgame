/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.texte;

import mfiari.gmm.game.texte.de.TexteVueMenuReseau_de;
import mfiari.gmm.game.texte.en.TexteVueMenuReseau_en;
import mfiari.gmm.game.texte.fr.TexteVueMenuReseau_fr;

/**
 *
 * @author mike
 */
public class TexteVueMenuReseau extends mfiari.lib.game.texte.Texte {
    
    public String retour;
    
    public static TexteVueMenuReseau getInstance() {
        switch (langue) {
            case fr :
                return new TexteVueMenuReseau_fr();
            case en:
                return new TexteVueMenuReseau_en();
            case de:
                return new TexteVueMenuReseau_de();
            default:
                return new TexteVueMenuReseau_fr();
        }
    }
}