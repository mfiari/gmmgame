/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.demarrage;

import mfiari.gmm.game.Vues;
import mfiari.gmm.game.extra.MenuExtra;
import mfiari.gmm.game.GmmJeu;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.ville.Endroit;
import mfiari.gmm.game.ville.Endroits;
import java.util.ArrayList;
import mfiari.lib.game.controlleur.ControlleurVue;
import mfiari.lib.game.evenements.EvenementQuete;
import mfiari.lib.game.liste.ListeObjet;
import mfiari.lib.game.texte.Langue;
import mfiari.lib.game.texte.Texte;

/**
 *
 * @author mike
 */
public class Demarrage extends ControlleurVue {

    private EvenementQuete quete_jeu;
    private ListeObjet sac;
    private ArrayList<Endroit> carte_gmm;
    private ArrayList<Endroit> endroitVisite;
    private ArrayList<Endroit> carte_gmm_actuel;
    private int partie;
    private ListeDePerso listePerso;
    private ListeDePerso equipe;
    private CreationPerso creationPerso;
    private CreationVille creationVille;
    private CreationEvenement creationEvenement;
    private CreationEnnemie creationEnnemie;
    private CreationObjet creationObjet;
    private CreationTechnique creationTechnique;

    public Demarrage() {
    }
    
    private void debutJeu() {
        do {
            this.pcsControlleurVue.firePropertyChange("choixLangue", null, null);
        } while (this.choix < 1 || this.choix > Langue.values().length);
        Texte.langue = Langue.values()[this.choix-1];
    }

    public void nouvellePartie() {
        //Connexion c = new Connexion(this.jeu);
        this.creationPerso = new CreationPerso();
        this.sac = new ListeObjet();
        this.carte_gmm_actuel = new ArrayList<>();
        this.endroitVisite = new ArrayList<>();
        this.equipe = this.creationPerso.getEquipe();
        this.carte_gmm = this.creationVille.getEndroit();
        this.creationEvenement = new CreationEvenement();
        this.listePerso = this.creationPerso.getPersos();
        this.quete_jeu = this.creationEvenement.getEvenement();
        this.carte_gmm_actuel.add(Endroits.maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent);
        /*this.partie = c.parties();
        c.CreerPartie(partie, equipe.getPersonnage(0));
        for (int i = 0; i < this.carte_gmm.size(); i++) {
            c.enregistrerVille(this.carte_gmm.get(i), this.partie);
        }
        c.enregistrerTechnique(this.creationTechnique.getListeTec(), this.partie);

        c.sauvegarderObjet(this.creationObjet.getListeDObjet(), this.partie);

        for (int i = 0; i < this.listePerso.size(); i++) {
            Personnage p = this.listePerso.getPersonnage(i);
            if (p!=null) {
                c.enregistrerPerso(p, partie, this.equipe);
            }
            D_UNI d = this.listePerso.getD_UNI(i);
            if (d!=null) {
                c.enregistrerD_UNI(d, this.partie, this.equipe);
            }
        }
        c.enregistrerVille(Endroits.maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent,this.partie);

        c.sauvegarderEvenement(this.quete_jeu, this.partie);*/
    }

    public void continuer() {
        
        /*Connexion c = new Connexion(this.jeu);
        this.partie = c.parties();
        String nomPersoPrincipal = c.getNonPersoPrincipale(this.partie);
        this.jeu.setNomPersoPrincipal(nomPersoPrincipal);
        ListeDePerso listeP = new ListeDePerso();
        this.creationPerso = new CreationPerso(true);
        this.listePerso = this.creationPerso.getPersos();
        for (int i=0 ; i < this.listePerso.size() ; i++) {
            listeP.ajouterPerso(this.listePerso.getPerso(i));
        }
        
        listeP.getPersonnage("marco").changerNom(nomPersoPrincipal);
        ListeObjet listeObj = this.creationObjet.getListeDObjet();
        ListeTec listeTec = this.creationTechnique.getListeTec();
        this.carte_gmm = this.creationVille.getEndroit();
        ListeDEndroit e = new ListeDEndroit(this.carte_gmm);

        listeP = c.chargerPersonnages(this.partie, listeP, listeTec, listeObj, e);
        for (int i=0 ; i <listeP.size() ; i++) {
            System.out.println(listeP.getPerso(i));
            System.out.println(listeP.getPersonnage(i).getNom());
            System.out.println(this.listePerso.getPersonnage(""));
            this.listePerso.enleverPerso(this.listePerso.getPerso(listeP.getPerso(i).getNom()));
            this.listePerso.ajouterPerso(listeP.getPersonnage(i));
        }
        this.listePerso.getPersonnage(c.getNonPersoPrincipale(this.partie)).getPosition().getEndroit().enleverGens(
        this.listePerso.getPersonnage(c.getNonPersoPrincipale(this.partie)));
        this.equipe = c.chargerEquipe(this.partie, listeP, listeTec, listeObj, e);
        this.carte_gmm = c.chargerEndroit(e,this.partie);
        this.sac = c.chargerObjet(listeObj, this.partie);
        int nbEvenementChapitre = c.chargerEvenementChapitre(this.partie);
        int nbQueteAnnex = c.chargerQueteAnnexe(nbEvenementChapitre, this.partie);
        this.creationEvenement = new CreationEvenement();
        this.quete_jeu = this.creationEvenement.getEvenement();
        EvenementQuete chapitre = (EvenementQuete) this.quete_jeu.getEvenement();
        if (nbEvenementChapitre-1 > 0) {
            for (int i=0 ; i<nbEvenementChapitre ; i++) {
                chapitre.FinirEvenement();
                chapitre.enleverGens();
                this.quete_jeu.evenementSuivant();
                chapitre = (EvenementQuete) this.quete_jeu.getEvenement();
            }
        }
        int nbEvenementQuete = c.chargerEvenementQuete(nbEvenementChapitre, this.partie);
        EvenementQuete quete = (EvenementQuete) chapitre.getEvenement();
        if (nbEvenementQuete-1 > 0) {
            for (int i=0 ; i<nbEvenementQuete ; i++) {
                quete.FinirEvenement();
                quete.enleverGens();
                chapitre.evenementSuivant();
                quete = (EvenementQuete) chapitre.getEvenement();
            }
        }
        int nbQuete = c.chargerQuete(nbEvenementQuete, nbEvenementChapitre, this.partie);
        Evenement evenement = quete.getEvenement();
        if (nbQuete-1 > 0) {
            for (int i=0 ; i<nbQuete ; i++) {
                evenement.FinirEvenement();
                evenement.enleverGens();
                quete.evenementSuivant();
                evenement = quete.getEvenement();
            }
        }*/

    }

    public void extra() {
        MenuExtra m = new MenuExtra ();
        Vues.createVue(m);
        m.menu();
    }

    public void jeu() {
        this.debutJeu();
        do {
            this.pcsControlleurVue.firePropertyChange("debutJeu", null, null);
            switch (this.choix) {
                case (1):
                    this.creationVille = new CreationVille();
                    this.creationEnnemie = new CreationEnnemie();
                    //this.creationObjet = new CreationObjet ();
                    this.creationTechnique = new CreationTechnique ();
                    nouvellePartie();
                    GmmJeu jeu = new GmmJeu();
                    Vues.createVue(jeu);
                    jeu.jouer(this.quete_jeu, this.equipe, this.listePerso, this.sac, this.carte_gmm, this.partie);
                    break;
                case (2):
                    continuer();
                    break;
                case (3):
                    extra();
                    break;
            }
        } while (this.choix != 0);
    }
}
