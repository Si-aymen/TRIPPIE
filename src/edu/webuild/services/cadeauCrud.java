/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.model.cadeau;
import edu.webuild.model.coupon;
//import edu.webuild.model.coupon;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class cadeauCrud {
    Connection cnx2;
  public cadeauCrud(){
        cnx2= MyConnection.getinstance().getcnx();
    }
  public void ajoutercadeau(){
        
        try {
            String requete="INSERT INTO cadeau (nom_cadeau,recurrence)"+ "values ('abonnement','10')" ;
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("cadeau  ajoutee aves success ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
  
  
  
   public void ajoutercadeau2(cadeau c){
       
        
        
        try { 
            String requete2="INSERT INTO cadeau (nom_cadeau,recurrence)"+ "values (?,?)" ;
            PreparedStatement pst = cnx2.prepareStatement(requete2);
               
             
         
         
          
               pst.setString(1,c.getNom_cadeau());
               
                pst.setInt(2,c.getRecurrence());
                
                
             
              pst.executeUpdate();
              System.out.println("votre cadeau est ajouteessss ");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
        
    
  }
   
   
   public List<cadeau> displayCadeau() {
    List<cadeau> cadeauList = new ArrayList<>();
    try {
        String query = "SELECT * FROM cadeau";
        Statement stmt = cnx2.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id_cadeau");
            String nom = rs.getString("nom_cadeau");
            int recurrence = rs.getInt("recurrence");

            cadeau c = new cadeau(id, nom, recurrence);
            cadeauList.add(c);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return cadeauList;
}


 public  int Supprimer(int id ){
          
        try {
             String requete4= "delete from cadeau where id_cadeau ='"+id+"'";   
            PreparedStatement pst = cnx2.prepareStatement(requete4);
             pst.executeUpdate(requete4);
            System.out.println("cadeau supprimer aves success ");
        } catch (SQLException ex) {
              System.err.println("ex.getMessge()");
        }
        return 0;
       
   } 
 public void modifier(cadeau c ){
       
       
          try {
        
        String requete = "UPDATE cadeau SET nom_cadeau=?,recurrence=? WHERE id_cadeau =?";
        PreparedStatement st = cnx2.prepareStatement(requete);
     
       
                st.setString(1,c.getNom_cadeau());
                
                 st.setInt(2,c.getRecurrence());
               
                st.setInt(3, c.getId_cadeau());
        st.executeUpdate();
        System.out.println("cadeau modifiée avec succès !");
        
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la modification de la personne: " + ex.getMessage());
    
}
    }  
      
 

   
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

            cadeau c = new cadeau(id, nom, recurrence);
            cadeauList.add(c);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return cadeauList;
}

    

/*public List<cadeau> filterCadeau(String column, String value) {
        List<cadeau> filteredGifts = new ArrayList<>();
        try {
            String query = "SELECT * FROM cadeau WHERE " + column + " = ";
            if (column.equals("id_cadeau") || column.equals("recurrence")) {
                query += Integer.parseInt(value);
            } else {
                query += "\"" + value + "\"";
            }
            Statement statement = cnx2.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                cadeau gift = new cadeau();
                gift.setId_cadeau(resultSet.getInt("id_cadeau"));
                gift.setNom_cadeau(resultSet.getString("nom_cadeau"));
                gift.setRecurrence(resultSet.getInt("recurrence"));
                filteredGifts.add(gift);
            }
        } catch (SQLException ex) {
            System.out.println("Error in filtering gifts: " + ex.getMessage());
        }
        return filteredGifts;
    }
*/



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
            

            cadeau c = new cadeau (id_cadeau,  nom_cadeau, recurrence);
            cadeauList.add(c);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return cadeauList;
}
 
public boolean validatecadeau(cadeau cadeau) {

    if (cadeau.getNom_cadeau().length() == 0) {
        System.out.println("Le nom de ceadeau  ne peut pas être vide.");
        return false;
    }

     if (cadeau.getRecurrence()< 0 || cadeau.getRecurrence()>= 10) {
        System.out.println("La reccurence  doit être compris entre 0 et 10.");
   return false;     
    }
       
  return true;
}
}
