/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.combat;

import mfiari.gmm.game.evenement.EvenementCombat;
import mfiari.gmm.game.GmmJeu;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.perso.Ennemie;
import mfiari.gmm.game.perso.Perso;
import mfiari.gmm.game.perso.Personnage;
import mfiari.gmm.game.technique.Types;
import java.util.ArrayList;
import mfiari.lib.game.condition.Condition;
import mfiari.lib.game.condition.ConditionAttaque;
import mfiari.lib.game.condition.ConditionDefense;
import mfiari.lib.game.condition.ConditionDegat;
import mfiari.lib.game.condition.ConditionFinDeTour;
import mfiari.lib.game.condition.ConditionObjet;
import mfiari.lib.game.condition.ConditionPrimaire;
import mfiari.lib.game.condition.ConditionSecondaire;
import mfiari.lib.game.controlleur.ControlleurVue;
import mfiari.lib.game.liste.ListeDeGens;
import mfiari.lib.game.personnage.Gens;

/**
 *
 * @author mike
 */
public abstract class AbstractCombat extends ControlleurVue {

    protected GmmJeu jeu;
    protected ListeDePerso equipe;
    protected ListeDePerso adversaire;
    protected ListeDePerso ennemieDExp;
    protected ArrayList<Integer> tableau;
    protected int choixPerso;
    protected int choixAction;
    protected int choixTec;
    protected String affichage;
    protected int persoEnCours;

    public AbstractCombat() {
        this.adversaire = new ListeDePerso();
        this.ennemieDExp = new ListeDePerso();
        this.equipe = new ListeDePerso();
        tableau = new ArrayList<>();
    }
    
    public ListeDePerso getEquipe () {
        return this.equipe;
    }
    
    public ListeDePerso getAdversaires () {
        return this.adversaire;
    }
    
    public String getAffichage () {
        return this.affichage;
    }
    
    public void setAffichage (String affichage) {
        this.affichage = affichage;
        this.pcsControlleurVue.firePropertyChange("affichage", null, null);
    }
    
    public Personnage getPersoEnCours () {
        return this.equipe.getPersonnage(this.persoEnCours);
    }

    public AbstractCombat(ListeDePerso equipe, ListeDePerso adversaire, GmmJeu jeu, boolean evenement) {
        this.jeu = jeu;
        this.adversaire = adversaire;
        this.equipe = equipe;
        this.ennemieDExp = new ListeDePerso();
        for (int i = 0; i < this.adversaire.size(); i++) {
            this.ennemieDExp.ajouterPerso(this.adversaire.getEnnemie(i));
        }
        tableau = new ArrayList<>();
    }

    public AbstractCombat(ListeDePerso equipe, ListeDePerso adversaire) {
        this.adversaire = adversaire;
        this.equipe = equipe;
        this.ennemieDExp = new ListeDePerso();
        for (int i = 0; i < this.adversaire.size(); i++) {
            this.ennemieDExp.ajouterPerso(this.adversaire.getEnnemie(i));
        }
        tableau = new ArrayList<>();
    }
    
