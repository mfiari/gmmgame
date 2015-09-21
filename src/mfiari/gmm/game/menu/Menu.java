package mfiari.gmm.game.menu;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import mfiari.gmm.game.connexionBD.Connexion;
import mfiari.gmm.game.GmmJeu;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.objet.Categorie_objet;
import mfiari.gmm.game.objet.Equip;
import mfiari.gmm.game.objet.Objet_diver;
import mfiari.gmm.game.objet.TypeObjet;
import mfiari.gmm.game.perso.Personnage;
import mfiari.lib.game.controlleur.ControlleurVue;
import mfiari.lib.game.liste.ListeObjet;

/**
 *
 * @author mike
 */
public class Menu extends ControlleurVue {

    private ListeDePerso equipe;
    private GmmJeu jeu;
    private String affichage;
    private int choixPerso;
    private ListeObjet sac;

    public Menu(ListeDePerso equipe, ListeObjet sac, GmmJeu jeu) {
        this.equipe = equipe;
        this.jeu = jeu;
    }
    
    public ListeDePerso getEquipe () {
        return this.equipe;
    }
    
    public String getAffichage () {
        return this.affichage;
    }
    
    public GmmJeu getJeu () {
        return this.jeu;
    }
    
    public Personnage getPerso () {
        return this.equipe.getPersonnage(this.choixPerso);
    }
    
    public ListeObjet getSac () {
        return this.sac;
    }

    public void menu() {
        do {
            this.pcsControlleurVue.firePropertyChange("afficherMenu", null, null);
            switch (this.choix) {
                case (1):
                    this.menuObjet();
                    break;
                case (2):
                    this.menuTechnique();
                    break;
                case (3):
                    this.menuQuete();
                    break;
                case (4):
                    this.menuEtat();
                    break;
                case (5):
                    this.menuEquiper();
                    break;
                case (6):
                    this.menuCuisine();
                    break;
                case (7):
                    this.menuConfiguration();
                    break;
                case (8):
                    this.menuSauvegarder();
                    break;
            }
        } while (this.choix != 0);
    }

    //ce programme affiche ce qu'il y a dans le menu objet
    public void menuObjet() {
        this.choix = 1;
        do {
            //this.pcsControlleurVue.firePropertyChange("afficherMenuObjet", null, null);
            switch (this.choix) {
                case (1):
                    this.menuObjet_objetDivers();
                    break;
                case (2):
                    this.menuObjet_objet();
                    break;
                case (3):
                    this.menuObjet_arme();
                    break;
                case (4):
                    this.menuObjet_armure();
                    break;
                case (5):
                    this.menuObjet_chapeau();
                    break;
                case (6):
                    this.menuObjet_botte();
                    break;
                case (7):
                    this.menuObjet_accessoire();
                    break;
                case (8):
                    this.menuObjet_objetRare();
                    break;
            }
        } while (this.choix != 0);
        this.choix = -1;
    }

    public void menuObjet_objetDivers() {
        this.sac = new ListeObjet();
        if (!this.equipe.getSac().isEmpty()) {
            for (int i = this.equipe.getSac().size() - 1; i > this.equipe.getSac().size() - 21; i--) {
                this.sac.ajoutObjet(this.equipe.getSac().getObjet(i));
            }
        }
        this.affichage = "objet divers";
        this.pcsControlleurVue.firePropertyChange("afficherMenuObjet", null, null);
        if (this.choix > 8) {
            if (this.sac.getObjet(this.choix - 9).getType().equals(TypeObjet.soin)
                    || this.sac.getObjet(this.choix - 9).getType().equals(TypeObjet.soin_etat)
                    || this.sac.getObjet(this.choix - 9).getType().equals(TypeObjet.soin_stat)) {
                if (this.affichePersoMenu("l'utiliser sur quel perso ?") != 0) {
                    this.utiliserObjet(this.sac);
                }
            } else {
                if (this.sac.getObjet(this.choix - 9) instanceof Equip) {
                    if (this.affichePersoMenu("quel perso voulez vous equiper ?") != 0) {
                        if (this.equipe.getPersonnage(this.jeu.getChoix()).getMainEquip().equals(this.sac.getObjet(this.choix).getType())) {
                            this.equiperObjet(this.sac);
                        }
                    }
                } else {
                    /*objet rare */
                }
            }
        }
    }

