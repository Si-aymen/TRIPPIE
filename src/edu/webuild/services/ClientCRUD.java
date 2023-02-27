/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceClientCRUD;
import edu.webuild.model.Client;
import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import java.sql.Connection;
import java.sql.Statement;
import edu.webuild.utils.MyConnection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static javax.mail.Flags.Flag.USER;

/**
 *
 * @author aymen
 */
public class ClientCRUD implements InterfaceClientCRUD {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    @Override
    public void ajouterClient(Client cl) {
        try {
            String req = "INSERT INTO `client`(`id_client` ,`id_role`,`email`,`password`) VALUES ('" + cl.getId_client() + "','" + cl.getId_role() + "','" + cl.getEmail() + "','" + cl.getPassword() + "')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Client ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Client non ajouté");
            System.out.println(ex);
        }
    }

    @Override
    public void modifierClient(Client cl) {
        try {
            String req = "UPDATE `client` SET `email` = '" + cl.getEmail() + "', `password` = '" + cl.getPassword() + "' WHERE `client`.`id_client` = " + cl.getId_client();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Client updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void supprimerClient(int id_client) {
        try {
            String req = "DELETE FROM `client` WHERE id_client = " + id_client;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Client deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Client> afficherClient() {
        List<Client> list = new ArrayList<>();
        try {
            String req = "SELECT client.*, role.libelle FROM client INNER JOIN role ON client.id_role = role.id_role";//"SELECT client. *, role.libelle FROM client INNER JOIN role ON client.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Client cl = new Client();
                cl.setId_client(RS.getInt(1));
                Role role = new Role();
                cl.setId_role(role);
                role.setLibelle(RS.getString(2));
                cl.setEmail(RS.getString(3));
                cl.setPassword(RS.getString(4));

                list.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Role getRole(int id_role) {
        Role r = new Role();

        try {
            String req = "SELECT libelle FROM `role` WHERE id_role = '" + id_role + "'";//"SELECT utilisateur. *, role.libelle FROM utilisateur INNER JOIN role ON utilisateur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {

                r.setLibelle(RS.getString(1));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return r;
    }

    @Override
    public List<Client> getById(int id_client) {
        List<Client> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `client` WHERE id_client = " + id_client;//"SELECT client. *, role.libelle FROM client INNER JOIN role ON client.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Client cl = new Client();
                cl.setId_client(RS.getInt(1));
                cl.setEmail(RS.getString(2));
                cl.setPassword(RS.getString(3));

                list.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return list;
    }

    @Override
    public List<Client> FiltrerClient(String f1, String f2) {
        List<Client> list = new ArrayList<>();
        try {
            if (f1.equals("id")) {
                int temp = Integer.parseInt(f2);
                String req = "SELECT * FROM `client` WHERE " + f1 + "=" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    Client cl = new Client();
                    cl.setId_client(RS.getInt(1));
                    cl.setEmail(RS.getString(2));
                    cl.setPassword(RS.getString(3));

                    list.add(cl);
                }
            } else {
                String req = "SELECT * FROM `client` WHERE " + f1 + " =" + "\"" + f2 + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);

                while (RS.next()) {
                    Client cl = new Client();
                    cl.setId_client(RS.getInt(1));
                    cl.setEmail(RS.getString(2));
                    cl.setPassword(RS.getString(3));

                    list.add(cl);

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return list;
    }

    @Override
    public List<Client> trierClient() {
        List<Client> list = new ArrayList<>();
        try {
            String req = "Select * from client order by nom  DESC";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Client cl = new Client();
                cl.setId_client(RS.getInt(1));
                cl.setEmail(RS.getString(3));
                cl.setPassword(RS.getString(4));

                list.add(cl);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public boolean FoundUser(String email, String password) throws SQLException {
        String query = "SELECT COUNT(*) FROM client WHERE email = ? AND password = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);

        pstmt.setString(1, email);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }

        return false;
    }

    public Client getByIdRole(int id_role) {
        String query = "SELECT * FROM client WHERE id_role = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, id_role);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idClient = resultSet.getInt("id_client");
                int idRoleClient = resultSet.getInt("id_role");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                roleCRUD roleCRUD = new roleCRUD();
                Role role = (Role) roleCRUD.getById(idRoleClient);

                return new Client(idClient, role, email, password);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

    @Override
    public String afficherProfilClient(String email, String password) {
        String query = "SELECT utilisateur.nom, utilisateur.prenom "
                + "FROM utilisateur "
                + "INNER JOIN client ON utilisateur.id_user = client.id_user "
                + "WHERE client.email = ? AND client.password = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                return nom + " " + prenom;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Utilisateur getClient(String email, String password) throws SQLException {
        String query = "SELECT utilisateur.nom, utilisateur.prenom "
                + "FROM utilisateur "
                + "JOIN role ON utilisateur.id_user = role.id_user "
                + "JOIN client ON role.id_role = client.id_role "
                + "WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                return new Utilisateur(nom, prenom);
            } else {
                return null;
            }

        }
}
