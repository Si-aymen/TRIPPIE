/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.model.CoVoiturage;
import edu.webuild.model.Participation;
import edu.webuild.services.*;
import java.sql.Date;

/**
 *
 * @author manou
 */
public class Webuild {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        CoVoiturage v1 = new CoVoiturage("rades", "Esprit", Date.valueOf("11/02/2023"), 4);
        CoVoiturage v2 = new CoVoiturage("manzah", "boumhal", Date.valueOf("11/02/2023"), 4);
        CoVoiturage v3 = new CoVoiturage("ariena", "naser", Date.valueOf("11/02/2023"), 2);
        CoVoiturage v4 = new CoVoiturage("naser", "ariena",Date.valueOf("11/02/2023"), 4);
        CoVoiturage v5 = new CoVoiturage("ben aarouse", "ariena", Date.valueOf("11/02/2023"), 4);

        Participation p1 = new Participation(2, 9);
        Participation p2 = new Participation(2, 10);
        Participation p3 = new Participation(7, 11);
        Participation p4 = new Participation(3, 12);
        Participation p5 = new Participation(2, 13);

        CoVoiturageCRUD voi = new CoVoiturageCRUD();
        ParticipationCrud part = new ParticipationCrud();

//ajouter dans table co_voiturage
        /* voi.ajouterCoVoiturage(v1);
        voi.ajouterCoVoiturage(v2);
        voi.ajouterCoVoiturage(v3);
        voi.ajouterCoVoiturage(v4);
        voi.ajouterCoVoiturage(v5);*/
//afficher le table co_voiturage
        System.out.println(voi.afficherCoVoiturage());

//modification dans table co_voiturage 
        //voi.modifierCoVoiturage(v5, 10);
        System.out.println(voi.afficherCoVoiturage());

//supprimer dans table co_voiturage
        //voi.supprimerCoVoiturage(10);
        System.out.println(voi.afficherCoVoiturage());

        System.out.println("*****************************");
//ajouter dans table participation
        /* part.ajouterParticipation2(p1);
        part.ajouterParticipation2(p2);
        part.ajouterParticipation2(p3);
        part.ajouterParticipation2(p4);*/

//ajout en table participation avec update automatique en table co_voiturage
        System.out.println(voi.afficherCoVoiturage());
        // part.ajouterParticipation(p5);
        System.out.println(voi.afficherCoVoiturage());

//aficher le table participation 
        System.out.println(part.afficherParticipation());

    }

}