    public void combat2(EvenementCombat evenementCombat) {
        Perso p;
        int indice;
        EvenementCombat evenCbt = null;
        Condition derniereConditionEffectuer = null;
        boolean reussi=false;
        this.pcsControlleurVue.firePropertyChange("afficherTerrainCombat", null, null);
        do {
            if (evenementCombat != null) {
                if (!evenementCombat.equals(evenCbt)) {
                    evenCbt = evenementCombat;
                    derniereConditionEffectuer = evenCbt.getCondition();
                    if (evenCbt.getDialogue() != null) {
                        ListeDeGens<Gens> evenDiaParole = evenCbt.getDialogue().getGens();
                        for (int i = 0; i < evenDiaParole.size(); i++) {
                            String str = evenDiaParole.getPerso(i).Parler();
                            while (!str.isEmpty()) {
                                this.jeu.setParole(str);
                                str = evenDiaParole.getPerso(i).Parler();
                            }
                        }
                    }
                }
            }
            //this.jeu.afficherTerrainCombat(equipe, adversaire);
            p = this.combat1();
            this.setAffichage(this.jeu.getTextes().auTourDe(p.getNom()));
            indice = tableau.get(tableau.size() - 1);
            if (indice < equipe.size()) {
                if (equipe.getPersonnage(indice).getPv() != 0 && adversaire.size() != 0) {
                    do {
                        do {
                            this.pcsControlleurVue.firePropertyChange("afficherMenuJoueur", null, null);
                            this.choixAction = this.choix;
                        } while (this.choixAction < 1 || this.choixAction > 6);
                        if (evenementCombat != null) {
                            if (evenCbt.getCondition() instanceof ConditionPrimaire) {
                                if (evenCbt.getCondition().equals(this.getConditionAction(
                                        this.choixAction))) {
                                    combatPerso(equipe.getPersonnage(indice), adversaire, equipe);
                                    evenCbt.conditionReussi();
                                } else {
                                    ListeDeGens<Gens> evenDiaParole = evenCbt.getWarning().getGens();
                                    for (int i = 0; i < evenDiaParole.size(); i++) {
                                        String str = evenDiaParole.getPerso(i).Parler();
                                        while (!str.isEmpty()) {
                                            this.jeu.setParole(str);
                                            str = evenDiaParole.getPerso(i).Parler();
                                        }
                                    }
                                }
                            } else {
                                combatPerso(equipe.getPersonnage(indice), adversaire, equipe);
                            }
                        } else {
                            combatPerso(equipe.getPersonnage(indice), adversaire, equipe);
                        }
                    } while(evenementCombat != null && !reussi && !evenCbt.estFini() && derniereConditionEffectuer
                            instanceof ConditionPrimaire &&
                            derniereConditionEffectuer.equals(evenCbt.getCondition()));
                }
            } else {
                if (adversaire.contains(ennemieDExp.getEnnemie(indice - equipe.size())) &&
                        (!equipe.estKO())) {
                    if (evenementCombat != null) {
                        this.choixActionEnnemi(ennemieDExp.getEnnemie(indice - equipe.size()),
                                equipe, adversaire);
                        AttaqueEnnemi(ennemieDExp.getEnnemie(indice - equipe.size()), equipe, adversaire);
                    } else {
                        this.choixActionEnnemi(ennemieDExp.getEnnemie(indice - equipe.size()),
                                equipe, adversaire);
                        AttaqueEnnemi(ennemieDExp.getEnnemie(indice - equipe.size()), equipe, adversaire);
                    }
                }
            }
            if (this.tableau.size() == this.equipe.size() + this.ennemieDExp.size()) {
                while (!tableau.isEmpty()) {
                    tableau.remove(0);
                }
            }
            if (evenementCombat != null && !evenCbt.estFini()) {
                //if (evenCbt.getCondition() instanceof ConditionVictoire) {
                if (evenCbt.getCondition() instanceof ConditionSecondaire) {
                    //evenCbt.conditionReussi();
                }
            }
        } while (adversaire.size() != 0 && !equipe.estKO() && (!evenCbt.estFini() ||
                (derniereConditionEffectuer instanceof ConditionFinDeTour && !tableau.isEmpty())));
        if (evenementCombat != null && !evenCbt.estFini()) {
            //if (evenCbt.getCondition() instanceof ConditionVictoire) {
            if (evenCbt.getCondition() instanceof ConditionSecondaire) {
                evenCbt.conditionReussi();
            }
        }
        jeu.gameOver(equipe, adversaire);
        if (evenementCombat == null || (derniereConditionEffectuer instanceof ConditionSecondaire)) {
            equipe.setArgent(expEtArgent(equipe, ennemieDExp));
        }
    }
    
    public abstract void combat ();

    protected Perso combat1() {
        boolean gameOver;
        double rapide;
        int indice;
        int j;
        if (adversaire.size() != 0 && !equipe.estKO()) {
            rapide = 0;
            indice = 0;
            for (j = 0; j < (equipe.size() + ennemieDExp.size()); j++) {
                if (j < equipe.size()) {
                    if (equipe.getPersonnage(j).getVit() > rapide && !tableau.contains(j)) {
                        rapide = equipe.getPersonnage(j).getVit();
                        indice = j;
                    }
                } else {
                    if (ennemieDExp.getEnnemie(j - equipe.size()).getVit() > rapide &&
                            !tableau.contains(j)) {
                        rapide = ennemieDExp.getEnnemie(j - equipe.size()).getVit();
                        indice = j;
                    }
                }
            }

            tableau.add(indice);
            if (indice < equipe.size()) {
                this.persoEnCours = indice;
                return this.equipe.getPersonnage(indice);
            } else {
                return this.adversaire.getEnnemie(indice - equipe.size());
            }
        }
        return null;
    }

