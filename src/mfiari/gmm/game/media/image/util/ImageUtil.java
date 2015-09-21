/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.media.image.util;

import java.awt.image.BufferedImage;
import java.net.URL;
import mfiari.lib.game.image.Image;
import mfiari.lib.game.texte.Langue;

/**
 *
 * @author mike
 */
public class ImageUtil extends Image{
    
    public ImageUtil () {
        
    }
    
    public BufferedImage getDrapeau (Langue langue) {
        URL url = null;
        switch (langue) {
            case fr:
                url = getClass().getResource("drapeaux_francais.jpg");
                break;
            case en:
                url = getClass().getResource("drapeaux_englais.jpg");
                break;
            case de:
                url = getClass().getResource("drapeau_allemand.jpg");
                break;
        }
        return this.getImage(url, 100, 80);
    }
    
    public BufferedImage getLogo () {
        URL url = getClass().getResource("logo.png");
        return this.getImage(url);
    }
    
    public BufferedImage getImageDuel () {
        URL url = getClass().getResource("logo.png");
        return this.getImage(url, 100, 80);
    }
    
    public BufferedImage getImageEnLigne () {
        URL url = getClass().getResource("logo.png");
        return this.getImage(url, 100, 80);
    }
    
    public BufferedImage getImageConfiguration () {
        URL url = getClass().getResource("configuration.png");
        return this.getImage(url, 100, 80);
    }
    
    public BufferedImage getImageRetour () {
        URL url = getClass().getResource("fleche-retour.png");
        return this.getImage(url, 100, 80);
    }
}