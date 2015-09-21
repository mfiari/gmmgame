/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.extra;

import mfiari.gmm.game.Vues;
import mfiari.gmm.game.reseau.MenuReseau;
import mfiari.lib.game.controlleur.ControlleurVue;
import mfiari.lib.game.texte.Langue;
import mfiari.lib.game.texte.Texte;

/**
 *
 * @author mike
 */
public class MenuExtra extends ControlleurVue {
    

    public MenuExtra() {
        
    }
    
    public void menu () {
        do {
            this.pcsControlleurVue.firePropertyChange("afficherMenu", null, null);
            switch (choix) {
                case (1):
                    this.scene();
                    break;
                case (2):
                    this.duel();
                    break;
                case (3):
                    this.enLigne();
                    break;
                case (4):
                    this.musiqueEtVideo();
                    break;
                case (5):
                    this.configuration();
                    break;

            }
        } while (choix != 0);
    }

    private void scene() {
    }

    private void duel() {
        DuelExtra duel = new DuelExtra();
        Vues.createVue(duel);
        duel.menu();
    }

    private void enLigne() {
        MenuReseau menu = new MenuReseau();
        Vues.createVue(menu);
        menu.menu();
    }

    private void musiqueEtVideo() {
    }

    private void configuration() {
        do {
            this.pcsControlleurVue.firePropertyChange("configuration", null, null);
            switch (this.choix) {
                case 1:
                    do {
                        this.pcsControlleurVue.firePropertyChange("choixLangue", null, null);
                    } while (this.choix != 1 && this.choix != 2);
                    Texte.langue = Langue.values()[this.choix-1];
                    this.pcsControlleurVue.firePropertyChange("actualiseLangue", null, null);
                    break;
            }
        } while (this.choix != 0);
        this.choix = -1;
    }
}
