package mfiari.gmm.game.liste;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import mfiari.gmm.game.perso.D_UNI;
import mfiari.gmm.game.perso.Ennemie;
import java.util.ArrayList;
import mfiari.gmm.game.perso.Perso;
import mfiari.gmm.game.perso.Personnage;
import mfiari.gmm.game.ville.Endroit;
import mfiari.lib.game.liste.ListeDeGens;
import mfiari.lib.game.personnage.Habitant;

/**
 *
 * @author mike
 */
public class ListeDePerso extends ListeDeGens {

    private ArrayList<Perso> listeDePerso;
    private ArrayList<Habitant> listeDHabitant;

    public ListeDePerso() {
        super();
        this.listeDePerso = new ArrayList<>();
        this.listeDHabitant = new ArrayList<>();
    }

    public void ajouterPerso(Perso p) {
        this.listeDePerso.add(p);
    }

    public void enleverPerso(Perso p) {
        this.listeDePerso.remove(p);
    }

    @Override
    public void enleverPerso(int num) {
        this.listeDePerso.remove(num);
    }

    @Override
    public Perso getPerso(int i) {
        return this.listeDePerso.get(i);
    }

    @Override
    public Personnage getPersonnage(int i) {
        if (this.listeDePerso.get(i) instanceof Personnage) {
            return (Personnage) this.listeDePerso.get(i);
        }
        return null;
    }

    @Override
    public Personnage getPersonnage(String nom) {
        for (int i = 0; i < this.listeDePerso.size(); i++) {
            if (this.listeDePerso.get(i).getNom().equals(nom) && this.listeDePerso.get(i) instanceof Personnage) {
                return (Personnage) this.listeDePerso.get(i);
            }
        }
        return null;
    }

    public Perso getPerso(String nom) {
        for (int i = 0; i < this.listeDePerso.size(); i++) {
            if (this.listeDePerso.get(i).getNom().equals(nom)) {
                return this.listeDePerso.get(i);
            }
        }
        return null;
    }

    public D_UNI getD_UNI(int i) {
        if (this.listeDePerso.get(i) instanceof D_UNI) {
            return (D_UNI) this.listeDePerso.get(i);
        }
        return null;
    }

    public D_UNI getD_UNI(String nom) {
        for (int i = 0; i < this.listeDePerso.size(); i++) {
            if (this.listeDePerso.get(i).getNom().equals(nom) && this.listeDePerso.get(i) instanceof D_UNI) {
                return (D_UNI) this.listeDePerso.get(i);
            }
        }
        return null;
    }

    public Ennemie getEnnemie(int i) {
        if (this.listeDePerso.get(i) instanceof Ennemie) {
            return (Ennemie) this.listeDePerso.get(i);
        }
        return null;
    }

    public Ennemie getEnnemie(String nom) {
        for (int i = 0; i < this.listeDePerso.size(); i++) {
            if (this.listeDePerso.get(i).getNom().equals(nom) && this.listeDePerso.get(i) instanceof Ennemie) {
                return (Ennemie) this.listeDePerso.get(i);
            }
        }
        return null;
    }

    public Personnage aPerso(int i, int j) {
        Personnage p = null;
        int k = 0;
        while (p == null && k < this.listeDePerso.size()) {
            if (this.listeDePerso.get(k).getPosition().getPositionX() == i && this.listeDePerso.get(k).getPosition().getPositionY() == j) {
                if (this.listeDePerso.get(k) instanceof Personnage) {
                    p = (Personnage) this.listeDePerso.get(k);
                }
            }
            k++;
        }
        return p;
    }

    public void ajouterHabitant(Habitant h) {
        this.listeDHabitant.add(h);
    }

    public void enleverHabitant(Habitant h) {
        this.listeDHabitant.remove(h);
    }

    public Habitant getHabitant(int i) {
        return this.listeDHabitant.get(i);
    }

    public Habitant aHabitant(int i, int j) {
        for (int k=0 ; k < this.listeDHabitant.size() ; k++) {
            if (this.listeDHabitant.get(k).getPosition().getPositionX() == i && this.listeDHabitant.get(k).getPosition().getPositionY() == j) {
                return this.listeDHabitant.get(k);
            }
        }
        return null;
    }

    public boolean contains (Perso p) {
        return this.listeDePerso.contains(p);
    }

    public void setEndroit (Endroit e) {
        for (int i=0 ; i< this.listeDePerso.size(); i++) {
            this.listeDePerso.get(i).getPosition().setEndroit(e);
        }
    }

    public void setPositionX(int i) {
        for (int j = 0; j < this.listeDePerso.size(); j++) {
            this.listeDePerso.get(j).getPosition().setPositionX(i);
        }
    }

    public void setPositionY(int i) {
        for (int j = 0; j < this.listeDePerso.size(); j++) {
            this.listeDePerso.get(j).getPosition().setPositionY(i);
        }
    }

    @Override
    public int size() {
        return this.listeDePerso.size();
    }

    public void soin() {
        for (int i = 0; i < this.listeDePerso.size(); i++) {
            this.listeDePerso.get(i).soin();
        }
    }

    public boolean estKO() {
        boolean ko = false;
        int nbKO = 0;
        for (int i = 0; i < this.listeDePerso.size(); i++) {
            if (this.listeDePerso.get(i).getPv() == 0) {
                nbKO = nbKO + 1;
            }
        }
        if (nbKO == this.listeDePerso.size()) {
            ko = true;
        }
        return ko;
    }

    public boolean aPerso(Personnage p) {
        for (int i = 0; i < this.listeDePerso.size(); i++) {
            if (p.equals(this.listeDePerso.get(i))) {
                return true;
            }
        }
        return false;
    }
}
