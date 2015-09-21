/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.perso;

import mfiari.gmm.game.objet.TypeObjet;

/**
 *
 * @author mike
 */
public class Personnages {
    
    public static Personnage marco = new Personnage("marco", "technique", "ecolier", 2, 120, 12, 70, 16, 3, 6, 35, 40, 38, 0, 75, 
            TypeObjet.epee, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage marcoNiv100 = new Personnage("marco", "technique", "ecolier", 100, 6000, 600, 3500, 800, 150, 300, 1750, 2000, 1900, 1000000, 
            0, TypeObjet.epee, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage vard = new Personnage("Vard", "magie", "ecolier", 3, 90, 45, 8, 9, 82, 33, 41, 50, 45, 0, 72, 
            TypeObjet.livre, TypeObjet.robe, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage vardNiv100 = new Personnage("Vard", "magie", "ecolier", 100, 4500, 2250, 400, 450, 4100, 1650, 2050, 2500, 2250, 1000000, 0, 
            TypeObjet.livre, TypeObjet.robe, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage mok = new Personnage("Mok", "technique", "ecolier", 7, 220, 18, 186, 40, 14, 2, 36, 50, 35, 0, 326, 
            TypeObjet.hache, TypeObjet.armure, TypeObjet.casque, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage mokNiv100 = new Personnage("Mok", "technique", "ecolier", 100, 8000, 900, 7300, 2000, 700, 100, 1800, 2500, 1750, 1000000, 0, 
            TypeObjet.hache, TypeObjet.armure, TypeObjet.casque, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage blake = new Personnage("Blake", "technique", "apprenti archer", 5, 200, 24, 84, 32, 14, 9, 61, 70, 54, 0, 264, 
            TypeObjet.arc, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage blakeNiv100 = new Personnage("Blake", "technique", "apprenti archer", 100, 7500, 1200, 4200, 1600, 700, 450, 3050, 3500, 
            3700, 1000000, 0, TypeObjet.arc, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage roman = new Personnage("Roman", "technique", "chef de groupe", 12, 300, 70, 260, 113, 47, 41, 92, 72, 78, 0, 1020, 
            TypeObjet.epee, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage romanNiv100 = new Personnage("Roman", "technique", "chef de groupe", 12, 5500, 700, 2600, 1130, 470, 410, 920, 720, 780, 
            1000000, 0, TypeObjet.epee, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage lola = new Personnage ("Lola", "magie", "apprenti mage", 12, 224, 84, 28, 13, 217, 108, 92, 72, 78, 0, 1020, 
            TypeObjet.livre, TypeObjet.robe, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage lolaNiv100 = new Personnage ("Lola", "magie", "apprenti mage", 100, 3700, 2800, 270, 330, 5000, 1800, 2630, 2100, 2500, 
            1000000, 0, TypeObjet.livre, TypeObjet.robe, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Metamorphe alexis = new Metamorphe ("Alexis", "techn. Metamorph", "loup", 8, 230, 45, 101, 63, 21, 12, 71, 84, 42, 0, 508, 
            TypeObjet.epee, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage conan = new Personnage ("Conan", "technique", "chevalier", 30, 300, 70, 260, 113, 47, 41, 92, 72, 78, 0, 1020, 
            TypeObjet.lance, TypeObjet.armure, TypeObjet.casque, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage cross = new Personnage ("Cross", "technique", "apprenti archer", 6, 300, 70, 260, 113, 47, 41, 92, 72, 78, 0, 1020, 
            TypeObjet.arc, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage cynthia = new Personnage ("Cynthia", "sorcellerie", "apprenti sorcière", 21, 300, 70, 260, 113, 47, 41, 92, 72, 78, 0, 1020, 
            TypeObjet.balai, TypeObjet.robe, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Metamorphe edson = new Metamorphe ("Edson", "techn.Metamorph", "python", 6, 300, 70, 260, 113, 47, 41, 92, 72, 78, 0, 1020, 
            TypeObjet.epee, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage garrucha = new Personnage ("Garrucha", "technique/sort", "mage guerrier", 68, 300, 70, 260, 113, 47, 41, 92, 72, 78, 0, 1020,
            TypeObjet.epee_livre, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Metamorphe oisillon = new Metamorphe ("Oisillon", "techn.Metamorph", "aigle", 33, 300, 70, 260, 113, 47, 41, 92, 72, 78, 0, 1020, 
            TypeObjet.epee, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage pepe = new Personnage ("Pepe", "technique", "mage blanc", 1, 78, 70, 14, 4, 104, 41, 50, 28, 34, 0, 51, 
            TypeObjet.baton, TypeObjet.robe, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage roberto = new Personnage ("Roberto", "aide", "ecolier", 30, 300, 70, 260, 113, 47, 41, 92, 72, 78, 0, 1020, 
            TypeObjet.parchemin, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage sony = new Personnage ("Sony", "technique", "mage blanc", 30, 300, 70, 260, 113, 47, 41, 92, 72, 78, 0, 1020, 
            TypeObjet.baton, TypeObjet.robe, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static Personnage tom = new Personnage ("Tom", "technique", "voleur", 30, 300, 70, 260, 113, 47, 41, 92, 72, 78, 0, 1020, 
            TypeObjet.couteau, TypeObjet.veste, TypeObjet.chapeau, TypeObjet.botte, TypeObjet.accessoire, TypeObjet.accessoire);
    public static D_UNI galactika = new D_UNI ("Galactika", "technique", 50, 2543, 1065, 469, 123, 503, 204, 314, 352, 247, 5400, 8100);
    public static D_UNI fuleau = new D_UNI ("Fuleau", "technique", 50, 2543, 1065, 469, 123, 503, 204, 314, 352, 247, 5400, 8100);
    public static D_UNI foudroineau = new D_UNI ("Foudroineau", "technique", 50, 2543, 1065, 469, 123, 503, 204, 314, 352,247, 5400, 8100);
    public static D_UNI typhon = new D_UNI ("Typhon", "technique", 50, 2543, 1065, 469, 123, 503, 204, 314, 352,247, 5400, 8100);
    public static D_UNI guimelar = new D_UNI ("Guimelar", "technique", 50, 2543, 1065, 469, 123, 503, 204, 314, 352, 247, 5400, 8100);
    public static D_UNI medicoru = new D_UNI ("Medicoru", "technique", 50, 2543, 1065, 469, 123, 503, 204, 314, 352, 247, 5400, 8100);
    public static D_UNI espancien = new D_UNI ("Espancien", "technique", 50, 2543, 1065, 469, 123, 503, 204, 314, 352, 247, 5400, 8100);
    public static D_UNI goroku = new D_UNI ("Goroku", "technique", 50, 2543, 1065, 469, 123, 503, 204, 314, 352, 247, 5400, 8100);
    public static D_UNI bulzator = new D_UNI ("Bulzator", "technique", 50, 2543, 1065, 469, 123, 503, 204, 314, 352, 247, 5400, 8100);
}
