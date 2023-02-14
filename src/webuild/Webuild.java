/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webuild;

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
       //pcd.ajoutercoupon();
       
       
       /*try{
           Date date_debut = dateFormat.parse("2024-01-14");
            Date date_experation = dateFormat.parse("2022-01-14");
           coupon c1 = new coupon(date_debut,date_experation,40,"hiiii",5,"vip");
             pcd.ajouterpersonne2(c1);
       }catch(ParseException e)
       {
            e.printStackTrace();
            
       }
    */
          System.out.println("---------------- partie coupon -----------------------------");
       
       
       
       System.out.println(pcd.afficher());
       
       /*int id=1;
       pcd.Supprimer(id);
        System.out.println(pcd.afficher());*/
      
       
       
       
       
       
       
       
       
       
       
       
       try{
           Date date_debut = dateFormat.parse("2025-01-14");
            Date date_experation = dateFormat.parse("2025-01-14");
           coupon c = new coupon(date_debut,date_experation,30,"rimouta",5,"simple");
              c.setId_coupn(3); // id de la personne à modifier
pcd.modifier(c);
System.out.println(pcd.afficher());
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
       
       
       
       
       
       
         
         try{
           Date date_debut = dateFormat.parse("2022-01-14");
            Date date_experation = dateFormat.parse("2025-01-14");
           coupon c1 = new coupon(date_debut,date_experation,400,"valentin",2,"vip");
             
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
            
       }
    
        
       
   
       
        System.out.println("---------------- partie cadeau -----------------------------");
       
       cadeauCrud pd= new cadeauCrud();
      // pd.ajoutercadeau();
       /*cadeau k1 = new cadeau("location",2);
       pd.ajoutercadeau2(k1);
       */
       
       
       System.out.println(pd.displayCadeau());
       
       
       
        /*int id=23;
       pd.Supprimer(id);
        System.out.println(pd.displayCadeau());*/
      
               
         
           /*cadeau c = new cadeau("covoiturage",5);
              c.setId_cadeau(24); // id de la personne à modifier
pd.modifier(c);*/
//System.out.println(pd.displayCadeau());
    


          System.out.println("voici votre recherch");
        System.out.println(pd.rech(24));
        
        /// System.out.println(pd.filtercadeau("nom_cadeau", "covoiturage"));
         
        // System.out.println(pd.filtercadeau("recurrence", "5"));  
        
       
         
   /*List<cadeau> result = Filter_cadeau("id_cadeau", "1");
    for (cadeau c : result) {
        System.out.println("id_cadeau: " + c.getId_cadeau());
        System.out.println("nom_cadeau: " + c.getNom_cadeau());
        System.out.println("recurrence: " + c.getRecurrence());*/
    System.out.println("voici le tri");
        String columncadeau = "nom_cadeau";
         String ordercadeau = "ASC";
        
        System.out.println(pd.sortCoupons(columncadeau, ordercadeau));
   
   
    }
}



