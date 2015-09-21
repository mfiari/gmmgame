/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game;

import mfiari.gmm.game.objet.Objet_endroit_observable;
import mfiari.gmm.game.objet.Objet_endroit_coffre;
import mfiari.gmm.game.objet.Objet;
import mfiari.gmm.game.objet.Objet_endroit_passage;
import mfiari.gmm.game.objet.TypeObjet;
import mfiari.gmm.game.demarrage.Demarrage;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.liste.ListeTec;
import mfiari.gmm.game.menu.Menu;
import mfiari.gmm.game.perso.Personnage;
import mfiari.gmm.game.perso.Personnages;
import mfiari.gmm.game.texte.Texte;
import mfiari.gmm.game.texte.Texte_fr;
import mfiari.gmm.game.ville.Endroit;
import java.sql.ResultSet;
import java.util.ArrayList;
import mfiari.lib.game.evenements.Evenement;
import mfiari.lib.game.evenements.EvenementQuete;
import mfiari.lib.game.jeu.Jeu;
import mfiari.lib.game.liste.ListeObjet;
import mfiari.lib.game.objet.ObjetEndroit;
import mfiari.lib.game.objet.Sac;
import mfiari.lib.game.personnage.Gens;
import mfiari.lib.game.position.Position;

/**
 *
 * @author mike
 */
public class GmmJeu extends Jeu {

    private ResultSet result;
    private ListeDePerso equipe;
    private ListeDePerso listePerso;
    private ListeObjet sac;
    private ListeTec tec;
    private Personnage personnage;
    private ListeDePerso adversaire;
    private int argent;
    private int exp;
    private Evenement e;
    private ArrayList<Endroit> carte_gmm;
    private int partie;
    private int langue;
    private Texte textes;
    private String nomPersoPrincipal;

