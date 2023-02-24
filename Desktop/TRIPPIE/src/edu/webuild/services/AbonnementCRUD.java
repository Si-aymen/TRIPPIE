/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.model.abonnement;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.webuild.interfaces.InterfaceAbonnement;


/**
 *
 * @author mtirn
 */
public class AbonnementCRUD implements InterfaceAbonnement{
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    
    @Override
    public void ajouterabonnement(abonnement A) {
        try {
            String req = "INSERT INTO `abonnement`(`type`,`dateExpiration`,`dateAchat`,`prix`) VALUES ('"+A.getType()+"','"+A.getDateExpiration()+"','"+A.getDateAchat()+"',"+A.getPrix()+")";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Abonnement ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Abonnement non ajouté!!!");
                      }
 }
 
    @Override
    public void modifierabonnement(abonnement A ,int idA) {
        try {
            String req = "UPDATE `abonnement` SET `type` = '" + A.getType() + "', `dateExpiration` = '" + A.getDateExpiration() +"',`dateAchat` = '" + A.getDateAchat()+ "',`prix` = '" + A.getPrix()+ "' WHERE `idA` = " + idA;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println(" updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    @Override
    public void supprimerabonnement(int idA) {
        try {
            String req = "DELETE FROM `abonnement` WHERE idA = " + idA;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("abonnement deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public List<abonnement> afficherabonnement() {
       List<abonnement> list = new ArrayList<>();
        try {
            String req = "Select * from abonnement";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             abonnement A = new abonnement();
             A.setIdA(RS.getInt(1));
                A.setType(RS.getString(2));
                A.setDateExpiration(RS.getString(5));
                A.setDateAchat(RS.getString(4));    
                A.setPrix(RS.getInt(3));
             
             list.add(A);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    
    @Override
      public abonnement getUserByID(int idA ) throws SQLException {
       String querry="SELECT *  FROM abonnement WHERE `idA`="+idA;
       Statement stm=conn.createStatement();
       ResultSet RS=stm.executeQuery(querry);
       
      
     abonnement A = new abonnement();

        while (RS.next()) {            
             A.setIdA(RS.getInt(1));
                A.setType(RS.getString(2));
                A.setDateExpiration(RS.getString(5));
                A.setDateAchat(RS.getString(4));    
                A.setPrix(RS.getInt(3));
            
        }
    return A;
    }
      
      
       @Override
    public List<abonnement> trierabonnement() {
       List<abonnement> list = new ArrayList<>();
        try {
            String req = "Select * from abonnement order by Prix ASC";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
              abonnement A = new abonnement();
             A.setIdA(RS.getInt(1));
                A.setType(RS.getString(2));
                A.setDateExpiration(RS.getString(5));
                A.setDateAchat(RS.getString(4));    
                A.setPrix(RS.getInt(3));
             
             list.add(A);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    
   
   @Override
    public List<abonnement> Filter_abonnement(String S, String SS) {
        List<abonnement> list = new ArrayList<>();
        try {
            if (S.equals("idA") ) {
                int temp = Integer.parseInt(SS);
                String req = "SELECT * FROM `abonnement` WHERE " + S + " =" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    abonnement A = new abonnement();
                 A.setIdA(RS.getInt(1));
                A.setType(RS.getString(2));
                A.setDateExpiration(RS.getString(5));
                A.setDateAchat(RS.getString(4));    
                A.setPrix(RS.getInt(3));

                    list.add(A);
                }
            } else {
                String req = "SELECT * FROM `abonnement` WHERE " + S + " =" + "\"" + SS + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                 abonnement A = new abonnement();
                 A.setIdA(RS.getInt(1));
                A.setType(RS.getString(2));
                A.setDateExpiration(RS.getString(5));
                A.setDateAchat(RS.getString(4));    
                A.setPrix(RS.getInt(3));

                    list.add(A);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
  

 
    
}
