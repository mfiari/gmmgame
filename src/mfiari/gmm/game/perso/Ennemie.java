package mfiari.gmm.game.perso;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import mfiari.gmm.game.objet.Equip;
import mfiari.gmm.game.objet.Objet_diver;
import mfiari.gmm.game.technique.Types;

/**
 *
 * @author mike
 */
public class Ennemie extends Perso {

    private int numero;
    private Types type1;
    private Types type2;
    private Objet_diver objet1;
    private Objet_diver objet2;
    private Equip objet3;
    private Objet_diver objet4;
    private Equip objet5;
    private Objet_diver objeti1;
    private Objet_diver objeti2;
    private Equip objeti3;
    private Objet_diver objeti4;
    private Equip objeti5;

    public Ennemie(int numero, String nom, int niv, double pv, int pm, int force, int def, int magie, int res,
            int vit, int prec, int agi, int exp, int argent, Types type1, Types type2) {

        super(nom, niv, pv, pm, force, def, magie, res, vit, prec, agi, exp, argent, 0, 0, null);

        this.numero = numero;
        this.type1 = type1;
        this.type2 = type2;
        this.objet1 = null;
        this.objet2 = null;
        this.objet3 = null;
        this.objet4 = null;
        this.objet5 = null;
        this.objeti1 = objet1;
        this.objeti2 = objet2;
        this.objeti3 = objet3;
        this.objeti4 = objet4;
        this.objeti5 = objet5;
    }

    public int getNum() {
        return this.numero;
    }

    public Objet_diver getObjet1() {
        return this.objet1;
    }

    public void setObjet1() {
        this.objet1 = null;
    }

    public Objet_diver getObjet2() {
        return this.objet2;
    }

    public void setObjet2() {
        this.objet2 = null;
    }

    public Equip getObjet3() {
        return this.objet3;
    }

    public void setObjet3() {
        this.objet3 = null;
    }

    public Objet_diver getObjet4() {
        return this.objet4;
    }

    public void setObjet4() {
        this.objet4 = null;
    }

    public Equip getObjet5() {
        return this.objet5;
    }

    public void setObjet5() {
        this.objet5 = null;
    }

    public void soin1() {
        super.soin();
        this.objet1 = this.objeti1;
        this.objet2 = this.objeti2;
        this.objet3 = this.objeti3;
        this.objet4 = this.objeti4;
        this.objet5 = this.objeti5;

    }

    public boolean vole() {
        boolean vole = false;
        if (this.objet1 != null || this.objet2 != null || this.objet3 != null || this.objet4 != null
                || this.objet5 != null) {
            vole = true;
        }
        return vole;
    }

    public Objet_diver volObjetNul(int i) {
        Objet_diver objet = null;
        if (i == 1) {
            objet = this.getObjet1();
        }
        if (i == 2) {
            objet = this.getObjet2();
        }
        if (i == 4) {
            objet = this.getObjet4();
        }
        return objet;
    }

    public Equip volEquipNul(int i) {
        Equip objet = null;
        if (i == 3) {
            objet = this.getObjet3();
        }
        if (i == 5) {
            objet = this.getObjet5();
        }
        return objet;
    }

    public boolean elemental() {
        boolean elemental = false;
        if (this.type1.equals(Types.feu) || this.type1.equals(Types.eau)
                || this.type1.equals(Types.electrique) || this.type1.equals(Types.vent)
                || this.type1.equals(Types.lumiere) || this.type1.equals(Types.tenebre)
                || this.type1.equals(Types.espace) || this.type1.equals(Types.terre)
                || this.type1.equals(Types.glace)) {
            elemental = true;
        } else {
            if (this.type2.equals(Types.feu) || this.type2.equals(Types.eau)
                    || this.type2.equals(Types.electrique) || this.type2.equals(Types.vent)
                    || this.type2.equals(Types.lumiere) || this.type2.equals(Types.tenebre)
                    || this.type2.equals(Types.espace) || this.type2.equals(Types.terre)
                    || this.type2.equals(Types.glace)) {
                elemental = true;
            }
        }
        return elemental;
    }

    public Ennemie(Ennemie adv) {
        super(adv);
        this.numero = adv.numero;
        this.type1 = adv.type1;
        this.type2 = adv.type2;
        this.objet1 = adv.objet1;
        this.objet2 = adv.objet2;
        this.objet3 = adv.objet3;
        this.objet4 = adv.objet4;
        this.objet5 = adv.objet5;
        this.objeti1 = adv.objet1;
        this.objeti2 = adv.objet2;
        this.objeti3 = adv.objet3;
        this.objeti4 = adv.objet4;
        this.objeti5 = adv.objet5;
    }
}
