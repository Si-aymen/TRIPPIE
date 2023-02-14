/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.model.CoVoiturage;
import edu.webuild.model.Participation;
import edu.webuild.services.*;

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

        CoVoiturage v1 = new CoVoiturage("rades", "Esprit", "11/02/2023", 4);
        CoVoiturage v2 = new CoVoiturage("manzah", "boumhal", "10/12/2022", 4);
        CoVoiturage v3 = new CoVoiturage("ariena", "naser", "18/02/2022", 2);
        CoVoiturage v4 = new CoVoiturage("naser", "ariena", "18/02/2022", 4);

        Participation p1 = new Participation(2, 2);
        Participation p2 = new Participation(2, 4);
        Participation p3 = new Participation(7, 7);
        Participation p4 = new Participation(3, 8);
        Participation p5 = new Participation(2, 6);

        CoVoiturageCRUD voi = new CoVoiturageCRUD();
        ParticipationCrud part = new ParticipationCrud();
        //voi.ajouterCoVoiturage(v4);
        //voi.ajouterCoVoiturage2(v3);
        // System.out.println( voi.afficherCoVoiturage());
        //voi.supprimerCoVoiturage(2);
        // System.out.println( voi.afficherCoVoiturage());
        // voi.modifierCoVoiturage(v3,1);
        //System.out.println( voi.afficherCoVoiturage());
        //System.out.println( voi.rechCoVoiturage(1));
        System.out.println(voi.afficherCoVoiturage());

        System.out.println(voi.Filter_CoVoiturage("nmbr_place", "4"));
        System.out.println(voi.Filter_CoVoiturage("destination", "tunis"));
        // part.ajouterParticipation(p3);
        //part.ajouterParticipation2(p3);
        //part.ajouterParticipation(p4);
        //System.out.println(part.afficherParticipation());
        //part.modifierParticipation(p5,26);
        // part.supprimerParticipation(26);
        //System.out.println(part.afficherParticipation() );

        // System.out.println(part.rechParticipation(28));
        System.out.println(part.Filter_Participation("nmbr_place_part", "3"));
        System.out.println(part.Filter_Participation("id_part", "3"));

    }

}
