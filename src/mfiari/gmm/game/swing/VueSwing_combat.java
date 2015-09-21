/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.swing;

import mfiari.gmm.game.combat.AbstractCombat;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.liste.ListeTec;
import mfiari.gmm.game.media.image.personnage.ImagePersonnage;
import mfiari.gmm.game.perso.Personnage;
import mfiari.gmm.game.texte.TexteVueCombat;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import mfiari.lib.game.liste.ListeObjet;
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
public class VueSwing_combat extends VueSwing {

    AbstractCombat combat;
    TexteVueCombat textes;
    
    public VueSwing_combat (AbstractCombat combat){
        super(TexteVueCombat.getInstance(), combat);
        this.combat = combat;
        this.textes = TexteVueCombat.getInstance();
        this.combat.ajouterEcouteur(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                switch (evt.getPropertyName()) {
                    case "afficherTerrainCombat":
                        afficherTerrainCombat();
                        break;
                    case "attenteAdv":
                        attenteAdv();
                        break;
                    default :
                        switch (evt.getPropertyName()) {
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
                        attendre();
                        break;
                }
            }
        });
    }

    public void affichage() {
        JPanel panel2 = new JPanel ();
        PanelDeTexteSuivant panelDeTexteSuivant = new PanelDeTexteSuivant(this);
        panelDeTexteSuivant.ajouterTexte(this.combat.getAffichage());
        panel2.add(panelDeTexteSuivant);
        panelDeTexteSuivant.lancerAffichage();
        Ecran.panel.ajouterSud(panel2);
    }
    
    public void afficherTerrainCombat() {
        ListeDePerso equipe = this.combat.getEquipe();
        ListeDePerso adversaire = this.combat.getAdversaires();
        JPanel panel2 = new JPanel (new GridLayout(4, 5));
        ImagePersonnage imagePersonnage = new ImagePersonnage();
        int width = 200;
        int height = 100;
        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0 ; j < 5 ; j++) {
                switch (i) {
                    case (0):
                        switch (adversaire.size()) {
                            case (1):
                                if (j!=2) {
                                    JPanel panelDefault = new JPanel ();
                                    panelDefault.setPreferredSize(new Dimension(width, height));
                                    panel2.add(panelDefault);
                                } else {
                                    if (imagePersonnage.aImagePerso(adversaire.getEnnemie(0).getNom(), ImagePersonnage.combat)) {
                                        panel2.add(new PanelImage(imagePersonnage.getImagePersoHeigth(adversaire.getEnnemie(0).getNom(), height, ImagePersonnage.combat)));
                                    } else {
                                        panel2.add(new PanelDeTexteAffichage(adversaire.getEnnemie(0).getNom()));
                                    }
                                }
                                break;
                            case (2):
                                if (j!=1 && j!=3) {
                                    JPanel panelDefault = new JPanel ();
                                    panelDefault.setPreferredSize(new Dimension(width, height));
                                    panel2.add(panelDefault);
                                } else {
                                    if (imagePersonnage.aImagePerso(adversaire.getEnnemie((j-1)/2).getNom(), ImagePersonnage.combat)) {
                                        panel2.add(new PanelImage(imagePersonnage.getImagePersoHeigth(adversaire.getEnnemie((j-1)/2).getNom(), height, ImagePersonnage.combat)));
                                    } else {
                                        panel2.add(new PanelDeTexteAffichage(adversaire.getEnnemie((j-1)/2).getNom()));
                                    }
                                }
                                break;
                            case (3):
                                if (j!=1 && j!=2 && j!=3) {
                                    JPanel panelDefault = new JPanel ();
                                    panelDefault.setPreferredSize(new Dimension(width, height));
                                    panel2.add(panelDefault);
                                } else {
                                    if (imagePersonnage.aImagePerso(adversaire.getEnnemie(j-1).getNom(), ImagePersonnage.combat)) {
                                        panel2.add(new PanelImage(imagePersonnage.getImagePersoHeigth(adversaire.getEnnemie(j-1).getNom(), height, ImagePersonnage.combat)));
                                    } else {
                                        panel2.add(new PanelDeTexteAffichage(adversaire.getEnnemie(j-1).getNom()));
                                    }
                                }
                                break;
                            case (4):
                                if (j==4) {
                                    JPanel panelDefault = new JPanel ();
                                    panelDefault.setPreferredSize(new Dimension(width, height));
                                    panel2.add(panelDefault);
                                } else {
                                    if (imagePersonnage.aImagePerso(adversaire.getEnnemie(j).getNom(), ImagePersonnage.combat)) {
                                        panel2.add(new PanelImage(imagePersonnage.getImagePersoHeigth(adversaire.getEnnemie(j).getNom(), height, ImagePersonnage.combat)));
                                    } else {
                                        panel2.add(new PanelDeTexteAffichage(adversaire.getEnnemie(j).getNom()));
                                    }
                                }
                                break;
                            case (5):
                                if (imagePersonnage.aImagePerso(adversaire.getEnnemie(j).getNom(), ImagePersonnage.combat)) {
                                    panel2.add(new PanelImage(imagePersonnage.getImagePersoHeigth(adversaire.getEnnemie(j).getNom(), height, ImagePersonnage.combat)));
                                } else {
                                    panel2.add(new PanelDeTexteAffichage(adversaire.getEnnemie(j).getNom()));
                                }
                                break;
                        }
                        break;
                    case (3):
                        switch (equipe.size()) {
                            case (1):
                                if (j!=2) {
                                    JPanel panelDefault = new JPanel ();
                                    panelDefault.setPreferredSize(new Dimension(width, height));
                                    panel2.add(panelDefault);
                                } else {
                                    if (imagePersonnage.aImagePerso(equipe.getPersonnage(0).getNom(), ImagePersonnage.combat)) {
                                        panel2.add(new PanelImage(imagePersonnage.getImagePersoHeigth(equipe.getPersonnage(0).getNom(), height, ImagePersonnage.combat)));
                                    } else {
                                        panel2.add(new PanelDeTexteAffichage(equipe.getPersonnage(0).getNom()));
                                    }
                                }
                                break;
                            case (2):
                                if (j!=1 && j!=3) {
                                    JPanel panelDefault = new JPanel ();
                                    panelDefault.setPreferredSize(new Dimension(width, height));
                                    panel2.add(panelDefault);
                                } else {
                                    if (imagePersonnage.aImagePerso(equipe.getPersonnage((j-1)/2).getNom(), ImagePersonnage.combat)) {
                                        panel2.add(new PanelImage(imagePersonnage.getImagePersoHeigth(equipe.getPersonnage((j-1)/2).getNom(), height, ImagePersonnage.combat)));
                                    } else {
                                        panel2.add(new PanelDeTexteAffichage(equipe.getPersonnage((j-1)/2).getNom()));
                                    }
                                }
                                break;
                            case (3):
                                if (j!=1 && j!=2 && j!=3) {
                                    JPanel panelDefault = new JPanel ();
                                    panelDefault.setPreferredSize(new Dimension(width, height));
                                    panel2.add(panelDefault);
                                } else {
                                    if (imagePersonnage.aImagePerso(equipe.getPersonnage(j-1).getNom(), ImagePersonnage.combat)) {
                                        panel2.add(new PanelImage(imagePersonnage.getImagePersoHeigth(equipe.getPersonnage(j-1).getNom(), height, ImagePersonnage.combat)));
                                    } else {
                                        panel2.add(new PanelDeTexteAffichage(equipe.getPersonnage(j-1).getNom()));
                                    }
                                }
                                break;
                            case (4):
                                if (j==4) {
                                    JPanel panelDefault = new JPanel ();
                                    panelDefault.setPreferredSize(new Dimension(width, height));
                                    panel2.add(panelDefault);
                                } else {
                                    if (imagePersonnage.aImagePerso(equipe.getPersonnage(j).getNom(), ImagePersonnage.combat)) {
                                        panel2.add(new PanelImage(imagePersonnage.getImagePersoHeigth(equipe.getPersonnage(j).getNom(), height, ImagePersonnage.combat)));
                                    } else {
                                        panel2.add(new PanelDeTexteAffichage(equipe.getPersonnage(j).getNom()));
                                    }
                                }
                                break;
                            case (5):
                                if (imagePersonnage.aImagePerso(equipe.getPersonnage(j).getNom(), ImagePersonnage.combat)) {
                                    panel2.add(new PanelImage(imagePersonnage.getImagePersoHeigth(equipe.getPersonnage(j).getNom(), height, ImagePersonnage.combat)));
                                } else {
                                    panel2.add(new PanelDeTexteAffichage(equipe.getPersonnage(j).getNom()));
                                }
                                break;
                        }
                        break;
                    default:
                        JPanel panelDefault = new JPanel ();
                        panelDefault.setPreferredSize(new Dimension(width, height));
                        panel2.add(panelDefault);
                        break;
                }
            }
        }
        Ecran.panel.cacherNord();
        Ecran.panel.ajouterCentre(panel2);
    }
    
    public void afficherMenuJoueur() {
        Personnage perso = this.combat.getPersoEnCours();
        Box box = Box.createVerticalBox();
        box.add(new PanelDeTexteAffichage(this.textes.pv+":" + Math.round(perso.getPv()) + "\t" + this.textes.pm+":" + perso.getPm()));
        JPanel panelBouton = new JPanel (new GridLayout(2, 3));
        JButton boutonAttaquer = new JButton(this.textes.attaquer);
        boutonAttaquer.addActionListener(new boutonChoix(1));
        JButton boutonSort = new JButton(perso.getCapacite());
        boutonSort.addActionListener(new boutonChoix(2));
        JButton boutonExaminer = new JButton(this.textes.examiner);
        boutonExaminer.addActionListener(new boutonChoix(3));
        JButton boutonObjet = new JButton(this.textes.objet);
        boutonObjet.addActionListener(new boutonChoix(4));
        JButton boutonProteger = new JButton(this.textes.seProteger);
        boutonProteger.addActionListener(new boutonChoix(5));
        JButton boutonPerso = new JButton(this.textes.perso);
        boutonPerso.addActionListener(new boutonChoix(3));
        panelBouton.add(boutonAttaquer);
        panelBouton.add(boutonSort);
        panelBouton.add(boutonExaminer);
        panelBouton.add(boutonObjet);
        panelBouton.add(boutonProteger);
        panelBouton.add(boutonPerso);
        Ecran.panel.ajouterSud(panelBouton);
    }
    
    public void afficherEnnemies() {
        ListeDePerso adversaire = this.combat.getAdversaires();
        Box box = Box.createVerticalBox();
        box.add(new PanelDeTexteAffichage(this.textes.quiAttaquer));
        JPanel panel2 = new JPanel ();
        for (int i = 0; i < adversaire.size(); i++) {
            BoutonImage bouton = new BoutonImage(adversaire.getEnnemie(i).getNom());
            bouton.addActionListener(new boutonChoix(i+1));
            panel2.add(bouton);
        }
        JButton retour = new JButton(this.textes.retour);
        retour.addActionListener(new boutonChoix(6));
        panel2.add(retour);
        box.add(panel2);
        Ecran.panel.ajouterSud(box);
    }

    public void afficherEquipe() {
        ListeDePerso equipe = this.combat.getEquipe();
        String affichage = this.combat.getAffichage();
        Box box = Box.createVerticalBox();
        box.add(new PanelDeTexteAffichage(affichage));
        JPanel panel2 = new JPanel ();
        for (int i = 0; i < equipe.size(); i++) {
            BoutonImage bouton = new BoutonImage(equipe.getPersonnage(i).getNom());
            bouton.addActionListener(new boutonChoix(i+1));
            panel2.add(bouton);
        }
        JButton retour = new JButton(this.textes.retour);
        retour.addActionListener(new boutonChoix(0));
        panel2.add(retour);
        box.add(panel2);
        Ecran.panel.ajouterSud(box);
    }

    public void afficherTechniques() {
        ListeTec techniques = this.combat.getPersoEnCours().getAtt();
        Box box = Box.createVerticalBox();
        box.add(new PanelDeTexteAffichage(this.textes.quelTecUtilise));
        JPanel panel2 = new JPanel ();
        for (int i = 0; i < techniques.size(); i++) {
            BoutonImage bouton = new BoutonImage(techniques.getTechnique(i).getNom());
            bouton.addActionListener(new boutonChoix(i+1));
            panel2.add(bouton);
        }
        JButton retour = new JButton(this.textes.retour);
        retour.addActionListener(new boutonChoix(0));
        panel2.add(retour);
        box.add(panel2);
        Ecran.panel.ajouterSud(box);
    }

    public void afficherObjetCombat() {
        ListeObjet objets = this.combat.getEquipe().getSac();
        JPanel panelBouton = new JPanel();
        for (int i = 0 ; i < objets.size() ; i++) {
            JButton objet = new JButton(objets.getObjet(i).getNom());
            objet.addActionListener(new boutonChoix(i+1));
            panelBouton.add(objet);
        }
        JButton quitter = new JButton(this.textes.quitter);
        quitter.addActionListener(new boutonChoix(0));
        panelBouton.add(quitter);
        Ecran.panel.ajouterSud(panelBouton);
    }
    
    public void afficherMenuFinDeCombat() {
        ListeDePerso equipe = this.combat.getEquipe();
        Box box = Box.createVerticalBox();
        int argentGagne = 0;
        int expGagne = 0;
        box.add(new PanelDeTexteAffichage(this.textes.expRecu+": " + expGagne + this.textes.argentRecu + ": " + argentGagne + 
                this.textes.pieceOr + ": " + equipe.getArgent()));
        JPanel panel2 = new JPanel (new GridLayout(equipe.size(), 1));
        for (int i = 0; i < equipe.size(); i++) {
            Personnage perso = equipe.getPersonnage(i);
            JPanel panel = new JPanel (new GridLayout(3, 1));
            panel.add(new PanelDeTexteAffichage(perso.getNom() + "\t"+this.textes.niv+":" + perso.getNiveau()));
            panel.add(new PanelDeTexteAffichage(this.textes.pv+": " + perso.getPv()));
            panel.add(new PanelDeTexteAffichage(this.textes.pm+": " + perso.getPm()));
            /*panel.add(new PanelDeTexteAffichage(this.textes.pv+": " + perso.getPv() + "/" + perso.getPvInitial()));
            panel.add(new PanelDeTexteAffichage(this.textes.pm+": " + perso.getPm() + "/" + perso.getPmInitial()));*/
            panel2.add(panel);
        }
        box.add(panel2);
        Ecran.panel.ajouterCentre(box);
        JButton suivant = new JButton(this.textes.suivant);
        suivant.addActionListener(new boutonSuivant());
        Ecran.panel.ajouterSud(suivant);
    }

    private void attenteAdv() {
        Ecran.panel.ajouterSud(new PanelDeTexteAffichage(this.textes.attenteAdv));
    }
}