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
       
   
       
       
       
       cadeauCrud pd= new cadeauCrud();
      // pd.ajoutercadeau();
       /*cadeau k1 = new cadeau("location",2);
       pd.ajoutercadeau2(k1);
       */
       
       
       System.out.println(pd.displayCadeau());
       
       
       
        /*int id=23;
       pd.Supprimer(id);
        System.out.println(pd.displayCadeau());*/
      
              /*  System.out.println("---------------- partie cadeau -----------------------------");
         
           cadeau c = new cadeau("covoiturage",5);
              c.setId_cadeau(24); // id de la personne à modifier
pd.modifier(c);*/
System.out.println(pd.displayCadeau());
       
           System.out.println("les donnes concernat votre rechercher est ");
       System.out.println( pd.filter(26));
        
        
        
        
    }
}
