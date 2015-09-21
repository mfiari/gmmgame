/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.texte.en;

import mfiari.gmm.game.texte.TexteVueCombat;
import mfiari.lib.game.texte.Texte_en;

/**
 *
 * @author mike
 */
public class TexteVueCombat_en extends TexteVueCombat {
    
    public TexteVueCombat_en () {
        this.suivant = Texte_en.suivant;
        this.attaquer = "attack";
        this.attenteAdv = "waiting for the opponent...";
    }
}
