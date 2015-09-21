/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.reseau;

import mfiari.gmm.game.combat.AbstractCombat;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.objet.TypeObjet;
import mfiari.gmm.game.perso.Ennemie;
import mfiari.gmm.game.perso.Perso;
import mfiari.gmm.game.perso.Personnage;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import mfiari.lib.game.reseau.EnvoiObjet;
import mfiari.lib.game.reseau.ReceveurObjet;

/**
 *
 * @author mike
 */
public abstract class CombatReseau extends AbstractCombat {
    
    protected ReceveurObjet receveur;
    protected EnvoiObjet envoi;
    protected Perso votrePerso;
    
    public CombatReseau (Socket socket, ListeDePerso equipe, ListeDePerso adversaire, Perso p) {
        super(equipe, adversaire);
        this.envoi = new EnvoiObjet(socket);
        this.receveur = new ReceveurObjet(socket);
        this.votrePerso = p;
    }
    
    protected Object recoitObjet() {
        try {
            this.pcsControlleurVue.firePropertyChange("attenteAdv", null, null);
            return this.receveur.readObject();
        } catch (IOException ex) {
            Logger.getLogger(CombatReseau.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public abstract void combat ();

    @Override
    protected abstract int attaqueReussi(Perso attaquant, Perso attaquer);

    // cette fonction permet de savoir lequel de vos personnage l'ennemi va attaquer
    @Override
    protected abstract void AttaqueEnnemi(Ennemie ennemie, ListeDePerso equipe, ListeDePerso adversaire);

    @Override
    protected void combatPerso(Personnage perso, ListeDePerso adversaire, ListeDePerso equipe) {
        try {
        int a = 0;
        int b = 0;
        int c;
        double degat;
        int rate;
        int esq;
        int obs;
        int def;
        int aleaEtat;
        int aleaTec = 0;
        int aleaVole;
        boolean action = false;
        rate = 0;
        esq = 0;
        degat = -1;
        obs = 0;
        c = 0;
        def = 0;
        //perso.setDef(perso.getDefi());
        do {
            switch (this.choixAction) {
                case (1):
                    do {
                        do {
                            this.pcsControlleurVue.firePropertyChange("afficherEnnemies", null, null);
                            b = this.choix;
                        } while (b <= 0 || b > 6);
                        if (b != 6 && b <= adversaire.size() && adversaire.getEnnemie(b - 1).getPv() != 0 && perso.getPv() != 0) {
                            this.envoi.writeObject(this.choixAction);
                            this.envoi.writeObject(b);
                            rate = this.attaqueReussi(perso, adversaire.getEnnemie(b - 1));
                            if (rate == 0) {
                                action = true;
                                degat = this.degatAtt(perso, adversaire.getEnnemie(b - 1));
                                if (degat <= 1) {
                                    degat = arrondiDegat(equipe.getPersonnage(this.choixPerso), degat);
                                }
                                this.setAffichage(adversaire.getEnnemie(b - 1).getNom() + " reçoit " + (int) Math.round(degat) + " dégat");
                                adversaire.getEnnemie(b - 1).setPv((adversaire.getEnnemie(b - 1).getPv() - degat));
                                if (this.verifieKO(adversaire.getEnnemie(b - 1))) {
                                    adversaire.getEnnemie(b - 1).soin();
                                    adversaire.enleverPerso(b - 1);
                                }
                            }
                        }
                    } while (rate == -1 && degat == -1 && b != 6 && !action);
                    break;
                case (2):
                    do {
                        do {
                            do {
                                this.pcsControlleurVue.firePropertyChange("afficherTechniques", null, null);
                                b = this.choix;
                            } while (b < 0 || b > 6);
                            if (b != 0) {
                                this.choixTec = this.choix;
                                aleaTec = this.choixTec(perso);
                            }
                        } while (aleaTec == 0 && b != 0);
                        perso.getAtt().getTechnique(b - 1).setNbUtil();
                        action = true;
                        switch (aleaTec) {
                            case (1):
                                do {
                                    this.pcsControlleurVue.firePropertyChange("afficherEnnemies", null, null);
                                    c = this.choix;
                                } while ((c <= 0 || c > adversaire.size()) && c != 6);
                                this.envoi.writeObject(this.choixAction);
                                this.envoi.writeObject(b);
                                this.envoi.writeObject(this.choixTec);
                                this.envoi.writeObject(aleaTec);
                                this.envoi.writeObject(c);
                                this.setAffichage(perso.getNom() + " utilise " + perso.getTec().getTechnique(b - 1).getNom() + " sur " + 
                                        adversaire.getEnnemie(c - 1).getNom());
                                perso.setPm(perso.getPm() - perso.getAtt().getTechnique(b - 1).getPmTec());
                                if (this.attaqueReussi(perso, adversaire.getEnnemie(b - 1)) == 0) {
                                    degat = degatTec(perso, adversaire.getEnnemie(b - 1));
                                    if (degat <= 1) {
                                        degat = this.arrondiDegat(adversaire.getEnnemie(b - 1), degat);
                                    }
                                    this.setAffichage(adversaire.getEnnemie(b - 1).getNom() + " reçoit " + (int) Math.round(degat) + " dégat");
                                    adversaire.getEnnemie(b - 1).setPv((adversaire.getEnnemie(b - 1).getPv() - degat));
                                    if (perso.getAtt().getTechnique(b - 1).getCategorie().equals("specialU")) {
                                        aleaEtat = (int) (Math.random() * 20 + 1);
                                        this.envoi.writeObject(aleaEtat);
                                        if (aleaEtat == 1) {
                                            this.setAffichage(adversaire.getEnnemie(c - 1).getNom() + " est affecté.");
                                            adversaire.getEnnemie(c - 1).setEtat(perso.getAtt().getTechnique(b - 1).getEtat());
                                        }
                                    }
                                    if (this.verifieKO(adversaire.getEnnemie(c - 1))) {
                                        adversaire.getEnnemie(c - 1).soin();
                                        adversaire.enleverPerso(c - 1);
                                    }
                                }
                                break;
                            case (2):
                                /*do {
                                    this.pcsControlleurVue.firePropertyChange("afficherEnnemies", null, null);
                                    c = this.choix;
                                } while ((c <= 0 || c > adversaire.size()) && c != 6);*/
                                this.envoi.writeObject(this.choixAction);
                                this.envoi.writeObject(b);
                                this.envoi.writeObject(this.choixTec);
                                this.envoi.writeObject(aleaTec);
                                this.setAffichage(perso.getNom() + " utilise " + perso.getTec().getTechnique(b - 1).getNom());
                                perso.setPm(perso.getPm() - perso.getAtt().getTechnique(b - 1).getPmTec());
                                for (int i = 0; i < adversaire.size(); i++) {
                                    if (this.attaqueReussi(perso, adversaire.getEnnemie(i)) == 0) {
                                        degat = degatTec(perso, adversaire.getEnnemie(i));
                                        degat = degat / adversaire.size();
                                        if (degat <= 1) {
                                            degat = this.arrondiDegat(adversaire.getEnnemie(i), degat);
                                        }
                                        if (perso.getAtt().getTechnique(b - 1).getCategorie().equals("specialE")) {
                                            aleaEtat = (int) (Math.random() * 20 + 1);
                                            this.envoi.writeObject(aleaEtat);
                                            if (aleaEtat == 1) {
                                                this.setAffichage(adversaire.getEnnemie(i).getNom() + " est affecté.");
                                                adversaire.getEnnemie(i).setEtat(perso.getAtt().getTechnique(b - 1).getEtat());
                                            }
                                        }
                                        if (this.verifieKO(adversaire.getEnnemie(i))) {
                                            adversaire.getEnnemie(i).soin();
                                            adversaire.enleverPerso(i);
                                        }
                                    }
                                }
                                break;
                            case (3):
                                do {
                                    this.affichage = "sur qui utiliser?";
                                    this.pcsControlleurVue.firePropertyChange("afficherEquipe", null, null);
                                    c = this.choix;
                                } while ((c <= 0 || c > equipe.size()) && c != 6);
                                this.setAffichage(perso.getNom() + " utilise " + perso.getTec().getTechnique(b - 1).getNom() + " sur " + 
                                        equipe.getPersonnage(c - 1).getNom());
                                perso.setPm(perso.getPm() - perso.getAtt().getTechnique(b - 1).getPmTec());
                                equipe.getPersonnage(c - 1).recoitSoin(perso.getAtt().getTechnique(b - 1), perso);
                                break;
                            case (4):
                                this.setAffichage(perso.getNom() + " utilise " + perso.getTec().getTechnique(b - 1).getNom());
                                perso.setPm(perso.getPm() - perso.getAtt().getTechnique(b - 1).getPmTec());
                                for (int i = 0; i < equipe.size(); i++) {
                                    equipe.getPersonnage(i).recoitSoin(perso.getAtt().getTechnique(b - 1), perso);
                                }
                                break;
                            case (5):
                                this.setAffichage(perso.getNom() + " utilise " + perso.getTec().getTechnique(b - 1).getNom());
                                perso.setPm(perso.getPm() - perso.getAtt().getTechnique(b - 1).getPmTec());
                                perso.recoitSoin(perso.getAtt().getTechnique(b - 1), perso);
                                break;
                            case (6):
                                do {
                                    this.pcsControlleurVue.firePropertyChange("afficherEnnemies", null, null);
                                    c = this.choix;
                                } while ((c <= 0 || c > adversaire.size()) && c != 6);
                                this.setAffichage(perso.getNom() + " utilise " + perso.getTec().getTechnique(b - 1).getNom() + " sur " + 
                                        adversaire.getEnnemie(c - 1).getNom());
                                perso.setPm(perso.getPm() - perso.getAtt().getTechnique(b - 1).getPmTec());
                                if (this.attaqueReussi(perso, adversaire.getEnnemie(c - 1)) == 0) {
                                    degat = degatTec(perso, adversaire.getEnnemie(c - 1));
                                    if (degat <= 1) {
                                        degat = this.arrondiDegat(adversaire.getEnnemie(c - 1), degat);
                                    }
                                    if (adversaire.getEnnemie(c - 1).vole()) {
                                        aleaVole = (int) (Math.random() * 10 + 1);
                                        if (aleaVole > 5) {
                                            this.setAffichage("vole raté");
                                        } else {
                                            if (aleaVole == 1 || aleaVole == 2 || aleaVole == 4) {
                                                if (adversaire.getEnnemie(c - 1).volObjetNul(aleaVole) == null) {
                                                    this.setAffichage("vole raté");
                                                } else {
                                                    equipe.getSac().acheter(perso.voleObjet(adversaire.getEnnemie(c - 1), aleaVole), 1);
                                                }
                                            } else {
                                                if (adversaire.getEnnemie(c - 1).volEquipNul(aleaVole) == null) {
                                                    this.setAffichage("vole raté");
                                                } else {
                                                    perso.voleEquip(adversaire.getEnnemie(c - 1), aleaVole);
                                                }
                                            }
                                        }
                                    } else {
                                        this.setAffichage("rien à voler");
                                    }
                                    if (this.verifieKO(adversaire.getEnnemie(c - 1))) {
                                        adversaire.getEnnemie(c - 1).soin();
                                        adversaire.enleverPerso(c - 1);
                                    }
                                }
                                break;
                        }
                    } while (b != 7 && rate == 0 && esq == 0 && degat == 0 && !action);
                    break;
                case (3):
                    do {
                        this.pcsControlleurVue.firePropertyChange("afficherEnnemies", null, null);
                        b = this.choix;
                    } while (b <= 0 || b > 6);
                    //cette fonction permet d'examiner un ennemi pendant un combat
                    if (b <= adversaire.size() && adversaire.getEnnemie(b - 1).getPv() != 0 && perso.getPv() != 0) {
                        obs = 1;
                        action = true;
                        this.setAffichage(perso.getNom() + " examine " + adversaire.getEnnemie(b - 1).getNom());
                        this.setAffichage(adversaire.getEnnemie(b - 1).getNom() + "\n pv :"
                                + adversaire.getEnnemie(b - 1).getPv() + "/" + adversaire.getEnnemie(b - 1).getPvi()
                                + "\n pm :" + adversaire.getEnnemie(b - 1).getPm() + "/" + adversaire.getEnnemie(b - 1).getPmi());
                    }
                    break;
                case (4):
                    do {
                        this.pcsControlleurVue.firePropertyChange("afficherObjetCombat", null, null);
                        b = this.choix;
                        if (b > -1 && b <= equipe.getSac().size() && b != 0) {
                            this.setAffichage(equipe.getSac().getObjet(b - 1).toString());
                            do {
                                this.affichage = "sur qui utiliser?";
                                this.pcsControlleurVue.firePropertyChange("afficherEquipe", null, null);
                                c = this.choix;
                            } while (c > equipe.size() || c < 0);
                            if (c != 0) {
                                action = true;
                                if (equipe.getSac().getObjet(b - 1).getType().equals(TypeObjet.soin)) {
                                    if (!equipe.getPersonnage(c - 1).enForme()) {
                                        this.setAffichage(perso.getNom() + " utilise " + equipe.getSac().getObjet(b - 1).getNom() + " sur " + 
                                        equipe.getPersonnage(c - 1).getNom());
                                        //equipe.getPersonnage(c - 1).utilObjet(equipe.getSac().getObjet(b - 1));
                                        equipe.getSac().utilObjet(b - 1);
                                    } else {
                                        this.setAffichage(this.jeu.getTextes().dejaEnForme(equipe.getPersonnage(c - 1).getNom()));
                                    }
                                } else {
                                    if (equipe.getSac().getObjet(b - 1).getType().equals(TypeObjet.soin_stat)) {
                                        if (!equipe.getPersonnage(c - 1).enFormeStat()) {
                                            //equipe.getPersonnage(c - 1).utilObjet(equipe.getSac().getObjet(b - 1));
                                            equipe.getSac().utilObjet(b - 1);
                                            this.setAffichage(perso.getNom() + " utilise " + equipe.getSac().getObjet(b - 1).getNom() + " sur " + 
                                                equipe.getPersonnage(c - 1).getNom());
                                        } else {
                                            this.setAffichage(equipe.getPersonnage(c - 1).getNom() + " est déjà en forme");
                                        }
                                    }
                                    if (equipe.getSac().getObjet(b - 1).getType().equals(TypeObjet.soin_etat)) {
                                        if (!equipe.getPersonnage(c - 1).enFormeEtat()) {
                                            //equipe.getPersonnage(c - 1).utilObjet(equipe.getSac().getObjet(b - 1));
                                            equipe.getSac().utilObjet(b - 1);
                                            this.setAffichage(perso.getNom() + " utilise " + equipe.getSac().getObjet(b - 1).getNom() + " sur " + 
                                                equipe.getPersonnage(c - 1).getNom());
                                        } else {
                                            this.setAffichage(equipe.getPersonnage(c - 1).getNom() + " est déjà en forme");
                                        }
                                    }
                                }
                            }
                        }
                        if (b==0) {
                            action=true;
                        }
                    } while (b != 0 && !action);
                    if (b==0) {
                        action=false;
                    }
                    break;
                case (5):
                    perso.setDef(perso.getDef() + (perso.getDef() / 2));
                    this.setAffichage(perso.getNom() + " se met en garde");
                    def = 1;
                    action = true;
                    break;
                case (6):
                    do {
                        /*System.out.println(perso.getPerso());
                        System.out.println("0.quitter");
                        b = sc.nextInt();*/
                        b = 0;
                    } while (b != 0);
                    break;
            }
        } while (rate == 0 && obs == 0 && esq == 0 && degat == -1 && def == 0 && !action);
        } catch (IOException ex) {
            Logger.getLogger(CombatReseau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void combatAllie(Personnage perso, ListeDePerso adversaire, ListeDePerso equipe) {
        int b;
        int c;
        double degat;
        int aleaEtat;
        int aleaTec;
        int aleaVole;
        this.choixAction = (Integer)this.recoitObjet();
        switch (this.choixAction) {
            case (1):
                b = (Integer)this.recoitObjet();
                if (this.attaqueReussi(perso, adversaire.getEnnemie(b - 1)) == 0) {
                    degat = this.degatAtt(perso, adversaire.getEnnemie(b - 1));
                    if (degat <= 1) {
                        degat = arrondiDegat(equipe.getPersonnage(this.choixPerso), degat);
                    }
                    this.setAffichage(adversaire.getEnnemie(b - 1).getNom() + " reçoit " + (int) Math.round(degat) + " dégat");
                    adversaire.getEnnemie(b - 1).setPv((adversaire.getEnnemie(b - 1).getPv() - degat));
                    if (this.verifieKO(adversaire.getEnnemie(b - 1))) {
                        adversaire.getEnnemie(b - 1).soin();
                        adversaire.enleverPerso(b - 1);
                    }
                }
                break;
            case (2):
                b = (Integer)this.recoitObjet();
                this.choixTec = (Integer)this.recoitObjet();
                aleaTec = (Integer)this.recoitObjet();
                switch (aleaTec) {
                    case (1):
                        c = (Integer)this.recoitObjet();
                        this.setAffichage(perso.getNom() + " utilise " + perso.getTec().getTechnique(b - 1).getNom() + " sur " + 
                                adversaire.getEnnemie(c - 1).getNom());
                        perso.setPm(perso.getPm() - perso.getAtt().getTechnique(b - 1).getPmTec());
                        if (this.attaqueReussi(perso, adversaire.getEnnemie(b - 1)) == 0) {
                            degat = degatTec(perso, adversaire.getEnnemie(b - 1));
                            if (degat <= 1) {
                                degat = this.arrondiDegat(adversaire.getEnnemie(b - 1), degat);
                            }
                            this.setAffichage(adversaire.getEnnemie(b - 1).getNom() + " reçoit " + (int) Math.round(degat) + " dégat");
                            adversaire.getEnnemie(b - 1).setPv((adversaire.getEnnemie(b - 1).getPv() - degat));
                            if (perso.getAtt().getTechnique(b - 1).getCategorie().equals("specialU")) {
                                aleaEtat = (Integer)this.recoitObjet();
                                if (aleaEtat == 1) {
                                    this.setAffichage(adversaire.getEnnemie(c - 1).getNom() + " est affecté.");
                                    adversaire.getEnnemie(c - 1).setEtat(perso.getAtt().getTechnique(b - 1).getEtat());
                                }
                            }
                            if (this.verifieKO(adversaire.getEnnemie(c - 1))) {
                                adversaire.getEnnemie(c - 1).soin();
                                adversaire.enleverPerso(c - 1);
                            }
                        }
                        break;
                    case (2):
                        this.setAffichage(perso.getNom() + " utilise " + perso.getTec().getTechnique(b - 1).getNom());
                        perso.setPm(perso.getPm() - perso.getAtt().getTechnique(b - 1).getPmTec());
                        for (int i = 0; i < adversaire.size(); i++) {
                            if (this.attaqueReussi(perso, adversaire.getEnnemie(i)) == 0) {
                                degat = degatTec(perso, adversaire.getEnnemie(i));
                                degat = degat / adversaire.size();
                                if (degat <= 1) {
                                    degat = this.arrondiDegat(adversaire.getEnnemie(i), degat);
                                }
                                this.setAffichage(adversaire.getEnnemie(i).getNom() + " reçoit " + (int) Math.round(degat) + " dégat");
                                adversaire.getEnnemie(i).setPv((adversaire.getEnnemie(i).getPv() - degat));
                                if (perso.getAtt().getTechnique(b - 1).getCategorie().equals("specialE")) {
                                    aleaEtat = (Integer)this.recoitObjet();
                                    if (aleaEtat == 1) {
                                        this.setAffichage(adversaire.getEnnemie(i).getNom() + " est affecté.");
                                        adversaire.getEnnemie(i).setEtat(perso.getAtt().getTechnique(b - 1).getEtat());
                                    }
                                }
                                if (this.verifieKO(adversaire.getEnnemie(i))) {
                                    adversaire.getEnnemie(i).soin();
                                    adversaire.enleverPerso(i);
                                }
                            }
                        }
                        break;
                    case (3):
                        c = (Integer)this.recoitObjet();
                        this.setAffichage(perso.getNom() + " utilise " + perso.getTec().getTechnique(b - 1).getNom() + " sur " + 
                                equipe.getPersonnage(c - 1).getNom());
                        perso.setPm(perso.getPm() - perso.getAtt().getTechnique(b - 1).getPmTec());
                        equipe.getPersonnage(c - 1).recoitSoin(perso.getAtt().getTechnique(b - 1), perso);
                        break;
                    case (4):
                        this.setAffichage(perso.getNom() + " utilise " + perso.getTec().getTechnique(b - 1).getNom());
                        perso.setPm(perso.getPm() - perso.getAtt().getTechnique(b - 1).getPmTec());
                        for (int i = 0; i < equipe.size(); i++) {
                            equipe.getPersonnage(i).recoitSoin(perso.getAtt().getTechnique(b - 1), perso);
                        }
                        break;
                    case (5):
                        this.setAffichage(perso.getNom() + " utilise " + perso.getTec().getTechnique(b - 1).getNom());
                        perso.setPm(perso.getPm() - perso.getAtt().getTechnique(b - 1).getPmTec());
                        perso.recoitSoin(perso.getAtt().getTechnique(b - 1), perso);
                        break;
                    case (6):
                        c = (Integer)this.recoitObjet();
                        this.setAffichage(perso.getNom() + " utilise " + perso.getTec().getTechnique(b - 1).getNom() + " sur " + 
                                adversaire.getEnnemie(c - 1).getNom());
                        perso.setPm(perso.getPm() - perso.getAtt().getTechnique(b - 1).getPmTec());
                        if (this.attaqueReussi(perso, adversaire.getEnnemie(c - 1)) == 0) {
                            degat = degatTec(perso, adversaire.getEnnemie(c - 1));
                            if (degat <= 1) {
                                degat = this.arrondiDegat(adversaire.getEnnemie(c - 1), degat);
                            }
                            if (adversaire.getEnnemie(c - 1).vole()) {
                                aleaVole = (Integer)this.recoitObjet();
                                if (aleaVole > 5) {
                                    this.setAffichage("vole raté");
                                } else {
                                    if (aleaVole == 1 || aleaVole == 2 || aleaVole == 4) {
                                        if (adversaire.getEnnemie(c - 1).volObjetNul(aleaVole) == null) {
                                            this.setAffichage("vole raté");
                                        } else {
                                            equipe.getSac().acheter(perso.voleObjet(adversaire.getEnnemie(c - 1), aleaVole), 1);
                                        }
                                    } else {
                                        if (adversaire.getEnnemie(c - 1).volEquipNul(aleaVole) == null) {
                                            this.setAffichage("vole raté");
                                        } else {
                                            perso.voleEquip(adversaire.getEnnemie(c - 1), aleaVole);
                                        }
                                    }
                                }
                            } else {
                                this.setAffichage("rien à voler");
                            }
                            if (this.verifieKO(adversaire.getEnnemie(c - 1))) {
                                adversaire.getEnnemie(c - 1).soin();
                                adversaire.enleverPerso(c - 1);
                            }
                        }
                        break;
                }
                break;
            case (3):
                //cette fonction permet d'examiner un ennemi pendant un combat
                b = (Integer)this.recoitObjet();
                this.setAffichage(perso.getNom() + " examine " + adversaire.getEnnemie(b - 1).getNom());
                this.setAffichage(adversaire.getEnnemie(b - 1).getNom() + "\n pv :"
                        + adversaire.getEnnemie(b - 1).getPv() + "/" + adversaire.getEnnemie(b - 1).getPvi()
                        + "\n pm :" + adversaire.getEnnemie(b - 1).getPm() + "/" + adversaire.getEnnemie(b - 1).getPmi());
                break;
            case (4):
                b = (Integer)this.recoitObjet();
                c = (Integer)this.recoitObjet();
                if (equipe.getSac().getObjet(b - 1).getType().equals(TypeObjet.soin)) {
                    if (!equipe.getPersonnage(c - 1).enForme()) {
                        this.setAffichage(perso.getNom() + " utilise " + equipe.getSac().getObjet(b - 1).getNom() + " sur " + 
                        equipe.getPersonnage(c - 1).getNom());
                        //equipe.getPersonnage(c - 1).utilObjet(equipe.getSac().getObjet(b - 1));
                        equipe.getSac().utilObjet(b - 1);
                    } else {
                        this.setAffichage(this.jeu.getTextes().dejaEnForme(equipe.getPersonnage(c - 1).getNom()));
                    }
                } else {
                    if (equipe.getSac().getObjet(b - 1).getType().equals(TypeObjet.soin_stat)) {
                        if (!equipe.getPersonnage(c - 1).enFormeStat()) {
                            //equipe.getPersonnage(c - 1).utilObjet(equipe.getSac().getObjet(b - 1));
                            equipe.getSac().utilObjet(b - 1);
                            this.setAffichage(perso.getNom() + " utilise " + equipe.getSac().getObjet(b - 1).getNom() + " sur " + 
                                equipe.getPersonnage(c - 1).getNom());
                        } else {
                            this.setAffichage(equipe.getPersonnage(c - 1).getNom() + " est déjà en forme");
                        }
                    }
                    if (equipe.getSac().getObjet(b - 1).getType().equals(TypeObjet.soin_etat)) {
                        if (!equipe.getPersonnage(c - 1).enFormeEtat()) {
                            //equipe.getPersonnage(c - 1).utilObjet(equipe.getSac().getObjet(b - 1));
                            equipe.getSac().utilObjet(b - 1);
                            this.setAffichage(perso.getNom() + " utilise " + equipe.getSac().getObjet(b - 1).getNom() + " sur " + 
                                equipe.getPersonnage(c - 1).getNom());
                        } else {
                            this.setAffichage(equipe.getPersonnage(c - 1).getNom() + " est déjà en forme");
                        }
                    }
                }
                break;
            case (5):
                perso.setDef(perso.getDef() + (perso.getDef() / 2));
                this.setAffichage(perso.getNom() + " se met en garde");
                break;
            case (6):
                break;
        }
    }
}