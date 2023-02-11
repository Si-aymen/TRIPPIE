/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceCRUD;
import edu.webuild.model.Personne;
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
 * @author belkn
 */
public class PersonneCRUD implements InterfaceCRUD{
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    @Override
    public void ajouterPersonne(Personne p) {
        try {
            String req = "INSERT INTO `personne`(`nom`,`prenom`) VALUES ('"+p.getNom()+"','"+p.getPrenom()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Personne ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Personne non ajouté");
                      }
 }
 
    @Override
    public void modifierpersonne(Personne p) {
        try {
            String req = "UPDATE `personne` SET `nom` = '" + p.getNom() + "', `prenom` = '" + p.getPrenom() + "' WHERE `personne`.`id` = " + p.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Personne updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
  @Override
    public void supprimerpersonne(int id) {
        try {
            String req = "DELETE FROM `personne` WHERE id = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Personne deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void ajouterPersonne2(Personne p) {
 try {
            String req = "INSERT INTO `personne` (`nom`, `prenom`) VALUES (?,?)";
            PreparedStatement ps=conn.prepareStatement(req);
          
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
             ps.executeUpdate();
            System.out.println("Personne ajouté!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();                    
        }   
    }

    @Override
    public List<Personne> afficherPersonne() {
       List<Personne> list = new ArrayList<>();
        try {
            String req = "Select * from personne";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Personne p = new Personne();
             p.setNom(RS.getString("nom"));
             p.setId(RS.getInt(1));
             p.setPrenom(RS.getString(3));
             list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
}
