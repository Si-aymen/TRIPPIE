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
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author khmir
 */
public class Webuild {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        /// MyConnection conn = MyConnection.getInstance();
        voiture v1 = new voiture("221tunis987", "bmw", "10ch", 450);

        voiture mod = new voiture( "polo", "xd", "5ch", 280);
        voitureCRUD voi = new voitureCRUD();
     
       
      //  voi.ajoutervoiture(v1);

      //  voi.modifiervoiture(mod);
        // System.out.println("les donnes concernat votre rechercher est ");
        // System.out.println(voi.getUserByID(88)); 
        //  System.out.println(voi.triervoiture());
        //System.out.println( voi.affichervoitures());  
        //System.out.println(voi.Filter_voiture("puissance", "5ch"));
        //System.out.println( voi.affichervoitures());
        //------------------------------------------------------------------------------------/
        //    System.out.println("---------------- partie reservation -----------------------------");
        reservation r1 = new reservation(Date.valueOf("2023-1-10"), Date.valueOf("2023-1-10"),new voiture(200,"polo", "xd", "5ch", 280));
        reservationCRUD rev = new reservationCRUD();
      // rev.ajouterreservation(r1);
     //  System.out.println( rev.afficherreservations());
       
      /*  reservation mod1 = new reservation(88, Date.valueOf("2023-1-10"), Date.valueOf("2023-1-10"));
        
          
          System.out.println( rev.afficherreservations());
        // rev.supprimerreservation(86);
        //     System.out.println( rev.afficherreservations());          
        rev.modifierreservation(mod1);
        //  System.out.println( rev.afficherreservations());
        //    System.out.println("les donnes concernat votre rechercher est ");

        // System.out.println(rev.getUserByIDre(10)); 
        //   System.out.println(rev.trierReservation());
        //     System.out.println("filtration");
        //   System.out.println(rev.Filter_reservation("id_voiture","67"));
*/
    }

}
