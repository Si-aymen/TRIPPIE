/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

<<<<<<< HEAD
<<<<<<< HEAD
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import edu.webuild.model.CoVoiturage;
import edu.webuild.model.Participation;
import edu.webuild.services.*;
import java.sql.Date;
import java.time.ZoneId;
import java.util.Set;

/**
 *
 * @author manou
 */
public class Webuild {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SmS_Cov send = new SmS_Cov();
        //send.send_message("+21692554097", "test the msg 10th time");
        Call_Cov test_call = new Call_Cov();
        //test_call.cal("+21692554097");

        Whatsapp what = new Whatsapp();
        String toNumber = "+21692554097";
        String messageBody = "ok test";
        what.sendWhatsappMessage(toNumber, messageBody);

=======
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
        //rc.supprimerRole(1);
        /*------------------------------Utilisateur-------------------------------------------------------------------------------*/
        Utilisateur u1 = new Utilisateur("12345678", "Zouari", "Aymen", "Homme", 44);
        Utilisateur u2 = new Utilisateur("12345677", "zwaaaw", "zzaa", "Femme", 24);
        Utilisateur u3 = new Utilisateur("22245679", "Zouari", "Aymen", "Homme", 25);
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
>>>>>>> 86f631627a8ee2d0083d29de6b5c858caec1a85e
    }

}
=======
import edu.webuild.model.cadeau;
import edu.webuild.model.coupon;
import edu.webuild.services.cadeauCrud;
import edu.webuild.services.couponCrud;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import edu.webuild.utils.MyConnection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class Webuild {
    public static void main(String[] args){
     
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
       //MyConnection mc= new MyConnection();
     couponCrud pcd= new couponCrud();
       
    
          System.out.println("---------------- partie coupon -----------------------------");
       
       
       //pcd.ajoutercoupon();
       
     
  
        /* System.out.println(pcd.Filter_Coupon("code_coupon", "oo"));
         System.out.println(pcd.afficher());*/

      
       
      /* int id=20;
       pcd.Supprimer(id);
        System.out.println(pcd.afficher());
      */
       
       
       
       
       
       
       
       
       
       
    /*   
      try{
           Date date_debut = dateFormat.parse("2025-01-14");
            Date date_experation = dateFormat.parse("2025-01-14");
           coupon c = new coupon(date_debut,date_experation,30,"rimout",5,"simple");
              c.setId_coupon(56);// id de la personne à modifier
pcd.modifier(c);
System.out.println(pcd.displayCoupon());
       }catch(ParseException e)
       {
            e.printStackTrace();
            
       }
        /*System.out.println("voici votre recherch");
        System.out.println(pcd.rech(3));*/
        
        
       /* System.out.println("voici le tri");
        String columncoupon = "id_coupon";
         String ordercoupon = "ASC";
        
        System.out.println(pcd.sortCoupons(columncoupon, ordercoupon));*/
       
       
       
       
      /* 
       
         
       try{
           Date date_debut = dateFormat.parse("2022-01-14");
            Date date_experation = dateFormat.parse("2025-01-14");
           coupon c1 = new coupon(date_debut,date_experation,40,"valentin",200,"vip");
             
             if(pcd.validateCoupon(c1))
             {
                  System.out.println("Coupon valide");
                  pcd.ajouterpersonne2(c1);
             }
             else {
        System.out.println("Coupon non valide");
    }
       }catch(ParseException e)
       {
            e.printStackTrace();
            
       }*/
    
        
       
   
       
        System.out.println("---------------- partie cadeau -----------------------------");
       
       cadeauCrud pd= new cadeauCrud();
      //pd.ajoutercadeau
       
       
    /*
        cadeau c2 = new cadeau("carte fidelite",1,18);
       pd.ajoutercadeau2(c2);
       
      System.out.println(pd.displayCadeau());*/
       
       
       
        /*int id=23;
       pd.Supprimer(id);
        System.out.println(pd.displayCadeau());*/
      
               
         
          /*cadeau c = new cadeau("hello",5,47);
              c.setId_cadeau(65); // id de la personne à modifier
pd.modifier(c);
System.out.println(pd.displayCadeau());
    */


          /*System.out.println("voici votre recherch");
        System.out.println(pd.rech(34));
         */
         
        
        /// System.out.println(pd.filtercadeau("nom_cadeau", "covoiturage"));
         
        // System.out.println(pd.filtercadeau("recurrence", "5"));  
        
       
         
   /*List<cadeau> result = Filter_cadeau("id_cadeau", "1");
    for (cadeau c : result) {
        System.out.println("id_cadeau: " + c.getId_cadeau());
        System.out.println("nom_cadeau: " + c.getNom_cadeau());
        System.out.println("recurrence: " + c.getRecurrence());*/
   
   
   
   
   
   //triiiiiii
   /* System.out.println("voici le tri");
        String columncadeau = "nom_cadeau";
         String ordercadeau = "ASC";
        
        System.out.println(pd.sortCoupons(columncadeau, ordercadeau));*/
       
   
   //////controle saisie 
   
   
  /*  cadeau k1 = new cadeau("abonnement2",1);
       
     if(pd.validatecadeau(k1))
             {
                  System.out.println("cadeau valide");
                 pd.ajoutercadeau2(k1);
             }
             else {
        System.out.println("Coupon non valide");
    }*/
    }
}



>>>>>>> 9d50923a1a42e629ddfc92983077ffa5c623bbf0
