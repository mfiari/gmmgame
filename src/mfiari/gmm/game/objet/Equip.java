package mfiari.gmm.game.objet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mike
 */
public class Equip extends Objet {

    private Categorie_objet categorie;

    public Equip(String nom, Categorie_objet categorie, TypeObjet type, int pv, int pm, int force, int def, int magie, int res, int vit, 
            int prec, int agi, int prixAchat, int prixVente, String description, int quantite) {
        
        super(nom, type, pv, pm, force, def, magie, res, vit, prec, agi, prixAchat, prixVente, description, quantite);
        this.categorie = categorie;
    }

    public Categorie_objet getCategorie() {
        return this.categorie;
    }
}
