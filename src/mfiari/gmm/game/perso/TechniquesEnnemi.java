/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.perso;

import mfiari.gmm.game.liste.ListeTec;
import mfiari.gmm.game.technique.Techniques;

/**
 *
 * @author mike
 */
public class TechniquesEnnemi {

    public ListeTec tecLapin;
    public ListeTec tecRenard;
    public ListeTec tecCerf;
    public ListeTec tecExaminateur;
    public ListeTec tecHumanocible;
    public ListeTec tecChat;
    public ListeTec tecRat;
    public ListeTec tecBandit;
    public ListeTec tecLola;
    public ListeTec tecChauveSourie;
    public ListeTec tecSoldatGarrucha;
    public ListeTec tecMorgane;
    public ListeTec tecYuan;


    public TechniquesEnnemi () {
        this.tecLapin=new ListeTec ();
        this.tecRenard=new ListeTec ();
        this.tecCerf=new ListeTec ();
        this.tecExaminateur=new ListeTec ();
        this.tecHumanocible=new ListeTec ();
        this.tecChat=new ListeTec ();
        this.tecRat=new ListeTec ();
        this.tecBandit=new ListeTec ();
        this.tecLola=new ListeTec ();
        this.tecChauveSourie=new ListeTec ();
        this.tecSoldatGarrucha=new ListeTec ();
        this.tecMorgane=new ListeTec ();
        this.tecYuan=new ListeTec ();
        this.tecRenard.ajoutTec(Techniques.morsure);
        this.tecCerf.ajoutTec(Techniques.coupDeCorne);
        this.tecChat.ajoutTec(Techniques.griffe);
        this.tecChat.ajoutTec(Techniques.coupDePiedSaute);
        this.tecChat.ajoutTec(Techniques.agilite);
        this.tecRat.ajoutTec(Techniques.morsurePoison);
        this.tecRat.ajoutTec(Techniques.coupDeQueue);
        this.tecBandit.ajoutTec(Techniques.couteau);
        this.tecBandit.ajoutTec(Techniques.voler);
        this.tecLola.ajoutTec(Techniques.eau);
        this.tecChauveSourie.ajoutTec(Techniques.morsurePoison);
        this.tecChauveSourie.ajoutTec(Techniques.ultrason);
        this.tecChauveSourie.ajoutTec(Techniques.vampirisme);
        this.tecSoldatGarrucha.ajoutTec(Techniques.lance);
        this.tecMorgane.ajoutTec(Techniques.feu);
        this.tecMorgane.ajoutTec(Techniques.jetFlamme);
        this.tecYuan.ajoutTec(Techniques.lame);
    }
}
