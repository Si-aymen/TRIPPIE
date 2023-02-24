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
         //utilisateurCRUD uc = new utilisateurCRUD();
         roleCRUD rc = new roleCRUD();
         ChauffeurCRUD cc= new ChauffeurCRUD();
         ClientCRUD clc=new ClientCRUD();
         LocateurCRUD l=new LocateurCRUD();
         //System.out.println(cc.afficherChauffeur());
         System.out.println(clc.afficherClient());
     /*-----------------------------Role--------------------------------------------*/    
        // service init
        utilisateurCRUD ps = new utilisateurCRUD();
        
        //player init
         Utilisateur p = new Utilisateur();
        //p.setCin("15015203");
        //p.setNom("Sadio");
       // p.setPrenom("Mane");
        //p.setSexe("Homme");
        //p.setAge(28);
//        
//        //add action
        //ps.ajouterUtilisateur(p);
        
        //select
        //System.out.println(ps.fetchPlayers());
       
//        p.setId_user(43);
//        Role t = new Role();      
//        ps.affecterClient(t, p);
          //rc.affecterUser(r1, u);
         //System.out.println(rc.afficherRole());
        System.out.println(ps.afficherUtilisateur());
          //rc.modifierRole(r3);
          //System.out.println(rc.afficherRole());
          //rc.supprimerRole(1);
          
     /*------------------------------Utilisateur-------------------------------------------------------------------------------*/     
          Utilisateur u1= new Utilisateur("12345678","Zouari","Aymen","Homme", 44);
          Utilisateur u2= new Utilisateur("12345677","zwaaaw","zzaa","Femme",24);
          Utilisateur u3= new Utilisateur("22245679","Zouari","Aymen","Homme",25);
          Utilisateur u4 = new Utilisateur("23456789", "Saidi", "Fatma", "Femme", 28);
          Utilisateur u5 = new Utilisateur("34567890", "Boudali", "Ali", "Homme", 35);
          Utilisateur u6 = new Utilisateur("45678901", "Ghazi", "Nour", "Femme", 22);
          Utilisateur u7 = new Utilisateur("56789012", "Hamdi", "Karim", "Homme", 31);
          Utilisateur u8 = new Utilisateur("67890123", "Fakhfakh", "Nada", "Femme", 26);
          Utilisateur u9 = new Utilisateur("78901234", "Ben Hamouda", "Marwen", "Homme", 29);
          Utilisateur u10 = new Utilisateur("89012345", "Moussa", "Hela", "Femme", 37);
          Utilisateur u11 = new Utilisateur("90123456", "Kouki", "Samir", "Homme", 41);
          Utilisateur u12 = new Utilisateur("01234567", "Ben Ammar", "Safa", "Femme", 24);
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
          // System.out.println(uc.trierUtilisateur());
           //System.out.println((uc.afficherUtilisateur()));
     /*---------------------------------Chauffeur----------------------------------------------------------------------------*/     
     // Chauffeur c1=new Chauffeur(1,2,5,"12345678", "Ford", "Bleu", "172TUNIS1234", "aymen.zouari@esprit.tn", "12345");
         // cc.ajouterChauffeur(c1);
         System.out.println(cc.afficherChauffeur());
     /*----------------------------------Client-------------------------------------------------------------------------------*/     
       //   Client cli1=new Client(1,1,4,"azeae", "aaa"); 
         // clc.ajouterClient(cli1);
     /*----------------------------------Locateur-------------------------------------------------------------------------------*/      
     // Locateur l1=new Locateur(1,3,6, "TravelToDo","zouari.aymen@traveltodo.tn","12345");
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
