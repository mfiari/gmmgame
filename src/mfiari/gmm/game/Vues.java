/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game;

import mfiari.gmm.game.combat.AbstractCombat;
import mfiari.gmm.game.controller.Demarrage;
import mfiari.gmm.game.extra.DuelExtra;
import mfiari.gmm.game.extra.MenuExtra;
import mfiari.gmm.game.menu.Menu;
import mfiari.gmm.game.reseau.MenuReseau;
import mfiari.gmm.game.swing.VueSwing_combat;
import mfiari.gmm.game.swing.VueSwing_demarrage;
import mfiari.gmm.game.swing.VueSwing_duelExtra;
import mfiari.gmm.game.swing.VueSwing_jeu;
import mfiari.gmm.game.swing.VueSwing_menuExtra;
import mfiari.gmm.game.swing.VueSwing_menuReseau;
import mfiari.gmm.game.terminal.VueConsole_duelExtra;
import mfiari.gmm.game.terminal.gmm_vueConsole;
import mfiari.gmm.game.terminal.gmm_vueConsole_combat;
import mfiari.gmm.game.terminal.gmm_vueConsole_menu;

/**
 *
 * @author mike
 */
public class Vues {
    
    public static void createVue (Demarrage d) {
        //EcoleDeMagie_vueConsole_demarrage vueConsole = new EcoleDeMagie_vueConsole_demarrage (d);
        VueSwing_demarrage vueSwing = new VueSwing_demarrage (d);
    }
    
    public static void createVue (GmmJeu jeu) {
        //gmm_vueConsole vueConsole = new gmm_vueConsole (jeu);
        VueSwing_jeu vueSwing = new VueSwing_jeu (jeu);
    }
    
    public static void createVue (MenuExtra menuExtra) {
        //EcoleDeMagie_vueConsole_menuExtra vueConsole = new EcoleDeMagie_vueConsole_menuExtra (menuExtra);
        VueSwing_menuExtra vueSwing = new VueSwing_menuExtra (menuExtra);
    }
    
    public static void createVue (DuelExtra duelExtra) {
        //VueConsole_duelExtra vueConsole = new VueConsole_duelExtra (duelExtra);
        VueSwing_duelExtra vueSwing = new VueSwing_duelExtra (duelExtra);
    }
    
    public static void createVue (AbstractCombat combat) {
        //gmm_vueConsole_combat vueConsole = new gmm_vueConsole_combat (combat);
        VueSwing_combat vueSwing = new VueSwing_combat (combat);
    }
    
    public static void createVue (MenuReseau menuReseau) {
        //EcoleDeMagie_vueConsole_combat vueConsole = new EcoleDeMagie_vueConsole_combat (combat);
        VueSwing_menuReseau vueSwing = new VueSwing_menuReseau (menuReseau);
    }
    
    public static void createVue (Menu menu) {
        gmm_vueConsole_menu vueConsole = new gmm_vueConsole_menu (menu);
        //VueSwing_menuReseau vueSwing = new VueSwing_menuReseau (menuReseau);
    }
    
}