    protected double arrondiDegat(Perso p, double degat) {
        if (degat <= (-p.getDef())) {
            degat = 0;
        } else {
            degat = 1;
        }
        return degat;
    }

    protected abstract int attaqueReussi(Perso attaquant, Perso attaquer);
    
    protected boolean rate (Perso attaquant) {
        int aleaRate;
        aleaRate = (int) (Math.random() * 30 + 1);
        return (aleaRate > attaquant.getPrec());
    }
    
    protected boolean esquive (Perso attaquant, Perso attaquer) {
        double agil;
        int aleaEsq;
        agil = (attaquer.getAgi() - (2 * attaquant.getPrec()));
        if (agil > 0) {
            aleaEsq = (int) (Math.random() * 30 + 1);
            if (aleaEsq >= 1 && aleaEsq <= agil) {
                return true;
            }
        }
        return false;
    }

    protected boolean verifieKO(Perso p) {
        if (p.getPv() <= 0) {
            p.setPv(0);
        }
        this.setAffichage(p.getNom() + ": PV :" + Math.round(p.getPv()));
        if (p.getPv() == 0) {
            this.setAffichage(p.getNom() + " est KO");
            return true;
        }
        return false;
    }

    protected double degatAtt(Perso attaquant, Perso attaquer) {
        double degat;
        if (attaquer.estFaible(Types.normal)) {
            degat = ((attaquant.getForce() + (attaquant.getForce() / 2)) - attaquer.getDef());
        } else {
            if (attaquer.estFort(Types.normal)) {
                degat = (attaquant.getForce() - (attaquer.getDef() + (attaquer.getDef() / 2)));
            } else {
                degat = (attaquant.getForce() - attaquer.getDef());
            }
        }
        return degat;
    }

    protected double degatTec(Perso attaquant, Perso attaquer) {
        double degat;
        if (attaquant.getTec().getTechnique(this.choixTec-1).getCapacite().equals("magie")) {
            if (attaquer.estFaible(attaquant.getTec().getTechnique(this.choixTec-1).getType())) {
                degat = (((attaquant.getMagie() + (attaquant.getMagie() * attaquant.getTec().getTechnique(this.choixTec-1).getAtt()))
                        + ((attaquant.getMagie() + attaquant.getMagie() * attaquant.getTec().getTechnique(
                        this.choixTec-1).getAtt()) / 2)) - attaquer.getRes());
            } else {
                if (attaquer.estFort(attaquant.getTec().getTechnique(this.choixTec-1).getType())) {
                    degat = ((attaquant.getMagie() + (attaquant.getMagie() * 
                            attaquant.getTec().getTechnique(this.choixTec-1).getAtt())) - (attaquer.getRes() + (attaquer.getRes() / 2)));
                } else {
                    degat = ((attaquant.getMagie() + (attaquant.getMagie() * 
                            attaquant.getTec().getTechnique(this.choixTec-1).getAtt())) - attaquer.getRes());
                }
            }
        } else {
            if (attaquant.getTec().getTechnique(this.choixTec-1).getCategorie().equals("volU")) {
                degat = ((attaquant.getForce() * attaquant.getTec().getTechnique(this.choixTec-1).getAtt()) - attaquer.getDef());
            } else {
                if (attaquer.estFaible(attaquant.getTec().getTechnique(this.choixTec-1).getType())) {
                    degat = (((attaquant.getForce() + attaquant.getForce() * attaquant.getTec().getTechnique(this.choixTec-1).getAtt()) +
                            ((attaquant.getForce() + attaquant.getForce() *
                            attaquant.getTec().getTechnique(this.choixTec-1).getAtt()) / 2)) - attaquer.getDef());
                } else {
                    if (attaquer.estFort(attaquant.getTec().getTechnique(this.choixTec-1).getType())) {
                        degat = ((attaquant.getForce() + attaquant.getForce() * 
                                attaquant.getTec().getTechnique(this.choixTec-1).getAtt()) - (attaquer.getDef() + (attaquer.getDef() / 2)));
                    } else {
                        degat = ((attaquant.getForce() + (attaquant.getForce() * 
                                attaquant.getTec().getTechnique(this.choixTec-1).getAtt())) - attaquer.getDef());
                    }
                }
            }
        }
        return degat;
    }

