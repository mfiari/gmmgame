package mfiari.gmm.game.liste;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import mfiari.gmm.game.perso.Ennemie;
import java.util.ArrayList;
/**
 *
 * @author mike
 */
public class ListeDEnnemi {
    
    private ArrayList<Ennemie> listeDEnnemi;

    public ListeDEnnemi () {
        this.listeDEnnemi=new ArrayList<Ennemie>();
    }

    public void ajoutEnnemi (Ennemie nom) {
        this.listeDEnnemi.add(nom);
    }

    public void enleverEnnemi (int num) {
        this.listeDEnnemi.remove(num);
    }

    public int size() {
        return this.listeDEnnemi.size();
    }

    public boolean contains (Ennemie nom) {
        boolean contient=false;
        int i=0;
        while (!contient && i<this.listeDEnnemi.size()) {
            if (this.listeDEnnemi.contains(nom)) {
                contient=true;
            }
            i++;
        }
        return contient;
    }

    public Ennemie getEnnemie (int i) {
        return this.listeDEnnemi.get(i);
    }
}
