package mfiari.gmm.game.objet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mike
 */
public class Objet_diver extends Objet {

    private String effet1;
    private String effet2;

    public Objet_diver(String nom, TypeObjet type, String effet1, String effet2, int pv, int pm,
            int force, int def, int magie, int res, int vit, int prec, int agi, int prixAchat,
            int prixVente, String description, int quantite) {

        super(nom, type, pv, pm, force, def, magie, res, vit, prec, agi, prixAchat, prixVente,
                description, quantite);
        this.effet1 = effet1;
        this.effet2 = effet2;
    }

    public String getEffet1() {
        return this.effet1;
    }

    public String getEffet2() {
        return this.effet2;
    }

    
}
