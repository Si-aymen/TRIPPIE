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
        
      
       AbonnementCRUD A = new AbonnementCRUD();
        
 
       CartefideliteCRUD cf = new CartefideliteCRUD();
     
         System.out.println(cf.Filter_carte("dateExpiration", "15/12/2023"));
    }
    
}
