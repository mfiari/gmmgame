/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.objet;

/**
 *
 * @author mike
 */
public class Objets {

    public static Objet_diver potion = new Objet_diver("potion", TypeObjet.soin, "statP", "rien", 
            100, 0, 0, 0, 0, 0, 0, 0, 0, 75, 25, "redonne des pv", 0);
    public static Objet_diver ether = new Objet_diver("ether", TypeObjet.soin, "statP", "rien", 
            0, 50, 0, 0, 0, 0, 0, 0, 0, 120, 40, "redonne des pm", 0);
    public static Objet_diver antidote = new Objet_diver("antidote", TypeObjet.soin, "etatP", "rien", 
            100, 0, 0, 0, 0, 0, 0, 0, 0, 50, 15, "soigne poison", 0);
    public static Objet_diver renais = new Objet_diver("antidote", TypeObjet.soin, "etatP", "rien", 
            100, 0, 0, 0, 0, 0, 0, 0, 0, 50, 15, "soigne poison", 0);
    public static Objet_diver listeDennemi = new Objet_diver("livre ennemi", TypeObjet.rare, "rien", 
            "rien", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "liste des ennemi rencontrer au cours du jeu", 0);
    public static Equip epeeEnBois = new Equip("epee en bois", Categorie_objet.arme, TypeObjet.epee,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 33, "epee en bois, pratique pour l'entrainement", 0);
    public static Equip hacheEnBois = new Equip("hache en bois", Categorie_objet.arme, TypeObjet.hache,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 30, "hache en bois, pratique pour l'entrainement", 0);
    public static Equip livreDeMagie = new Equip("livre de magie", Categorie_objet.arme, 
            TypeObjet.livre, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 36, "livre pour magicient debutant", 0);
    public static Equip arcEnBois = new Equip("arc en bois", Categorie_objet.arme, TypeObjet.arc,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 80, 26, "arc en bois, pratique pour l'entrainement", 0);
    public static Equip epeeEnFer = new Equip("epee en fer", Categorie_objet.arme, TypeObjet.epee,
            0, 0, 3, 0, 0, 0, 0, 0, 0, 120, 40, "simple epee en fer", 0);
    public static Equip botteEnCuir = new Equip("botte en cuir", Categorie_objet.botte, TypeObjet.botte,
            0, 0, 0, 2, 0, 0, 1, 0, 0, 60, 20, "botte en cuir, assez confortable", 0);
    public static Equip chapeau = new Equip("chapeau", Categorie_objet.chapeau, TypeObjet.chapeau,
            0, 0, 0, 1, 0, 0, 0, 0, 0, 60, 40, "simple chapeau", 0);
    public static Equip cape = new Equip("cape", Categorie_objet.armure, TypeObjet.robe,
            0, 0, 0, 1, 0, 2, 0, 0, 0, 60, 40, "cape de voyage", 0);
    public static Equip vesteEnCuir = new Equip("veste en cuir", Categorie_objet.armure, 
            TypeObjet.veste, 0, 0, 0, 2, 0, 0, 0, 0, 0, 60, 40, "veste en cuir, assez confortable", 0);
}
