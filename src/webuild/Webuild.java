/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.model.reclamation;
import edu.webuild.model.reponse;
import edu.webuild.services.reclamationCRUD;
import edu.webuild.services.reponseCRUD;


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
        reclamation v1 = new reclamation("testtt","testt","");
        reclamation v2 = new reclamation("technique","technique","non traité");
        reclamation v3 = new reclamation("tech","tech","");
        
        reponse r1 = new reponse("frfz", 16, 1);
        
        reclamationCRUD rc = new reclamationCRUD() {};
        
        reponseCRUD rpc = new reponseCRUD();
        
        rc.ajouterReclamation(v1);
        //rc.modifierReclamation(v2,8);
        //rc.supprimerReclamation(14);
        
        //rpc.ajouterReponse(r1);
        //rpc.modifierReponse(r1, 1);
        //rpc.supprimerReponse(4);
       
        System.out.println(rc.afficherReclamation());
        
        //System.out.println(rpc.afficherReponse());
       
        
         
       
    }
    
}
