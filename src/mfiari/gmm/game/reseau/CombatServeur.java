/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.reseau;

import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.perso.Ennemie;
import mfiari.gmm.game.perso.Perso;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mike
 */
public class CombatServeur extends CombatReseau {
    
    public CombatServeur (Socket socket, ListeDePerso equipe, ListeDePerso adversaire, Perso p) {
        super(socket, equipe, adversaire, p);
    }
    
    @Override
    public void combat () {
        try {
        Perso p;
        int indice;
        do {
            this.pcsControlleurVue.firePropertyChange("afficherTerrainCombat", null, null);
            p = this.combat1();
            this.setAffichage("au Tour De " + p.getNom());
            indice = tableau.get(tableau.size() - 1);
            this.envoi.writeObject(indice);
            if (indice < equipe.size()) {
                if (equipe.getPersonnage(indice).getPv() != 0 && adversaire.size() != 0) {
                    if (equipe.getPersonnage(indice).equals(this.votrePerso)) {
                        do {
                            this.pcsControlleurVue.firePropertyChange("afficherMenuJoueur", null, null);
                            this.choixAction = this.choix;
                        } while (this.choixAction < 1 || this.choixAction > 6);
                        combatPerso(equipe.getPersonnage(indice), adversaire, equipe);
                    } else {
                        this.combatAllie(equipe.getPersonnage(indice), adversaire, equipe);
                    }
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
        jeu.gameOver(equipe, adversaire);
        } catch (IOException ex) {
            Logger.getLogger(CombatReseau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected int attaqueReussi(Perso attaquant, Perso attaquer) {
        try {
        // cette fonction permet a l'ennemi d'attaquer un de vos perso
        this.setAffichage(attaquant.getNom() + " attaque " + attaquer.getNom());
        if (this.rate(attaquant)) {
            this.envoi.writeObject(true);
            this.setAffichage(attaquant.getNom() + " rate son attaque.");
            return -1;
        }
        this.envoi.writeObject(false);
        if (this.esquive(attaquant, attaquer)) {
            this.envoi.writeObject(true);
            this.setAffichage(attaquer.getNom() + " esquive l'attaque.");
            return -1;
        }
        this.envoi.writeObject(false);
        } catch (IOException ex) {
            Logger.getLogger(CombatReseau.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    // cette fonction permet de savoir lequel de vos personnage l'ennemi va attaquer
    @Override
    protected void AttaqueEnnemi(Ennemie ennemie, ListeDePerso equipe, ListeDePerso adversaire) {
        try {
        int aleaTec;
        int aleaEtat;
        int aleaEquipe;
        double degat = -1;
        int rate = -1;
        int nbPersoOK = 0;
        do {
            if (this.choixAction == 1) {
                this.envoi.writeObject(this.choixAction);
                this.envoi.writeObject(this.choixPerso);
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
                            this.envoi.writeObject(this.choixAction);
                            this.envoi.writeObject(this.choixPerso);
                            this.envoi.writeObject(this.choixTec);
                            this.envoi.writeObject(aleaTec);
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
                                    this.envoi.writeObject(aleaEtat);
                                    if (aleaEtat == 1) {
                                        this.setAffichage(equipe.getPersonnage(this.choixPerso).getNom() + " est affecté.");
                                        equipe.getPersonnage(this.choixPerso).setEtat(ennemie.getTec().getTechnique(this.choixTec).getEtat());
                                    }
                                }
                                this.verifieKO(equipe.getPersonnage(this.choixPerso));
                            }
                            break;
                        case (2):
                            this.envoi.writeObject(this.choixAction);
                            this.envoi.writeObject(this.choixPerso);
                            this.envoi.writeObject(this.choixTec);
                            this.envoi.writeObject(aleaTec);
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
                                            this.envoi.writeObject(aleaEtat);
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
                            this.envoi.writeObject(this.choixAction);
                            this.envoi.writeObject(this.choixPerso);
                            this.envoi.writeObject(this.choixTec);
                            this.envoi.writeObject(aleaTec);
                            aleaEquipe = (int) (Math.random() * adversaire.size() + 1);
                            this.envoi.writeObject(aleaEquipe);
                            this.setAffichage(ennemie.getNom() + " utilise " + ennemie.getTec().getTechnique(this.choixTec).getNom() + " sur " + 
                                    adversaire.getEnnemie(aleaEquipe - 1).getNom());
                            ennemie.setPm(ennemie.getPm() - ennemie.getTec().getTechnique(this.choixTec).getPmTec());
                            adversaire.getEnnemie(aleaEquipe - 1).recoitSoin(ennemie.getTec().getTechnique(this.choixTec));
                            break;
                        case (4):
                            this.envoi.writeObject(this.choixAction);
                            this.envoi.writeObject(this.choixPerso);
                            this.envoi.writeObject(this.choixTec);
                            this.envoi.writeObject(aleaTec);
                            this.setAffichage(ennemie.getNom() + " utilise " + ennemie.getTec().getTechnique(this.choixTec).getNom());
                            ennemie.setPm(ennemie.getPm() - ennemie.getTec().getTechnique(this.choixTec).getPmTec());
                            for (int i = 0; i < adversaire.size(); i++) {
                                adversaire.getEnnemie(i).recoitSoin(ennemie.getTec().getTechnique(this.choixTec));
                            }
                            break;
                        case (5):
                            this.envoi.writeObject(this.choixAction);
                            this.envoi.writeObject(this.choixPerso);
                            this.envoi.writeObject(this.choixTec);
                            this.envoi.writeObject(aleaTec);
                            this.setAffichage(ennemie.getNom() + " utilise " + ennemie.getTec().getTechnique(this.choixTec).getNom());
                            ennemie.setPm(ennemie.getPm() - ennemie.getTec().getTechnique(this.choixTec).getPmTec());
                            ennemie.recoitSoin(ennemie.getTec().getTechnique(this.choixTec));
                            break;
                        case (6):
                            this.envoi.writeObject(this.choixAction);
                            this.envoi.writeObject(this.choixPerso);
                            this.envoi.writeObject(this.choixTec);
                            this.envoi.writeObject(aleaTec);
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
        } catch (IOException ex) {
            Logger.getLogger(CombatReseau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
