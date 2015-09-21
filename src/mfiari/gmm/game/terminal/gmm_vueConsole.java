/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.terminal;

import mfiari.gmm.game.GmmJeu;
import mfiari.gmm.game.ville.Endroit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mike
 */
public class gmm_vueConsole {

    private GmmJeu jeu;
    Scanner sc = new Scanner(System.in);
    private int choix;

    public gmm_vueConsole(GmmJeu jeu) {

        this.jeu = jeu;
        this.jeu.ajouterEcouteur(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("choixLangue")) {
                    choixLangue();
                }
                if (evt.getPropertyName().equals("continuer")) {
                    continuer();
                }
                if (evt.getPropertyName().equals("gagnerCombat")) {
                    gagnerCombat();
                }
                if (evt.getPropertyName().equals("perdu")) {
                    Perdu();
                }
                if (evt.getPropertyName().equals("parole")) {
                    parole();
                }
                if (evt.getPropertyName().equals("affichage")) {
                    affichage();
                }
                if (evt.getPropertyName().equals("confirmation")) {
                    confirmation();
                }
                if (evt.getPropertyName().equals("choix")) {
                    choix();
                }
                if (evt.getPropertyName().equals("suivant")) {
                    suivant();
                }
                if (evt.getPropertyName().equals("debutJeu")) {
                    debutJeu();
                }
                if (evt.getPropertyName().equals("changerNom")) {
                    changerNom();
                }
                if (evt.getPropertyName().equals("voirParties")) {
                    try {
                        voirParties();
                    } catch (SQLException ex) {
                        Logger.getLogger(gmm_vueConsole.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (evt.getPropertyName().equals("actionJeu")) {
                    actionJeu();
                }
                if (evt.getPropertyName().equals("afficheEndroit")) {
                    afficheEndroit();
                }
                if (evt.getPropertyName().equals("afficherObjetMagasin")) {
                    afficherObjetMagasin();
                }
            }
        });
    }

    public void choixLangue() {
        this.choix = 0;
        while (this.choix < 1 || this.choix > 2) {
            System.out.println("choisissez une langue");
            System.out.println("1.français     2.english");
            this.choix = sc.nextInt();
        }
        this.jeu.setChoix(this.choix);
    }

    public void suivant() {
        int a;
        System.out.println("1="+this.jeu.getTextes().suivant);
        a = sc.nextInt();
        while (a != 1) {
            System.out.println("1="+this.jeu.getTextes().suivant);
            a = sc.nextInt();
        }
    }

    public void debutJeu() {
        this.choix = 0;
        while (this.choix < 1 || this.choix > 3) {
            System.out.println("1."+this.jeu.getTextes().nouvellePartie+"    2."+this.jeu.getTextes().continuer+"     3."+this.jeu.getTextes().extra);
            this.choix = sc.nextInt();
        }
        this.jeu.setChoix(this.choix);
    }

    public void continuer() {
        /*
        on affiche la ville, le batiment... dans laquelle se trouve le personnage
         */
    }

    public void actionJeu() {
        System.out.println("1."+this.jeu.getTextes().haut+"      2."+this.jeu.getTextes().bas+"      3."+this.jeu.getTextes().droite);
        System.out.println("4."+this.jeu.getTextes().gauche+"    5."+this.jeu.getTextes().action+"   6."+this.jeu.getTextes().menu);
        System.out.println(this.jeu.getTextes().queFaire);
        this.choix = sc.nextInt();
        this.jeu.setChoixAction(this.choix);
    }

    public void Perdu() {
        /*
         * message lorsque l'on a perdu la partie (game over)
         */
        System.out.println("GAME OVER");
        this.suivant();
    }

    public void gagnerCombat() {
        /*
         * message lorsque l'on gagne un combat
         */
    }

    public void parole() {
        /*
         * affichage lorsque qu'un personnage parle
         */
        System.out.println(this.jeu.getParole());
        this.suivant();
    }

    public void affichage() {
        /*
         * pour faire des affichages divers
         */
        System.out.println(this.jeu.getAffichage());
        this.suivant();
    }

