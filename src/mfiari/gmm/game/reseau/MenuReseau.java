/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.reseau;

import mfiari.gmm.game.Global;
import mfiari.gmm.game.Vues;
import mfiari.gmm.game.demarrage.CreationPerso;
import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.perso.Ennemies;
import mfiari.gmm.game.perso.Personnage;
import mfiari.gmm.game.perso.Personnages;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import mfiari.lib.game.controlleur.ControlleurVue;
import mfiari.lib.game.reseau.Client;
import mfiari.lib.game.reseau.EnvoiObjet;
import mfiari.lib.game.reseau.ReceveurObjet;
import mfiari.lib.game.reseau.Serveur;

/**
 *
 * @author mike
 */
public class MenuReseau extends ControlleurVue {
    
    public MenuReseau () {
        
    }
    
    public void menu() {
        try {
        CreationPerso creationPerso = new CreationPerso();
        do {
            this.pcsControlleurVue.firePropertyChange("choixClientServeur", null, null);
            switch (choix) {
                case 1 :
                    Serveur serveur = new Serveur();
                    serveur.lancerServeur(Global.port);
                    while (!serveur.clientArrive()) {
                        this.pcsControlleurVue.firePropertyChange("attenteJoueur", null, null);
                        this.attendre(1000);
                    }
                    Socket socket = serveur.getSocket();
                    ListeDePerso equipe = new ListeDePerso();
                    ListeDePerso adversaire = new ListeDePerso();
                    Personnage p = Personnages.marco;
                    EnvoiObjet envoi = new EnvoiObjet(socket);
                    System.out.println("ok");
                    envoi.writeObject(p);
                    ReceveurObjet receveur = new ReceveurObjet(socket);
                    Personnage alie = (Personnage) receveur.readObject();
                    System.out.println("ok2");
                    equipe.ajouterPerso(p);
                    equipe.ajouterPerso(alie);
                    adversaire.ajouterPerso(Ennemies.lapin);
                    adversaire.ajouterPerso(Ennemies.lapin);
                    CombatServeur combat = new CombatServeur(socket, equipe, adversaire, p);
                    Vues.createVue(combat);
                    combat.combat();
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MenuReseau.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2 :
                    Client client = new Client();
                    do {
                        this.pcsControlleurVue.firePropertyChange("rechercheHote", null, null);
                        this.attendre(1000);
                        client.lancerClient(Global.serveur, Global.port);
                    } while (!client.estConnecter());
                    Socket socket2 = client.getSocket();
                    ListeDePerso equipe2 = new ListeDePerso();
                    ListeDePerso adversaire2 = new ListeDePerso();
                    Personnage p2 = Personnages.vard;
                    ReceveurObjet receveur2 = new ReceveurObjet(socket2);
                    System.out.println("ok");
                    Personnage alie2 = (Personnage) receveur2.readObject();
                    EnvoiObjet envoi2 = new EnvoiObjet(socket2);
                    envoi2.writeObject(p2);
                    System.out.println("ok2");
                    equipe2.ajouterPerso(alie2);
                    equipe2.ajouterPerso(p2);
                    adversaire2.ajouterPerso(Ennemies.lapin);
                    adversaire2.ajouterPerso(Ennemies.lapin);
                    CombatClient combatClient = new CombatClient(socket2, equipe2, adversaire2, p2);
                    Vues.createVue(combatClient);
                    combatClient.combat();
                    try {
                        socket2.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MenuReseau.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        } while (choix != 0);
        } catch (IOException ex) {
            Logger.getLogger(CombatReseau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}