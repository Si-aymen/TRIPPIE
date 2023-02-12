/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import edu.webuild.services.roleCRUD;
import edu.webuild.services.utilisateurCRUD;



/**
 *
 * @author aymen
 */
public class Webuild {

    private static Object scanner;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
         utilisateurCRUD uc = new utilisateurCRUD();
          //Role r1 =new Role ("Client");
           roleCRUD rc = new roleCRUD();
          Role r1=new Role(1,"Client");
          Role r2=new Role(2,"Locateur");
          Role r3=new Role(3,"Chauffeur");
          // rc.ajouterRole(r1);
         // rc.ajouterRole(r2);
         // rc.ajouterRole(r3);
          Utilisateur u1= new Utilisateur("12345678","Zouari","Aymen",1);
          Utilisateur u2= new Utilisateur("12345677","aaa","aa",2);
          Utilisateur u3= new Utilisateur("12345679","Zouari","Aymen",3);
         // uc.ajouterUtilisateur(u1);
          //uc.ajouterUtilisateur(u2);
         // uc.ajouterUtilisateur(u3);
         
        //  uc.modifierUtilisateur(u2);
         // System.out.println(uc.afficherUtilisateur());
        //  System.out.println(rc.afficherRole());
          
          
          
       
    }
    
}
