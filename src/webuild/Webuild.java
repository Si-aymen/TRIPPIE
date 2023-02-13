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
          Role r2=new Role(2,"Chauffeur");
          Role r3=new Role(3,"Locateur");
          //rc.ajouterRole(r1);
          //rc.ajouterRole(r2);
          //rc.ajouterRole(r3);
          //rc.modifierRole(r3);
          System.out.println(rc.afficherRole());
          //rc.supprimerRole(1);
          
     /*------------------------------Utilisateur-------------------------------------------------------------------------------*/     
          Utilisateur u1= new Utilisateur("12345678","Zouari","Aymen","Homme", 44, 1);
          Utilisateur u2= new Utilisateur(5,"12345677","zwaaaw","zzaa","Femme",24,2);
          Utilisateur u3= new Utilisateur("22245679","Zouari","Aymen","Homme",25,3);
          
           // uc.ajouterUtilisateur(u1);
           // uc.ajouterUtilisateur(u2);
           //uc.ajouterUtilisateur(u3);
           //uc.modifierUtilisateur(u2);
           //uc.supprimerUtilisateurByCin("22245679");
           //System.out.println(uc.afficherUtilisateur());
     /*---------------------------------Chauffeur----------------------------------------------------------------------------*/     
          Chauffeur c1=new Chauffeur(1,2,5,"12345678", "Ford", "Bleu", "172TUNIS1234", "aymen.zouari@esprit.tn", "12345");
         // cc.ajouterChauffeur(c1);
         System.out.println(cc.afficherChauffeur());
     /*----------------------------------Client-------------------------------------------------------------------------------*/     
          Client cli1=new Client(1,1,4,"azeae", "aaa"); 
         // clc.ajouterClient(cli1);
     /*----------------------------------Locateur-------------------------------------------------------------------------------*/      
          Locateur l1=new Locateur(1,3,6, "TravelToDo","zouari.aymen@traveltodo.tn","12345");
          System.out.println(l.afficherLocateur());
          //l.ajouterLocateur(l1);
          
          
         
         
         
         
          
         // uc.ajouterUtilisateur(u2);
         // uc.ajouterUtilisateur(u3);
         // cc.ajouterChauffeur(c1);
        //  uc.modifierUtilisateur(u2);
         // System.out.println(uc.afficherUtilisateur());
        //  System.out.println(rc.afficherRole());
        //  
          //
         // 
          
       
    }
    
}
