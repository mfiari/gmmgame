/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.texte;

import mfiari.gmm.game.texte.de.TexteVueMenuExtra_de;
import mfiari.gmm.game.texte.en.TexteVueMenuExtra_en;
import mfiari.gmm.game.texte.fr.TexteVueMenuExtra_fr;

/**
 *
 * @author mike
 */
public class TexteVueMenuExtra extends mfiari.lib.game.texte.Texte {
    
    public String duel;
    public String ligne;
    public String configuration;
    public String retour;
    public String choixLangue;
    
    public static TexteVueMenuExtra getInstance() {
        switch (langue) {
            case fr :
                return new TexteVueMenuExtra_fr();
            case en:
                return new TexteVueMenuExtra_en();
            case de:
                return new TexteVueMenuExtra_de();
            default :
                return new TexteVueMenuExtra_fr();
        }
    }
}