    public void menuObjet_objet() {
        this.sac = new ListeObjet();
        for (int i = 0; i < this.equipe.getSac().size(); i++) {
            if (this.equipe.getSac().getObjet(i) instanceof Objet_diver) {
                this.sac.ajoutObjet(this.equipe.getSac().getObjet(i));
            }
        }
        this.affichage = "objet";
        this.pcsControlleurVue.firePropertyChange("afficherMenuObjet", null, null);
        if (this.choix > 8) {
            if (this.affichePersoMenu("l'utiliser sur quel perso ?") != 0) {
                this.utiliserObjet(this.sac);
            }
        }
    }

    public void menuObjet_arme() {
        this.sac = new ListeObjet();
        for (int i = 0; i < this.equipe.getSac().size(); i++) {
            if (this.equipe.getSac().getObjet(i) instanceof Equip) {
                Equip e = (Equip) this.equipe.getSac().getObjet(i);
                if (e.getCategorie().equals(Categorie_objet.arme)) {
                    this.sac.ajoutObjet(this.equipe.getSac().getObjet(i));
                }
            }
        }
        this.affichage = "arme";
        this.pcsControlleurVue.firePropertyChange("afficherMenuObjet", null, null);
        if (this.choix > 8) {
            if (this.affichePersoMenu("qui equiper ?") != 0) {
                if (this.equipe.getPersonnage(this.jeu.getChoix()).getMainEquip().equals(this.sac.getObjet(this.choix).getType())) {
                    this.equiperObjet(this.sac);
                }
            }
        }
    }

    public void menuObjet_armure() {
        this.sac = new ListeObjet();
        for (int i = 0; i < this.equipe.getSac().size(); i++) {
            if (this.equipe.getSac().getObjet(i) instanceof Equip) {
                Equip e = (Equip) this.equipe.getSac().getObjet(i);
                if (e.getCategorie().equals(Categorie_objet.armure)) {
                    this.sac.ajoutObjet(this.equipe.getSac().getObjet(i));
                }
            }
        }
        this.affichage = "armure";
        this.pcsControlleurVue.firePropertyChange("afficherMenuObjet", null, null);
        if (this.choix > 8) {
            if (this.affichePersoMenu("qui equiper ?") != 0) {
                if (this.equipe.getPersonnage(this.jeu.getChoix()).getCorpsEquip().equals(this.sac.getObjet(this.choix).getType())) {
                    this.equiperObjet(this.sac);
                }
            }
        }
    }

    public void menuObjet_chapeau() {
        this.sac = new ListeObjet();
        for (int i = 0; i < this.equipe.getSac().size(); i++) {
            if (this.equipe.getSac().getObjet(i) instanceof Equip) {
                Equip e = (Equip) this.equipe.getSac().getObjet(i);
                if (e.getCategorie().equals(Categorie_objet.chapeau)) {
                    this.sac.ajoutObjet(this.equipe.getSac().getObjet(i));
                }
            }
        }
        this.affichage = "chapeau";
        this.pcsControlleurVue.firePropertyChange("afficherMenuObjet", null, null);
        if (this.choix > 8) {
            if (this.affichePersoMenu("qui equiper ?") != 0) {
                if (this.equipe.getPersonnage(this.jeu.getChoix()).getTeteEquip().equals(this.sac.getObjet(this.choix).getType())) {
                    this.equiperObjet(this.sac);
                }
            }
        }
    }

    public void menuObjet_botte() {
        this.sac = new ListeObjet();
        for (int i = 0; i < this.equipe.getSac().size(); i++) {
            if (this.equipe.getSac().getObjet(i) instanceof Equip) {
                Equip e = (Equip) this.equipe.getSac().getObjet(i);
                if (e.getCategorie().equals(Categorie_objet.botte)) {
                    this.sac.ajoutObjet(this.equipe.getSac().getObjet(i));
                }
            }
        }
        this.affichage = "botte";
        this.pcsControlleurVue.firePropertyChange("afficherMenuObjet", null, null);
        if (this.choix > 8) {
            if (this.affichePersoMenu("qui equiper ?") != 0) {
                if (this.equipe.getPersonnage(this.jeu.getChoix()).getPiedEquip().equals(this.sac.getObjet(this.choix).getType())) {
                    this.equiperObjet(this.sac);
                }
            }
        }
    }

