/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.model.reclamation;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.webuild.interfaces.InterfaceCRUD;
import edu.webuild.model.reponse;

/**
 *
 * @author belkn
 */
public class reclamationCRUD implements InterfaceCRUD {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    @Override
    public void ajouterReclamation(reclamation r) {
        try {
            String req = "INSERT INTO `reclamation`(`type_rec`,`commentaire`,`etat`) VALUES ('" + r.getType_rec() + "','" + r.getCommentaire() + "','non traité')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Reclamation ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Reclamation non ajouté");
        }
    }

    @Override
    public void modifierReclamation(reclamation r, int id) {
        try {
            String req = "UPDATE `reclamation` SET `type_rec` = '" + r.getType_rec() + "', `commentaire` = '" + r.getCommentaire() + "' WHERE `reclamation`.`id_rec` = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Reclamation updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerReclamation(int id) {
        try {
            String req = "DELETE FROM `reclamation` WHERE id_rec = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<reclamation> afficherReclamation() {
        List<reclamation> list = new ArrayList<>();
        try {
            String req = "Select * from reclamation";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                reclamation r = new reclamation(RS.getString(2), RS.getString(3), RS.getString(4));
                r.setId_rec(RS.getInt(1));
                r.setType_rec(RS.getString(2));
                r.setCommentaire(RS.getString(3));
                r.setEtat(RS.getString(4));

                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    @Override
    public List<reclamation> filtrer1(int id) {
        List<reclamation> list = new ArrayList<>();
        try {
            String req = "Select * from reponse  WHERE `id_rec` = " + id;
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                reclamation r = new reclamation();
                r.setId_rec(RS.getInt(1));
                r.setType_rec(RS.getString(2));
                r.setCommentaire(RS.getString(3));
                r.setEtat(RS.getString(4));

                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    @Override
    public void traite(reclamation r) {
        try {
            String req = "UPDATE `reclamation` SET `etat` = 'traité'  WHERE `reclamation`.`id_rec` = " +r.getId_rec();
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Reponse traité!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
                      }
    }

    @Override
    public reclamation detailsReclamation(int id) {

        reclamation r = new reclamation();

        try {
            String req = "Select * from reclamation where id_rec = " + id;
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            r.setId_rec(RS.getInt(1));
            r.setType_rec(RS.getString(2));
            r.setCommentaire(RS.getString(3));
            r.setEtat(RS.getString(4));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return r;
    }

    @Override
    public void ajouterReponse(reponse r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierReponse(reponse r, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerReponse(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<reponse> afficherReponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reponse detailsReponse(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<reponse> filtrer_rep(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


}
