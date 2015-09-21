package mfiari.gmm.game.liste;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import mfiari.gmm.game.technique.Technique;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author mike
 */
public class ListeTec implements Serializable {

    private ArrayList<Technique> listeDeTec;

    public ListeTec() {
        this.listeDeTec = new ArrayList<>();
    }

    public void ajoutTec(Technique nom) {
        this.listeDeTec.add(nom);
    }

    public void remplaceTec(Technique nom, int i) {
        ArrayList<Technique> tecs = new ArrayList<>();
        while (i + 1 < this.listeDeTec.size()) {
            tecs.add(this.listeDeTec.get(i + 1));
            this.listeDeTec.remove(i + 1);
        }
        this.listeDeTec.remove(i);
        this.listeDeTec.add(nom);
        for (int j = 0; j < tecs.size(); j++) {
            this.listeDeTec.add(tecs.get(i));
        }
    }

    public void enleverTec(int num) {
        this.listeDeTec.remove(num);
    }

    public int size() {
        return this.listeDeTec.size();
    }

    public Technique getTechnique(int i) {
        return this.listeDeTec.get(i);
    }

    public Technique getTechnique(String nom) {
        for (int i = 0; i < this.listeDeTec.size(); i++) {
            if (this.listeDeTec.get(i).getNom().equals(nom)) {
                return this.listeDeTec.get(i);
            }
        }
        return null;
    }
}