    public void menuObjet_accessoire() {
        this.sac = new ListeObjet();
        for (int i = 0; i < this.equipe.getSac().size(); i++) {
            if (this.equipe.getSac().getObjet(i) instanceof Equip) {
                Equip e = (Equip) this.equipe.getSac().getObjet(i);
                if (e.getCategorie().equals(Categorie_objet.accessoire)) {
                    this.sac.ajoutObjet(this.equipe.getSac().getObjet(i));
                }
            }
        }
        this.affichage = "accessoire";
        this.pcsControlleurVue.firePropertyChange("afficherMenuObjet", null, null);
        if (this.choix > 8) {
            if (this.affichePersoMenu("qui equiper ?") != 0) {
                if (this.equipe.getPersonnage(this.jeu.getChoix()).getAcc1Equip().equals(this.sac.getObjet(this.choix).getType())) {
                    this.equiperObjet(this.sac);
                }
            }
        }
    }

    public void menuObjet_objetRare() {
        this.sac = new ListeObjet();
        this.affichage = "rare";
        this.pcsControlleurVue.firePropertyChange("afficherMenuObjet", null, null);
    }

    public int affichePersoMenu(String texte) {
        do {
            this.affichage = texte;
            this.pcsControlleurVue.firePropertyChange("affichePerso", null, null);
        } while (this.choix < 0 || this.choix > this.equipe.size());
        return this.choix;
    }

    public void utiliserObjet(ListeObjet objets) {
        if (objets.getObjet(this.choix - 9).getType().equals(TypeObjet.soin_stat)) {
            if (this.equipe.getPerso(this.jeu.getChoix()).enFormeStat()) {
                this.jeu.setAffichage("stat deja au max");
            } else {
                /*this.equipe.getPersonnage(this.jeu.getChoix()).utilObjet(
                        objets.getObjet(this.choix - 9));*/
                objets.utilObjet(this.choix);
            }
        } else {
            if (objets.getObjet(this.choix - 9).getType().equals(TypeObjet.soin_etat)) {
                if (this.equipe.getPerso(this.jeu.getChoix()).enFormeEtat()) {
                    this.jeu.setAffichage("aucune alteration d'etat");
                } else {
                    /*this.equipe.getPersonnage(this.jeu.getChoix()).utilObjet(
                            objets.getObjet(this.choix - 9));*/
                    objets.utilObjet(this.choix);
                }
            } else {
                if (objets.getObjet(this.choix - 9).getType().equals(TypeObjet.soin)) {
                    if (this.equipe.getPerso(this.jeu.getChoix()).enForme()) {
                        this.jeu.setAffichage("stat deja au max et aucune alteration d'etat");
                    } else {
                        /*this.equipe.getPersonnage(this.jeu.getChoix()).utilObjet(
                                objets.getObjet(this.choix - 9));*/
                        objets.utilObjet(this.choix);
                    }
                }
            }
        }
    }

    // ce programme permet de voir les stats et les techniques des personnage
    public void menuTechnique() {
        int a, b;
        this.pcsControlleurVue.firePropertyChange("afficherMenuTechnique", null, null);
        a = this.choix;
        this.affichage = "Quel technique placer ?";
        this.pcsControlleurVue.firePropertyChange("afficherMenuTechnique", null, null);
        b = this.choix;
        this.equipe.getPersonnage(this.choix).getTec().remplaceTec(this.equipe.getPersonnage(this.choix).getAtt().getTechnique(b), a);
    }

    //ce programme permet de voir les quete en cour ou effectuer
    public void menuQuete() {
    }

    //ce programme permet de voir les stats et les equipement des perso
    public void menuEtat() {
        //this.jeu.menuTechnique();
        this.choix = this.jeu.getChoix();
    }

