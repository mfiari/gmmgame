/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.swing;

import mfiari.gmm.game.extra.DuelExtra;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.media.image.personnage.ImagePersonnage;
import mfiari.gmm.game.texte.TexteVueDuelExtra;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import mfiari.lib.game.swing.BoutonImage;
import mfiari.lib.game.swing.Ecran;
import mfiari.lib.game.swing.PanelDeTexteAffichage;
import mfiari.lib.game.swing.PanelDeTexteSuivant;
import mfiari.lib.game.swing.PanelImage;
import mfiari.lib.game.swing.VueSwing;

/**
 *
 * @author mike
 */
public class VueSwing_duelExtra extends VueSwing {
    
    private DuelExtra duel;
    private TexteVueDuelExtra textes;
    
    public VueSwing_duelExtra (DuelExtra duel) {
        super(TexteVueDuelExtra.getInstance(), duel);
        this.duel = duel;
        this.textes = TexteVueDuelExtra.getInstance();
        this.duel.ajouterEcouteur(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                switch (evt.getPropertyName()) {
                    case "afficherPersoChoisit":
                        afficherPersoChoisit();
                        break;
                    default :
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
                        attendre();
                        break;
                }
            }
        });
    }
    
    private void setAffichage() {
        JPanel panel2 = new JPanel ();
        PanelDeTexteSuivant panelDeTexteSuivant = new PanelDeTexteSuivant(this);
        panelDeTexteSuivant.ajouterTexte(this.duel.getAffichage());
        panel2.add(panelDeTexteSuivant);
        panelDeTexteSuivant.lancerAffichage();
        Ecran.panel.ajouterSud(panel2);
    }
    
    private void menuPrincipal() {
        JPanel panelBouton = new JPanel ();
        JButton boutonCombatLigne = new JButton("combat en ligne");
        boutonCombatLigne.addActionListener(new boutonChoix(1));
        JButton boutonCombatPc = new JButton("combat contre pc");
        boutonCombatPc.addActionListener(new boutonChoix(2));
        JButton boutonMultijoueur = new JButton("multijoueur");
        boutonMultijoueur.addActionListener(new boutonChoix(3));
        JButton boutonRetour = new JButton("retour");
        boutonRetour.addActionListener(new boutonChoix(0));
        panelBouton.add(boutonCombatLigne);
        panelBouton.add(boutonCombatPc);
        panelBouton.add(boutonMultijoueur);
        panelBouton.add(boutonRetour);
        Ecran.panel.ajouterSud(panelBouton);
        Ecran.panel.viderCentre();
    }
    
    private void combatSolo() {
        JPanel panelBouton = new JPanel ();
        JButton bouton1VS1 = new JButton("1 VS 1");
        bouton1VS1.addActionListener(new boutonChoix(1));
        JButton bouton3VS3 = new JButton("3 VS 3");
        bouton3VS3.addActionListener(new boutonChoix(2));
        JButton bouton5VS5 = new JButton("5 VS 5");
        bouton5VS5.addActionListener(new boutonChoix(3));
        JButton boutonBoss = new JButton("Boss");
        boutonBoss.addActionListener(new boutonChoix(4));
        JButton boutonRetour = new JButton("retour");
        boutonRetour.addActionListener(new boutonChoix(0));
        panelBouton.add(bouton1VS1);
        panelBouton.add(bouton3VS3);
        panelBouton.add(bouton5VS5);
        panelBouton.add(boutonBoss);
        panelBouton.add(boutonRetour);
        Ecran.panel.ajouterSud(panelBouton);
    }
    
    private void unContreUn() {
        JPanel panelBouton = new JPanel ();
        JButton boutonJ1VSOrdi = new JButton("J1 VS ORDI");
        boutonJ1VSOrdi.addActionListener(new boutonChoix(1));
        JButton boutonJ1VSJ2 = new JButton("J1 VS J2");
        boutonJ1VSJ2.addActionListener(new boutonChoix(2));
        JButton boutonOrdiVSOrdi = new JButton("ORDI VS ORDI");
        boutonOrdiVSOrdi.addActionListener(new boutonChoix(3));
        JButton boutonRetour = new JButton("retour");
        boutonRetour.addActionListener(new boutonChoix(0));
        panelBouton.add(boutonJ1VSOrdi);
        panelBouton.add(boutonJ1VSJ2);
        panelBouton.add(boutonOrdiVSOrdi);
        panelBouton.add(boutonRetour);
        Ecran.panel.ajouterSud(panelBouton);
    }
    
    private void choixPersoJ1() {
        this.choixPerso(this.duel.getPersonnages());
    }
    
    private void choixPersoJ2() {
        this.choixPerso(this.duel.getAdv());
    }
    
    private void afficherPersoChoisit () {
        JPanel panelHaut = new JPanel (new GridLayout(1, 2));
        String nom;
        ImagePersonnage imagePersonnage = new ImagePersonnage();
        Box boxPerso = Box.createVerticalBox();
        boxPerso.add(new PanelDeTexteAffichage("equipe"));
        JPanel panelPerso = new JPanel();
        ListeDePerso equipeJ1 = this.duel.getEquipeJ1();
        for (int i =0 ; i < equipeJ1.size() ; i++) {
            nom = equipeJ1.getPerso(i).getNom();
            PanelImage image;
            if (imagePersonnage.aImagePerso(nom)) {
                image = new PanelImage(imagePersonnage.getImagePersoHeigth(nom, 60));
            } else {
                image = new PanelImage();
                image.add(new PanelDeTexteAffichage(nom));
            }
            panelPerso.add(image);
        }
        boxPerso.add(panelPerso);
        panelHaut.add(boxPerso);
        Box boxAdv = Box.createVerticalBox();
        boxAdv.add(new PanelDeTexteAffichage("adv"));
        JPanel panelAdv = new JPanel();
        ListeDePerso equipeJ2 = this.duel.getEquipeAdv();
        for (int i =0 ; i < equipeJ2.size() ; i++) {
            nom = equipeJ2.getPerso(i).getNom();
            PanelImage image;
            if (imagePersonnage.aImagePerso(nom)) {
                image = new PanelImage(imagePersonnage.getImagePersoHeigth(nom, 60));
            } else {
                image = new PanelImage();
                image.add(new PanelDeTexteAffichage(nom));
            }
            panelAdv.add(image);
        }
        boxAdv.add(panelAdv);
        panelHaut.add(boxAdv);
        Ecran.panel.ajouterNord(panelHaut);
    }
    
    private void choixPerso (ListeDePerso personnages) {
        String nom;
        ImagePersonnage imagePersonnage = new ImagePersonnage();
        JPanel panel2 = new JPanel (new GridLayout(5, 6));
        for (int i = 0 ; i < personnages.size() ; i++) {
            nom = personnages.getPerso(i).getNom();
            BoutonImage bouton;
            if (imagePersonnage.aImagePerso(nom)) {
                bouton = new BoutonImage(imagePersonnage.getImagePersoHeigth(nom, 80));
            } else {
                bouton = new BoutonImage(nom);
            }
            bouton.addActionListener(new boutonChoix(i+1));
            panel2.add(bouton);
        }
        JButton terminer = new JButton("aleatoire");
        terminer.addActionListener(new boutonChoix(100));
        JButton retour = new JButton("retour");
        retour.addActionListener(new boutonChoix(0));
        panel2.add(terminer);
        panel2.add(retour);
        Ecran.panel.ajouterCentre(panel2);
        Ecran.panel.viderSud();
    }
    
    private void J1VSJ2() {
        JPanel panel2 = new JPanel ();
        PanelDeTexteSuivant panelDeTexteSuivant = new PanelDeTexteSuivant(this);
        panelDeTexteSuivant.ajouterTexte("Le mode combat en ligne n'est pas disponible pour le moment");
        panel2.add(panelDeTexteSuivant);
        panelDeTexteSuivant.lancerAffichage();
        Ecran.panel.ajouterSud(panel2);
    }
    
    private void OrdiVsOrdi() {
        JPanel panel2 = new JPanel ();
        PanelDeTexteSuivant panelDeTexteSuivant = new PanelDeTexteSuivant(this);
        panelDeTexteSuivant.ajouterTexte("Le mode combat en ligne n'est pas disponible pour le moment");
        panel2.add(panelDeTexteSuivant);
        panelDeTexteSuivant.lancerAffichage();
        Ecran.panel.ajouterSud(panel2);
    }
    
    private void tournoi() {
        JPanel panel2 = new JPanel ();
        PanelDeTexteSuivant panelDeTexteSuivant = new PanelDeTexteSuivant(this);
        panelDeTexteSuivant.ajouterTexte("Le mode combat en ligne n'est pas disponible pour le moment");
        panel2.add(panelDeTexteSuivant);
        panelDeTexteSuivant.lancerAffichage();
        Ecran.panel.ajouterSud(panel2);
    }
    
    private void mission() {
        JPanel panel2 = new JPanel ();
        PanelDeTexteSuivant panelDeTexteSuivant = new PanelDeTexteSuivant(this);
        panelDeTexteSuivant.ajouterTexte("Le mode combat en ligne n'est pas disponible pour le moment");
        panel2.add(panelDeTexteSuivant);
        panelDeTexteSuivant.lancerAffichage();
        Ecran.panel.ajouterSud(panel2);
    }
}