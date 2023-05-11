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
import edu.webuild.model.reponse;
import java.sql.PreparedStatement;
import edu.webuild.interfaces.InterfaceCRUDrec;
import edu.webuild.model.Chauffeur;
import edu.webuild.model.Client;
import edu.webuild.model.Locateur;
import edu.webuild.model.Role;

/**
 *
 * @author belkn
 */
public class reclamationCRUD implements InterfaceCRUDrec {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    @Override
    public void ajouterReclamation(reclamation reclamation) {
        try {
            String query = "INSERT INTO reclamation (type, commentaire, etat,id_user,date_creation,image) VALUES (?, ?, ?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, reclamation.getType_rec());
            preparedStatement.setString(2, reclamation.getCommentaire());
            preparedStatement.setString(3, "non traité");
            preparedStatement.setInt(4, reclamation.getId_utilisateur());
            preparedStatement.setString(5, reclamation.getDate_creation().toString());
            preparedStatement.setString(6, reclamation.getUrl_image());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /*public void ajouterReclamation(reclamation r) {
        try {
            String req = "INSERT INTO `reclamation`(`type`,`commentaire`,`etat`,`id_user`,`date_creation`) VALUES ('" + r.getType_rec() + "',"
                    + "'" + r.getCommentaire() + "','non traité','" + r.getId_utilisateur() + "','" + r.getDate_creation().toString()+ "')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Reclamation ajouté!!!");²
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }*/
    @Override
    public void modifierReclamation(reclamation r, int id) {
        try {
            String req = "UPDATE `reclamation` SET `type` = '" + r.getType_rec() + "', `commentaire` = '" + r.getCommentaire() + "' WHERE `id` = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Reclamation updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
        public void modifierReclamation2(reclamation r, int id) {
        try {
            String req = "UPDATE `reclamation` SET `etat` = 'traité' WHERE `id` = " + id;
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
            String req = "DELETE FROM `reclamation` WHERE id = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<reclamation> afficherReclamation(int id) {
        List<reclamation> list = new ArrayList<>();
        try {
            String req = "Select * from reclamation WHERE `id_user` = " + id;
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                reclamation r = new reclamation();
                r.setId_rec(RS.getInt(1));
                r.setType_rec(RS.getString(2));
                r.setCommentaire(RS.getString(3));
                r.setEtat(RS.getString(4));
                r.setId_utilisateur(RS.getInt(5));
                r.setDate_creation(RS.getDate(6));
                r.setUrl_image(RS.getString(7));

                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public reclamation getById_rec(int id) {
        reclamation r = new reclamation();
        try {
            String req = "Select * from reclamation  WHERE `id` = " + id;
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);

            while (RS.next()) {
                r.setId_rec(RS.getInt(1));
                r.setType_rec(RS.getString(2));
                r.setCommentaire(RS.getString(3));
                r.setEtat(RS.getString(4));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return r;
    }

    @Override
    public void traite(reclamation r) {
        try {
            String req = "UPDATE `reclamation` SET `etat` = " + "traité" + "  WHERE `reclamation`.`id` = " + r.getId_rec();
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Reclamation traité!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public reclamation detailsReclamation(int id) {

        reclamation r = new reclamation();

        try {
            String req = "Select * from reclamation where id = " + id;
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
    public int countRec(String type) {
        int count = 0;
        try {
            String req = "SELECT COUNT(*) FROM reclamation WHERE type = '" + type + "'";
            PreparedStatement pst = conn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return count;
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
    public List<reponse> getById_rep(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<reclamation> rechReclamation(int id) {
        List<reclamation> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `reclamation` WHERE id= " + id;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                reclamation r = new reclamation();
                r.setId_rec(RS.getInt("id"));
                r.setType_rec(RS.getString("type"));
                r.setCommentaire(RS.getString("commentaire"));
                r.setEtat(RS.getString("etat"));
                r.setId_utilisateur(RS.getInt("id_user"));
                r.setDate_creation(RS.getDate("date_creation"));
                r.setUrl_image(RS.getString("image"));

                list.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return list;
    }

    public Role getRole(int id_role) {
        Role r = new Role();

        try {
            String req = "SELECT * FROM `role` WHERE id_role = '" + id_role + "'";//"SELECT utilisateur. *, role.libelle FROM utilisateur INNER JOIN role ON utilisateur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {

                r.setLibelle(RS.getString("libelle"));
                r.setId_role(RS.getInt("id_role"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return r;
    }

    public Client getByIdClient(int id_client) {
        Client cl = new Client();
        try {
            String req = "SELECT * FROM `client` WHERE id_client = " + id_client;
            //String req = "SELECT client. *, role FROM client INNER JOIN role ON client.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                cl.setId_client(RS.getInt(1));
                int id_role = RS.getInt("id_role");
                reclamationCRUD rc = new reclamationCRUD();
                cl.setId_role(rc.getRole(id_role));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return cl;
    }

    public Chauffeur getByIdChauffeur(int id_ch) {
        Chauffeur ch = new Chauffeur();
        try {
            String req = "SELECT * FROM `chauffeur` WHERE id_ch = " + id_ch;
            //String req = "SELECT client. *, role FROM client INNER JOIN role ON client.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                ch.setId_ch(RS.getInt(1));
                int id_role = RS.getInt("id_role");
                reclamationCRUD rc = new reclamationCRUD();
                ch.setId_role(rc.getRole(id_role));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return ch;
    }

    public Locateur getByIdLoc(int id_loc) {
        Locateur lc = new Locateur();
        try {
            String req = "SELECT * FROM `locateur` WHERE id_loc = " + id_loc;
            //String req = "SELECT client. *, role FROM client INNER JOIN role ON client.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                lc.setId_loc(RS.getInt(1));
                int id_role = RS.getInt("id_role");
                reclamationCRUD rc = new reclamationCRUD();
                lc.setId_role(rc.getRole(id_role));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return lc;
    }

    @Override
    public List<reclamation> afficher() {
        List<reclamation> list = new ArrayList<>();
        try {
            String req = "Select * from reclamation";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                reclamation r = new reclamation();
                r.setId_rec(RS.getInt(1));
                r.setType_rec(RS.getString(2));
                r.setCommentaire(RS.getString(3));
                r.setEtat(RS.getString(4));
                r.setId_utilisateur(RS.getInt(5));
                r.setDate_creation(RS.getDate(6));
                r.setUrl_image(RS.getString(7));

                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

}
