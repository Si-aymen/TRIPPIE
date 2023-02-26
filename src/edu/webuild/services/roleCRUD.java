/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceRoleCRUD;
import edu.webuild.model.Chauffeur;
import edu.webuild.model.Client;
import edu.webuild.model.Locateur;
import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aymen
 */
public class roleCRUD implements InterfaceRoleCRUD {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    @Override
    public void ajouterRole(Role r) {
        try {
            String req = "INSERT INTO `role`(`libelle`,id_user) VALUES ('" + r.getLibelle() + "','" + r.getId_user() + "')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            ste.executeUpdate(req, Statement.RETURN_GENERATED_KEYS);

            // Récupérer l'ID auto-incrémenté généré lors de l'insertion
            ResultSet generatedKeys = ste.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id_role = generatedKeys.getInt(1);
                System.out.println("ID auto-incrémenté généré lors de l'insertion: " + id_role);
            } else {
                throw new SQLException("L'ajout a échoué, aucun ID auto-incrémenté généré.");
            }
            System.out.println("Role ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Role non ajouté");
        }
    }

    @Override
    public void modifierRole(Role r) {
        try {
            String req = "UPDATE `role` SET `libelle` = '" + r.getLibelle() + "' WHERE `role`.`id_role` = " + r.getId_role();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Role updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerRole(int id_role) {
        try {
            String req = "DELETE FROM `role` WHERE id_role = " + id_role;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Role deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Role> afficherRole() {
        List<Role> list = new ArrayList<>();
        try {
            String req = "SELECT libelle FROM role ";//"SELECT role. *, role.libelle FROM role INNER JOIN role ON role.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Role r = new Role();
                // r.setId_role(RS.getInt(1));
                r.setLibelle(RS.getString(1));
                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Role> getById(int id_role) {
        List<Role> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `role` WHERE id_role = " + id_role;//"SELECT role. *, role.libelle FROM role INNER JOIN role ON role.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Role r = new Role();
                r.setId_role(RS.getInt(1));
                r.setLibelle(RS.getString(2));
                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    

    @Override
    public List<Role> FiltrerRole(String f1, String f2) {
        List<Role> list = new ArrayList<>();
        try {
            if (f1.equals("id")) {
                int temp = Integer.parseInt(f2);
                String req = "SELECT * FROM `role` WHERE " + f1 + "=" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    Role r = new Role();
                    r.setId_role(RS.getInt(1));
                    r.setLibelle(RS.getString(2));

                    list.add(r);
                }
            } else {
                String req = "SELECT * FROM `role` WHERE " + f1 + " =" + "\"" + f2 + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);

                while (RS.next()) {
                    Role r = new Role();
                    r.setId_role(RS.getInt(1));

                    r.setLibelle(RS.getString(2));

                    list.add(r);

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return list;
    }

    @Override
    public List<Role> trierRole() {
        List<Role> list = new ArrayList<>();
        try {
            String req = "Select * from role order by nom  DESC";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Role r = new Role();
                r.setId_role(RS.getInt(1));

                r.setLibelle(RS.getString(2));

                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public void affecterRole(Chauffeur ch, Role r) {
        try {

            String req = "INSERT INTO `chauffeur`  (`num_permis`,marque_voiture,couleur_voiture,immatriculation,email,password,id_role) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ch.getNum_permis());
            ps.setString(2, ch.getMarque_voiture());
            ps.setString(3, ch.getCouleur_voiture());
            ps.setString(4, ch.getImmatriculation());
            ps.setString(5, ch.getEmail());
            ps.setString(6, ch.getPassword());
            ps.setInt(7, r.getId_role());

            ps.executeUpdate();

            System.out.println("Chauffeur ajouté!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void affecterRole2(Client cli, Role r) {
        try {

            String req = "INSERT INTO `client`  (`email`,password,id_role) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, cli.getEmail());
            ps.setString(2, cli.getPassword());
            ps.setInt(3, r.getId_role());

            ps.executeUpdate();

            System.out.println("Client ajouté!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void affecterRole3(Locateur loc, Role r) {
        try {

            String req = "INSERT INTO `locateur`  (nom_agence,email,password,id_role) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, loc.getNom_agence());
            ps.setString(2, loc.getEmail());
            ps.setString(3, loc.getPassword());
            ps.setInt(4, r.getId_role());

            ps.executeUpdate();

            System.out.println("Locateur ajouté!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    public Role getById_role(int id_role) {
    String query = "SELECT * FROM role WHERE id_role = ?";

    try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
        preparedStatement.setInt(1, id_role);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int id_Role = resultSet.getInt("id_role");
            int id_User = resultSet.getInt("id_user");
            String libelle = resultSet.getString("libelle");

            return new Role(id_Role, id_User, libelle);
        }

    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }

    return null;
}

}
