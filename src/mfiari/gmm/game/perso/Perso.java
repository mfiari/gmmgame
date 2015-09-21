/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.perso;

import mfiari.gmm.game.liste.ListeTec;
import mfiari.gmm.game.menu.Stat;
import mfiari.gmm.game.objet.Objet;
import mfiari.gmm.game.technique.Etat;
import mfiari.gmm.game.technique.Technique;
import mfiari.gmm.game.technique.Types;
import mfiari.gmm.game.ville.Endroit;
import mfiari.lib.game.position.Orientation;

/**
 *
 * @author mike
 */
public class Perso extends mfiari.lib.game.personnage.Personnage {

    private int niv;
    private double pv;
    private double pm;
    private double force;
    private double def;
    private double magie;
    private double res;
    private double vit;
    private double prec;
    private double agi;
    private int exp;
    private Etat etat1;
    private Etat etat2;
    private Types[] fort;
    private Types[] faible;
    private int argent;
    private ListeTec tec;
    private Stat stat;

    public Perso(String nom, int niv, double pv, int pm, int force, int def, int magie, int res, int vit,
            int prec, int agi, int exp, int argent, int positionX, int positionY,
            Endroit ville) {

        super(nom, positionX, positionY, ville, Orientation.face);
        this.niv = niv;
        this.pv = pv;
        this.pm = pm;
        this.force = force;
        this.def = def;
        this.magie = magie;
        this.res = res;
        this.vit = vit;
        this.prec = prec;
        this.agi = agi;
        this.exp = exp;
        this.etat1 = Etat.aucun;
        this.etat2 = Etat.aucun;
        this.tec = new ListeTec();
        this.fort = new Types[Types.values().length];
        for (int i=0 ; i< this.fort.length ; i++) {
            this.fort[i] = Types.aucun;
        }
        this.faible = new Types[Types.values().length];
        for (int i=0 ; i< this.faible.length ; i++) {
            this.faible[i] = Types.aucun;
        }
        this.argent = argent;
    }

    public Perso(Perso adv) {
        super(adv.getNom(), adv.getPosition());
        this.niv = adv.niv;
        this.pv = adv.pv;
        this.pm = adv.pm;
        this.force = adv.force;
        this.def = adv.def;
        this.magie = adv.magie;
        this.res = adv.res;
        this.vit = adv.vit;
        this.prec = adv.prec;
        this.agi = adv.agi;
        this.exp = adv.exp;
        this.etat1 = adv.etat1;
        this.etat2 = adv.etat2;
        this.argent = adv.argent;
        this.fort = adv.fort;
        this.faible = adv.faible;
        this.tec = adv.tec;
        this.stat = adv.stat;
    }

    //retourne les pv de l'individu
    public double getPv() {
        return this.pv;
    }

    //retourne les pv initiale de l'individu
    public double getPvi() {
        return this.stat.getPv(this.niv -1);
    }

    //remplace les pv de l'individu par ceux passé en paramètre
    public void setPv(double pv) {
        this.pv = pv;
    }

    //retourne les pm de l'individu
    public double getPm() {
        return this.pm;
    }

    //retourne les pm initiale de l'individu
    public double getPmi() {
        return this.stat.getPm(this.niv -1);
    }

    //remplace les pm de l'individu par ceux passé en paramètre
    public void setPm(double pm) {
        this.pm = pm;
    }

    //retourne la force physique de l'individu
    public double getForce() {
        return this.force;
    }

    //remplace la force physique de l'individu par celle passé en paramètre
    public void setForce(int force) {
        this.force = force;
    }

    //retourne la defense physique de l'individu
    public double getDef() {
        return this.def;
    }

    //retourne la defense physique initiale de l'individu
    public double getDefi() {
        return this.stat.getDef(this.niv -1);
    }

    //remplace la défense physique de l'individu par celle passé en paramètre
    public void setDef(double def) {
        this.def = def;
    }

    //retourne la force magique de l'individu
    public double getMagie() {
        return this.magie;
    }

    //remplace la force magique de l'individu par celle passé en paramètre
    public void setMagie(int magie) {
        this.magie = magie;
    }

    //retourne la defense magique de l'individu
    public double getRes() {
        return this.res;
    }

    //remplace la défense magique de l'individu par celle passé en paramètre
    public void setRes(int res) {
        this.res = res;
    }

    //retourne la vitesse de l'individu
    public double getVit() {
        return this.vit;
    }

    //remplace la vitesse de l'individu par celle passé en paramètre
    public void setVit(int vit) {
        this.vit = vit;
    }

    //retourne la precision de l'individu
    public double getPrec() {
        return this.prec;
    }

    //remplace la précision de l'individu par celle passé en paramètre
    public void setPrec(int prec) {
        this.prec = prec;
    }

    //retourne l'agilité de l'individu
    public double getAgi() {
        return this.agi;
    }

    //remplace l'agilité de l'individu par celle passé en paramètre
    public void setAgi(int agi) {
        this.agi = agi;
    }

    //retourne l'expérience de l'individu
    public int getExp() {
        return this.exp;
    }

