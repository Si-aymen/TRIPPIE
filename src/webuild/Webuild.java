/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.model.cartefidelite;
import edu.webuild.model.abonnement;
import edu.webuild.model.AbonnementCarteFidelite;
import edu.webuild.services.CartefideliteCRUD;
import edu.webuild.services.AbonnementCRUD;
import java.sql.SQLException;
import java.util.List;


import java.sql.Date;
import java.sql.SQLException;


/**
 *
 * @author mtirn
 */
public class Webuild {


    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
     /// MyConnection conn = MyConnection.getInstance();
     /*_________________________Jointure_____________________________________*/
        
      CartefideliteCRUD carteFideliteCRUD = new CartefideliteCRUD();
        List<AbonnementCarteFidelite> cartesFidelitesAbonnements = carteFideliteCRUD.getAllCarteFideliteWithAbonnement();
        for (AbonnementCarteFidelite cfa : cartesFidelitesAbonnements) {
            System.out.println(cfa);
        }

 
  


       
      /*_________________________Abonnement_____________________________________*/
           
      
// ---------------Create a new Abonnement object--------------
   
//    AbonnementCRUD abonnementCRUD = new AbonnementCRUD();
//            Date dateAchat = Date.valueOf("2023-02-24");
//               Date dateExpiration = Date.valueOf("2024-02-24");
//              abonnement abonnement = new abonnement("Premium", 200, dateAchat ,dateExpiration);
//        
        
// -------------Add the new Abonnement object to the database-----------
//               abonnementCRUD.ajouterabonnement(abonnement);

    

    // -------------display the objects in the database---------------------------------
//       System.out.println( abonnementCRUD.afficherabonnement());

 // --------------Get the Abonnement with id 2 from the database-------------------------
           
            //   abonnement abonnement = abonnementCRUD.getUserByID(2);

 //-------------------------------Trie---------------------------------------------------

             // System.out.println( abonnementCRUD.trierabonnement());

 //-----------------------------Filter---------------------------------------------------


            // System.out.println( abonnementCRUD.Filter_abonnement("dateAchat","2022-02-22"));





      /*_________________________Cartefidelite_____________________________________*/
      
      
      // ---------------Create a new Cartefidelite object--------------
   
    //CartefideliteCRUD cartefideliteCRUD = new CartefideliteCRUD();
        
//                Date dateExpiration = Date.valueOf("2025-10-10");
//               cartefidelite cartefidelite = new cartefidelite("20",dateExpiration,4 );
//        
      
      // -------------Add the new Cartefidelite object to the database-----------
//               cartefideliteCRUD.ajoutercarte(cartefidelite);

      // -------------display the objects in the database---------------------------------
           // System.out.println( cartefideliteCRUD.affichercarte());
           
      // -------------deletes  objects in the database---------------------------------
         // cartefideliteCRUD.supprimercarte(8);

         
            // --------------Get the Cartefidelite with id 9 from the database-------------------------
           
             //cartefidelite cartefidelite = cartefideliteCRUD.getUserByIDcf(9);

             //-------------------------------Trie---------------------------------------------------

              //System.out.println( cartefideliteCRUD.triercarte());
             
             //-----------------------------Filter---------------------------------------------------


            //System.out.println( cartefideliteCRUD.Filter_carte("dateExpiration","2024-12-12"));


  }
//    
}
