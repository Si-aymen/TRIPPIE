/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.model.cartefidelite;
import edu.webuild.model.abonnement;
import edu.webuild.services.CartefideliteCRUD;
import edu.webuild.services.AbonnementCRUD;
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
        
      
 
  


       
      /*_________________________Abonnement_____________________________________*/
//        abonnement a3=new abonnement("Gold","22/01/2023","22/03/2023",9);
//        abonnement a4=new abonnement("Gold","01/01/2023","01/03/2023",9);
//        abonnement a5=new abonnement("Plat","22/01/2023","22/03/2023",9);
//        abonnement a6=new abonnement("Gold","22/01/2023","22/03/2023",9);
         
             AbonnementCRUD ac;
             ac = new AbonnementCRUD();
//         ac.ajouterabonnement(a3);
//         ac.ajouterabonnement(a4);
//         ac.ajouterabonnement(a5);
//         ac.ajouterabonnement(a6);


//             System.out.println( ac.afficherabonnement());
        

             
//            ac.supprimerabonnement(40);

//      System.out.println("les donnes de votre rechercher sont ");
//      System.out.println(ac.getUserByID(30)); 
//      System.out.println(ac.trierabonnement());
//      System.out.println(ac.Filter_abonnement("type", "gold"));
             
      /*_________________________Cartefidelite_____________________________________*/
             cartefidelite c= new cartefidelite("1000points", "15/12/2023", 16);
            
                  CartefideliteCRUD cf = new CartefideliteCRUD();
                    cf.ajoutercarte(c);
                    System.out.println(cf.affichercarte());
//        System.out.println(cf.Filter_carte("pointMerci", "1000points"));
  }
//    
}