    //ajoute à l'expérience de l'individu celle passé en paramètre
    public void setExp(int exp) {
        this.exp = this.exp + exp;
    }

    //retourne l'argent de l'individu
    public int getArgent() {
        return this.argent;
    }

    //ajoute à l'argent de l'individu celui passé en paramètre
    public void setArgent(int arg) {
        this.argent = this.argent + arg;
    }

    //retourne l'état de l'individu
    public Etat getEtat() {
        return this.etat1;
    }

    //remplace l'état de l'individu par celui passé en paramètre
    public void setEtat(Etat etat) {
        this.etat1 = etat;
    }

    //retourne vrai si l'individu est faible au type passé en paramètre
    public boolean estFaible(Types type) {
        boolean estFaible = false;
        int j = 0;
        while (j < this.faible.length && !this.faible[j].equals(type)) {
            j++;
        }
        if (j < this.faible.length) {
            estFaible = true;
        }

        return estFaible;
    }

    //retourne vrai si l'individu est fort au type passé en paramètre
    public boolean estFort(Types type) {
        boolean estFort = false;
        int j = 0;
        while (j < this.fort.length && !this.fort[j].equals(type)) {
            j++;
        }
        if (j < this.fort.length) {
            estFort = true;
        }

        return estFort;
    }

    public ListeTec getTec() {
        return this.tec;
    }
    
    public void setStat (Stat stat) {
        this.stat = stat;
    }

    //permet de soigné toute les stats de l'individu
    public void soin() {
        this.pv = this.stat.getPv(this.niv -1);
        this.pm = this.stat.getPm(this.niv -1);
        this.force = this.stat.getForce(this.niv -1);
        this.def = this.stat.getDef(this.niv -1);
        this.magie = this.stat.getMagie(this.niv -1);
        this.res = this.stat.getRes(this.niv -1);
        this.vit = this.stat.getVit(this.niv -1);
        this.prec = this.stat.getPrec(this.niv -1);
        this.agi = this.stat.getAgi(this.niv -1);
    }

    //permet de reçevoir un sort de soin
    public void recoitSoin(Technique sort) {
        if (this.pv + sort.getPv() > this.stat.getPv(this.niv -1)) {
            this.pv = this.stat.getPv(this.niv -1);
        } else {
            this.pv = this.pv + sort.getPv();
        }
        if (this.pm + sort.getPm() > this.stat.getPm(this.niv -1)) {
            this.pm = this.stat.getPm(this.niv -1);
        } else {
            this.pm = this.pm + sort.getPm();
        }
        if (this.force + sort.getForce() > this.stat.getForce(this.niv -1)) {
            this.force = this.stat.getForce(this.niv -1);
        } else {
            this.force = this.force + sort.getForce();
        }
        if (this.def + sort.getDef() > this.stat.getDef(this.niv -1)) {
            this.def = this.stat.getDef(this.niv -1);
        } else {
            this.def = this.def + sort.getDef();
        }
        if (this.magie + sort.getMagie() > this.stat.getMagie(this.niv -1)) {
            this.magie = this.stat.getMagie(this.niv -1);
        } else {
            this.magie = this.magie + sort.getMagie();
        }
        if (this.res + sort.getRes() > this.stat.getRes(this.niv -1)) {
            this.res = this.stat.getRes(this.niv -1);
        } else {
            this.res = this.res + sort.getRes();
        }
        if (this.vit + sort.getVit() > this.stat.getVit(this.niv -1)) {
            this.vit = this.stat.getVit(this.niv -1);
        } else {
            this.vit = this.vit + sort.getVit();
        }
        if (this.prec + sort.getPrec() > this.stat.getPrec(this.niv -1)) {
            this.prec = this.stat.getPrec(this.niv -1);
        } else {
            this.prec = this.prec + sort.getPrec();
        }
        if (this.agi + sort.getAgi() > this.stat.getAgi(this.niv -1)) {
            this.agi = this.stat.getAgi(this.niv -1);
        } else {
            this.agi = this.agi + sort.getAgi();
        }
    }

