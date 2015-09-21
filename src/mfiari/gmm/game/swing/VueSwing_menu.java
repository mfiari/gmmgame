/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.swing;

import mfiari.gmm.game.media.image.personnage.ImagePersonnage;
import mfiari.gmm.game.menu.Menu;
import mfiari.gmm.game.texte.TexteVueCombat;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import mfiari.lib.game.swing.Ecran;
import mfiari.lib.game.swing.PanelDeTexteAffichage;
import mfiari.lib.game.swing.PanelImage;
import mfiari.lib.game.swing.VueSwing;

/**
 *
 * @author mike
 */
public class VueSwing_menu  extends VueSwing {
    
    private TexteVueCombat textes;
    private Menu menu;

    public VueSwing_menu (Menu menu) {
        super(TexteVueCombat.getInstance(), menu);
        this.menu = menu;
        this.textes = TexteVueCombat.getInstance();
        Ecran.panel.redimenssionnerCentre(900, 550);
        Ecran.panel.redimenssionnerSud(1200, 100);
        Ecran.panel.redimenssionnerEst(300, 600);
        Ecran.panel.afficherEst();
        Ecran.panel.afficherCentre();
        Ecran.panel.afficherSud();
        Ecran.panel.cacherNord();
        Ecran.panel.cacherOuest();
        this.menu.ajouterEcouteur(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                switch (evt.getPropertyName()) {
                    case "afficherMenu":
                        afficherMenu();
                        break;
                    case "configuration":
                        configuration();
                        break;
                    case "sauvegarde":
                        sauvegarde();
                        break;
                }
                attendre();
            }
        });
    }

    private void afficherMenu() {
        Ecran.panel.afficherPanelCentre();
        JPanel panel2 = new JPanel (new GridLayout(1, 6));
        JButton boutonObjet = new JButton("objets");
        boutonObjet.addActionListener(new boutonChoix(1));
        JButton boutonTechnique = new JButton("techniques");
        boutonTechnique.addActionListener(new boutonChoix(2));
        JButton boutonQuetes = new JButton("quêtes");
        boutonQuetes.addActionListener(new boutonChoix(3));
        JButton boutonEtat = new JButton("etat");
        boutonEtat.addActionListener(new boutonChoix(4));
        JButton boutonEquiper = new JButton("equiper");
        boutonEquiper.addActionListener(new boutonChoix(5));
        JButton boutonCuisine = new JButton("cuisine");
        boutonCuisine.addActionListener(new boutonChoix(6));
        JButton boutonConfiguration = new JButton("configuration");
        boutonConfiguration.addActionListener(new boutonChoix(7));
        JButton boutonSauvagarde = new JButton("sauvegarder");
        boutonSauvagarde.addActionListener(new boutonChoix(8));
        JButton boutonQuitter = new JButton(this.textes.quitter);
        boutonQuitter.addActionListener(new boutonQuitter());
        panel2.add(boutonObjet);
        panel2.add(boutonTechnique);
        panel2.add(boutonQuetes);
        panel2.add(boutonEtat);
        panel2.add(boutonEquiper);
        panel2.add(boutonCuisine);
        panel2.add(boutonConfiguration);
        panel2.add(boutonSauvagarde);
        panel2.add(boutonQuitter);
        Ecran.panel.ajouterNord(panel2);
        PanelDeTexteAffichage panelDeTexteAffichage = new PanelDeTexteAffichage ();
        panelDeTexteAffichage.ajouterTexte(this.menu.getPerso().getArgent() + this.textes.pieceOr + " \t " + "temps de jeu" + ": " 
                + this.menu.getJeu().getHeureTempsJeu() + ":" + this.menu.getJeu().getMinuteTempsJeu());
        Ecran.panel.ajouterEst(panelDeTexteAffichage);
        JPanel panelPerso = new JPanel (new GridLayout(this.menu.getEquipe().size(), 1));
        ImagePersonnage imagePersonnage = new ImagePersonnage();
        for (int i = 0 ; i < this.menu.getEquipe().size() ; i++) {
            JPanel panel = new JPanel (new GridLayout(1, 2));
            if (imagePersonnage.aImagePerso(this.menu.getEquipe().getPerso(i).getNom(), ImagePersonnage.combat)) {
                panel.add(new PanelImage(imagePersonnage.getImagePersoHeigth(this.menu.getEquipe().getPerso(i).getNom(), 50, ImagePersonnage.combat)));
            } else {
                panel.add(new PanelDeTexteAffichage(this.menu.getEquipe().getPerso(i).getNom()));
            }
            panel.add(new PanelDeTexteAffichage(this.menu.getEquipe().getPerso(i).getNom()));
        }
        Ecran.panel.ajouterSud(panelDeTexteAffichage);
    }
    
    private void configuration() {
        PanelDeTexteAffichage panelDeTexteAffichage = new PanelDeTexteAffichage ();
        panelDeTexteAffichage.ajouterTexte("vous ne pouvez pas modifier les configurations.");
        Ecran.panel.ajouterCentre(panelDeTexteAffichage);
        
        JPanel panelBouton = new JPanel ();
        JButton boutonRetour = new JButton(this.textes.retour);
        boutonRetour.addActionListener(new boutonChoix(0));
        panelBouton.add(boutonRetour);
        Ecran.panel.cacherEst();
        Ecran.panel.ajouterSud(panelBouton);
    }
    
    private void sauvegarde() {
        PanelDeTexteAffichage panelDeTexteAffichage = new PanelDeTexteAffichage ();
        panelDeTexteAffichage.ajouterTexte("vous ne pouvez pas sauvegarder la partie");
        Ecran.panel.ajouterCentre(panelDeTexteAffichage);
    }
    
    private class boutonRetour implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent event) {
            menu.setChoix(0);
            Ecran.panel.cacherEst();
            reprendre();
        }
    }
    
    private class boutonQuitter implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent event) {
            menu.setChoix(-1);
            Ecran.panel.cacherEst();
            reprendre();
        }
    }
    
}