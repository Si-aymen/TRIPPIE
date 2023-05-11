/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.model.reclamation;
import edu.webuild.model.reponse;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.webuild.interfaces.InterfaceCRUDrec;

/**
 *
 * @author guerf
 */
public class reponseCRUD implements InterfaceCRUDrec {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    @Override
    public void ajouterReponse(reponse r) {
        try {
            String req = "INSERT INTO `reponse`(`reponse`,`id_rec_id_id_id`,`etat`) VALUES ('" + r.getReponse() + "','" + r.getId_rec() + "','" + r.getEtat() + "')";
            String req2 = "UPDATE `reclamation` SET `etat` = 'en cours de traitement'  WHERE `reclamation`.`id_rec_id_id_id` = " + r.getId_rec();
            ste = conn.createStatement();
            ste.executeUpdate(req);
            ste.executeUpdate(req2);
            System.out.println("Reponse ajouté!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifierReponse(reponse r, int id) {
        try {
            String req = "UPDATE `reponse` SET `reponse` = '" + r.getReponse() + "', `etat` = '" + r.getEtat() + "'  WHERE `reponse`.`id` = " + id;
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
            String req = "DELETE FROM `reponse` WHERE id = " + id;
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

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                reponse r = new reponse();
                r.setId_rep(RS.getInt(1));
                r.setReponse(RS.getString(2));
                r.setId_rec(RS.getInt(3));
                r.setEtat(RS.getString(4));

                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<reponse> getById_rep(int id) {
        List<reponse> list = new ArrayList<>();
        try {
            String req = "Select * from reponse  WHERE `id` = " + id;
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                reponse r = new reponse();
                r.setId_rep(RS.getInt(1));
                r.setReponse(RS.getString(2));
                r.setId_rec(RS.getInt(3));
                r.setEtat(RS.getString(4));

                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public reponse detailsReponse(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterReclamation(reclamation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierReclamation(reclamation r, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerReclamation(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<reclamation> afficherReclamation(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reclamation detailsReclamation(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void traite(reclamation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reclamation getById_rec(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countRec(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<reclamation> rechReclamation(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<reclamation> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
