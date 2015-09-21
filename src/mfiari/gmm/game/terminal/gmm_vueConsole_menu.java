/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.terminal;

import mfiari.gmm.game.GmmJeu;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.liste.ListeTec;
import mfiari.gmm.game.menu.Menu;
import mfiari.gmm.game.perso.Personnage;
import mfiari.gmm.game.texte.Texte;
import mfiari.gmm.game.texte.TexteVueCombat;
import mfiari.gmm.game.texte.Texte_fr;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import mfiari.lib.game.console.VueConsole;
import mfiari.lib.game.liste.ListeObjet;

/**
 *
 * @author mike
 */
public class gmm_vueConsole_menu extends VueConsole {

    private Texte textes;
    private Menu menu;
    
    public gmm_vueConsole_menu (Menu menu){
        super(TexteVueCombat.getInstance());
        this.menu = menu;
        this.textes = new Texte_fr();
        this.menu.ajouterEcouteur(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                switch (evt.getPropertyName()) {
                    case "affichePerso":
                        affichePerso();
                        break;
                    case "afficherMenu":
                        afficherMenu();
                        break;
                    case "afficherMenuObjet":
                        afficherMenuObjet();
                        break;
                    case "afficherMenuTechnique":
                        afficherMenuTechnique();
                        break;
                    case "afficherMenuTechnique_choixTec":
                        afficherMenuTechnique_choixTec();
                        break;
                    case "afficherMenuEtat":
                        afficherMenuEtat();
                        break;
                }
            }
        });
    }

    public void affichePerso () {
        ListeDePerso perso = this.menu.getEquipe();
        String affichage = this.menu.getAffichage();
        for (int i = 0; i < perso.size(); i++) {
            System.out.println(perso.getPersonnage(i).getNom() + "\t"+this.textes.etat+" : " + perso.getPersonnage(i).getEtat() +
                    "\n"+this.textes.niv+" : " + perso.getPersonnage(i).getNiveau()+ "\t"+this.textes.pv+" : " + perso.getPersonnage(i).getPv() +
                "/" + perso.getPersonnage(i).getPvi() + "\t"+this.textes.pm+" : " + perso.getPersonnage(i).getPm() + "/" +
                perso.getPersonnage(i).getPmi());
        }
        System.out.println(affichage);
        this.menu.setChoix(this.testEntier());
    }
    public void afficherMenu () {
        ListeDePerso perso = this.menu.getEquipe();
        GmmJeu jeu = this.menu.getJeu();
        System.out.print("1."+this.textes.objet+" \t 2."+this.textes.technique+" \t");
        System.out.print("3."+this.textes.quete+" \t");
        System.out.print("4."+this.textes.etat+" \n5."+this.textes.equiper+" \t");
        System.out.print("6."+this.textes.cuisine+" \t 7."+this.textes.configuration+" \t");
        System.out.println("8."+this.textes.sauvegarder+" \t 0."+this.textes.quitter);
        System.out.println();
        System.out.println(perso.getArgent() + this.textes.pieceOr+" \t "+this.textes.tempsjeu+": " + jeu.getHeureTempsJeu() + ":" +
                jeu.getMinuteTempsJeu());
        System.out.println();
        this.affichePerso();
        this.menu.setChoix(this.testEntier());
    }

    public void afficherMenuObjet () {
        ListeObjet sac = this.menu.getEquipe().getSac();
        String affichage = this.menu.getAffichage();
        System.out.println("1."+this.textes.objetDivers+"     2."+this.textes.objet+"     3."+this.textes.arme+"     4."+this.textes.armure+
                "     5."+this.textes.chapeau);
        System.out.println("6."+this.textes.botte+"     7."+this.textes.accessoire+"     8."+this.textes.objetRare+"     0."+this.textes.quitter);
        System.out.println();
        System.out.println(affichage);
        for (int i =0 ; i<sac.size() ; i++) {
            System.out.println((i+9) + "." + sac.getObjet(i).getNom());
        }
        System.out.println(this.textes.queFaire);
        this.menu.setChoix(this.testEntier());
    }

    public void afficherMenuTechnique () {
        ListeDePerso perso = this.menu.getEquipe();
        System.out.println("0."+this.textes.quitter);
        this.affichePerso();
        this.menu.setChoix(this.testEntier());
    }

    public void afficherMenuTechnique_choixTec () {
        ListeTec tec = this.menu.getPerso().getTec();
        String affichage = this.menu.getAffichage();
        for (int i=0 ; i<tec.size() ; i++) {
            System.out.println(i+1 + "." + tec.getTechnique(i).getNom());
        }
        System.out.println("0."+this.textes.quitter);
        System.out.println(affichage);
        this.menu.setChoix(this.testEntier());
    }

    public void afficherMenuEtat () {
        Personnage perso = this.menu.getPerso();
        System.out.println(perso.getNom());
        System.out.println(this.textes.pv+": " + perso.getPv() + "\t" + "\t" + perso.getTec().getTechnique(0).getNom()
                + "\n"+this.textes.pm+": " + perso.getPm() + "\t" + "\t" + perso.getTec().getTechnique(1).getNom()
                + "\n"+this.textes.force+": " + perso.getForce() + "\t" + "\t" + perso.getTec().getTechnique(2).getNom()
                + "\n"+this.textes.def+": " + perso.getDef() + "\t" + "\t" + perso.getTec().getTechnique(3).getNom()
                + "\n"+this.textes.magie+": " + perso.getMagie() + "\t" + "\t" + perso.getTec().getTechnique(4).getNom()
                + "\n"+this.textes.res+": " + perso.getRes() + "\t" + "\t" + perso.getTec().getTechnique(5).getNom()
                + "\n"+this.textes.vit+": " + perso.getVit() + " \n"+this.textes.prec+": " + perso.getPrec() 
                + " \n"+this.textes.agi+": " + perso.getAgi()
                + "\n"+this.textes.exp+" : " + perso.getExp() /*+ "\n"+this.textes.nivSuiv+": " + perso.getExpRes()*/);
        System.out.println("0."+this.textes.quitter);
        this.menu.setChoix(this.testEntier());
    }

}
