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

            String req = "INSERT INTO `chauffeur` (img,num_permis,gsm,email,password,id_role) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ch.getImg());
             ps.setString(2, ch.getNum_permis());
            ps.setInt(3, ch.getTel());
            ps.setString(4, ch.getEmail());
            ps.setString(5, ch.getPassword());
            ps.setInt(6, r.getId_role());

            ps.executeUpdate();

            System.out.println("Chauffeur ajouté!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void affecterRole2(Client cli, Role r) {
        try {

            String req = "INSERT INTO `client`  (img,gsm,email,password,id_role) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, cli.getImg());
            ps.setInt(2, cli.getTel());
            ps.setString(3, cli.getEmail());
            ps.setString(4, cli.getPassword());
            ps.setInt(5, r.getId_role());

            ps.executeUpdate();

            System.out.println("Client ajouté!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void affecterRole3(Locateur loc, Role r) {
        try {

            String req = "INSERT INTO `locateur`  (img,nom_agence,gsm,email,password,id_role) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
             ps.setString(1, loc.getImg());
            ps.setString(2, loc.getNom_agence());
            ps.setInt(3, loc.getTel());
            ps.setString(4, loc.getEmail());
            ps.setString(5, loc.getPassword());
            ps.setInt(6, r.getId_role());

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

    @Override
    public Role getById_user(int id_user) {
        Role r = new Role();

        try {
            String req = "SELECT * FROM `role` WHERE id_user = '" + id_user + "'";//"SELECT utilisateur. *, role.libelle FROM utilisateur INNER JOIN role ON utilisateur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                r.setId_role(RS.getInt(1));
                r.setLibelle(RS.getString(2));
               Utilisateur u =new Utilisateur(id_user);
                u.setId_user(id_user);
                r.setId_user(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return r;
    }
}