    //permet de reçevoir un sort de soin d'un personnage
    public void recoitSoin(Technique sort, Personnage perso) {
        if (sort.getPv() != 0) {
            if (this.pv + (perso.getMagie() + (perso.getMagie() * sort.getAtt())) > this.stat.getPv(this.niv -1)) {
                this.pv = this.stat.getPv(this.niv -1);
            } else {
                this.pv = this.pv + (perso.getMagie() + (perso.getMagie() * sort.getAtt()));
            }
        }
        if (sort.getPm() != 0) {
            if (this.pm + (perso.getMagie() + (perso.getMagie() * sort.getAtt())) > this.stat.getPm(this.niv -1)) {
                this.pm = this.stat.getPm(this.niv -1);
            } else {
                this.pm = this.pm + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt()));
            }
        }
        if (sort.getForce() != 0) {
            if (this.force + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt())) > this.stat.getForce(this.niv -1)) {
                this.force = this.stat.getForce(this.niv -1);
            } else {
                this.force = this.force + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt()));
            }
        }
        if (sort.getDef() != 0) {
            if (this.def + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt())) > this.stat.getDef(this.niv -1)) {
                this.def = this.stat.getDef(this.niv -1);
            } else {
                this.def = this.def + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt()));
            }
        }
        if (sort.getMagie() != 0) {
            if (this.magie + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt())) > this.stat.getMagie(this.niv -1)) {
                this.magie = this.stat.getMagie(this.niv -1);
            } else {
                this.magie = this.magie + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt()));
            }
        }
        if (sort.getRes() != 0) {
            if (this.res + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt())) > this.stat.getRes(this.niv -1)) {
                this.res = this.stat.getRes(this.niv -1);
            } else {
                this.res = this.res + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt()));
            }
        }
        if (sort.getVit() != 0) {
            if (this.vit + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt())) > this.stat.getVit(this.niv -1)) {
                this.vit = this.stat.getVit(this.niv -1);
            } else {
                this.vit = this.vit + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt()));
            }
        }
        if (sort.getPrec() != 0) {
            if (this.prec + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt())) > this.stat.getPrec(this.niv -1)) {
                this.prec = this.stat.getPrec(this.niv -1);
            } else {
                this.prec = this.prec + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt()));
            }
        }
        if (sort.getAgi() != 0) {
            if (this.agi + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt())) > this.stat.getAgi(this.niv -1)) {
                this.agi = this.stat.getAgi(this.niv -1);
            } else {
                this.agi = this.agi + (int) (perso.getMagie() + (perso.getMagie() * sort.getAtt()));
            }
        }
    }

    //retourne vrai si les stats de l'individu sont égaux aux stats initiaux et si il n'a pas d'altération d'état
    public boolean enForme() {
        boolean forme = false;
        if (this.enFormeStat() && this.enFormeEtat()) {
            forme = true;
        }
        return forme;
    }

    //retourne vrai si les stats de l'individu sont égaux aux stats initiaux
    public boolean enFormeStat() {
        boolean forme = false;
        if (this.pv == this.stat.getPv(this.niv -1) && this.pm == this.stat.getPm(this.niv -1) && this.force == this.stat.getForce(this.niv -1) && this.def == this.stat.getDef(this.niv -1)
                && this.magie == this.stat.getMagie(this.niv -1) && this.res == this.stat.getRes(this.niv -1) && this.vit == this.stat.getVit(this.niv -1) && this.prec == 
                this.stat.getPrec(this.niv -1) && this.agi == this.stat.getAgi(this.niv -1)) {
            forme = true;
        }
        return forme;
    }

    //retourne vrai si l'individu n'a pas d'altération d'état
    public boolean enFormeEtat() {
        return this.etat1.equals(Etat.aucun);
    }

    //permet d'utiliser un objet sur l'individu
    public void utilObjet(Objet o) {
        if (this.pv + o.getPv() > this.stat.getPv(this.niv -1)) {
            this.pv = this.stat.getPv(this.niv -1);
        } else {
            if (this.pv + o.getPv() < 0) {
                this.pv = 0;
            } else {
                this.pv = this.pv + o.getPv();
            }
        }
        if (this.pm + o.getPm() > this.stat.getPm(this.niv -1)) {
            this.pm = this.stat.getPm(this.niv -1);
        } else {
            this.pm = this.pm + o.getPm();
        }
        if (this.force + o.getForce() > this.stat.getForce(this.niv -1)) {
            this.force = this.stat.getForce(this.niv -1);
        } else {
            this.force = this.force + o.getForce();
        }
        if (this.def + o.getDef() > this.stat.getDef(this.niv -1)) {
            this.def = this.stat.getDef(this.niv -1);
        } else {
            this.def = this.def + o.getDef();
        }
        if (this.magie + o.getMagie() > this.stat.getMagie(this.niv -1)) {
            this.magie = this.stat.getMagie(this.niv -1);
        } else {
            this.magie = this.magie + o.getMagie();
        }
        if (this.res + o.getRes() > this.stat.getRes(this.niv -1)) {
            this.res = this.stat.getRes(this.niv -1);
        } else {
            this.res = this.res + o.getRes();
        }
        if (this.vit + o.getVit() > this.stat.getVit(this.niv -1)) {
            this.vit = this.stat.getVit(this.niv -1);
        } else {
            this.vit = this.vit + o.getVit();
        }
        if (this.prec + o.getPrec() > this.stat.getPrec(this.niv -1)) {
            this.prec = this.stat.getPrec(this.niv -1);
        } else {
            this.prec = this.prec + o.getPrec();
        }
        if (this.agi + o.getAgi() > this.stat.getAgi(this.niv -1)) {
            this.agi = this.stat.getAgi(this.niv -1);
        } else {
            this.agi = this.agi + o.getAgi();
        }

    }
    
    public int getNiveau() {
        return this.niv;
    }

    //permet a l'individu de monter de niveau
    public void nivSuiv(int niv) {
    }

    //retourne la faiblesse de l'individu
    public Types getFaiblesse(int i) {
        return this.faible[i];
    }

    //retourne la première force de l'individu
    public Types getFort(int i) {
        return this.fort[i];
    }
}
