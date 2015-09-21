/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.texte.de;

import mfiari.gmm.game.texte.TexteVueDemarrage;
import mfiari.lib.game.texte.Texte_de;

/**
 *
 * @author mike
 */
public class TexteVueDemarrage_de extends TexteVueDemarrage  {
    
    public TexteVueDemarrage_de () {
        this.suivant = Texte_de.suivant;
        this.nouvellePartie = Texte_de.nouvellePartie;
        this.continuer = Texte_de.continuer;
        this.extra = Texte_de.extra;
    }
}