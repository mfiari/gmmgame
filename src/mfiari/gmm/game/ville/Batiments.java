/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.ville;

import mfiari.gmm.game.liste.ListeDePerso;
import java.util.ArrayList;
import mfiari.lib.game.objet.ObjetEndroit;
import mfiari.lib.game.position.Orientation;
import mfiari.lib.game.position.Position;

/**
 *
 * @author mike
 */
abstract public class Batiments extends Quartier {

    private int etage;
    private int etageMin;
    private int etageMax;
    private ArrayList<ArrayList<Salle>> salles;
    private int[] largeurs;
    private int[] longueur;

    public Batiments() {
    }

    public Batiments(String nom, int positionX, int positionY, int longueur, int largeur, int etageMin, int etageMax) {

        super(nom, positionX, positionY, longueur, largeur);

        this.salles = new ArrayList();
        for (int i = 0; i < etageMax - (etageMin - 1); i++) {
            this.salles.add(new ArrayList());
        }
        this.largeurs = new int[etageMax - etageMin + 1];
        this.longueur = new int[etageMax - etageMin + 1];
        this.largeurs[0] = largeur;
        this.longueur[0] = longueur;
        this.etage = 0;
        this.etageMin = etageMin;
        this.etageMax = etageMax;
    }

    public void ajouterSalle(Salle s, int etage) {
        this.salles.get(etage).add(s);
        System.out.println("ajout de salle " + this.getNom() + " ; etage : "+etage+"; taille : " + this.salles.get(etage).size());
    }

    public void setNbSalle(int etage, int longueur, int largeur) {
        this.largeurs[etage] = largeur;
        this.longueur[etage] = longueur;
    }

    @Override
    public void entrer(ListeDePerso equipe) {
        System.out.println("salles : " + this.salles.size());
        System.out.println("salles etage 0 : " + this.salles.get(0).size());
        /*equipe.setEndroit(this.salles.get(0).get(0));
        if (this.salles.get(0).get(0).getObjetEndroit(0).getPosition().getPositionX() == 0) {
            equipe.setPositionX(this.salles.get(0).get(0).getObjetEndroit(0).getPosition().getPositionX() + 1);
            equipe.setPositionY(this.salles.get(0).get(0).getObjetEndroit(0).getPosition().getPositionY());
        } else if (this.salles.get(0).get(0).getObjetEndroit(0).getPosition().getPositionY() == 0) {
            equipe.setPositionX(this.salles.get(0).get(0).getPositionX());
            equipe.setPositionY(this.salles.get(0).get(0).getPositionY() + 1);
        } else if (this.salles.get(0).get(0).getObjetEndroit(0).getPosition().getPositionX() == this.salles.get(0).get(0).getLongueur()) {
            equipe.setPositionX(this.salles.get(0).get(0).getPositionX() - 1);
            equipe.setPositionY(this.salles.get(0).get(0).getPositionY());
        } else {
            equipe.setPositionX(this.salles.get(0).get(0).getPositionX());
            equipe.setPositionY(this.salles.get(0).get(0).getPositionY() - 1);
        }*/
        Salle salle = this.salles.get(0).get(0);
        ObjetEndroit objet_endroit = salle.getObjetEndroit(0);
        Position p = new Position(objet_endroit.getPosition().getPositionX(), objet_endroit.getPosition().getPositionY(), salle);
        if (objet_endroit.getPosition().getPositionX() == 0) {
            p.reculer();
        } else if (objet_endroit.getPosition().getPositionY() == 0) {
            p.droite();
        } else if (objet_endroit.getPosition().getPositionX() == salle.getLargeur() -1) {
            p.avancer();
        } else {
            p.gauche();
        }
        equipe.setEndroit((Endroit)p.getEndroit());
        equipe.setPositionX(p.getPositionX());
        equipe.setPositionY(p.getPositionY());
        //equipe.setPosition(p);
    }

    public void sortir() {
    }

    public void monter() {
        if (this.etage < this.etageMax) {
            this.etage++;
            this.sortir();
            //this.entrer();
        }
    }

    public void descendre() {
        if (this.etage > this.etageMin) {
            this.etage--;
            this.sortir();
            //this.entrer();
        }
    }
    
    public mfiari.lib.game.ville.Batiment toBatiment () {
        mfiari.lib.game.ville.Batiment bat = new mfiari.lib.game.ville.Batiment(this.getNom(), this.getPositionX(), this.getPositionY(), this.getLongueur(), 
                this.getLargeur(), this.etageMin, this.etageMax, Orientation.droite, null);
        return bat;
    }
    
    public static Batiments getInstance (mfiari.lib.game.ville.Batiment bat) {
        if (bat != null) {
            Batiments bati = new Batiment(bat.getNom(), bat.getPosition().getPositionX(), bat.getPosition().getPositionY(), 
                    bat.getLongueur(), bat.getLargeur(), bat.getEtageMin(), bat.getEtageMax());
            return bati;
        }
        return null;
    }
}
