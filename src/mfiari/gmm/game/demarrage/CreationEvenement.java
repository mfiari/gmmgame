/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.gmm.game.demarrage;

import mfiari.gmm.game.perso.Ennemies;
import mfiari.gmm.game.perso.Ennemie;
import mfiari.gmm.game.perso.Habitants;
import mfiari.gmm.game.perso.Personnages;
import mfiari.gmm.game.perso.Personnage;
import mfiari.gmm.game.evenement.Evenements;
import mfiari.gmm.game.objet.Objets;
import mfiari.gmm.game.texte.Texte;
import mfiari.gmm.game.texte.Texte_fr;
import mfiari.gmm.game.ville.Endroits;
import mfiari.lib.game.condition.ConditionAttaque;
import mfiari.lib.game.condition.ConditionDefense;
import mfiari.lib.game.condition.ConditionObjet;
import mfiari.lib.game.condition.ConditionSecondaire;
import mfiari.lib.game.evenements.EvenementDialogue;
import mfiari.lib.game.evenements.EvenementQuete;
import mfiari.lib.game.personnage.Habitant;
import mfiari.lib.game.position.Orientation;
import mfiari.lib.game.position.Position;

/**
 *
 * @author mike
 */
public class CreationEvenement {

    private Texte textes;

    public CreationEvenement() {
        this.textes = new Texte_fr();
        this.creationEvenementDialogue();
        this.creationEvenementCombat();
        this.creationEvenementChoix();
        this.creationEvenementSpecial();
        this.creationEvenementQueteAnnexe();
        this.creationEvenementQuete();


    }

