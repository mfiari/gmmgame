/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.demarrage;

import mfiari.gmm.game.liste.ListeDePerso;
import mfiari.gmm.game.menu.Stat;
import mfiari.gmm.game.perso.Ennemies;
import mfiari.gmm.game.technique.Techniques;

/**
 *
 * @author mike
 */
public class CreationEnnemie {
    
    private ListeDePerso listePerso;

    public CreationEnnemie () {
        this.listePerso = new ListeDePerso () ;

        this.creationPersonnages();
        
        this.listePerso.ajouterPerso(Ennemies.bandit);
        this.listePerso.ajouterPerso(Ennemies.cerf);
        this.listePerso.ajouterPerso(Ennemies.chat);
        this.listePerso.ajouterPerso(Ennemies.chauveSourie);
        this.listePerso.ajouterPerso(Ennemies.examinateur);
        this.listePerso.ajouterPerso(Ennemies.humanocible);
        this.listePerso.ajouterPerso(Ennemies.lapin);
        this.listePerso.ajouterPerso(Ennemies.lola);
        this.listePerso.ajouterPerso(Ennemies.morgane);
        this.listePerso.ajouterPerso(Ennemies.rat);
        this.listePerso.ajouterPerso(Ennemies.renard);
        this.listePerso.ajouterPerso(Ennemies.soldatGarrucha);
        this.listePerso.ajouterPerso(Ennemies.yuan);
    }

    private void creationPersonnages () {
        Ennemies.humanocible.setStat(new Stat(Ennemies.humanocible, Ennemies.humanocibleNivMax));
        Ennemies.lapin.setStat(new Stat(Ennemies.lapin, Ennemies.lapinNivMax));
        Ennemies.renard.getTec().ajoutTec(Techniques.morsure);
        Ennemies.renard.setStat(new Stat(Ennemies.renard, Ennemies.renardNivMax));
        Ennemies.cerf.getTec().ajoutTec(Techniques.coupDeCorne);
        Ennemies.cerf.setStat(new Stat(Ennemies.cerf, Ennemies.cerfNivMax));
        Ennemies.chat.getTec().ajoutTec(Techniques.griffe);
        Ennemies.chat.getTec().ajoutTec(Techniques.coupDePiedSaute);
        Ennemies.chat.getTec().ajoutTec(Techniques.agilite);
        Ennemies.chat.setStat(new Stat(Ennemies.chat, Ennemies.chatNivMax));
        Ennemies.rat.getTec().ajoutTec(Techniques.morsurePoison);
        Ennemies.rat.getTec().ajoutTec(Techniques.coupDeQueue);
        Ennemies.rat.setStat(new Stat(Ennemies.rat, Ennemies.ratNivMax));
        Ennemies.bandit.getTec().ajoutTec(Techniques.couteau);
        Ennemies.bandit.getTec().ajoutTec(Techniques.voler);
        Ennemies.bandit.setStat(new Stat(Ennemies.bandit, Ennemies.banditNivMax));
        Ennemies.lola.getTec().ajoutTec(Techniques.eau);
        Ennemies.lola.setStat(new Stat(Ennemies.lola, Ennemies.lolaNivMax));
        Ennemies.chauveSourie.getTec().ajoutTec(Techniques.morsurePoison);
        Ennemies.chauveSourie.getTec().ajoutTec(Techniques.ultrason);
        Ennemies.chauveSourie.getTec().ajoutTec(Techniques.vampirisme);
        Ennemies.chauveSourie.setStat(new Stat(Ennemies.chauveSourie, Ennemies.chauveSourieNivMax));
        Ennemies.soldatGarrucha.getTec().ajoutTec(Techniques.lance);
        Ennemies.soldatGarrucha.setStat(new Stat(Ennemies.soldatGarrucha, Ennemies.soldatGarruchaNivMax));
        Ennemies.morgane.getTec().ajoutTec(Techniques.feu);
        Ennemies.morgane.getTec().ajoutTec(Techniques.jetFlamme);
        Ennemies.morgane.setStat(new Stat(Ennemies.morgane, Ennemies.morganeNivMax));
        Ennemies.yuan.getTec().ajoutTec(Techniques.lame);
        Ennemies.yuan.setStat(new Stat(Ennemies.yuan, Ennemies.yuanNivMax));
    }

    public ListeDePerso getPersos () {
        return this.listePerso;
    }

}
