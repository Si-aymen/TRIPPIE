/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

<<<<<<< HEAD
import edu.webuild.model.reservation;
import edu.webuild.model.voiture;
import edu.webuild.services.reservationCRUD;
import edu.webuild.services.voitureCRUD;
import java.sql.SQLException;

=======
import edu.webuild.model.CoVoiturage;
import edu.webuild.model.Participation;
import edu.webuild.services.*;
>>>>>>> 1a369414b902b253d0c5a9cadf39cc600108e84c

/**
 *
 * @author manou
 */
public class Webuild {

<<<<<<< HEAD

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
     /// MyConnection conn = MyConnection.getInstance();
        voiture v1 = new voiture("122tunis1259","clio", "5ch",280);
        voiture v2 = new voiture("122tunis1259","clio", "5ch",450);
        voiture v4 = new voiture("1259","clio", "5ch",280);
        voiture v3 = new voiture("122tunis1259","clio", "5ch",280);
       voitureCRUD voi = new voitureCRUD();
        
  //    voi.ajoutervoiture(v2);
        //voi.ajouterPersonne2(v1);
     //   System.out.println( per.affichervoiture());
     // System.out.println( voi.affichervoitures());
        voiture mod = new voiture("hhhh","dtftdt", "hhhhhh",10000);
       // voi.modifiervoiture(mod,18);
     //    System.out.println( voi.affichervoitures());
        // voi.supprimervoiture(18);
       // System.out.println("les donnes concernat votre rechercher est ");
         //    System.out.println(voi.getUserByID(25)); 
      //   System.out.println(voi.triervoiture());
      //System.out.println(voi.Filter_voiture("puissance", "5ch"));
     //------------------------------------------------------------------------------------/
     //    System.out.println("---------------- partie reservation -----------------------------");
     reservation r1=new reservation("12/10/2022","14/05/2021",32);
      // reservation r2=new reservation("12/10/2052","14/05/2021");
       reservationCRUD rev = new reservationCRUD();
      //  rev.ajouterreservation(r1);
     //   System.out.println( rev.afficherreservations());
     //  rev.supprimerreservation(10);
         //       System.out.println( rev.afficherreservations());
                
      //  reservation mod1 = new reservation("2ihkakakakkakakakka88","25/2020");
       // rev.modifierreservation(mod1,11);
       //  System.out.println( rev.afficherreservations());
    //    System.out.println("les donnes concernat votre rechercher est ");
  
       // System.out.println(rev.getUserByIDre(10)); 
     //   System.out.println(rev.trierReservation());
         
         System.out.println(rev.Filter_reservation("date_debut", "12/10/2022"));
    }
    
=======
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

>>>>>>> 1a369414b902b253d0c5a9cadf39cc600108e84c
}