    //ce programme permet de modifier l'equipement de vos perso
    public void menuEquiper() {
        int a, b;
        ListeObjet objets = new ListeObjet();
        //this.jeu.affichePersoMenu(this.equipe, "quel perso choisir ?");
        this.choix = this.jeu.getChoix();
        this.jeu.choix("ou voulez vous vous equiper ?");
        a = this.jeu.getChoix();
        switch (a) {
            case (1):
                for (int i = 0; i < this.equipe.getSac().size(); i++) {
                    if (this.equipe.getSac().getObjet(i) instanceof Equip
                            && this.equipe.getSac().getObjet(i).getType().equals(
                            this.equipe.getPersonnage(this.choix).getMainEquip())) {
                        objets.ajoutObjet(this.equipe.getSac().getObjet(i));
                    }
                }
                //this.jeu.menuObjet(objets, "arme");
                break;
            case (2):
                for (int i = 0; i < this.equipe.getSac().size(); i++) {
                    if (this.equipe.getSac().getObjet(i) instanceof Equip
                            && this.equipe.getSac().getObjet(i).getType().equals(
                            this.equipe.getPersonnage(this.choix).getCorpsEquip())) {
                        objets.ajoutObjet(this.equipe.getSac().getObjet(i));
                    }
                }
                //this.jeu.menuObjet(objets, "armure");
                break;
            case (3):
                for (int i = 0; i < this.equipe.getSac().size(); i++) {
                    if (this.equipe.getSac().getObjet(i) instanceof Equip
                            && this.equipe.getSac().getObjet(i).getType().equals(
                            this.equipe.getPersonnage(this.choix).getTeteEquip())) {
                        objets.ajoutObjet(this.equipe.getSac().getObjet(i));
                    }
                }
                //this.jeu.menuObjet(objets, "chapeau");
                break;
            case (4):
                for (int i = 0; i < this.equipe.getSac().size(); i++) {
                    if (this.equipe.getSac().getObjet(i) instanceof Equip
                            && this.equipe.getSac().getObjet(i).getType().equals(
                            this.equipe.getPersonnage(this.choix).getPiedEquip())) {
                        objets.ajoutObjet(this.equipe.getSac().getObjet(i));
                    }
                }
                //this.jeu.menuObjet(objets, "botte");
                break;
            case (5):
                for (int i = 0; i < this.equipe.getSac().size(); i++) {
                    if (this.equipe.getSac().getObjet(i) instanceof Equip
                            && this.equipe.getSac().getObjet(i).getType().equals(
                            this.equipe.getPersonnage(this.choix).getAcc1Equip())) {
                        objets.ajoutObjet(this.equipe.getSac().getObjet(i));
                    }
                }
                //this.jeu.menuObjet(objets, "accessoire");
                break;
            case (6):
                for (int i = 0; i < this.equipe.getSac().size(); i++) {
                    if (this.equipe.getSac().getObjet(i) instanceof Equip
                            && this.equipe.getSac().getObjet(i).getType().equals(
                            this.equipe.getPersonnage(this.choix).getAcc2Equip())) {
                        objets.ajoutObjet(this.equipe.getSac().getObjet(i));
                    }
                }
                //this.jeu.menuObjet(objets, "accessoire");
                break;

        }
        b = this.jeu.getChoix();
        if (b > 8) {
            this.equiperObjet(objets);
        }
    }

    //ce programme permet de voir vos recette de cuisine
    public void menuCuisine() {
        this.jeu.setAffichage("vous n'avez pas de cuisine");
    }

    //ce programme permet de modifier la configuration du jeu
    public void menuConfiguration() {
        this.jeu.setAffichage("vous ne pouvez pas modifier les configurations");
    }

    public void menuSauvegarder () {
        Connexion c = new Connexion(this.jeu);
        int partie = c.parties();
        this.jeu.setAffichage("sauvegarde en cour, ne pas eteindre");
        c.sauvegarderPartie(partie, this.equipe.getPersonnage(0), this.jeu.getHeureTempsJeu(), this.jeu.getMinuteTempsJeu(),
                this.jeu.getSecondeTempsJeu());
        for (int i=0 ; i<this.jeu.getPersos().size() ; i++) {
            if (this.jeu.getPersos().getD_UNI(i) != null) {
                c.sauvegarderD_UNI(this.jeu.getPersos().getD_UNI(i), partie, equipe);
            }
            if (this.jeu.getPersos().getPersonnage(i) != null) {
                c.sauvegarderPerso(this.jeu.getPersos().getPersonnage(i), partie, equipe);
            }
        }
        c.sauvegarderVille(this.jeu.getCarte_gmm(), partie);

        /*c.sauvegarderEvenement(this.jeu.getEvenementJeu(), partie);
        c.sauvegarderObjet(this.equipe.getSac(), partie);*/
        this.jeu.setAffichage("sauvegarde reussi");
    }

    public void equiperObjet(ListeObjet objets) {
        Equip e;
        e = this.equipe.getPersonnage(this.jeu.getChoix()).equiper((Equip) objets.getObjet(this.choix - 9));
        this.equipe.getSac().ajoutObjet(e);
    }
}