    public void confirmation () {
        System.out.println(this.jeu.getAffichage());
        System.out.println("1."+this.jeu.getTextes().oui+"     2."+this.jeu.getTextes().non);
        this.choix = this.sc.nextInt();
        if (this.choix == 1) {
            this.jeu.setConfirmation(true);
        } else {
            this.jeu.setConfirmation(false);
        }
    }

    public void choix () {
        System.out.println(this.jeu.getAffichage());
        this.choix = this.sc.nextInt();

    }

    public void afficheEndroit() {
        Endroit e = (Endroit)this.jeu.getEndroit();
        System.out.print(e.getNom());
        for (int i = 0; i < e.getLargeur(); i++) {
            System.out.println();
            for (int j = 0; j < e.getLongueur(); j++) {
                if (this.jeu.getEquipe().getPersonnage(0).getPosition().getPositionX() == i
                        && this.jeu.getEquipe().getPersonnage(0).getPosition().getPositionY() == j) {
                    System.out.print(this.jeu.getEquipe().getPersonnage(0).getNom().substring(0, 3));
                } else {
                    if (e.aEndroit(i, j) != null) {
                        if (e.aEndroit(i, j).getNom().length() >3) {
                            System.out.print(e.aEndroit(i, j).getNom().substring(0, 3));
                        } else {
                            System.out.print(e.aEndroit(i, j).getNom());
                        }
                    } else {
                        if (e.aGens(i, j) != null) {
                            if (e.aGens(i, j).getNom().length() >3) {
                                System.out.print(e.aGens(i, j).getNom().substring(0, 3));
                            } else {
                                System.out.print(e.aGens(i, j).getNom());
                            }
                        } else {
                            if (e.aObjetEndroit(i, j) != null) {
                                if (e.aObjetEndroit(i, j).getNom().length() >3) {
                                    System.out.print(e.aObjetEndroit(i, j).getNom().substring(0, 3));
                                } else {
                                    System.out.print(e.aObjetEndroit(i, j).getNom());
                                }
                            } else {
                                System.out.print("+++");
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public void changerNom() {
        int a;
        do {
            System.out.println(this.jeu.getTextes().quelEstVotreNom);
            System.out.println("1."+this.jeu.getTextes().entrerUnNom+"       2." + this.jeu.getAffichage());
            a = sc.nextInt();
        } while (a != 1 && a != 2);
        if (a == 1) {
            System.out.println(this.jeu.getTextes().quelEstVotreNom);
            this.jeu.setAffichage(sc.next());
        }
    }

    public void voirParties() throws SQLException {
        ArrayList<String> parties = new ArrayList<>();
        this.choix = 0;
        while (this.jeu.getResult().next()) {
            parties.add(this.jeu.getResult().getString("partie"));
            System.out.print(this.jeu.getTextes().sauvegarde+ " " + parties.size());
            if (this.jeu.getResult().getString("nom") != null && !this.jeu.getResult().getString("nom").isEmpty()) {
                System.out.print("\t" + this.jeu.getResult().getString("nom") + "\n");
                System.out.print(this.jeu.getTextes().tempsjeu + " : " + this.jeu.getResult().getString("tempsjeu_heure") + ":"
                        + this.jeu.getResult().getString("tempsjeu_minute") + "\n");
            } else {
                System.out.print("\t" + this.jeu.getTextes().vide);
            }
            System.out.println("\n---------------------------------");

        }
        while (this.choix < 1 || this.choix > parties.size()) {
            System.out.println(this.jeu.getTextes().surQuelPartieSauvegarder);
            for (int j = 0; j < parties.size(); j++) {
                System.out.println(j + 1 + ":" + parties.get(j));

            }
            this.choix = this.sc.nextInt();
        }
        this.jeu.setChoix(this.choix);
        //this.jeu.setAffichage(parties.get(choix - 1));
    }

    public void afficherObjetMagasin() {
        System.out.println(this.jeu.getAffichage());
        /*for (int i =0 ; i<this.jeu.getSac().size() ; i++) {
            System.out.println((i) + "." + this.jeu.getSac().getObjet(i).getNom());
        }*/
        System.out.println("0."+ this.jeu.getTextes().quitter);
        this.choix = sc.nextInt();
        this.jeu.setChoix(this.choix);
    }
}
