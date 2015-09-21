/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.objet;

/**
 *
 * @author mike
 */
abstract public class Objet extends mfiari.lib.game.objet.Objet {
    
    private String nom;
    private TypeObjet type;
    private int pv;
    private int pm;
    private int force;
    private int def;
    private int magie;
    private int res;
    private int vit;
    private int prec;
    private int agi;
    private int prixAchat;
    private int prixVente;
    private String description;
    private int quantite;

    public Objet(String nom, TypeObjet type, int pv, int pm, int force, int def, int magie, int res, 
            int vit, int prec, int agi, int prixAchat, int prixVente, String description, int quantite) {
        this.nom = nom;
        this.type = type;
        this.pv = pv;
        this.pm = pm;
        this.force = force;
        this.def = def;
        this.magie = magie;
        this.res = res;
        this.vit = vit;
        this.prec = prec;
        this.agi = agi;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.description = description;
        this.quantite = quantite;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public TypeObjet getType() {
        return this.type;
    }

    @Override
    public int getPv() {
        return this.pv;
    }

    @Override
    public int getPm() {
        return this.pm;
    }

    @Override
    public int getForce() {
        return this.force;
    }

    @Override
    public int getDef() {
        return this.def;
    }

    @Override
    public int getMagie() {
        return this.magie;
    }

    @Override
    public int getRes() {
        return this.res;
    }

    @Override
    public int getVit() {
        return this.vit;
    }

    @Override
    public int getPrec() {
        return this.prec;
    }

    @Override
    public int getAgi() {
        return this.agi;
    }

    @Override
    public int getPrixAchat() {
        return this.prixAchat;
    }

    @Override
    public int getPrixVente() {
        return this.prixVente;
    }

    @Override
    public int getQuantite() {
        return this.quantite;
    }

    @Override
    public void acheter(int quantite) {
        this.quantite = this.quantite + quantite;
    }

    @Override
    public void vendre(int quantite) {
        this.quantite = this.quantite - quantite;
    }

    @Override
    public void jeter(int quantite) {
        for (int i = 0; i < quantite; i++) {
            this.quantite = this.quantite - 1;
        }
    }

    @Override
    public void equiper() {
        this.quantite = (this.quantite - 1);
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void utilObjet() {
        this.vendre(1);
    }

    @Override
    public String toString () {
        return this.nom + "qte: " + this.quantite;
    }

}
