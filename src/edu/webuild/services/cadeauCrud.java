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
    Connection cnx2 = MyConnection.getInstance().getConn();
  public cadeauCrud(){
        Connection cnx2 = MyConnection.getInstance().getConn();
    }
    
  
  
  
    @Override
   public void ajoutercadeau2(cadeau c){
       
        
        
        try { 
            String requete2="INSERT INTO cadeau (nom_cadeay,reccurence,description,valeur,coupon_id) "+ "values (?,?,?,?,?)" ;
            PreparedStatement pst = cnx2.prepareStatement(requete2);
          
              pst.setString(1,c.getNom_cadeau());
               
              pst.setInt(2,c.getRecurrence());
              pst.setString(3,c.getDescription());
               
              pst.setInt(4,c.getValeur());
            pst.setInt(5,c.getId_coupon() );
                
             
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
           
            String nom = rs.getString("nom_cadeay");
            int recurrence = rs.getInt("reccurence");
            String des = rs.getString("description");
            int val = rs.getInt("valeur");
            //int id_coupon = rs.getInt("id_coupon");
            cadeau c = new cadeau(nom, recurrence,des,val);
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
             String requete4= "delete from cadeau where nom_cadeay ='"+cadeau+"'";   
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
        
        String requete = "UPDATE cadeau SET nom_cadeay=?,reccurence=? ,description=?,valeur=? WHERE idcadeau =?";
        PreparedStatement st = cnx2.prepareStatement(requete);
     
       
                 st.setString(1,c.getNom_cadeau());
                
                 st.setInt(2,c.getRecurrence());
                 
                st.setString(3,c.getDescription());
                
                 st.setInt(4,c.getValeur());
               
                st.setInt(3, c.getId_coupon());
                 st.setInt(5, c.getId_cadeau());
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
        String query = "SELECT * FROM cadeau WHERE idcadeau= " + id ;
        Statement stmt = cnx2.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id1 = rs.getInt("idcadeau");
            String nom = rs.getString("nom_cadeay");
            int recurrence = rs.getInt("reccurence");
            String des = rs.getString("description");
            int val = rs.getInt("valeur");
 int coupon_id = rs.getInt("coupon_id");
            cadeau c = new cadeau(id, nom, recurrence,des,val,coupon_id);
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
            int id_cadeau = rs.getInt("idcadeau");
           
           
            String nom_cadeau = rs.getString("nom_cadeay");
            int recurrence = rs.getInt("reccurence");
             String des = rs.getString("description");
            int val = rs.getInt("valeur");
            int id_coupon = rs.getInt("coupon_id");
            

            cadeau c = new cadeau (id_cadeau,  nom_cadeau, recurrence,des,val,id_coupon);
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

