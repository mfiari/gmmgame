/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.terminal;

import mfiari.gmm.game.extra.DuelExtra;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.texte.TexteVueDuelExtra;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import mfiari.lib.game.console.VueConsole;

/**
 *
 * @author mike
 */
public class VueConsole_duelExtra extends VueConsole {
    
    private DuelExtra duel;
    private TexteVueDuelExtra textes;
    
    public VueConsole_duelExtra (){
    }
    
    public VueConsole_duelExtra (DuelExtra duel){
        this.duel = duel;
        this.textes = TexteVueDuelExtra.getInstance();
        this.duel.ajouterEcouteur(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                switch (evt.getPropertyName()) {
                    case "affichage":
                        setAffichage();
                        break;
                    case "menuPrincipal":
                        menuPrincipal();
                        break;
                    case "combatSolo":
                        combatSolo();
                        break;
                    case "unContreUn":
                        unContreUn();
                        break;
                    case "choixPersoJ1":
                        choixPersoJ1();
                        break;
                    case "choixPersoJ2":
                        choixPersoJ2();
                        break;
                    case "J1VSJ2":
                        J1VSJ2();
                        break;
                    case "OrdiVsOrdi":
                        OrdiVsOrdi();
                        break;
                    case "tournoi":
                        tournoi();
                        break;
                    case "mission":
                        mission();
                        break;
                }
            }
        });
    }
    
    private void setAffichage() {
        System.out.println(this.duel.getAffichage());
        this.suivant();
    }
    
    private void menuPrincipal() {
        System.out.println("1.combat en ligne   2.combat contre pc  3.multijoueur  0.retour");
        this.duel.setChoix(this.testEntier());
    }
    
    private void combatSolo() {
        System.out.println("1. 1 VS 1   2. 3 VS 3   3. 5 VS 5   4.Boss  0.retour");
        this.duel.setChoix(this.testEntier());
    }
    
    private void unContreUn() {
        System.out.println("1.J1 VS ORDI   2.J1 VS J2  3.ORDI VS ORDI  0.retour");
        this.duel.setChoix(this.testEntier());
    }
    
    private void choixPersoJ1() {
        ListeDePerso personnages = this.duel.getPersonnages();
        for (int i = 0 ; i < personnages.size() ; i++) {
            System.out.print(i+1+"."+personnages.getPerso(i).getNom());
            if (i%3 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("100.aleatoire  0.retour");
        this.duel.setChoix(this.testEntier());
    }
    
    private void choixPersoJ2() {
        ListeDePerso personnages = this.duel.getAdv();
        for (int i = 0 ; i < personnages.size() ; i++) {
            System.out.print(i+1+"."+personnages.getPerso(i).getNom());
            if (i%3 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("100.aleatoire  0.retour");
        this.duel.setChoix(this.testEntier());
    }
    
    private void J1VSJ2() {
        System.out.println("Le mode combat en ligne n'est pas disponible pour le moment");
        this.suivant();
    }
    
    private void OrdiVsOrdi() {
        System.out.println("Le mode combat en ligne n'est pas disponible pour le moment");
        this.suivant();
    }
    
    private void tournoi() {
        System.out.println("Le mode combat en ligne n'est pas disponible pour le moment");
        this.suivant();
    }
    
    private void mission() {
        System.out.println("Le mode combat en ligne n'est pas disponible pour le moment");
        this.suivant();
    }
}