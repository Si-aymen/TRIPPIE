/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceReponse;
import edu.webuild.model.reclamation;
import edu.webuild.model.reponse;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guerf
 */
public class reponseCRUD implements InterfaceReponse{
    
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    @Override
    public void ajouterReponse(reponse r) {
        try {
            String req = "INSERT INTO `reponse`(`reponse`) VALUES ('"+r.getReponse()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Reponse ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Reponse non ajouté");
                      }
    }

    @Override
    public void modifierReponse(reponse r, int id) {
        try {
            String req = "UPDATE `reponse` SET `reponse` = '" +r.getReponse()+ "'  WHERE `reponse`.`id_rep` = " +id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Reponse updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerReponse(int id) {
        try {
            String req = "DELETE FROM `reponse` WHERE id_rep = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Reponse deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<reponse> afficherReponse() {
        List<reponse> list = new ArrayList<>();
        try {
            String req = "Select * from reponse";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             reponse r = new reponse();
             r.setId_rep(RS.getInt(1));
             r.setReponse(RS.getString(2));
             
             list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
}
