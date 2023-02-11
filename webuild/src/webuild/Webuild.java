/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.model.CoVoiturage;
import edu.webuild.services.CoVoiturageCRUD;


/**
 *
 * @author manou
 */
public class Webuild {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //CoVoiturage v1 = new CoVoiturage("rades","Esprit","11/02/2023",4);
        CoVoiturage v2 = new CoVoiturage("manzah","boumhal","10/12/2022",4);
        CoVoiturage v3 = new CoVoiturage("esprit","tunis","18/02/2022",2);
        
        CoVoiturageCRUD voi= new CoVoiturageCRUD();
        
       // voi.ajouterCoVoiturage(v1);
       //voi.ajouterCoVoiturage2(v2);
       System.out.println( voi.afficherCoVoiturage());
       voi.supprimerCoVoiturage(2);
       System.out.println( voi.afficherCoVoiturage());
       voi.modifierCoVoiturage(v3,1);
       System.out.println( voi.afficherCoVoiturage());
        
    }
    
}
