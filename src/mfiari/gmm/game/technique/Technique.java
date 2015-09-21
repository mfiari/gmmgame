package mfiari.gmm.game.technique;

import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mike
 */
public class Technique implements Serializable {

    private String nom;
    private Types type;
    private String categorie;
    private double att;
    private int pmTec;
    private double pv;
    private int pm;
    private int force;
    private int def;
    private int magie;
    private int res;
    private int vit;
    private int prec;
    private int agi;
    private Etat etat;
    private String capacite;
    private int nbUtil;
    private String description;

    public Technique(String nom, Types type, String categorie, double att, int pmTec, double pv, int pm, int force,
            int def, int magie, int res, int vit, int prec, int agi,
            Etat etat, String capacite, int nbUtil, String description) {
        this.nom = nom;
        this.type = type;
        this.categorie = categorie;
        this.att = att;
        this.pmTec = pmTec;
        this.pv = pv;
        this.pm = pm;
        this.force = force;
        this.def = def;
        this.magie = magie;
        this.res = res;
        this.vit = vit;
        this.prec = prec;
        this.agi = agi;
        this.etat = etat;
        this.capacite = capacite;
        this.nbUtil = nbUtil;
        this.description = description;
    }

    public String getNom() {
        return this.nom;
    }

    public Types getType() {
        return this.type;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public double getAtt() {
        return this.att;
    }

    public int getPmTec() {
        return this.pmTec;
    }

    public double getPv() {
        return this.pv;
    }

    public int getPm() {
        return this.pm;
    }

    public int getForce() {
        return this.force;
    }

    public int getDef() {
        return this.def;
    }

    public int getMagie() {
        return this.magie;
    }

    public int getRes() {
        return this.res;
    }

    public int getVit() {
        return this.vit;
    }

    public int getPrec() {
        return this.prec;
    }

    public int getAgi() {
        return this.agi;
    }

    public String getCapacite() {
        return this.capacite;
    }

    public int getNbUtil() {
        return this.nbUtil;
    }

    public String getDescription() {
        return this.description;
    }

    public Etat getEtat() {
        return this.etat;
    }

    public void setNbUtil() {
        this.nbUtil = nbUtil + 1;
    }

    public double attaque(int att) {
        return (att + (att * this.att));
    }
}