    @Override
    public void bouger(Position p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean gameOver() {
        return false;
    }

    public GmmJeu() {
        super();
        this.textes = new Texte_fr();
    }

    public Texte getTextes () {
        return this.textes;
    }
    
    public void setNomPersoPrincipal(String nom) {
        this.nomPersoPrincipal = nom;
    }
    
    public String getNomPersoPrincipal() {
        return this.nomPersoPrincipal;
    }
    
    @Override
    public void afficherEndroit (mfiari.lib.game.ville.Endroit endroit) {
        this.endroit = endroit;
        this.equipe = new ListeDePerso();
        this.equipe.ajouterPerso(Personnages.marco);
        this.pcsControlleurVue.firePropertyChange("afficheEndroit", null, null);
    }

    public void jouer(EvenementQuete jeu, ListeDePerso equipe, ListeDePerso listePerso, ListeObjet sac, ArrayList<Endroit> carte_gmm, int partie) {
        super.jouer(jeu, equipe.getPersonnage(0));
        this.jeu = jeu;
        this.equipe = equipe;
        this.sac = sac;
        this.carte_gmm = carte_gmm;
        this.listePerso = listePerso;
        this.partie = partie;
        this.queteAnnexe = null;
        this.endroit = (Endroit)this.equipe.getPersonnage(0).getPosition().getEndroit();
        this.continuer();
        /*
         * this.pcsDeroulementJeu.firePropertyChange("continuer", null, null);
         * affiche la ville où se trouve le perso, en positionnant le perso et les batiments
         * met en marche le timer
         * verifie si il y a un evenement qui se declenche
         * affiche les actions et laisse la main au joueur
         */
    }

    public ListeDePerso getPersos() {
        return this.listePerso;
    }

    public ArrayList<Endroit> getCarte_gmm() {
        return this.carte_gmm;
    }

    public int getPartie () {
        return this.partie;
    }

    public ResultSet getResult() {
        return this.result;
    }

    public void setResultSet(ResultSet result) {
        this.result = result;
        this.pcsControlleurVue.firePropertyChange("voirParties", null, null);
    }

    public void choix(String texte) {
        this.affichage = texte;
        this.pcsControlleurVue.firePropertyChange("choix", null, null);
    }

    @Override
    public void setChoixAction(int choix) {
        this.choix = choix;
        int positionX;
        int positionY;
        switch (this.choix) {
            case (1):
                positionY = this.equipe.getPersonnage(0).getPosition().getPositionY();
                positionX = this.equipe.getPersonnage(0).getPosition().getPositionX() - 1;
                this.bouger(positionX, positionY);
                break;
            case (2):
                positionY = this.equipe.getPersonnage(0).getPosition().getPositionY();
                positionX = this.equipe.getPersonnage(0).getPosition().getPositionX() + 1;
                this.bouger(positionX, positionY);
                break;
            case (3):
                positionY = this.equipe.getPersonnage(0).getPosition().getPositionY() + 1;
                positionX = this.equipe.getPersonnage(0).getPosition().getPositionX();
                this.bouger(positionX, positionY);
                break;
            case (4):
                positionY = this.equipe.getPersonnage(0).getPosition().getPositionY() - 1;
                positionX = this.equipe.getPersonnage(0).getPosition().getPositionX();
                this.bouger(positionX, positionY);
                break;
            case (5):
                this.action();
                break;
            case (6):
                Menu menu = new Menu(this.equipe, this.sac, this);
                Vues.createVue(menu);
                menu.menu();
                break;
        }
        this.perso.setPosition(this.equipe.getPersonnage(0).getPosition());
        //this.continuer();
    }

    public void bouger(int positionX, int positionY) {
        System.out.println("bouger");
        if (!(this.endroit.aObjetEndroit(this.equipe.getPersonnage(0).getPosition()) instanceof Objet_endroit_passage)) {
            System.out.println("pas endroit pasage");
            if (positionX >= 0 && positionX < this.endroit.getLargeur() && positionY >= 0 && positionY < this.endroit.getLongueur()) {
                System.out.println("dans cadre");
                if (this.endroit.aObjetEndroit(new Position(positionX, positionY)) != null) {
                    System.out.println("obje endroit pas null");
                    if (this.endroit.aObjetEndroit(new Position(positionX, positionY)) instanceof Objet_endroit_passage) {
                        System.out.println("dest endroit pasage");
                        Objet_endroit_passage obj = (Objet_endroit_passage) this.endroit.aObjetEndroit(new Position(positionX, positionY));
                        if (!obj.getType().equals(TypeObjet.chemin)) {
                            System.out.println("prendre");
                            obj.prendre(this.equipe.getPersonnage(0));
                            this.endroit = (Endroit)this.equipe.getPersonnage(0).getPosition().getEndroit();
                        } else {
                            System.out.println("chemin");
                            this.equipe.setPositionY(positionY);
                            this.equipe.setPositionX(positionX);
                        }
                    }
                } else if (this.endroit.aGens(new Position(positionX, positionY)) != null) {
                     System.out.println("gens");
                    this.setAffichage(this.textes.impossible);
                } else {
                     System.out.println("voie libre");
                    if (this.endroit.aEndroit(new Position(positionX, positionY)) != null) {
                        ((Endroit)(this.endroit.aEndroit(new Position(positionX, positionY)))).entrer(this.equipe);
                        this.endroit = (Endroit)this.equipe.getPersonnage(0).getPosition().getEndroit();
                    } else {
                        this.equipe.setPositionY(positionY);
                        this.equipe.setPositionX(positionX);
                    }
                }
            }
        } else {
             System.out.println("endroit pasage");
            Objet_endroit_passage obj = (Objet_endroit_passage) this.endroit.aObjetEndroit(this.equipe.getPersonnage(0).getPosition());
            if (positionX < 0 || positionX == this.endroit.getLargeur() || positionY < 0
                    || positionY == this.endroit.getLongueur()) {
                if (!this.quete.verifieEndroitAccessible(obj.getEndroitDarive())) {
                    obj.prendre(this.equipe.getPersonnage(0));
                    this.endroit = (Endroit)this.equipe.getPersonnage(0).getPosition().getEndroit();
                } else {
                }
            } else {
                this.equipe.setPositionY(positionY);
                this.equipe.setPositionX(positionX);
            }
        }
    }

    @Override
    public void action() {
        Gens gensAquiParler = this.verifieGensAquiParler();
        if (gensAquiParler != null) {
            String str = gensAquiParler.Parler();
            while (!str.isEmpty()) {
                this.setParole(str);
                str = gensAquiParler.Parler();
            }
        } else {
            ObjetEndroit objetAobserver = this.verifieObjetAObserver();
            if (objetAobserver != null) {
                if (objetAobserver instanceof Objet_endroit_observable) {
                    Objet_endroit_observable Objet_endroit_observable = (Objet_endroit_observable) objetAobserver;
                    this.setAffichage(Objet_endroit_observable.observer());
                } else {
                    if (objetAobserver instanceof Objet_endroit_coffre) {
                        Objet_endroit_coffre Objet_endroit_coffre = (Objet_endroit_coffre) objetAobserver;
                        Objet objet = Objet_endroit_coffre.ouvrir();
                        if (objet == null) {
                            this.setAffichage(Objet_endroit_coffre.observer());
                        } else {
                            this.setAffichage(this.textes.vousRecevez(objet.getNom()));
                            this.sac.ajoutObjet(objet);
                        }
                    }
                }
            }
        }

    }

    public ListeDePerso getEquipe() {
        return this.equipe;
    }

    /*public ListeObjet getSac() {
        return this.sac;
    }*/

    public ListeTec getTec() {
        return this.tec;
    }

    public Personnage getPersonnage() {
        return this.personnage;
    }

    public ListeDePerso getAdversaires() {
        return this.adversaire;
    }

    public void suivant() {
        this.pcsControlleurVue.firePropertyChange("suivant", null, null);
    }

    public int getLangue () {
        return this.langue;
    }

    public void gameOver(ListeDePerso equipe, ListeDePerso adversaire) {
        /*boolean gameOver = false;
        if (adversaire.size() == 0) {
        System.out.println("vous gagnez le combat");
        } else {
        System.out.println("vous perdez le combat");
        gameOver = true;
        throw new Error("GAME  OVER");
        }*/
        if (equipe.estKO()) {
            this.pcsControlleurVue.firePropertyChange("perdu", null, null);
            Demarrage d = new Demarrage();
            d.jeu();
        }
    }

    @Override
    public int getArgent() {
        return this.argent;
    }

    @Override
    public int getExp() {
        return this.exp;
    }

    public void sauvegarder() {
    }

    @Override
    public Sac getSac() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
