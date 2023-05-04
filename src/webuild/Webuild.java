/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

import edu.webuild.model.Client;
import edu.webuild.model.Utilisateur;
import edu.webuild.services.ChauffeurCRUD;
import edu.webuild.services.ClientCRUD;
import edu.webuild.services.LocateurCRUD;
import edu.webuild.services.roleCRUD;
import edu.webuild.services.utilisateurCRUD;
import java.sql.SQLException;
import sun.applet.Main;

/**
 *
 * @author aymen
 */
public class Webuild {

    private static Object scanner;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        /*-------------------------------Instance CRUD--------------------------------------------------------------------*/
        //utilisateurCRUD uc = new utilisateurCRUD();
        roleCRUD rc = new roleCRUD();
        ChauffeurCRUD cc = new ChauffeurCRUD();
        ClientCRUD client = new ClientCRUD();
        LocateurCRUD l = new LocateurCRUD();
        
        System.out.println(client.getClient("zouari.aymen@esprit.tn"));
     
        //System.out.println(cc.afficherChauffeur());
        // System.out.println(rc.afficherRole());
        /*-----------------------------Role--------------------------------------------*/
        // service init
        utilisateurCRUD ps = new utilisateurCRUD();
        
        //mail.sendEmail("aymen.donga@gmail.com", "aa", "aa");
        //clc.getClient("zouari.aymen@esprit.tn", "fe7a6e9f64edda7c234e8af6daf9860a26fe45e7a0d1098f0ec24e53fd3cfef8");
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
        //System.out.println(ps.afficherUtilisateur());
        //rc.modifierRole(r3);
        //System.out.println(rc.afficherRole());

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
        //   System.out.println(cc.afficherChauffeur());
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
