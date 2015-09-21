/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.perso;

import mfiari.gmm.game.technique.Types;

/**
 *
 * @author mike
 */
public class Ennemies {
    
    public static Ennemie lapin = new Ennemie(3, "Lapin", 1, 120, 12, 21, 18, 1, 2, 40, 23, 28, 0, 20, Types.animal, Types.aucun);
    public static Ennemie lapinNivMax = new Ennemie(3, "Lapin", 3, 120, 12, 21, 18, 1, 2, 40, 23, 28, 0, 20, Types.animal, Types.aucun);
    public static Ennemie renard = new Ennemie(2, "Renard", 1, 176, 20, 26, 25, 36, 5, 43, 35, 31, 0, 30, Types.felin, Types.aucun);
    public static Ennemie renardNivMax = new Ennemie(2, "Renard", 3, 176, 20, 26, 25, 36, 5, 43, 35, 31, 0, 30, Types.felin, Types.aucun);
    public static Ennemie cerf = new Ennemie(1, "Cerf", 1, 190, 32, 43, 32, 12, 20, 36, 60, 31, 0, 50, Types.animal, Types.aucun);
    public static Ennemie cerfNivMax = new Ennemie(1, "Cerf", 3, 190, 32, 43, 32, 12, 20, 36, 60, 31, 0, 50, Types.animal, Types.aucun);
    public static Ennemie examinateur = new Ennemie(5, "Examinateur", 1, 130, 22, 54, 35, 8, 13, 27, 48,29, 100, 500, Types.humain, Types.aucun);
    public static Ennemie examinateurNivMax = new Ennemie(5, "Examinateur", 3, 130, 22, 54, 35, 8, 13, 27, 48,29, 100, 500, Types.humain, Types.aucun);
    public static Ennemie humanocible = new Ennemie(5, "Humanocible", 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, Types.normal, Types.aucun);
    public static Ennemie humanocibleNivMax = new Ennemie(5, "Humanocible", 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, Types.normal, Types.aucun);
    public static Ennemie chat = new Ennemie(9, "Chat guerrier", 1, 310, 40, 73, 50, 6, 14, 65, 68, 70, 72, 83, Types.felin, Types.aucun);
    public static Ennemie chatNivMax = new Ennemie(9, "Chat guerrier", 3, 310, 40, 73, 50, 6, 14, 65, 68, 70, 72, 83, Types.felin, Types.aucun);
    public static Ennemie rat = new Ennemie(10, "Rat geant", 1, 270, 32, 68, 47, 12, 24, 58, 54, 35, 51,60, Types.animal, Types.aucun);
    public static Ennemie ratNivMax = new Ennemie(10, "Rat geant", 3, 270, 32, 68, 47, 12, 24, 58, 54, 35, 51,60, Types.animal, Types.aucun);
    public static Ennemie bandit = new Ennemie(6, "Bandit", 1, 350, 40, 82, 61, 20, 35, 55, 59, 48, 87,105, Types.humain, Types.aucun);
    public static Ennemie banditNivMax = new Ennemie(6, "Bandit", 3, 350, 40, 82, 61, 20, 35, 55, 59, 48, 87,105, Types.humain, Types.aucun);
    public static Ennemie lola = new Ennemie(171, "Lola", 1, 130, 22, 18, 32, 51, 40, 60, 62, 37, 0, 0, Types.humain, Types.aucun);
    public static Ennemie lolaNivMax = new Ennemie(171, "Lola", 3, 130, 22, 18, 32, 51, 40, 60, 62, 37, 0, 0, Types.humain, Types.aucun);
    public static Ennemie chauveSourie = new Ennemie(11, "Chauve sourie geante", 1, 350, 50, 75, 55, 20,35, 62, 65, 57, 75, 90, Types.animal, Types.vol);
    public static Ennemie chauveSourieNivMax = new Ennemie(11, "Chauve sourie geante", 3, 350, 50, 75, 55, 20,35, 62, 65, 57, 75, 90, Types.animal, 
            Types.vol);
    public static Ennemie soldatGarrucha = new Ennemie(25, "Soldat de garrucha", 1, 300, 50, 52, 40, 20,32, 60, 58, 57, 70, 80, Types.humain, Types.aucun);
    public static Ennemie soldatGarruchaNivMax = new Ennemie(25, "Soldat de garrucha", 3, 300, 50, 52, 40, 20,32, 60, 58, 57, 70, 80, Types.humain, 
            Types.aucun);
    public static Ennemie morgane = new Ennemie(193, "Morgane", 1, 330, 200, 20, 13, 150, 80, 112, 87, 81, 210, 320, Types.humain, Types.feu);
    public static Ennemie morganeNivMax = new Ennemie(193, "Morgane", 3, 330, 200, 20, 13, 150, 80, 112, 87, 81, 210, 320, Types.humain, Types.feu);
    public static Ennemie yuan = new Ennemie(194, "Yuan", 1, 520, 93, 170, 91, 13, 23, 81, 70, 74, 220,340, Types.humain, Types.aucun);
    public static Ennemie yuanNivMax = new Ennemie(194, "Yuan", 3, 520, 93, 170, 91, 13, 23, 81, 70, 74, 220,340, Types.humain, Types.aucun);
}
