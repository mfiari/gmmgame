package mfiari.gmm.game.perso;



import mfiari.gmm.game.liste.ListeTec;
import mfiari.gmm.game.objet.Categorie_objet;
import mfiari.gmm.game.objet.Equip;
import mfiari.gmm.game.objet.Objet_diver;
import mfiari.gmm.game.objet.TypeObjet;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mike
 */
public class Personnage extends Perso {

    private String capacite;
    private String classe;
    private Equip equipMain;
    private Equip equipCorps;
    private Equip equipTete;
    private Equip equipPied;
    private Equip equipAcc1;
    private Equip equipAcc2;
    private TypeObjet mainEquip;
    private TypeObjet corpsEquip;
    private TypeObjet piedEquip;
    private TypeObjet teteEquip;
    private TypeObjet acc1Equip;
    private TypeObjet acc2Equip;
    private ListeTec att;
    private ArrayList<D_UNI> def_uni;
    
    public Personnage(String nom, String capacite, String classe, int niv, double pv, int pm, int force,
            int def, int magie, int res, int vit, int prec, int agi, int exp, int expNivSup,
            TypeObjet main, TypeObjet corps, TypeObjet tete, TypeObjet pied, TypeObjet acc1, TypeObjet acc2) {

        super(nom, niv, pv, pm, force, def, magie, res, vit, prec, agi, exp, 0, 0, 0, null);
        this.capacite = capacite;
        this.classe = classe;
        this.equipMain = null;
        this.equipCorps = null;
        this.equipTete = null;
        this.equipPied = null;
        this.equipAcc1 = null;
        this.equipAcc2 = null;
        this.mainEquip = main;
        this.corpsEquip = corps;
        this.teteEquip = tete;
        this.piedEquip = pied;
        this.acc1Equip = acc1;
        this.acc2Equip = acc2;
        this.att = new ListeTec();
        this.def_uni = new ArrayList<> ();
    }

    public Personnage (Personnage perso) {
       super(perso);
       this.capacite = perso.capacite;
        this.classe = perso.classe;
        this.equipMain = perso.equipMain;
        this.equipCorps = perso.equipCorps;
        this.equipTete = perso.equipTete;
        this.equipPied = perso.equipPied;
        this.equipAcc1 = perso.equipAcc1;
        this.equipAcc2 = perso.equipAcc2;
        this.mainEquip = perso.mainEquip;
        this.corpsEquip = perso.corpsEquip;
        this.teteEquip = perso.teteEquip;
        this.piedEquip = perso.piedEquip;
        this.acc1Equip = perso.acc1Equip;
        this.acc2Equip = perso.acc2Equip;
        this.att=perso.att;
        this.def_uni = perso.def_uni;
        this.att = perso.att;
    }

    public String getCapacite() {
        return this.capacite;
    }

    public String getClasse() {
        return this.classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public TypeObjet getMainEquip() {
        return this.mainEquip;
    }

    public TypeObjet getCorpsEquip() {
        return this.corpsEquip;
    }

    public TypeObjet getTeteEquip() {
        return this.teteEquip;
    }

    public TypeObjet getPiedEquip() {
        return this.piedEquip;
    }

    public TypeObjet getAcc1Equip() {
        return this.acc1Equip;
    }

    public TypeObjet getAcc2Equip() {
        return this.acc2Equip;
    }

    public ListeTec getAtt () {
        return this.att;
    }

    public Equip getArme () {
        return this.equipMain;
    }

    public Equip getArmure () {
        return this.equipCorps;
    }

    public Equip getChapeau () {
        return this.equipTete;
    }

    public Equip getBotte () {
        return this.equipPied;
    }

    public Equip getAcc1 () {
        return this.equipAcc1;
    }

    public Equip getAcc2 () {
        return this.equipAcc2;
    }

    public boolean estEquipMain () {
        return this.equipMain!=null;
    }
    public Equip equiper(Equip equipement) {
        Equip equip;
        if (equipement.getCategorie().equals(Categorie_objet.arme)) {
            equip = this.equipMain;
        } else {
            equip=this.equipCorps;
        }
        this.equipMain = equipement;
        return equip;
    }
    public boolean estEquipCorps () {
        return this.equipCorps!=null;
    }
    
    public boolean estEquipTete () {
        return this.equipTete!=null;
    }
    
    public boolean estEquipPied () {
        return this.equipPied!=null;
    }
    
    public boolean estEquipAcc1 () {
        return this.equipAcc1!=null;
    }
   
    public boolean estEquipAcc2 () {
        return this.equipAcc2!=null;
    }

    public void ajouterD_UNI (D_UNI d) {
        this.def_uni.add(d);
    }

    public void enleverD_UNI (D_UNI d) {
        this.def_uni.remove(d);
    }
    
    public Objet_diver voleObjet (Ennemie adv, int i) {
        Objet_diver objet=null;
        if (i==1) {
            objet=adv.getObjet1();
            adv.setObjet1();
        }
        if (i==2) {
            objet=adv.getObjet2();
            adv.setObjet2();
        }
        if (i==4) {
            objet=adv.getObjet4();
            adv.setObjet4();
        }
        return objet;
    }
    public Equip voleEquip (Ennemie adv, int i) {
        Equip objet=null;
        if (i==3) {
            objet=adv.getObjet3();
            adv.setObjet3();
        }
        if (i==5) {
            objet=adv.getObjet5();
            adv.setObjet5();
        }
        return objet;
    }

    public boolean possedeD_UNI (D_UNI d) {
        for (int i=0 ; i<this.def_uni.size() ; i++) {
            if (this.def_uni.get(i).equals(d)) {
                return true;
            }
        }
        return false;
    }
}


