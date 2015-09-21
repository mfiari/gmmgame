/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.objet;


/**
 *
 * @author mike
 */
public enum TypeObjet implements mfiari.lib.game.interfaces.TypeObjet {
    
    /*objet*/
    soin, soin_stat, soin_etat, rare,
    /*arme */
    epee, hache, livre, arc, botte, chapeau, robe, veste, armure, accessoire, casque, lance, balai, epee_livre, baton,
    parchemin, couteau,
    /*objet passage*/
    porte, escalier_montant, escalier_descendant, chemin,
    /*objet coffre */
    bureau, coffre,
    /*objet observable ou coffre*/
    etagere,
    /* objet observable */
    
    /*objet classique */
    table, arbre, lit, mur, grand_chene, place, fontaine, herbe;

    @Override
    public boolean estBloquant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estPassageDirect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
