/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mfiari.gmm.game.perso;

import mfiari.gmm.game.ville.Endroits;
import mfiari.lib.game.personnage.Habitant;
import mfiari.lib.game.position.Orientation;

/**
 *
 * @author mike
 */
public class Habitants {
    
    public static Habitant papaDeMarco = new Habitant ("papa", 1, 2,
            Endroits.bas_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    public static Habitant mamanDeMarco = new Habitant ("maman", 3, 1, 
            Endroits.bas_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    public static Habitant homme_quartierHabitant_medieville = new Habitant ("homme", 2, 3,
            Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    public static Habitant gardeGauche_quartierHabitant_medieville = new Habitant ("garde", 5, 3,
            Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    public static Habitant gardeDroite_quartierHabitant_medieville = new Habitant ("garde", 5, 6,
            Endroits.quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    
    /* personne se trouvant dans le quartier principal de medieville */
    public static Habitant gardeHaut_quartierPrincipal_medieville = new Habitant ("garde", 0, 0,
            Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    public static Habitant gardeBas_quartierPrincipal_medieville = new Habitant ("garde", 3, 0,
            Endroits.quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    public static Habitant gardien_entreeParcDEntrainement_medieville = new Habitant ("gardien", 1, 3,
            Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    public static Habitant homme_entreeParcDEntrainement_medieville = new Habitant ("homme", 3, 5,
            Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    public static Habitant bibliothecaire_medieville = new Habitant ("bibliothecaire", 0, 0,
            Endroits.salle_bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    public static Habitant homme_bibliotheque_medieville = new Habitant ("homme", 0, 7,
            Endroits.salle_bibliotheque_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    public static Habitant prof_medieville = new Habitant ("prof", 2, 9,
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    public static Habitant vendeur_magasin_medieville = new Habitant ("vendeur", 4, 2,
            Endroits.salle_magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
    public static Habitant aubergiste_auberge_medieville = new Habitant ("aubergiste", 4, 2,
            Endroits.salle_auberge_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
}
