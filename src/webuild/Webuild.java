/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.model.Chauffeur;
import edu.webuild.model.Client;
import edu.webuild.model.Locateur;
import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.services.ClientCRUD;
import edu.webuild.services.LocateurCRUD;
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
    /*-------------------------------Instance CRUD--------------------------------------------------------------------*/
         utilisateurCRUD uc = new utilisateurCRUD();
         roleCRUD rc = new roleCRUD();
         ChauffeurCRUD cc= new ChauffeurCRUD();
         ClientCRUD clc=new ClientCRUD();
         LocateurCRUD l=new LocateurCRUD();
         
     /*-----------------------------Role--------------------------------------------*/    
          Role r1=new Role(1,"Client");
          Role r2=new Role(2,"Locateur");
          Role r3=new Role(3,"Chauffeur");
          
          
          
     /*------------------------------Utilisateur-------------------------------------------------------------------------------*/     
          Utilisateur u1= new Utilisateur("12345678","Zouari","Aymen",23,1);
          Utilisateur u2= new Utilisateur("12345677","aaa","aa",24,2);
          Utilisateur u3= new Utilisateur("12345679","Zouari","Aymen",25,3);
          
     /*---------------------------------Chauffeur----------------------------------------------------------------------------*/     
          Chauffeur c1=new Chauffeur(1, 3, "12345678", "Ford", "Bleu", "172TUNIS1234", "aymen.zouari@esprit.tn", "12345");
          Chauffeur c2=new Chauffeur(2, 3, "13335678", "Ford", "Bleu", "132TUNIS1244", "aymen.zouari@esprit.tn", "12345");
     /*----------------------------------Client-------------------------------------------------------------------------------*/     
          Client cli1=new Client(1,1,"iheb.khemiri@esprit.tn","12345"); 
          
     /*----------------------------------Locateur-------------------------------------------------------------------------------*/      
          Locateur l1=new Locateur(1, 2, "TravelToDo","zouari.aymen@traveltodo.tn","12345");
           //rc.ajouterRole(r1);
          //rc.ajouterRole(r2);
          //rc.ajouterRole(r3);
         
          //uc.ajouterUtilisateur(u1);
          //uc.ajouterUtilisateur(u2);
          //uc.ajouterUtilisateur(u3);
          //cc.ajouterChauffeur(c1);
        //  uc.modifierUtilisateur(u2);
         // System.out.println(uc.afficherUtilisateur());
        //  System.out.println(rc.afficherRole());
          //cc.ajouterChauffeur(c2);
         // clc.ajouterClient(cli1);
          l.ajouterLocateur(l1);
          
       
    }
    
}
