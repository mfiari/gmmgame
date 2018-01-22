/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.combat;

import mfiari.gmm.game.GmmJeu;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.objet.TypeObjet;
import mfiari.gmm.game.perso.Ennemie;
import mfiari.gmm.game.perso.Perso;
import mfiari.gmm.game.perso.Personnage;

/**
 *
 * @author mike
 */
public class Combat extends AbstractCombat {

    public Combat() {
        super();
    }

    public Combat(ListeDePerso equipe, ListeDePerso adversaire, GmmJeu jeu, boolean evenement) {
        super(equipe, adversaire, jeu, evenement);
    }

    public Combat(ListeDePerso equipe, ListeDePerso adversaire) {
        super(equipe, adversaire);
    }
    
    @Override
    public void combat () {
        Perso p;
        int indice;
        boolean reussi=false;
        do {
            this.pcsControlleurVue.firePropertyChange("afficherTerrainCombat", null, null);
            p = this.combat1();
            this.setAffichage("au Tour De " + p.getNom());
            indice = tableau.get(tableau.size() - 1);
            if (indice < equipe.size()) {
                if (equipe.getPersonnage(indice).getPv() != 0 && adversaire.size() != 0) {
                    do {
                        this.pcsControlleurVue.firePropertyChange("afficherMenuJoueur", null, null);
                        this.choixAction = this.choix;
                    } while (this.choixAction < 1 || this.choixAction > 6);
                    combatPerso(equipe.getPersonnage(indice), adversaire, equipe);
                }
            } else {
                if (adversaire.contains(ennemieDExp.getEnnemie(indice - equipe.size())) && (!equipe.estKO())) {
                    this.choixActionEnnemi(ennemieDExp.getEnnemie(indice - equipe.size()), equipe, adversaire);
                     AttaqueEnnemi(ennemieDExp.getEnnemie(indice - equipe.size()), equipe, adversaire);
                }
            }
            if (this.tableau.size() == this.equipe.size() + this.ennemieDExp.size()) {
                while (!tableau.isEmpty()) {
                    tableau.remove(0);
                }
            }
        } while (adversaire.size() != 0 && !equipe.estKO());
        if (this.jeu != null) {
            jeu.gameOver(equipe, adversaire);
        }
    }

    @Override
    protected int attaqueReussi(Perso attaquant, Perso attaquer) {
        // cette fonction permet a l'ennemi d'attaquer un de vos perso
        this.setAffichage(attaquant.getNom() + " attaque " + attaquer.getNom());
        if (this.rate(attaquant)) {
            this.setAffichage(attaquant.getNom() + " rate son attaque.");
            return -1;
        }
        if (this.esquive(attaquant, attaquer)) {
            this.setAffichage(attaquer.getNom() + " esquive l'attaque.");
            return -1;
        }
        return 0;
    }