    private void creationEvenementQuete() {
        Evenements.ecole.ajouterQuete(Evenements.debut);
        Evenements.ecole.ajouterQuete(Evenements.cours);
        Evenements.ecole.ajouterQuete(Evenements.baseAttaque);
        Evenements.ecole.ajouterQuete(Evenements.baseDefense);
        Evenements.ecole.ajouterQuete(Evenements.potionPourCour);
        Evenements.ecole.ajouterQuete(Evenements.baseObjet);
        Evenements.ecole.ajouterQuete(Evenements.finCours);
        Evenements.ecole.ajouterQuete(Evenements.soinApresCour);
        Evenements.ecole.ajouterQuete(Evenements.choixQueteEntrainementAvecVardEtMok);
        Evenements.ecole.ajouterQueteAnnexe(Evenements.entrainementAvecVardEtMok);
        Evenements.ecole.ajouterQuete(Evenements.nuitApresCombatContreCerf);
        Evenements.ecole.ajouterEndroitNonAccessible(
                Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        Evenements.ecole.ajouterEndroitNonAccessible(Endroits.magasin_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent);
        Evenements.ecole.ajouterEndroitNonAccessible(Endroits.quartierChateau_medieville_zoneMedieville_zoneMedicoru_continent);
        Evenements.ecole.ajouterEndroitNonAccessible(Endroits.zoneMedieville_zoneMedicoru_continent);
        Evenements.examen.ajouterQuete(Evenements.discussionAvecMaman);
        Evenements.examen.ajouterQuete(Evenements.discussionAcheterEpeeMarco);
        Evenements.examen.ajouterQuete(Evenements.acheterEpeeMarco);
        Evenements.examen.ajouterQuete(Evenements.discussionEpreuve1);
        Evenements.examen.ajouterQuete(Evenements.epreuve1);
        Evenements.examen.ajouterQuete(Evenements.discussionEpreuve2);
        Evenements.examen.ajouterQuete(Evenements.epreuve2);
        Evenements.examen.ajouterQuete(Evenements.discussionEpreuve3);
        Evenements.examen.ajouterQuete(Evenements.epreuve3);
        Evenements.examen.ajouterQuete(Evenements.discussionFinEpreuve);
        Evenements.examen.ajouterQuete(Evenements.livreEnnemie);
        Evenements.examen.ajouterEndroitNonAccessible(Endroits.zoneMedieville_zoneMedicoru_continent);
        Evenements.pemiereMission.ajouterQuete(Evenements.parlerARoman);
        Evenements.pemiereMission.ajouterQuete(Evenements.equipeMission);
        Evenements.pemiereMission.ajouterQuete(Evenements.batcity);
        Evenements.pemiereMission.ajouterQuete(Evenements.parlerPretreBatcity);
        Evenements.pemiereMission.ajouterQuete(Evenements.combatContreChauveSourie);
        Evenements.pemiereMission.ajouterEndroitNonAccessible(Endroits.zoneGrandeForet1_zoneMedicoru_continent);
        Evenements.lattaque.ajouterQuete(Evenements.fumeeDeMedieville);
        Evenements.lattaque.ajouterQuete(Evenements.lattaque_dialogue1);
        Evenements.lattaque.ajouterQuete(Evenements.romanQuitteLequipe);
        Evenements.lattaque.ajouterQuete(Evenements.lattaqueCombat1);
        Evenements.lattaque.ajouterQuete(Evenements.lattaque_dialogue2);
        Evenements.lattaque.ajouterQuete(Evenements.lattaqueCombat2);
        Evenements.lattaque.ajouterQuete(Evenements.lattaque_dialogueYuanEtMorgane);
        Evenements.lattaque.ajouterQuete(Evenements.yuanEtMorgane);
        Evenements.chapitre1.ajouterQuete(Evenements.ecole);
        Evenements.chapitre1.ajouterQuete(Evenements.entrainementAvecVardEtMok);
        Evenements.chapitre1.ajouterQuete(Evenements.examen);
        Evenements.chapitre1.ajouterQuete(Evenements.pemiereMission);
        Evenements.chapitre1.ajouterQuete(Evenements.aidePaysan);
        Evenements.chapitre1.ajouterQuete(Evenements.lattaque);
        Evenements.jeu.ajouterQuete(Evenements.chapitre1);
    }

    private void creationEvenementQueteAnnexe() {
        Evenements.entrainementAvecVardEtMok.ajouterQuete(Evenements.vardEtMokDansLequipe);
        Evenements.entrainementAvecVardEtMok.ajouterQuete(Evenements.entrerDansParcDentrainement);
        Evenements.entrainementAvecVardEtMok.ajouterQuete(Evenements.discussionAvantCombat);
        Evenements.entrainementAvecVardEtMok.ajouterQuete(Evenements.premierCombat);
        Evenements.entrainementAvecVardEtMok.ajouterQuete(Evenements.discussionentreCombat);
        Evenements.entrainementAvecVardEtMok.ajouterQuete(Evenements.combatContreRenardEtLapin);
        Evenements.entrainementAvecVardEtMok.ajouterQuete(Evenements.discussionAvantCombatContreCerf);
        Evenements.entrainementAvecVardEtMok.ajouterQuete(Evenements.soinAvantCombatContreCerf);
        Evenements.entrainementAvecVardEtMok.ajouterQuete(Evenements.discussionAvantCombatContreCerf2);
        Evenements.entrainementAvecVardEtMok.ajouterQuete(Evenements.discussionAvantCombatContreCerf3);
        Evenements.entrainementAvecVardEtMok.ajouterQuete(Evenements.combatContreCerf);
        Evenements.entrainementAvecVardEtMok.ajouterQuete(Evenements.discussionApresCombatContreCerf);
        Evenements.entrainementAvecVardEtMok.ajouterEndroitNonAccessible(Endroits.zoneMedieville_zoneMedicoru_continent);
        Evenements.aidePaysan.ajouterQuete(Evenements.discussionAidePaysan);
        Evenements.aidePaysan.ajouterQuete(Evenements.combatAidePaysan);
        Evenements.aidePaysan.ajouterEndroitNonAccessible(Endroits.zoneMedieville_zoneMedicoru_continent);
    }

    private void creationEvenementDialogue() {
        
        Habitants.papaDeMarco.addListeDialogueEvenement(Evenements.debut, "Marco" + "?...", 1);
        Habitants.papaDeMarco.addListeDialogueEvenement(Evenements.debut, "Marco" + "!!", 2);
        Habitants.papaDeMarco.addListeDialogueEvenement(Evenements.debut, this.textes.getParoleCreationEvenementDialogue1(), 3);
        Personnages.marco.addListeDialogueEvenement(Evenements.debut, this.textes.getParoleCreationEvenementDialogue2(), 4);
        Personnages.marco.addListeDialogueEvenement(Evenements.debut, this.textes.getParoleCreationEvenementDialogue3(), 5);
        Evenements.debut.ajouterGens(Habitants.papaDeMarco, new Position(1, 1, 0,
                Endroits.chambreMarco_maisonMarco_quartierHabitant_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face));
        Evenements.debut.ajouterGens(Personnages.marco);
        
        Habitants.prof_medieville.addListeDialogueEvenement(Evenements.cours, this.textes.getParoleCreationEvenementDialogue4(), 1);
        Habitants.prof_medieville.addListeDialogueEvenement(Evenements.cours, this.textes.getParoleCreationEvenementDialogue5(), 2);
        Habitants.prof_medieville.addListeDialogueEvenement(Evenements.cours, this.textes.getParoleCreationEvenementDialogue6(), 3);
        Habitants.prof_medieville.addListeDialogueEvenement(Evenements.cours, this.textes.getParoleCreationEvenementDialogue7("Marco"), 4);
        Evenements.cours.ajouterGens(Habitants.prof_medieville);
        
        Habitants.prof_medieville.addListeDialogueEvenement(Evenements.finCours, this.textes.getParoleCreationEvenementDialogue8(), 1);
        Habitants.prof_medieville.addListeDialogueEvenement(Evenements.finCours, this.textes.getParoleCreationEvenementDialogue9(), 2);
        Evenements.finCours.ajouterGens(Habitants.prof_medieville);
        
        Personnages.mok.addListeDialogueEvenement(Evenements.entrerDansParcDentrainement, this.textes.getParoleCreationEvenementDialogue10(), 1);
        Personnages.mok.addListeDialogueEvenement(Evenements.entrerDansParcDentrainement, this.textes.getParoleCreationEvenementDialogue11(), 2);
        Personnages.mok.addListeDialogueEvenement(Evenements.entrerDansParcDentrainement, this.textes.getParoleCreationEvenementDialogue12(), 3);
        Personnages.mok.addListeDialogueEvenement(Evenements.entrerDansParcDentrainement, this.textes.getParoleCreationEvenementDialogue13(), 4);
        Personnages.marco.addListeDialogueEvenement(Evenements.entrerDansParcDentrainement, this.textes.getParoleCreationEvenementDialogue14(), 5);
        Personnages.mok.addListeDialogueEvenement(Evenements.entrerDansParcDentrainement, this.textes.getParoleCreationEvenementDialogue15(), 6);
        Evenements.entrerDansParcDentrainement.ajouterGens(Personnages.mok, new Position(3, 2, 0,
                Endroits.salle_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face));
        Evenements.entrerDansParcDentrainement.ajouterGens(Personnages.marco);
            
        Personnages.marco.addListeDialogueEvenement(Evenements.discussionAvantCombat, this.textes.getParoleCreationEvenementDialogue16(), 1);
        Personnages.vard.addListeDialogueEvenement(Evenements.discussionAvantCombat, this.textes.getParoleCreationEvenementDialogue17(), 2);
        Evenements.discussionAvantCombat.ajouterGens(Personnages.marco);
        Evenements.discussionAvantCombat.ajouterGens(Personnages.vard, new Position(4, 6, 0,
                Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face));
        Evenements.entrerDansParcDentrainement.ajouterGens(Personnages.marco);
                
        Personnages.marco.addListeDialogueEvenement(Evenements.discussionentreCombat, this.textes.getParoleCreationEvenementDialogue18(), 1);
        Personnages.mok.addListeDialogueEvenement(Evenements.discussionentreCombat, this.textes.getParoleCreationEvenementDialogue19(), 2);
        Evenements.discussionAvantCombat.ajouterGens(Personnages.marco);
        Evenements.discussionAvantCombat.ajouterGens(Personnages.mok, new Position(4, 4, 0,
                Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face));
                
        Personnages.marco.addListeDialogueEvenement(Evenements.discussionAvantCombatContreCerf, this.textes.getParoleCreationEvenementDialogue20(), 1);
        Personnages.mok.addListeDialogueEvenement(Evenements.discussionAvantCombatContreCerf, this.textes.getParoleCreationEvenementDialogue21(), 2);              
        Personnages.marco.addListeDialogueEvenement(Evenements.discussionAvantCombatContreCerf, this.textes.getParoleCreationEvenementDialogue22(), 3);
        Personnages.mok.addListeDialogueEvenement(Evenements.discussionAvantCombatContreCerf, this.textes.getParoleCreationEvenementDialogue23(), 4);
        Personnages.marco.addListeDialogueEvenement(Evenements.discussionAvantCombatContreCerf, this.textes.getParoleCreationEvenementDialogue24(), 5);
        Personnages.vard.addListeDialogueEvenement(Evenements.discussionAvantCombatContreCerf, this.textes.getParoleCreationEvenementDialogue25(), 6);
        Evenements.discussionAvantCombatContreCerf.ajouterGens(Personnages.mok, new Position(4, 4, 0,
                Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face));
        Evenements.discussionAvantCombatContreCerf.ajouterGens(Personnages.mok, new Position(4, 4, 0,
                Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face));
                
        Personnages.marco.addListeDialogueEvenement(Evenements.discussionAvantCombatContreCerf2, this.textes.getParoleCreationEvenementDialogue26(), 1);
        Personnages.mok.addListeDialogueEvenement(Evenements.discussionAvantCombatContreCerf2, this.textes.getParoleCreationEvenementDialogue27(), 2);
        Evenements.discussionAvantCombatContreCerf2.ajouterGens(Personnages.marco);
        Evenements.discussionAvantCombatContreCerf2.ajouterGens(Personnages.mok, new Position(4, 4, 0,
                Endroits.zone1_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face));
                
        Personnages.marco.addListeDialogueEvenement(Evenements.discussionAvantCombatContreCerf3, this.textes.getParoleCreationEvenementDialogue29(), 2);
        Personnages.vard.addListeDialogueEvenement(Evenements.discussionAvantCombatContreCerf3, this.textes.getParoleCreationEvenementDialogue28(), 1);
        Evenements.discussionAvantCombatContreCerf3.ajouterGens(Personnages.marco);
        Evenements.discussionAvantCombatContreCerf3.ajouterGens(Personnages.vard, new Position(3, 5, 0,
                Endroits.zone2_parcDEntrainement_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face));
    }

    private void creationEvenementCombat() {
        Habitant professeur;
        Habitant professeur2;
        Habitant professeur3;
        Habitant professeur4;
        Habitant professeur5;
        Habitant professeur6;
        Habitant professeur7;
        Habitant professeur8;
        professeur = new Habitant(this.textes.professeur, 2, 9,
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
        professeur2 = new Habitant(this.textes.professeur, 2, 9,
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
        professeur3 = new Habitant(this.textes.professeur, 2, 9,
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
        professeur4 = new Habitant(this.textes.professeur, 2, 9,
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
        professeur5 = new Habitant(this.textes.professeur, 2, 9,
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
        professeur6 = new Habitant(this.textes.professeur, 2, 9,
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
        professeur7 = new Habitant(this.textes.professeur, 2, 9,
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
        professeur8 = new Habitant(this.textes.professeur, 2, 9,
            Endroits.salle_ecole_quartierPrincipal_medieville_zoneMedieville_zoneMedicoru_continent, Orientation.face);
                
        professeur.ajouterParole(this.textes.getParoleCreationEvenementCombat1());
        professeur.ajouterParole(this.textes.getParoleCreationEvenementCombat2());
        EvenementDialogue e1 = new EvenementDialogue();
        e1.ajouterGens(professeur);
        
        professeur2.ajouterParole(this.textes.getParoleCreationEvenementCombat3());
        EvenementDialogue e2 = new EvenementDialogue();
        e2.ajouterGens(professeur2);

        professeur3.ajouterParole(this.textes.getParoleCreationEvenementCombat4());
        EvenementDialogue e3 = new EvenementDialogue();
        e3.ajouterGens(professeur3);
        
        professeur4.ajouterParole(this.textes.getParoleCreationEvenementCombat5());
        EvenementDialogue e4 = new EvenementDialogue();
        e4.ajouterGens(professeur4);
        
        professeur5.ajouterParole(this.textes.getParoleCreationEvenementCombat6());
        professeur5.ajouterParole(this.textes.getParoleCreationEvenementCombat7());
        professeur5.ajouterParole(this.textes.getParoleCreationEvenementCombat8());
        professeur5.ajouterParole(this.textes.getParoleCreationEvenementCombat9());
        EvenementDialogue e5 = new EvenementDialogue();
        e5.ajouterGens(professeur5);
        
        professeur6.ajouterParole(this.textes.getParoleCreationEvenementCombat5());
        EvenementDialogue e6 = new EvenementDialogue();
        e6.ajouterGens(professeur6);
        
        professeur7.ajouterParole(this.textes.getParoleCreationEvenementCombat10());
        EvenementDialogue e7 = new EvenementDialogue();
        e7.ajouterGens(professeur7);
        
        professeur8.ajouterParole(this.textes.getParoleCreationEvenementCombat11());
        EvenementDialogue e8 = new EvenementDialogue();
        e8.ajouterGens(professeur8);

        Personnage p = new Personnage(Personnages.mok);
        p.ajouterParole(this.textes.getParoleCreationEvenementCombat12());
        EvenementDialogue e9 = new EvenementDialogue();
        e9.ajouterGens(p);

        Personnage p1 = new Personnage(Personnages.vard);
        p1.ajouterParole(this.textes.getParoleCreationEvenementCombat13());
        p1.ajouterParole(this.textes.getParoleCreationEvenementCombat14());
        EvenementDialogue e10 = new EvenementDialogue();
        e10.ajouterGens(p1);

        Evenements.baseAttaque.ajouterEvenementDialogue(e1, new ConditionAttaque(), e2);
        Evenements.baseAttaque.getAdversaire().ajouterPerso(new Ennemie(Ennemies.humanocible));

        Evenements.baseDefense.ajouterEvenementDialogue(e3, new ConditionDefense(), e4);
        Evenements.baseDefense.getAdversaire().ajouterPerso(new Ennemie(Ennemies.humanocible));

        Evenements.baseObjet.ajouterEvenementDialogue(e5, new ConditionDefense(), e6);
        Evenements.baseObjet.ajouterEvenementDialogue(e7, new ConditionObjet(), e8);
        Evenements.baseObjet.getAdversaire().ajouterPerso(new Ennemie(Ennemies.examinateur));

        Evenements.premierCombat.ajouterEvenementDialogue(e9, new ConditionSecondaire(), null);
        Evenements.premierCombat.ajouterAdversaire(Ennemies.lapin);

        Evenements.combatContreRenardEtLapin.ajouterEvenementDialogue(e10, new ConditionSecondaire(), null);
        Evenements.combatContreRenardEtLapin.ajouterAdversaire(Ennemies.lapin);
        Evenements.combatContreRenardEtLapin.ajouterAdversaire(Ennemies.renard);

        Evenements.combatContreCerf.ajouterEvenementDialogue(null, new ConditionSecondaire(), null);
        Evenements.combatContreCerf.ajouterAdversaire(Ennemies.cerf);

        Evenements.epreuve1.ajouterAdversaire(new Ennemie(Ennemies.humanocible));
        Evenements.epreuve1.ajouterAdversaire(new Ennemie(Ennemies.humanocible));
        Evenements.epreuve1.ajouterAdversaire(new Ennemie(Ennemies.humanocible));

        Evenements.epreuve2.ajouterAdversaire(new Ennemie(Ennemies.examinateur));

        Evenements.epreuve3.ajouterAdversaire(new Ennemie(Ennemies.examinateur));

        Evenements.combatContreChauveSourie.ajouterAdversaire(new Ennemie(Ennemies.chauveSourie));
        Evenements.combatContreChauveSourie.ajouterAdversaire(new Ennemie(Ennemies.chauveSourie));
        Evenements.combatContreChauveSourie.ajouterAdversaire(new Ennemie(Ennemies.chauveSourie));

        Evenements.combatAidePaysan.ajouterAdversaire(new Ennemie(Ennemies.renard));
        Evenements.combatAidePaysan.ajouterAdversaire(new Ennemie(Ennemies.cerf));
        Evenements.combatAidePaysan.ajouterAdversaire(new Ennemie(Ennemies.renard));

        Evenements.lattaqueCombat1.ajouterAdversaire(new Ennemie(Ennemies.soldatGarrucha));
        Evenements.lattaqueCombat1.ajouterAdversaire(new Ennemie(Ennemies.soldatGarrucha));

        Evenements.lattaqueCombat2.ajouterAdversaire(new Ennemie(Ennemies.soldatGarrucha));
        Evenements.lattaqueCombat2.ajouterAdversaire(new Ennemie(Ennemies.soldatGarrucha));

        Evenements.yuanEtMorgane.ajouterAdversaire(new Ennemie(Ennemies.yuan));
        Evenements.yuanEtMorgane.ajouterAdversaire(new Ennemie(Ennemies.morgane));
        
    }

    private void creationEvenementChoix() {
        Personnage p = new Personnage(Personnages.vard);
        p.ajouterParole(this.textes.getParoleCreationEvenementChoix1("Marco"));
        p.ajouterParole(this.textes.getParoleCreationEvenementChoix2(Personnages.mok.getNom()));
        p.ajouterParole(this.textes.getParoleCreationEvenementChoix3());

        Evenements.choixQueteEntrainementAvecVardEtMok.ajouterGens(p);
        Evenements.choixQueteEntrainementAvecVardEtMok.ajouterEvenementQueteAnnexe(Evenements.entrainementAvecVardEtMok);
    }

    private void creationEvenementSpecial() {
        
        Evenements.potionPourCour.ajouterObjet(Objets.potion);

        Evenements.soinApresCour.soignerEquipe();

        Evenements.vardEtMokDansLequipe.ajouterPersoAajouter(Personnages.vard);
        Evenements.vardEtMokDansLequipe.ajouterPersoAajouter(Personnages.mok);

        Evenements.soinAvantCombatContreCerf.soignerEquipe();
    }

    public EvenementQuete getEvenement() {
        return Evenements.jeu;
    }
}
