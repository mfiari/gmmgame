/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.ville;
import mfiari.gmm.game.GmmJeu;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.objet.Objet;
import mfiari.lib.game.liste.ListeObjet;
/**
 *
 * @author mike
 */
public class magasin extends Batiments {
    private ListeObjet magasin;

    public magasin (String nom, int positionX, int positionY, int longueur, int largeur,
            int etageMax) {
        super(nom, positionX, positionY, longueur, largeur, 0, etageMax);
        this.magasin = new ListeObjet();
    }

    public void ajouterObjet (Objet o) {
        this.magasin.ajoutObjet(o);
    }

    public void enleverObjet (Objet o) {
        this.magasin.enleverObjet(o);
    }

    public void acheter (GmmJeu jeu, ListeDePerso equipe) {
        //jeu.menuObjetMagasin(this.magasin, "Que voulez vous acheter ?");
        int a = jeu.getChoix();
        if (a>0 && a<=this.magasin.size()) {
            jeu.choix("combien ?");
            if (jeu.getChoix()>0 && jeu.getChoix()*this.magasin.getObjet(a).getPrixAchat() <= equipe.getArgent()) {
                equipe.getSac().acheter(this.magasin.getObjet(a), jeu.getChoix());
            }
        }
    }

    public void vendre (GmmJeu jeu, ListeDePerso equipe) {
        //jeu.menuObjetMagasin(equipe.getSac(), "Que voulez vous acheter ?");
        int a = jeu.getChoix();
        if (a>0 && a<=equipe.getSac().size()) {
            jeu.choix("combien ?");
            if (jeu.getChoix()>0) {
                equipe.getSac().vendre(a, jeu.getChoix());
                equipe.setArgent(equipe.getSac().getObjet(a).getPrixVente()*jeu.getChoix());
            }
        }
    }
}
