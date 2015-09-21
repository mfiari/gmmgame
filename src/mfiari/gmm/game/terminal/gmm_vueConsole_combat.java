/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.terminal;

import mfiari.gmm.game.combat.Combat;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.liste.ListeTec;
import mfiari.gmm.game.perso.Personnage;
import mfiari.gmm.game.texte.TexteVueCombat;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import mfiari.lib.game.console.VueConsole;
import mfiari.lib.game.liste.ListeObjet;

/**
 *
 * @author mike
 */
public class gmm_vueConsole_combat extends VueConsole {

    Combat combat;
    TexteVueCombat textes;
    
    public gmm_vueConsole_combat (Combat combat){
        super(TexteVueCombat.getInstance());
        this.combat = combat;
        this.textes = TexteVueCombat.getInstance();
        this.combat.ajouterEcouteur(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                switch (evt.getPropertyName()) {
                    case "afficherTerrainCombat":
                        afficherTerrainCombat();
                        break;
                    case "affichage":
                        affichage();
                        break;
                    case "afficherMenuJoueur":
                        afficherMenuJoueur();
                        break;
                    case "afficherEnnemies":
                        afficherEnnemies();
                        break;
                    case "afficherEquipe":
                        afficherEquipe();
                        break;
                    case "afficherTechniques":
                        afficherTechniques();
                        break;
                    case "afficherObjetCombat":
                        afficherObjetCombat();
                        break;
                    case "afficherMenuFinDeCombat":
                        afficherMenuFinDeCombat();
                        break;
                }
            }
        });
    }

    public void affichage() {
        System.out.println(this.combat.getAffichage());
        this.suivant();
    }

    public void afficherTerrainCombat() {
        ListeDePerso equipe = this.combat.getEquipe();
        ListeDePerso adversaire = this.combat.getAdversaires();
        for (int i=0 ; i< 7 ; i++) {
            for (int j=0 ; j<14 ; j++) {
                switch (i) {
                    default:
                        System.out.print("***");
                        break;
                    case (1):
                        switch (adversaire.size()) {
                            case (1):
                                if (j!=7) {
                                    System.out.print("***");
                                } else {
                                   System.out.print(adversaire.getEnnemie(0).getNom().substring(0, 3));
                                }
                                break;
                            case (2):
                                if (j!=5 && j!=9) {
                                    System.out.print("***");
                                } else {
                                   System.out.print(adversaire.getEnnemie(0).getNom().substring(0, 3));
                                }
                                break;
                            case (3):
                                if (j!=5 && j!=7 && j!=9) {
                                    System.out.print("***");
                                } else {
                                   System.out.print(adversaire.getEnnemie(0).getNom().substring(0, 3));
                                }
                                break;
                            case (4):
                                if (j!=3 && j!=5 && j!=7 && j!=9) {
                                    System.out.print("***");
                                } else {
                                   System.out.print(adversaire.getEnnemie(0).getNom().substring(0, 3));
                                }
                                break;
                            case (5):
                                if (j!=3 && j!=5 && j!=7 && j!=9 && j!=11) {
                                    System.out.print("***");
                                } else {
                                   System.out.print(adversaire.getEnnemie(0).getNom().substring(0, 3));
                                }
                                break;
                        }
                        break;
                    case (5):
                        switch (equipe.size()) {
                            case (1):
                                if (j!=7) {
                                    System.out.print("***");
                                } else {
                                   System.out.print(equipe.getPersonnage(0).getNom().substring(0, 3));
                                }
                                break;
                            case (2):
                                if (j!=5 && j!=9) {
                                    System.out.print("***");
                                } else {
                                   System.out.print(equipe.getPersonnage(0).getNom().substring(0, 3));
                                }
                                break;
                            case (3):
                                if (j!=5 && j!=7 && j!=9) {
                                    System.out.print("***");
                                } else {
                                   System.out.print(equipe.getPersonnage(0).getNom().substring(0, 3));
                                }
                                break;
                            case (4):
                                if (j!=3 && j!=5 && j!=7 && j!=9) {
                                    System.out.print("***");
                                } else {
                                   System.out.print(equipe.getPersonnage(0).getNom().substring(0, 3));
                                }
                                break;
                            case (5):
                                if (j!=3 && j!=5 && j!=7 && j!=9 && j!=11) {
                                    System.out.print("***");
                                } else {
                                   System.out.print(equipe.getPersonnage(0).getNom().substring(0, 3));
                                }
                                break;
                        }
                        break;
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public void afficherMenuJoueur() {
        Personnage perso = this.combat.getPersoEnCours();
        /*System.out.println(this.textes.pv+":" + Math.round(perso.getPv()) + "/" + Math.round(perso.getPvi()) + "\t" + 
                this.textes.pm+":" + perso.getPm() + "/" + perso.getPmi());*/
        System.out.println(this.textes.pv+":" + Math.round(perso.getPv()) + "\t" + 
                this.textes.pm+":" + perso.getPm());
        System.out.println("1."+this.textes.attaquer+"	   2." + perso.getCapacite());
        System.out.println("3."+this.textes.examiner+"     4."+this.textes.objet);
        System.out.println("5."+this.textes.seProteger+"   6."+this.textes.perso);
        this.combat.setChoix(this.testEntier());
    }

    public void afficherEnnemies() {
        ListeDePerso adversaire = this.combat.getAdversaires();
        for (int i = 0; i < adversaire.size(); i++) {
            System.out.println((i + 1) + "." + adversaire.getEnnemie(i).getNom());
        }
        System.out.println("6."+this.textes.retour);
        System.out.println(this.textes.quiAttaquer);
        this.combat.setChoix(this.testEntier());
    }

    public int afficherEquipe() {
        ListeDePerso equipe = this.combat.getEquipe();
        String affichage = this.combat.getAffichage();
        for (int i = 0; i < equipe.size(); i++) {
            System.out.println((i + 1) + "." + equipe.getPersonnage(i).getNom());
        }
        System.out.println("0."+this.textes.retour);
        System.out.println(affichage);
        return this.testEntier();
    }

    public int afficherTechniques() {
        ListeTec techniques = this.combat.getPersoEnCours().getAtt();
        for (int j = 0; j < techniques.size(); j++) {
            System.out.println((j + 1) + "." + techniques.getTechnique(j).getNom());
        }
        System.out.println("0."+this.textes.retour);
        System.out.println(this.textes.quelTecUtilise);
        return this.testEntier();
    }

    public int afficherObjetCombat() {
        ListeObjet sac = null;
        for (int i = 0; i < sac.size(); i++) {
            System.out.println(sac.getObjet(i).getNom() + " " + sac.getObjet(i).getQuantite());
        }
        System.out.println();
        System.out.println("0."+this.textes.quitter);
        System.out.println(this.textes.queFaire);
        return this.testEntier();
    }

    public void afficherMenuFinDeCombat() {
        ListeDePerso equipe = null;
        int argentGagne = 0;
        int expGagne = 0;
        System.out.println(this.textes.expRecu+": " + expGagne + this.textes.argentRecu + ": " + argentGagne + this.textes.pieceOr + ": " +
                equipe.getArgent());
        for (int i = 0; i < equipe.size(); i++) {
            System.out.println(equipe.getPersonnage(i).getNom() + "\t"+this.textes.niv+":" + equipe.getPersonnage(i).getNiveau());
            System.out.println(this.textes.pv+": " + equipe.getPersonnage(i).getPv() + "/" + equipe.getPersonnage(i).getPvi());
            System.out.println(this.textes.pm+": " + equipe.getPersonnage(i).getPm() + "/" + equipe.getPersonnage(i).getPmi());
        }

    }
}
