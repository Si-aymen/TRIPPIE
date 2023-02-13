/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.model.reclamation;
import edu.webuild.services.reclamationCRUD;


/**
 *
 * @author manou
 */
public class Webuild {

    private static Object scanner;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     /// MyConnection conn = MyConnection.getInstance();
        reclamation v1 = new reclamation("testtt","testt");
        reclamation v2 = new reclamation("technique","technique");
        reclamation v4 = new reclamation("taher","taher");
        reclamation v3 = new reclamation("tech","tech");
        reclamationCRUD rc = new reclamationCRUD();
        
        //rc.ajouterReclamation(v3);
        //rc.modifierReclamation(v1,3);
        //rc.supprimerReclamation(4);
       
        System.out.println(rc.afficherReclamation());
       
        
         
       
    }
    
}
