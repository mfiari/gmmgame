/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.swing;

import mfiari.gmm.game.GmmJeu;
import mfiari.gmm.game.media.image.objetEndroit.ImageObjetEndroit;
import mfiari.gmm.game.media.image.personnage.ImagePersonnage;
import mfiari.gmm.game.media.image.sol.ImageSol;
import mfiari.gmm.game.objet.TypeObjet;
import mfiari.gmm.game.perso.Personnage;
import mfiari.gmm.game.texte.TexteVueJeu;
import mfiari.gmm.game.ville.Endroit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import mfiari.lib.game.objet.ObjetEndroit;
import mfiari.lib.game.position.Position;
import mfiari.lib.game.swing.Ecran;
import mfiari.lib.game.swing.PanelDeTexteAffichage;
import mfiari.lib.game.swing.PanelDeTexteSuivant;
import mfiari.lib.game.swing.PanelImage;
import mfiari.lib.game.swing.ViewComponent;
import mfiari.lib.game.swing.VueSwing;

/**
 *
 * @author mike
 */
public class VueSwing_jeu extends VueSwing {

    private GmmJeu jeu;
    private int choix;
    private TexteVueJeu textes;

    public VueSwing_jeu(GmmJeu jeu) {
        super(TexteVueJeu.getInstance(), jeu);
        this.jeu = jeu;
        this.textes = TexteVueJeu.getInstance();
        this.jeu.ajouterEcouteur(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("PropertyChangeEvent => name = " + evt.getPropertyName());
                if (evt.getPropertyName().equals("afficheEndroit")) {
                    System.out.println("PropertyChangeEvent => afficheEndroit");
                    afficheEndroit();
                } else if (evt.getPropertyName().equals("deplacerPerso")) {
                    System.out.println("PropertyChangeEvent => deplacerPerso");
                    deplacerPerso((Position)evt.getOldValue(), (Position)evt.getNewValue());
                } else {
                    switch (evt.getPropertyName()) {
                        case "continuer":
                            continuer();
                            break;
                        case "gagnerCombat":
                            gagnerCombat();
                            break;
                        case "perdu":
                            Perdu();
                            break;
                        case "parole":
                            parole();
                            break;
                        case "affichage":
                            affichage();
                            break;
                        case "confirmation":
                            confirmation();
                            break;
                        case "choix":
                            choix();
                            break;
                        case "actionJeu":
                            actionJeu();
                            break;
                    }
                    attendre();
                }
            }
        });
    }

    public void continuer() {
        /*
        on affiche la ville, le batiment... dans laquelle se trouve le personnage
         */
    }

    public void actionJeu() {
        JPanel panel2 = new JPanel (new GridLayout(2, 3));
        JButton boutonHaut = new JButton(this.textes.haut);
        boutonHaut.addActionListener(new boutonChoix(1));
        JButton boutonBas = new JButton(this.textes.bas);
        boutonBas.addActionListener(new boutonChoix(2));
        JButton boutonDroite = new JButton(this.textes.droite);
        boutonDroite.addActionListener(new boutonChoix(3));
        JButton boutonGauche = new JButton(this.textes.gauche);
        boutonGauche.addActionListener(new boutonChoix(4));
        JButton boutonAction = new JButton(this.textes.action);
        boutonAction.addActionListener(new boutonChoix(5));
        JButton boutonMenu = new JButton(this.textes.menu);
        boutonMenu.addActionListener(new boutonChoix(6));
        panel2.add(boutonHaut);
        panel2.add(boutonBas);
        panel2.add(boutonDroite);
        panel2.add(boutonGauche);
        panel2.add(boutonAction);
        panel2.add(boutonMenu);
        Ecran.panel.ajouterSud(panel2);
    }

    public void Perdu() {
        /*
         * message lorsque l'on a perdu la partie (game over)
         */
        PanelDeTexteSuivant panelTexteSuivant = new PanelDeTexteSuivant(this);
        panelTexteSuivant.ajouterTexte("GAME OVER");
        panelTexteSuivant.lancerAffichage();
        Ecran.panel.ajouterSud(panelTexteSuivant);
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
        PanelDeTexteSuivant panelTexteSuivant = new PanelDeTexteSuivant(this);
        panelTexteSuivant.ajouterTexte(this.jeu.getParole());
        panelTexteSuivant.lancerAffichage();
        Ecran.panel.ajouterSud(panelTexteSuivant);
    }

    public void affichage() {
        /*
         * pour faire des affichages divers
         */
        PanelDeTexteSuivant panelTexteSuivant = new PanelDeTexteSuivant(this);
        panelTexteSuivant.ajouterTexte(this.jeu.getAffichage());
        panelTexteSuivant.lancerAffichage();
        Ecran.panel.ajouterSud(panelTexteSuivant);
    }

    public void confirmation () {
        JPanel panel2 = new JPanel (new GridLayout(2, 1));
        PanelDeTexteAffichage panelTexteAffichage = new PanelDeTexteAffichage();
        panelTexteAffichage.ajouterTexte(this.jeu.getAffichage());
        JButton boutonOui = new JButton(this.textes.oui);
        boutonOui.addActionListener(new boutonConfirmation(true));
        JButton boutonNon = new JButton(this.textes.non);
        boutonNon.addActionListener(new boutonConfirmation(false));
        panel2.add(panelTexteAffichage);
        JPanel panelBouton = new JPanel ();
        panelBouton.add(boutonOui);
        panelBouton.add(boutonNon);
        panel2.add(panelBouton);
        Ecran.panel.ajouterSud(panel2);
    }

    public void choix () {
        System.out.println(this.jeu.getAffichage());

    }

    public void afficheEndroit() {
        Ecran.panel.cacherNord();
        Endroit e = (Endroit)this.jeu.getEndroit();
        Ecran.panel.changerCentre(e.getLargeur(), e.getLongueur(), 1250, 550);
        int width = (Ecran.panel.getPanelCentre().getWidth() / e.getLongueur());
        int height = (Ecran.panel.getPanelCentre().getHeight() / e.getLargeur());
        Personnage perso = this.jeu.getEquipe().getPersonnage(0);
        for (int i = 0; i < e.getLargeur(); i++) {
            for (int j = 0; j < e.getLongueur(); j++) {
                if (perso.getPosition().getPositionX() == i && perso.getPosition().getPositionY() == j) {
                    ImagePersonnage imagePersonnage = new ImagePersonnage();
                    if (imagePersonnage.aImagePerso(perso.getNom(), ImagePersonnage.dehors, perso.getPosition().getOrientation())) {
                        PanelImage image = new PanelImage(imagePersonnage.getImagePersoHeigth(perso.getNom(), height, ImagePersonnage.dehors, perso.getPosition().getOrientation()));
                        Ecran.panel.getPanelCentre().ajouterContent(image, i, j, 1);
                    } else {
                        JPanel panelFond = new JPanel ();
                        panelFond.setPreferredSize(new Dimension(width, height));
                        panelFond.setBackground(Color.YELLOW);
                        Ecran.panel.getPanelCentre().ajouterContent(panelFond, i, j, 1);
                    }
                } else if (e.aEndroit(i, j) != null) {
                    Ecran.panel.getPanelCentre().ajouterContent(new PanelDeTexteAffichage(e.aEndroit(i, j).getNom()), i, j, 1);
                } else if (e.aGens(i, j) != null) {
                    Ecran.panel.getPanelCentre().ajouterContent(new PanelDeTexteAffichage(e.aGens(i, j).getNom()), i, j, 1);
                } else if (e.aObjetEndroit(i,j) != null) {
                    ObjetEndroit objet_endroit = e.aObjetEndroit(i,j);
                    if (ImageObjetEndroit.getNivImageObjet((TypeObjet)objet_endroit.getType()) == 1) {
                        String nom = ImageObjetEndroit.getNomImageObjetByType((TypeObjet)objet_endroit.getType());
                        ImageObjetEndroit imageObjet = new ImageObjetEndroit();
                        if (imageObjet.aImageObjet(nom)) {
                            PanelImage image;
                            if (ImageObjetEndroit.getImageObjetWidthEtHeight((TypeObjet)objet_endroit.getType())) {
                                image = new PanelImage(imageObjet.getImageObjetWidthEtHeigth(nom, width, height));
                            } else {
                                image = new PanelImage(imageObjet.getImageObjetWidthOrHeigth(nom, width, height));
                            }
                            Ecran.panel.getPanelCentre().ajouterContent(image, i, j, 1);
                        } else {
                            Ecran.panel.getPanelCentre().ajouterContent(new PanelDeTexteAffichage(e.aEndroit(i, j).getNom()), i, j, 1);
                        }
                    }
                } else {
                    Ecran.panel.getPanelCentre().ajouterContent(null, i, j);
                }
                if (e.aObjetEndroit(i,j) != null) {
                    ObjetEndroit objet_endroit = e.aObjetEndroit(i,j);
                    if (ImageObjetEndroit.getNivImageObjet((TypeObjet)objet_endroit.getType()) == 0) {
                        String nom = ImageObjetEndroit.getNomImageObjetByType((TypeObjet)objet_endroit.getType());
                        ImageObjetEndroit imageObjet = new ImageObjetEndroit();
                        if (imageObjet.aImageObjet(nom)) {
                            PanelImage image;
                            if (ImageObjetEndroit.getImageObjetWidthEtHeight((TypeObjet)objet_endroit.getType())) {
                                image = new PanelImage(imageObjet.getImageObjetWidthEtHeigth(nom, width, height));
                            } else {
                                image = new PanelImage(imageObjet.getImageObjetWidthOrHeigth(nom, width, height));
                            }
                            Ecran.panel.getPanelCentre().ajouterContent(image, i, j, 0);
                        } else {
                            Ecran.panel.getPanelCentre().ajouterContent(new PanelDeTexteAffichage(e.aObjetEndroit(i, j).getNom()), i, j, 1);
                        }
                    } else {
                        ObjetEndroit objet_endroit_sol = ImageObjetEndroit.getSolImageObjetByType((TypeObjet)objet_endroit.getType());
                        if (objet_endroit_sol != null) {
                            ImageObjetEndroit imageObjet = new ImageObjetEndroit();
                            String nom = ImageObjetEndroit.getNomImageObjetByType((TypeObjet)objet_endroit_sol.getType());
                            if (imageObjet.aImageObjet(nom)) {
                                PanelImage image;
                                if (ImageObjetEndroit.getImageObjetWidthEtHeight((TypeObjet)objet_endroit_sol.getType())) {
                                    image = new PanelImage(imageObjet.getImageObjetWidthEtHeigth(nom, width, height));
                                } else {
                                    image = new PanelImage(imageObjet.getImageObjetWidthOrHeigth(nom, width, height));
                                }
                                Ecran.panel.getPanelCentre().ajouterContent(image, i, j, 0);
                            } else {
                                Ecran.panel.getPanelCentre().ajouterContent(new PanelDeTexteAffichage(e.aEndroit(i, j).getNom()), i, j, 1);
                            }
                        }
                    }
                } else {
                    Ecran.panel.getPanelCentre().ajouterContent(null, i, j);
                }
                ImageSol imageSol = new ImageSol();
                if (imageSol.aImageSol(ImageSol.getNomImageSolBySalle(e))) {
                    Ecran.panel.getPanelCentre().ajouterBackground(new PanelImage(
                            imageSol.getImageSolWidthEtHeigth(ImageSol.getNomImageSolBySalle(e), width, height)), i, j);
                } else {
                    JPanel panelFond = new JPanel ();
                    panelFond.setPreferredSize(new Dimension(width, height));
                    panelFond.setBackground(Color.BLACK);
                    Ecran.panel.getPanelCentre().ajouterBackground(panelFond, i, j);
                }
            }
        }
    }
    
    public void deplacerPerso(Position oldPosition, Position newPosition) {
        System.out.println("deplacerPerso");
        if (this.jeu.getEndroit().equals(oldPosition.getEndroit())) {
            Endroit e = (Endroit)newPosition.getEndroit();
            int width = (Ecran.panel.getCentre().getWidth() / e.getLongueur());
            int height = (Ecran.panel.getCentre().getHeight() / e.getLargeur());
            Ecran.panel.getPanelCentre().ajouterViewContent(null, oldPosition.getPositionX(), oldPosition.getPositionY(), 1);
            ImagePersonnage imagePersonnage = new ImagePersonnage();
            Personnage perso = this.jeu.getEquipe().getPersonnage(0);
            if (imagePersonnage.aImagePerso(perso.getNom(), ImagePersonnage.dehors, perso.getPosition().getOrientation())) {
                PanelImage image = new PanelImage(imagePersonnage.getImagePersoHeigth(perso.getNom(), height, ImagePersonnage.dehors, perso.getPosition().getOrientation()));
                Ecran.panel.getPanelCentre().ajouterContent(image, newPosition.getPositionX(), newPosition.getPositionY(), 1);
            } else {
                JPanel panelFond = new JPanel ();
                panelFond.setPreferredSize(new Dimension(width, height));
                panelFond.setBackground(Color.YELLOW);
                Ecran.panel.getPanelCentre().ajouterContent(panelFond, newPosition.getPositionX(), newPosition.getPositionY(), 1);
            }
        } else {
            this.afficheEndroit();
        }
    }
    
    private class boutonConfirmation implements ActionListener {
        boolean confirmation;
        
        public boutonConfirmation (boolean confirmation) {
            this.confirmation = confirmation;
        }
        @Override
        public void actionPerformed (ActionEvent event) {
            jeu.setConfirmation(this.confirmation);
            reprendre();
        }
    }
}