    protected void choixActionEnnemi(Ennemie ennemie, ListeDePerso equipe, ListeDePerso adversaire) {
        int alea;
        boolean att = false;
        while (!att) {
            alea = (int) (Math.random() * equipe.size() - 1);
            if (equipe.getPersonnage(alea).getPv() != 0) {
                att = true;
                this.choixPerso = alea;
            }
        }
        if (ennemie.elemental()) {
            this.choixAction = (int) (Math.random() * 10 + 1);
        } else {
            this.choixAction = (int) (Math.random() * 3 + 1);
        }
    }

    protected int choixTec(Perso perso) {
        // cette fonction permet a l'ennemi d'utiliser une technique sur un perso
        if (choixTec-1 < perso.getTec().size() && perso.getTec().size() != 0 && perso.getPm() >= perso.getTec().getTechnique(choixTec - 1).getPmTec()) {
            if (perso.getTec().getTechnique(choixTec - 1).getCategorie().equals("attaqueU")
                    || perso.getTec().getTechnique(choixTec - 1).getCategorie().equals("specialU")) {
                return 1;
            }
            if (perso.getTec().getTechnique(choixTec - 1).getCategorie().equals("attaqueE")
                    || perso.getTec().getTechnique(choixTec - 1).getCategorie().equals("specialE")) {
                return 2;
            }
            if (perso.getTec().getTechnique(choixTec - 1).getCategorie().equals("boostU")
                    || perso.getTec().getTechnique(choixTec - 1).getCategorie().equals("soinU")) {
                return 3;
            }
            if (perso.getTec().getTechnique(choixTec - 1).getCategorie().equals("boostE")
                    || perso.getTec().getTechnique(choixTec - 1).getCategorie().equals("soinE")) {
                return 4;
            }
            if (perso.getTec().getTechnique(choixTec - 1).getCategorie().equals("boostM")) {
                return 5;
            }
            return 6;
        }
        return 0;
    }

    // cette fonction permet de savoir lequel de vos personnage l'ennemi va attaquer
    protected abstract void AttaqueEnnemi(Ennemie ennemie, ListeDePerso equipe, ListeDePerso adversaire);

    protected abstract void combatPerso(Personnage perso, ListeDePerso adversaire, ListeDePerso equipe);

    protected int expEtArgent(ListeDePerso equipe, ListeDePerso adversaire) {
        int exp = 0;
        int expRecu;
        int monai = 0;
        int nbPerso = 0;
        for (int i = 0; i
                < adversaire.size(); i++) {
            exp = exp + adversaire.getEnnemie(i).getExp();
            monai = monai + adversaire.getEnnemie(i).getArgent();
        }
        for (int i = 0; i
                < equipe.size(); i++) {
            if (equipe.getPersonnage(i).getPv() != 0) {
                nbPerso++;
            }
        }
        expRecu = (exp / (nbPerso));
        //this.jeu.afficherMenuFinDeCombat(equipe, monai, expRecu);
        for (int i = 0; i < equipe.size(); i++) {
            equipe.getPersonnage(i).setExp(expRecu);
            /*if (equipe.getPersonnage(i).getExp() > equipe.getPersonnage(i).getExpNivSup()) {
                this.jeu.setAffichage(this.jeu.getTextes().monteDeNiveau(equipe.getPersonnage(i).getNom()));
                equipe.getPersonnage(i).nivSuiv(equipe.getPersonnage(i).getStat());
            }
            equipe.getPersonnage(i).setExpRes((equipe.getPersonnage(i).getExpNivSup()
                    - equipe.getPersonnage(i).getExp()));*/
        }
        equipe.setArgent(monai);
        //this.jeu.afficherMenuFinDeCombat(equipe, 0, 0);
        while (adversaire.size() != 0) {
            adversaire.enleverPerso(0);
        }
        return monai;
    }

    protected Condition getConditionAction(int action) {
        switch (action) {
            case (1):
                return new ConditionAttaque();
            case (2):
                return new ConditionDegat();
            case (3):
                return new ConditionDegat();
            case (4):
                return new ConditionObjet();
            case (5):
                return new ConditionDefense();
            case (6):
                return new ConditionDegat();
        }
        return null;
    }
}