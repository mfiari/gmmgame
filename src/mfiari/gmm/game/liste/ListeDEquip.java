package mfiari.gmm.game.liste;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import mfiari.gmm.game.objet.Equip;
import java.util.ArrayList;

/**
 *
 * @author mike
 */

public class ListeDEquip {

    private ArrayList<Equip> listeDEquip;

    public ListeDEquip() {
        this.listeDEquip = new ArrayList<Equip>();
    }

    public Equip getEquip(int i) {
        return this.listeDEquip.get(i);
    }

    public void ajoutEquip(Equip nom) {
        this.listeDEquip.add(nom);
    }

    public int size() {
        return this.listeDEquip.size();
    }

    public boolean contains(Equip nom) {
        boolean contient;
        contient = false;
        if (this.listeDEquip.contains(nom)) {
            contient = true;
        }
        return contient;
    }

    private Equip chercherEquip(String nom) {
        int i;
        boolean trouve;
        i = 0;
        trouve = false;
        Equip equipement;
        equipement = null;
        while (!trouve && i < listeDEquip.size()) {
            if (nom.equals(listeDEquip.get(i).getNom())) {
                trouve = true;
                equipement = this.listeDEquip.get(i);
            }
            i++;
        }
        return (equipement);
    }

    public void acheter(Equip equipement, int quantite) {
        int i;
        i = 0;
        if (this.listeDEquip.contains(equipement)) {
            while (i < this.listeDEquip.size() && !equipement.getNom().equals(this.listeDEquip.get(i).getNom())) {
                i++;
            }
            this.listeDEquip.get(i).acheter(quantite);
        } else {
            this.listeDEquip.add(equipement);
            this.listeDEquip.get(this.listeDEquip.size() - 1).acheter(quantite);
        }
    }

    public void vendre(int i, int quantite) {
        this.listeDEquip.get(i).vendre(quantite);
        if (this.listeDEquip.get(i).getQuantite() == 0) {
            this.listeDEquip.remove(i);
        }
    }

    public void equiper(int i) {
        this.listeDEquip.get(i).equiper();
        if (this.listeDEquip.get(i).getQuantite() == 0) {
            this.listeDEquip.remove(i);
        }
    }
}
