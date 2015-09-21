package mfiari.gmm.game.menu;

import mfiari.gmm.game.perso.Perso;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mike
 */
public class Stat extends mfiari.lib.game.personnage.Stat {
    
    
    public Stat (Perso persoNivMin, Perso persoNivMax) {
        this.stat=new double[persoNivMax.getNiveau()][13];
        this.stat[persoNivMin.getNiveau()-1][0]=persoNivMin.getNiveau();
        this.stat[persoNivMin.getNiveau()-1][1]=persoNivMin.getPv();
        this.stat[persoNivMin.getNiveau()-1][2]=persoNivMin.getPm();
        this.stat[persoNivMin.getNiveau()-1][3]=persoNivMin.getForce();
        this.stat[persoNivMin.getNiveau()-1][4]=persoNivMin.getDef();
        this.stat[persoNivMin.getNiveau()-1][5]=persoNivMin.getMagie();
        this.stat[persoNivMin.getNiveau()-1][6]=persoNivMin.getRes();
        this.stat[persoNivMin.getNiveau()-1][7]=persoNivMin.getVit();
        this.stat[persoNivMin.getNiveau()-1][8]=persoNivMin.getPrec();
        this.stat[persoNivMin.getNiveau()-1][9]=persoNivMin.getAgi();
        this.stat[persoNivMin.getNiveau()-1][10]=persoNivMin.getExp();
        int niv = persoNivMin.getNiveau()+1;
        int niveauEcart = persoNivMax.getNiveau() - persoNivMin.getNiveau();
        double pv = (persoNivMax.getPv() - persoNivMin.getPv()) / niveauEcart;
        double pm = (persoNivMax.getPm() - persoNivMin.getPm()) / niveauEcart;
        double force = (persoNivMax.getForce() - persoNivMin.getForce()) / niveauEcart;
        double def = (persoNivMax.getDef() - persoNivMin.getDef()) / niveauEcart;
        double magie = (persoNivMax.getMagie() - persoNivMin.getMagie()) / niveauEcart;
        double res = (persoNivMax.getRes() - persoNivMin.getRes()) / niveauEcart;
        double vit = (persoNivMax.getVit() - persoNivMin.getVit()) / niveauEcart;
        double prec = (persoNivMax.getPrec() - persoNivMin.getPrec()) / niveauEcart;
        double agi = (persoNivMax.getAgi() - persoNivMin.getAgi()) / niveauEcart;
        for (int i=niv-1 ; i<persoNivMax.getNiveau() ; i++) {
            this.stat[i][0]= i+1;
            this.stat[i][1]= this.stat[i-1][1] + pv;
            this.stat[i][2]= this.stat[i-1][2] + pm;
            this.stat[i][3]= this.stat[i-1][3] + force;
            this.stat[i][4]= this.stat[i-1][4] + def;
            this.stat[i][5]= this.stat[i-1][5] + magie;
            this.stat[i][6]= this.stat[i-1][6] + res;
            this.stat[i][7]= this.stat[i-1][7] + vit;
            this.stat[i][8]= this.stat[i-1][8] + prec;
            this.stat[i][9]= this.stat[i-1][9] + agi;
            this.stat[i][12]= calculeExp(persoNivMin.getExp(), persoNivMax.getExp(), i+1);
        }
    }
    
    public double getNiv(int i) {
        return this.stat[i][0];
    }
    public double getPv(int i) {
        return this.stat[i][1];
    }
    public double getPm(int i) {
        return this.stat[i][2];
    }
    public double getForce(int i) {
        return this.stat[i][3];
    }
    public double getDef(int i) {
        return this.stat[i][4];
    }
    public double getMagie(int i) {
        return this.stat[i][5];
    }
    public double getRes(int i) {
        return this.stat[i][6];
    }
    public double getVit(int i) {
        return this.stat[i][7];
    }
    public double getPrec(int i) {
        return this.stat[i][8];
    }
    public double getAgi(int i) {
        return this.stat[i][9];
    }
    public double getExp(int i) {
        return this.stat[i][10];
    }
}
