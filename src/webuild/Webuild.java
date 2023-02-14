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
          //System.out.println(rc.afficherRole());
          //rc.supprimerRole(1);
          
     /*------------------------------Utilisateur-------------------------------------------------------------------------------*/     
          Utilisateur u1= new Utilisateur("12345678","Zouari","Aymen","Homme", 44, 1);
          Utilisateur u2= new Utilisateur(5,"12345677","zwaaaw","zzaa","Femme",24,2);
          Utilisateur u3= new Utilisateur("22245679","Zouari","Aymen","Homme",25,3);
          Utilisateur u4 = new Utilisateur("23456789", "Saidi", "Fatma", "Femme", 28, 2);
          Utilisateur u5 = new Utilisateur("34567890", "Boudali", "Ali", "Homme", 35, 1);
          Utilisateur u6 = new Utilisateur("45678901", "Ghazi", "Nour", "Femme", 22, 2);
          Utilisateur u7 = new Utilisateur("56789012", "Hamdi", "Karim", "Homme", 31, 3);
          Utilisateur u8 = new Utilisateur("67890123", "Fakhfakh", "Nada", "Femme", 26, 2);
          Utilisateur u9 = new Utilisateur("78901234", "Ben Hamouda", "Marwen", "Homme", 29, 1);
          Utilisateur u10 = new Utilisateur("89012345", "Moussa", "Hela", "Femme", 37, 3);
          Utilisateur u11 = new Utilisateur("90123456", "Kouki", "Samir", "Homme", 41, 3);
          Utilisateur u12 = new Utilisateur("01234567", "Ben Ammar", "Safa", "Femme", 24, 2);
          //uc.ajouterUtilisateur(u1);
          //uc.ajouterUtilisateur(u2);
          //uc.ajouterUtilisateur(u3);
          //uc.ajouterUtilisateur(u4);
          //uc.ajouterUtilisateur(u5);
          //uc.ajouterUtilisateur(u6);
          //uc.ajouterUtilisateur(u7);
          //uc.ajouterUtilisateur(u8);
          //uc.ajouterUtilisateur(u9);
          //uc.ajouterUtilisateur(u10);
          //uc.ajouterUtilisateur(u11);
           //uc.ajouterUtilisateur(u12);
           // uc.ajouterUtilisateur(u1);
           // uc.ajouterUtilisateur(u2);
           //uc.ajouterUtilisateur(u3);
           //uc.modifierUtilisateur(u2);
           //uc.supprimerUtilisateurByCin("22245679");
           //System.out.println(uc.afficherUtilisateur());
           //System.out.println(uc.getById(6));
           //System.out.println(uc.FiltrerUtilisateur("sexe","Femme"));
           System.out.println(uc.trierUtilisateur());
     /*---------------------------------Chauffeur----------------------------------------------------------------------------*/     
          Chauffeur c1=new Chauffeur(1,2,5,"12345678", "Ford", "Bleu", "172TUNIS1234", "aymen.zouari@esprit.tn", "12345");
         // cc.ajouterChauffeur(c1);
        // System.out.println(cc.afficherChauffeur());
     /*----------------------------------Client-------------------------------------------------------------------------------*/     
          Client cli1=new Client(1,1,4,"azeae", "aaa"); 
         // clc.ajouterClient(cli1);
     /*----------------------------------Locateur-------------------------------------------------------------------------------*/      
          Locateur l1=new Locateur(1,3,6, "TravelToDo","zouari.aymen@traveltodo.tn","12345");
          //System.out.println(l.afficherLocateur());
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
