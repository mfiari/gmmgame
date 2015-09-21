/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.texte;

import mfiari.gmm.game.texte.en.TexteVueDuelExtra_en;
import mfiari.gmm.game.texte.fr.TexteVueDuelExtra_fr;

/**
 *
 * @author mike
 */
public class TexteVueDuelExtra extends mfiari.lib.game.texte.Texte {
    
    public static TexteVueDuelExtra getInstance() {
        switch (langue) {
            case fr :
                return new TexteVueDuelExtra_fr();
            case en:
                return new TexteVueDuelExtra_en();
            default:
                return new TexteVueDuelExtra_fr();
        }
    }
    
}