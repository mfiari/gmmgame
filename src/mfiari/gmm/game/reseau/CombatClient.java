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
public class CombatClient extends CombatReseau {
    
    public CombatClient (Socket socket, ListeDePerso equipe, ListeDePerso adversaire, Perso p) {
        super(socket, equipe, adversaire, p);
    }
    
    @Override
    public void combat () {
        int indice;
        do {
            this.pcsControlleurVue.firePropertyChange("afficherTerrainCombat", null, null);
            indice = (Integer)this.recoitObjet();
            if (indice < equipe.size()) {
                if (equipe.getPersonnage(indice).getPv() != 0 && adversaire.size() != 0) {
                    this.persoEnCours = indice;
                    this.setAffichage("au Tour De " + equipe.getPersonnage(indice).getNom());
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
                    this.setAffichage("au Tour De " + ennemieDExp.getEnnemie(indice - equipe.size()).getNom());
                    this.AttaqueEnnemi(ennemieDExp.getEnnemie(indice - equipe.size()), equipe, adversaire);
                }
            }
        } while (adversaire.size() != 0 && !equipe.estKO());
        jeu.gameOver(equipe, adversaire);
    }

    @Override
    protected int attaqueReussi(Perso attaquant, Perso attaquer) {
        // cette fonction permet a l'ennemi d'attaquer un de vos perso
        this.setAffichage(attaquant.getNom() + " attaque " + attaquer.getNom());
        boolean rate = (Boolean)this.recoitObjet();
        if (rate) {
            this.setAffichage(attaquant.getNom() + " rate son attaque.");
            return -1;
        }
        boolean esquive = (Boolean)this.recoitObjet();
        if (esquive) {
            this.setAffichage(attaquer.getNom() + " esquive l'attaque.");
            return -1;
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
        double degat;
        int nbPersoOK = 0;
        this.choixAction = (Integer)this.recoitObjet();
        if (this.choixAction == 1) {
            this.choixPerso = (Integer)this.receveur.readObject();
            if (this.attaqueReussi(ennemie, equipe.getPersonnage(this.choixPerso)) == 0) {
                degat = this.degatAtt(ennemie, equipe.getPersonnage(this.choixPerso));
                if (degat <= 1) {
                    degat = arrondiDegat(equipe.getPersonnage(this.choixPerso), degat);
                }
                this.setAffichage(equipe.getPersonnage(this.choixPerso).getNom() + " reçoit " + (int) Math.round(degat) + " dégat");
                equipe.getPersonnage(this.choixPerso).setPv((equipe.getPersonnage(this.choixPerso).getPv() - degat));
                this.verifieKO(equipe.getPersonnage(this.choixPerso));
            }
        } else if (this.choixAction == 3) {
                this.setAffichage("pas d'objet");
                /*l'ennemie utilise un objet*/
        } else {
            this.choixPerso = (Integer)this.receveur.readObject();
            this.choixTec = (Integer)this.receveur.readObject();
            aleaTec = (Integer)this.receveur.readObject();
            switch (aleaTec) {
                case (1):
                    this.setAffichage(ennemie.getNom() + " utilise " + ennemie.getTec().getTechnique(this.choixTec).getNom() + " sur " + 
                            equipe.getPersonnage(this.choixPerso).getNom());
                    ennemie.setPm(ennemie.getPm() - ennemie.getTec().getTechnique(this.choixTec).getPmTec());
                    if (this.attaqueReussi(ennemie, equipe.getPersonnage(this.choixPerso)) == 0) {
                        degat = degatTec(ennemie, equipe.getPersonnage(this.choixPerso));
                        if (degat <= 1) {
                            degat = this.arrondiDegat(equipe.getPersonnage(this.choixPerso),degat);
                        }
                        this.setAffichage(equipe.getPersonnage(this.choixPerso).getNom() + " reçoit " + (int) Math.round(degat) + " dégat");
                        equipe.getPersonnage(this.choixPerso).setPv((equipe.getPersonnage(this.choixPerso).getPv() - degat));
                        if (ennemie.getTec().getTechnique(this.choixTec).getCategorie().equals("specialU")) {
                            aleaEtat = (Integer)this.receveur.readObject();
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
                            if (this.attaqueReussi(ennemie, equipe.getPersonnage(j)) == 0) {
                                degat = degatTec(ennemie, equipe.getPersonnage(j));
                                degat = degat / nbPersoOK;
                                if (degat <= 1) {
                                    degat = this.arrondiDegat(equipe.getPersonnage(j), degat);
                                }
                                this.setAffichage(equipe.getPersonnage(j).getNom() + " reçoit " + (int) Math.round(degat) + " dégat");
                                equipe.getPersonnage(j).setPv((equipe.getPersonnage(j).getPv() - degat));
                                if (ennemie.getTec().getTechnique(this.choixTec).getCategorie().equals("specialE")) {
                                    aleaEtat = (Integer)this.receveur.readObject();
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
                    aleaEquipe = (Integer)this.receveur.readObject();
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
                    if (this.attaqueReussi(ennemie, equipe.getPersonnage(this.choixPerso)) == 0) {
                        degat = degatTec(ennemie, equipe.getPersonnage(this.choixPerso));
                        if (degat <= 1) {
                            degat = this.arrondiDegat(equipe.getPersonnage(this.choixPerso),degat);
                        }
                        this.setAffichage(equipe.getPersonnage(this.choixPerso).getNom() + " reçoit " + (int) Math.round(degat) + " dégat");
                        equipe.getPersonnage(this.choixPerso).setPv((equipe.getPersonnage(this.choixPerso).getPv() - degat));
                        this.verifieKO(equipe.getPersonnage(this.choixPerso));
                    }
                    break;
            }
        }
        } catch (IOException ex) {
            Logger.getLogger(CombatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}