/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.texte;

import mfiari.gmm.game.texte.de.TexteVueDemarrage_de;
import mfiari.gmm.game.texte.en.TexteVueDemarrage_en;
import mfiari.gmm.game.texte.fr.TexteVueDemarrage_fr;



/**
 *
 * @author mike
 */
public class TexteVueDemarrage extends mfiari.lib.game.texte.Texte {
    
    public String nouvellePartie;
    public String continuer;
    public String extra;
    
    public static TexteVueDemarrage getInstance () {
        switch (langue) {
            case fr:
                return new TexteVueDemarrage_fr();
            case en:
                return new TexteVueDemarrage_en();
            case de:
                return new TexteVueDemarrage_de();
        }
        return null;
    }
}