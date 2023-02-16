/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.services.AbonnementCRUD;
import edu.webuild.model.Abonnement;
import edu.webuild.utils.MyConnection;

/**
 *
 * @author mtirn
 */
public class webuild {
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       /// MyConnection conn = MyConnection.getInstance();
        Abonnement A1 = new Abonnement("gold","9dt", "22/01/2023","22/03/2023");
        Abonnement A2 = new Abonnement("gold","9dt", "22/01/2023","22/03/2023");

        AbonnementCRUD Ab = new AbonnementCRUD();
        
        //per.ajouterAbonnement(A1);
        //per.ajouterAbonnement2(A1);
        System.out.println( Ab.afficherAbonnement());
          
       
        
    }
    
}
