/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;
import edu.webuild.interfaces.InterfaceCRUD;
import edu.webuild.model.Abonnement;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mtirn
 */
public class AbonnementCRUD implements InterfaceCRUD{
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    @Override
    public void ajouterAbonnement(Abonnement A) {
        try {
            String req = "INSERT INTO `Abonnement`( `type`,`prix`, `dateAchat`, `dateExpiration`) VALUES ('"+A.getType()+"','"+A.getPrix()+"','"+A.getDateAchat()+"','"+A.getDateExpiration()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Abonnement ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Abonnement non ajouté");
                      }
 }
 
    @Override
    public void modifierAbonnement(Abonnement A) {
        try {
            String req = "UPDATE `Abonnement` SET `type` = '"+A.getType()+"','"+A.getPrix()+"','"+A.getDateAchat()+"','"+A.getDateExpiration()+"' WHERE `Abonnement`.`id` = " + A.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Abonnement updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
  @Override
    public void supprimerAbonnement(int id) {
        try {
            String req = "DELETE FROM `Abonnement` WHERE id = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Abonnement deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void ajouterAbonnement2(Abonnement A) {
 try {
            String req = "INSERT INTO `Abonnement` (`type`, `prix`,`dateAchat`,`dateExpiration`) VALUES (?,?)";
            PreparedStatement ps=conn.prepareStatement(req);
          
            ps.setString(1, A.getType());
            ps.setString(2, A.getPrix());
            ps.setString(3, A.getDateAchat());
            ps.setString(4, A.getDateExpiration());
             ps.executeUpdate();
            System.out.println("Abonnement ajouté!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();                    
        }   
    }

    @Override
    public List<Abonnement> afficherAbonnement() {
       List<Abonnement> list = new ArrayList<>();
        try {
            String req = "Select * from Abonnement";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Abonnement A = new Abonnement();
             A.setType(RS.getString("type"));
             A.setPrix(RS.getString("prix"));
             A.setDateAchat(RS.getString("dateAchat"));
             A.setDateExpiration(RS.getString("dateExpiration"));
             A.setId(RS.getInt(1));
             list.add(A);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    
}