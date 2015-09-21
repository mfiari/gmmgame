/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.technique;

/**
 *
 * @author mike
 */
public class Techniques {

    public static Technique coupDEpee = new Technique("coup d'epee", Types.normal, "attaqueU",
            0.1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0, "coup d'epee");
    public static Technique foudre = new Technique("foudre", Types.electrique, "attaqueU",
            0.1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "magie", 0, "sort de foudre novice");
    public static Technique attaquePuissante = new Technique("attaque puissante", Types.normal, "attaqueU",
            0.1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0, "puissant coup de hache");
    public static Technique fleche = new Technique("fleche", Types.normal, "attaqueU",
            0.1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0, "lance une fleche sur l'ennemi");
    public static Technique morsure = new Technique("morsure", Types.felin, "attaqueU",
            0.1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0, "mord l'adversaire");
    public static Technique coupDeCorne = new Technique("coup de corne", Types.normal, "attaqueU",
            0.15, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0, "charge avec ses corne");
    public static Technique voler = new Technique("voler", Types.normal, "volU",
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0, "vole un adversaire");
    public static Technique soin = new Technique("soin", Types.lumiere, "soinU",
            0.2, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "magie", 0, "soigne un alie");
    public static Technique griffe = new Technique("griffe", Types.felin, "attaqueU",
            0.2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0, "donne un coup de griffe");
    public static Technique coupDePiedSaute = new Technique("coup de pied saute", Types.normal, "attaqueU",
            0.2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0, "donne un coup de pied saute");
    public static Technique agilite = new Technique("agilite", Types.normal, "boostM",
            0.1, 3, 0, 0, 0, 0, 0, 0, 1, 0, 1, Etat.aucun, "technique", 0, "augmente la vitesse et l'agilite");
    public static Technique morsurePoison = new Technique("morsure", Types.reptil, "specialeU",
            0.2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.empoisonne, "technique", 0,
            "mord l'adversaire, peut empoisonne");
    public static Technique coupDeQueue = new Technique("coup de queue", Types.normal, "attaqueU",
            0.2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0, "donne un coup de queue");
    public static Technique ultrason = new Technique("ultrason", Types.normal, "specialeU",
            0.1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.folie, "magie", 0,
            "cri et envoi une onde, peut rendre confus");
    public static Technique couteau = new Technique("coup de couteau", Types.normal, "attaqueU",
            0.2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0, "donne un coup de couteau");
    public static Technique vampirisme = new Technique("vampirisme", Types.normal, "specialeU",
            0.15, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0, "mord et aspire les pv adverse");
    public static Technique eau = new Technique("eau", Types.eau, "attaqueU",
            0.1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "magie", 0, "sort d'eau novice");
    public static Technique lance = new Technique("lance", Types.normal, "attaqueU",
            0.1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0, "attaque l'ennemie avec une lance");
    public static Technique feu = new Technique("feu", Types.feu, "attaqueU",
            0.1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "magie", 0, "sort de feu novice");
    public static Technique lame = new Technique("lame", Types.normal, "attaqueE",
            0.2, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "technique", 0,
            "donne un coup d'epee qui coupe sur une certaine distance");
    public static Technique jetFlamme = new Technique("jet de flamme", Types.feu, "attaqueE",
            0.2, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, Etat.aucun, "magie", 0,
            "jette des flammes sur tous les adversaires");
}
