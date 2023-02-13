/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.model.reservation;
import edu.webuild.model.voiture;
import edu.webuild.services.reservationCRUD;
import edu.webuild.services.voitureCRUD;
import java.sql.SQLException;


/**
 *
 * @author manou
 */
public class Webuild {


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
    
}
