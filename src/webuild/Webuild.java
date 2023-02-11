/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.model.voiture;
import edu.webuild.services.voitureCRUD;

/**
 *
 * @author manou
 */
public class Webuild {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     /// MyConnection conn = MyConnection.getInstance();
        voiture v1 = new voiture("122tunis1259","clio", "5ch",280);
        voiture v2 = new voiture("122tunis1259","clio", "5ch",450);
        voiture v4 = new voiture("1259","clio", "5ch",280);
        voiture v3 = new voiture("122tunis1259","clio", "5ch",280);
       voitureCRUD voi = new voitureCRUD();
        
     //   voi.ajouterPersonne(v2);
        //voi.ajouterPersonne2(v1);
     //   System.out.println( per.affichervoiture());
     System.out.println( voi.affichervoiture());
        voiture mod = new voiture("hhhh","dtftdt", "hhhhhh",10000);
        voi.modifiervoiture(mod,17);
         System.out.println( voi.affichervoiture());
     //    per.supprimervoiture(10);
    }
    
}