    // cette fonction permet de savoir lequel de vos personnage l'ennemi va attaquer
    @Override
    protected void AttaqueEnnemi(Ennemie ennemie, ListeDePerso equipe, ListeDePerso adversaire) {
        int aleaTec;
        int aleaEtat;
        int aleaEquipe;
        double degat = -1;
        int rate = -1;
        int nbPersoOK = 0;
        do {
            if (this.choixAction == 1) {
                rate = this.attaqueReussi(ennemie, equipe.getPersonnage(this.choixPerso));
                if (rate == 0) {
                    degat = this.degatAtt(ennemie, equipe.getPersonnage(this.choixPerso));
                    if (degat <= 1) {
                        degat = arrondiDegat(equipe.getPersonnage(this.choixPerso), degat);
                    }
                    this.setAffichage(equipe.getPersonnage(this.choixPerso).getNom() + " reçoit " + (int) Math.round(degat) + " dégat");
                    equipe.getPersonnage(this.choixPerso).setPv((equipe.getPersonnage(this.choixPerso).getPv() - degat));
                    this.verifieKO(equipe.getPersonnage(this.choixPerso));
                } else {
                    degat = 0;
                }
            } else {
                if (this.choixAction == 3) {
                    this.setAffichage("pas d'objet");
                    this.choixActionEnnemi(ennemie, equipe, adversaire);
                    /*l'ennemie utilise un objet*/
                } else {
                    do {
                        choixTec = (int) (Math.random() * 10 + 1);
                        aleaTec = this.choixTec(ennemie);
                    } while (aleaTec == 0 && ennemie.getTec().size()!=0);
                    switch (aleaTec) {
                        case (1):
                            this.setAffichage(ennemie.getNom() + " utilise " + ennemie.getTec().getTechnique(this.choixTec).getNom() + " sur " + 
                                    equipe.getPersonnage(this.choixPerso).getNom());
                            ennemie.setPm(ennemie.getPm() - ennemie.getTec().getTechnique(this.choixTec).getPmTec());
                            rate = this.attaqueReussi(ennemie, equipe.getPersonnage(this.choixPerso));
                            if (rate == 0) {
                                degat = degatTec(ennemie, equipe.getPersonnage(this.choixPerso));
                                if (degat <= 1) {
                                    degat = this.arrondiDegat(equipe.getPersonnage(this.choixPerso),degat);
                                }
                                if (ennemie.getTec().getTechnique(this.choixTec).getCategorie().equals("specialU")) {
                                    aleaEtat = (int) (Math.random() * 20 + 1);
                                    if (aleaEtat == 1) {
                                        this.setAffichage(equipe.getPersonnage(this.choixPerso).getNom() + " est affecté.");
                                        equipe.getPersonnage(this.choixPerso).setEtat(ennemie.getTec().getTechnique(this.choixTec).getEtat());
                                    }
                                }
                                this.verifieKO(equipe.getPersonnage(this.choixPerso));
                            }
                            break;
                        case (2):
                            this.setAffichage(ennemie.getNom() + " utilise " + ennemie.getTec().getTechnique(this.choixTec).getNom());
                            ennemie.setPm(ennemie.getPm() - ennemie.getTec().getTechnique(this.choixTec).getPmTec());
                            for (int i = 0; i < equipe.size(); i++) {
                                if (equipe.getPersonnage(i).getPv() != 0) {
                                    nbPersoOK++;
                                }
                            }
                            for (int j = 0; j < equipe.size(); j++) {
                                if (equipe.getPersonnage(j).getPv() != 0) {
                                    rate = this.attaqueReussi(ennemie, equipe.getPersonnage(j));
                                    if (rate == 0) {
                                        degat = degatTec(ennemie, equipe.getPersonnage(this.choixPerso));
                                        degat = degat / nbPersoOK;
                                        if (degat <= 1) {
                                            degat = this.arrondiDegat(equipe.getPersonnage(j), degat);
                                        }
                                        if (ennemie.getTec().getTechnique(this.choixTec).getCategorie().equals("specialE")) {
                                            aleaEtat = (int) (Math.random() * 20 + 1);
                                            if (aleaEtat == 1) {
                                                this.setAffichage(equipe.getPersonnage(j).getNom() + " est affecté.");
                                                equipe.getPersonnage(j).setEtat(ennemie.getTec().getTechnique(this.choixTec).getEtat());
                                            }
                                        }
                                        this.verifieKO(equipe.getPersonnage(j));
                                    }
                                }
                            }
                            break;
                        case (3):
                            aleaEquipe = (int) (Math.random() * adversaire.size() + 1);
                            this.setAffichage(ennemie.getNom() + " utilise " + ennemie.getTec().getTechnique(this.choixTec).getNom() + " sur " + 
                                    adversaire.getEnnemie(aleaEquipe - 1).getNom());
                            ennemie.setPm(ennemie.getPm() - ennemie.getTec().getTechnique(this.choixTec).getPmTec());
                            adversaire.getEnnemie(aleaEquipe - 1).recoitSoin(ennemie.getTec().getTechnique(this.choixTec));
                            break;
                        case (4):
                            this.setAffichage(ennemie.getNom() + " utilise " + ennemie.getTec().getTechnique(this.choixTec).getNom());
                            ennemie.setPm(ennemie.getPm() - ennemie.getTec().getTechnique(this.choixTec).getPmTec());
                            for (int i = 0; i < adversaire.size(); i++) {
                                adversaire.getEnnemie(i).recoitSoin(ennemie.getTec().getTechnique(this.choixTec));
                            }
                            break;
                        case (5):
                            this.setAffichage(ennemie.getNom() + " utilise " + ennemie.getTec().getTechnique(this.choixTec).getNom());
                            ennemie.setPm(ennemie.getPm() - ennemie.getTec().getTechnique(this.choixTec).getPmTec());
                            ennemie.recoitSoin(ennemie.getTec().getTechnique(this.choixTec));
                            break;
                        case (6):
                            this.setAffichage(ennemie.getNom() + " utilise " + ennemie.getTec().getTechnique(this.choixTec).getNom() + " sur " + 
                                    equipe.getPersonnage(this.choixPerso).getNom());
                            ennemie.setPm(ennemie.getPm() - ennemie.getTec().getTechnique(this.choixTec).getPmTec());
                            rate = this.attaqueReussi(ennemie, equipe.getPersonnage(this.choixPerso));
                            if (rate == 0) {
                                degat = degatTec(ennemie, equipe.getPersonnage(this.choixPerso));
                                if (degat <= 1) {
                                    degat = this.arrondiDegat(equipe.getPersonnage(this.choixPerso),degat);
                                }
                                this.verifieKO(equipe.getPersonnage(this.choixPerso));
                            }
                            break;
                        default:
                            this.setAffichage("pas de technique");
                            this.choixActionEnnemi(ennemie, equipe, adversaire);
                            break;
                    }
                }
            }
        } while (rate == -1 && degat == -1);
    }

    @Override
    protected void combatPerso(Personnage perso, ListeDePerso adversaire, ListeDePerso equipe) {
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
                                do {
                                    this.pcsControlleurVue.firePropertyChange("afficherEnnemies", null, null);
                                    c = this.choix;
                                } while ((c <= 0 || c > adversaire.size()) && c != 6);
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
    }
    
}
