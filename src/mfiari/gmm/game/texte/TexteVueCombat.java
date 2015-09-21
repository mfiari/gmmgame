/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.texte;

import mfiari.gmm.game.texte.en.TexteVueCombat_en;
import mfiari.gmm.game.texte.fr.TexteVueCombat_fr;

/**
 *
 * @author mike
 */
public class TexteVueCombat extends mfiari.lib.game.texte.Texte {
    
    public String impossible;
    public String pv;
    public String pm;
    public String pasObjet;
    public String vide;
    public String etatAffecte;
    public String pasTechnique;
    public String surQuiUtiliser;
    public String volRate;
    public String rienAvoler;
   
    public String attaquer;
    public String examiner;
    public String objet;
    public String seProteger;
    public String perso;
    public String retour;
    public String quiAttaquer;
    public String quelTecUtilise;
    public String expRecu;
    public String argentRecu;
    public String pieceOr;
    public String niv;
    
    public String quitter;
    public String queFaire;
    public String attenteAdv;
    
    public static TexteVueCombat getInstance() {
        switch (langue) {
            case fr :
                return new TexteVueCombat_fr();
            case en:
                return new TexteVueCombat_en();
            default:
                return new TexteVueCombat_fr();
        }
    }
    
}
