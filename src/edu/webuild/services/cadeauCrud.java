/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.inter.interfacecadeau;
import edu.webuild.model.cadeau;

//import edu.webuild.model.coupon;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author HP
 */
public class cadeauCrud  implements interfacecadeau{
    Connection cnx2;
  public cadeauCrud(){
        cnx2= MyConnection.getinstance().getcnx();
    }
    @Override
  public void ajoutercadeau(){
        
        try {
            String requete="INSERT INTO cadeau (nom_cadeau,recurrence,id_coupon)"+ "values ('location','10','15')" ;
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("cadeau  ajoutee aves success ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
  
  
  
    @Override
   public void ajoutercadeau2(cadeau c){
       
        
        
        try { 
            String requete2="INSERT INTO cadeau (nom_cadeau,recurrence,id_coupon) "+ "values (?,?,?)" ;
            PreparedStatement pst = cnx2.prepareStatement(requete2);
          
               pst.setString(1,c.getNom_cadeau());
               
              pst.setInt(2,c.getRecurrence());
            pst.setInt(3,c.getId_coupon() );
                
             
              pst.executeUpdate();
              System.out.println("votre cadeau est ajouteessss ");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
        
    
  }
   
   
    @Override
   public List<cadeau> displayCadeau() {
    List<cadeau> cadeauList = new ArrayList<>();
    try {
        String query = "SELECT * FROM cadeau";
        Statement stmt = cnx2.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
          
            String nom = rs.getString("nom_cadeau");
            int recurrence = rs.getInt("recurrence");
 //int id_coupon = rs.getInt("id_coupon");
            cadeau c = new cadeau( nom, recurrence);
            cadeauList.add(c);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return cadeauList;
}


    @Override
 public  int Supprimer(String cadeau ){
          
        try {
             String requete4= "delete from cadeau where nom_cadeau ='"+cadeau+"'";   
            PreparedStatement pst = cnx2.prepareStatement(requete4);
             pst.executeUpdate(requete4);
            System.out.println("cadeau supprimer aves success ");
        } catch (SQLException ex) {
              System.err.println("ex.getMessge()");
        }
        return 0;
       
   } 
    @Override
 public void modifier(cadeau c ){
       
       
          try {
        
        String requete = "UPDATE cadeau SET nom_cadeau=?,recurrence=?, id_coupon=? WHERE id_cadeau =?";
        PreparedStatement st = cnx2.prepareStatement(requete);
     
       
                st.setString(1,c.getNom_cadeau());
                
                 st.setInt(2,c.getRecurrence());
               
                st.setInt(3, c.getId_coupon());
                 st.setInt(4, c.getId_cadeau());
        st.executeUpdate();
        System.out.println("cadeau modifiée avec succès !");
        
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la modification de la personne: " + ex.getMessage());
    
}
    }  
      
 

   
    @Override
    public List<cadeau> rech(int id ) {
    List<cadeau> cadeauList = new ArrayList<>();
    try {
        String query = "SELECT * FROM cadeau WHERE id_cadeau= " + id ;
        Statement stmt = cnx2.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id1 = rs.getInt("id_cadeau");
            String nom = rs.getString("nom_cadeau");
            int recurrence = rs.getInt("recurrence");
 int id_coupon = rs.getInt("id_coupon");
            cadeau c = new cadeau(id, nom, recurrence,id_coupon);
            cadeauList.add(c);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return cadeauList;
}

    






//triiiiii 
public List<cadeau> sortCoupons(String column, String order) {
    List<cadeau> cadeauList = new ArrayList<>();
    try {
        String query = "SELECT * FROM cadeau ORDER BY " + column + " " + order;
        Statement stmt = cnx2.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id_cadeau = rs.getInt("id_cadeau");
           
           
            String nom_cadeau = rs.getString("nom_cadeau");
            int recurrence = rs.getInt("recurrence");
            int id_coupon = rs.getInt("id_coupon");
            

            cadeau c = new cadeau (id_cadeau,  nom_cadeau, recurrence,id_coupon);
            cadeauList.add(c);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return cadeauList;
}
 
/*public boolean validatecadeau(cadeau cadeau) {

    if (cadeau.getNom_cadeau().length() == 0) {
        System.out.println("Le nom de ceadeau  ne peut pas être vide.");
        return false;
    }

     if (cadeau.getRecurrence()< 0 || cadeau.getRecurrence()>= 10) {
        System.out.println("La reccurence  doit être compris entre 0 et 10.");
   return false;     
    }
       
  return true;
}*/

    }

