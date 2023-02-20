/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;



import edu.webuild.model.coupon;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class couponCrud {
 Connection cnx2;
  public couponCrud(){
        cnx2= MyConnection.getinstance().getcnx();
    }
  public void ajoutercoupon(){
        
        try {
            String requete="INSERT INTO coupon (date_debut,date_experation,taux_reduction,code_coupon,nbr_utilisation,type)"+ "values ('2023-02-14','2023-03-01','20','Valentin10','10','vip')" ;
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("coupon ajoutee aves success ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
  public void ajouterpersonne2(coupon c){
       
        
        
        try { 
            String requete2="INSERT INTO coupon (date_debut,date_experation,taux_reduction,code_coupon,nbr_utilisation,type)"+ "values (?,?,?,?,?,?)" ;
            PreparedStatement pst = cnx2.prepareStatement(requete2);
               
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date_Debut = dateFormat.format(c.getDate_debut());
            pst.setString(1,date_Debut);
         
            String date_experation = dateFormat.format(c.getDate_experation());
            pst.setString(2,date_experation);
          
               pst.setInt(3,c.getTaux_reduction());
               
                pst.setString(4,c.getCode_coupon());
                
                 pst.setInt(5,c.getNbr_utilisation());
                pst.setString(6,c.getType());
              pst.executeUpdate();
              System.out.println("votre coupon est ajouteessss ");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
        
    
  }
    /*public List<coupon> afficher() {

            List<coupon> myList = new ArrayList<>();
       
        try {
       String requete3= "Select * from coupon";
       Statement  st1 = cnx2.createStatement();
       ResultSet rs= st1.executeQuery(requete3);
       while(rs.next()){
           coupon c1 =  new coupon();
           c1.setId_coupn(rs.getInt(1));
           c1.setDate_debut(rs.getDate(2));
           c1.setDate_experation(rs.getDate(3));
           c1.setTaux_reducton(rs.getInt(4));
           c1.setCode_coupon(rs.getString(5));
           c1.setNbr_utilisation(rs.getInt(6));
           c1.setType(rs.getString(7));
           myList.add(c1);
       }
           
        } catch (SQLException ex) {
           System.err.println("ex.getMessge()");
        }
      
       return myList; 
    }*/
    
    public List<coupon> displayCoupon() {
    List<coupon> couponList = new ArrayList<>();
    try {
        String query = "SELECT * FROM coupon";
        Statement stmt = cnx2.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id_coupon = rs.getInt("id_coupon");
            Date date_debut = rs.getDate("date_debut");
             Date date_experation = rs.getDate("date_experation");
            int taux_reduction = rs.getInt("taux_reduction");
            String code_coupon= rs.getString("code_coupon");
 int nbr_utilisation = rs.getInt("nbr_utilisation");
   String type= rs.getString("type");
            coupon k = new coupon(id_coupon, date_debut, date_experation,taux_reduction,code_coupon,nbr_utilisation,type);
            couponList.add(k);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return couponList;
}

        
    
    public  int Supprimer(int id ){
          
        try {
             String requete4= "delete from coupon where id_coupon ='"+id+"'";   
            PreparedStatement pst = cnx2.prepareStatement(requete4);
             pst.executeUpdate(requete4);
            System.out.println("coupon supprimer aves success ");
        } catch (SQLException ex) {
              System.err.println("ex.getMessge()");
        }
        return 0;
       
   } 
    public void modifier(coupon c ){
       
       
          try {
        
        String requete = "UPDATE coupon SET date_debut=?, date_experation=?,taux_reduction=?,code_coupon=?,nbr_utilisation=?,type=? WHERE id_coupon =?";
        PreparedStatement st = cnx2.prepareStatement(requete);
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date_Debut = dateFormat.format(c.getDate_debut());
            st.setString(1,date_Debut);
            
            
            
        String date_experation = dateFormat.format(c.getDate_experation());
            st.setString(2,date_experation);
        st.setInt(3,c.getTaux_reduction());
               
                st.setString(4,c.getCode_coupon());
                
                 st.setInt(5,c.getNbr_utilisation());
                st.setString(6,c.getType());
                st.setInt(7, c.getId_coupon());
        st.executeUpdate();
        System.out.println("coupon modifiée avec succès !");
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la modification de la personne: " + ex.getMessage());
    
}
    }
    
    
    
    
    public List<coupon> rech(int id ) {
    List<coupon> couponList = new ArrayList<>();
    try {
        String query = "SELECT * FROM coupon WHERE id_coupon= " + id ;
        Statement stmt = cnx2.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id_coupon = rs.getInt("id_coupon");
            Date  date_debut = rs.getDate("date_debut");
        Date date_experation = rs.getDate("date_experation");
        int taux_reduction = rs.getInt("taux_reduction");
        String code_coupon = rs.getString("code_coupon");
        int nbr_utilisation = rs.getInt("nbr_utilisation");
        String type = rs.getString("type");
        
           
            coupon c = new coupon(id_coupon, date_debut, date_experation,taux_reduction, code_coupon, nbr_utilisation, type);
        couponList.add(c);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return couponList;
}
    
  //triiii
    public List<coupon> sortCoupons(String column, String order) {
    List<coupon> couponList = new ArrayList<>();
    try {
        String query = "SELECT * FROM coupon ORDER BY " + column + " " + order;
        Statement stmt = cnx2.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id_coupon = rs.getInt("id_coupon");
            Date date_debut = rs.getDate("date_debut");
            Date date_experation = rs.getDate("date_experation");
            int taux_reduction = rs.getInt("taux_reduction");
            String code_coupon = rs.getString("code_coupon");
            int nbr_utilisation = rs.getInt("nbr_utilisation");
            String type = rs.getString("type");

            coupon c = new coupon(id_coupon, date_debut, date_experation, taux_reduction, code_coupon, nbr_utilisation, type);
            couponList.add(c);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return couponList;
}
    
    
    
    
    
    
    
    
    
    
    
    
    //controle saisie 
    public boolean validateCoupon(coupon coupon) {


    if (coupon.getDate_debut().after(coupon.getDate_experation())) {
        System.out.println("La date de début doit être antérieure à la date d'expiration.");
        return false;
    }

    if (coupon.getTaux_reduction()< 0 || coupon.getTaux_reduction()>= 100) {
        System.out.println("Le taux de réduction doit être compris entre 0 et 100.");
        return false;
    }

    if (coupon.getCode_coupon().length() == 0) {
        System.out.println("Le code coupon ne peut pas être vide.");
        return false;
    }

    if (coupon.getNbr_utilisation() < 0) {
        System.out.println("Le nombre d'utilisation doit être un entier positif.");
        return false;
    }

    if (coupon.getType().length() == 0) {
        System.out.println("Le type ne peut pas être vide.");
        return false;
    }

    return true;
}
    
    public List<coupon> Filter_Coupon(String S, String SS) {
        List<coupon> list = new ArrayList<>();
        try {
            if (S.equals("type") || S.equals("code_coupon")) {
                int temp = Integer.parseInt(SS);
                String req = "SELECT * FROM `coupon` WHERE " + S + " =" + temp;
                Statement st = cnx2.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    coupon v = new coupon();
                    v.setId_coupn(RS.getInt("id_coupon"));
                    v.setDate_debut(RS.getDate("date_debut"));
                    v.setDate_experation(RS.getDate("date_experation"));
                    v.setTaux_reducton(RS.getInt("taux_reduction"));
                    v.setCode_coupon(RS.getString("code_coupon"));
                    v.setNbr_utilisation(RS.getInt("nbr_utilisation"));
                    v.setType(RS.getString("type"));
                    list.add(v);
                }
            } else {
                String req = "SELECT * FROM `coupon` WHERE " + S + " =" + "\"" + SS + "\"";
                Statement st = cnx2.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    coupon v = new coupon();
                     v.setId_coupn(RS.getInt("id_coupon"));
                    v.setDate_debut(RS.getDate("date_debut"));
                    v.setDate_experation(RS.getDate("date_experation"));
                    v.setTaux_reducton(RS.getInt("taux_reduction"));
                    v.setCode_coupon(RS.getString("code_coupon"));
                    v.setNbr_utilisation(RS.getInt("nbr_utilisation"));
                    v.setType(RS.getString("type"));

                    list.add(v);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;


        
    }}

