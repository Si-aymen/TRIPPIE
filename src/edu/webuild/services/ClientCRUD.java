/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceClientCRUD;
import edu.webuild.model.Client;
import edu.webuild.model.Etat;
import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import java.sql.Connection;
import java.sql.Statement;
import edu.webuild.utils.MyConnection;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static java.lang.Math.log;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static javax.mail.Flags.Flag.USER;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 *
 * @author aymen
 */
public class ClientCRUD implements InterfaceClientCRUD {

    Statement ste;
    PreparedStatement stee;
    Connection conn = MyConnection.getInstance().getConn();

    @Override
    public void ajouterClient(Client cl) {
        try {
            String req = "INSERT INTO `client`(`id_client` ,`id_role`,`img`,`gsm`,`email`,`password`) VALUES ('" + cl.getId_client() + "','" + cl.getId_role() + "','" + cl.getImg()+ "',"
                    + "'" + cl.getTel()+ "','" + cl.getEmail()+ "','" + cl.getPassword() + "')";
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
    public void modifierProfil(Client cl) {
        try {
            String req = "UPDATE `client` SET `gsm` = '" + cl.getTel() + "'`email` = '" + cl.getEmail() + "', `password` = '" + cl.getPassword() + "' WHERE `client`.`id_client` = " + cl.getId_client();
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
    public void disable(int id_client) {
        try {
            String req = "UPDATE client SET etat = false WHERE id_client = ?";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setInt(1, id_client);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la désactivation du compte du client : " + e.getMessage());
        }
    }
    
    

     public Client getClientCard(String email) throws SQLException {
        String query = "SELECT * "
                + "FROM utilisateur "
                + "JOIN role ON utilisateur.id_user = role.id_user "
                + "JOIN chauffeur ON role.id_role = chauffeur.id_role "
                + "WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String img = rs.getString("img");
                
                    int id_role = rs.getInt("id_role");
                    int id_client = rs.getInt("id_ch");
                    int id_user = rs.getInt("id_user");

                    // Créer l'objet User
                    Utilisateur user = new Utilisateur();
                    user.setId_user(id_user);
                    user.setNom(nom);
                    user.setPrenom(prenom);

                    // Créer l'objet Role
                    Role role = new Role();
                    role.setId_role(id_role);
                    role.setId_user(user);

                    // Créer l'objet Chauffeur
                    Client client = new Client();
                    client.setImg(img);
                    client.setEmail(email);
                    client.setId_client(id_client);
                    client.setId_role(role);

                    return client;

                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isEnabled(int clientId) {
        boolean result = false;
        try {
            String sql = "SELECT etat FROM client WHERE id_client = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clientId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getBoolean("enabled");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'état du compte du client : " + e.getMessage());
        }
        return result;
    }

//    @Override
//    public List<Client> afficherClient() {
//        List<Client> list = new ArrayList<>();
//        try {
//            String req = "SELECT client.*, role.libelle FROM client INNER JOIN role ON client.id_role = role.id_role";//"SELECT client. *, role.libelle FROM client INNER JOIN role ON client.role = role.id_role";
//            Statement st = conn.createStatement();
//            ResultSet RS = st.executeQuery(req);
//            while (RS.next()) {
//                Client cl = new Client();
//                cl.setId_client(RS.getInt(1));
//                Role role = new Role();
//                cl.setId_role(role);
//                role.setLibelle(RS.getString(2));
//                cl.setEmail(RS.getString(3));
//                cl.setPassword(RS.getString(4));
//
//                list.add(cl);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return list;
//    }
    @Override
    public List<Client> afficherClient() {
        List<Client> list = new ArrayList<>();
        try {
            String req = "SELECT * "
                    + "FROM client "
                    + "INNER JOIN client ON utilisateur.id_user = client.id_user "
                    + "WHERE client.email = ? ";//"SELECT client. *, role.libelle FROM client INNER JOIN role ON client.role = role.id_role";
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
    public List<Client> affiche() {
        List<Client> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `client` ";//"SELECT client. *, role.libelle FROM client INNER JOIN role ON client.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Client cl = new Client();
                cl.setId_client(RS.getInt(1));
                cl.setTel(RS.getInt(2));
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

    public boolean FoundClient(String email, String password) throws SQLException {
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

    public void changePassword(String mdp, String email) throws SQLException {
        String req = "UPDATE client SET password = ?  WHERE email = ?";
        PreparedStatement pst = conn.prepareStatement(req);
        pst.setString(1, mdp);
        pst.setString(2, email);
        int rowUpdated = pst.executeUpdate();
        if (rowUpdated > 0) {
            System.out.println("Mdp modifié");
        } else {
            System.out.println("ERR");
        }
    }
    
     public void changePassword2(String mdp, int gsm) throws SQLException {
        String req = "UPDATE client SET password = ?  WHERE gsm = ?";
        PreparedStatement pst = conn.prepareStatement(req);
        pst.setString(1, mdp);
        pst.setInt(2, gsm);
        int rowUpdated = pst.executeUpdate();
        if (rowUpdated > 0) {
            System.out.println("Mdp modifié");
        } else {
            System.out.println("ERR");
        }
    }
     
     
     public Client getClientUpdate(String email) throws SQLException {
        String query = "SELECT * "
                + "FROM utilisateur "
                + "JOIN role ON utilisateur.id_user = role.id_user "
                + "JOIN client ON role.id_role = client.id_role "
                + "WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String cin = rs.getString("cin");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String img = rs.getString("img");
                    int id_role = rs.getInt("id_role");
                    int id_client = rs.getInt("id_client");
                    int id_user = rs.getInt("id_user");

                    // Créer l'objet User
                    Utilisateur user = new Utilisateur();
                    user.setId_user(id_user);
                    user.setCin(cin);
                    user.setNom(nom);
                    user.setPrenom(prenom);

                    // Créer l'objet Role
                    Role role = new Role();
                    role.setId_role(id_role);
                    role.setId_user(user);

                    // Créer l'objet Chauffeur
                    Client client = new Client();
                 
                    client.setEmail(email);
                    client.setId_client(id_client);
                    client.setId_role(role);

                    return client;

                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

      public void UpdateCli(int gsm, String email, int id_client) throws SQLException {
        try {
            String req = "UPDATE client SET gsm = ? , email = ? WHERE id_client = ?";
            PreparedStatement pst = conn.prepareStatement(req);
            pst.setInt(1, gsm);
            pst.setString(2, email);
            pst.setInt(3, id_client);
            int rowUpdated = pst.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Mdp modifié");
            } else {
                System.out.println("ERR");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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

               // return new Client(idClient, role, email, password);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

    @Override
    public String afficherProfilClient(String email) {
        String query = "SELECT utilisateur.nom, utilisateur.prenom "
                + "FROM utilisateur "
                + "INNER JOIN client ON utilisateur.id_user = client.id_user "
                + "WHERE client.email = ? ";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);

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

    /*public Client getClient(String email, String password) throws SQLException {
        String query = "SELECT utilisateur.nom, utilisateur.prenom, role.id_role "
                + "FROM utilisateur "
                + "JOIN role ON utilisateur.id_user = role.id_user "
                + "JOIN client ON role.id_role = client.id_role "
                + "JOIN utilisateur ON utilisateur.id_user = client.id_user "
                + "WHERE email = ? AND password = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    int id_role = rs.getInt("id_role");
                    int id_client = rs.getInt("id_client");
                    int id_user = rs.getInt("id_user");
                    //Utilisateur user = new Utilisateur(nom, prenom);
                    // Créer l'objet User
                    Utilisateur user = new Utilisateur();
                    // Créer l'objet Role
                    Role role = new Role(id_role, user);

                    // Créer l'objet Client
                    Client client = new Client();
                    client.setEmail(email);
                    client.setId_client(id_client);
                    user.setId_user(id_user);
                    client.setId_role(role);
                    return client;

                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    public Client getClient(String email) throws SQLException {
        String query = "SELECT * "
                + "FROM utilisateur "
                + "JOIN role ON utilisateur.id_user = role.id_user "
                + "JOIN client ON role.id_role = client.id_role "
                + "WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String img = rs.getString("img");
                    Etat etat = Etat.valueOf(rs.getString("etat"));
                    String password = rs.getString("password");
                    int id_role = rs.getInt("id_role");
                    int id_client = rs.getInt("id_client");
                    int id_user = rs.getInt("id_user");

                    // Créer l'objet User
                    Utilisateur user = new Utilisateur();
                    user.setId_user(id_user);
                    user.setNom(nom);
                    user.setPrenom(prenom);

                    // Créer l'objet Role
                    Role role = new Role();
                    role.setId_role(id_role);
                    role.setId_user(user);

                    // Créer l'objet Client
                    Client client = new Client();
                    client.setEtat(etat);
                    client.setImg(img);
                    client.setEmail(email);
                    client.setPassword(password);
                    client.setId_client(id_client);
                    client.setId_role(role);

                    return client;

                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Client getClientbymail(String email) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM client WHERE email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            int id_client = rs.getInt("id_client");
            int id_role = rs.getInt("id_role");
            String password = rs.getString("password");
            Role role = new Role();
            role.setId_role(id_role);
            Client client = new Client();
            client.setId_client(id_client);
            client.setId_role(role);
            client.setEmail(email);
            client.setPassword(password);

            return client;
        } else {
            return null;
        }
    }

    /*public void afficherProfil(Client client) {
        System.out.println("Nom: " + client.getUtilisateur().getNom());
        System.out.println("Prénom: " + client.getUtilisateur().getPrenom());
        System.out.println("Email: " + client.getEmail());

        // Récupérer le rôle du client
        Role role = client.getId_role();

        System.out.println("Rôle: " + role.getLibelle());

        // Récupérer l'utilisateur associé au rôle
        Utilisateur user = role.getId_user();

        System.out.println("ID Utilisateur: " + user.getId_user());
    }*/
    public List<Client> getClientByEmail(String email) throws SQLException {
        String query = "SELECT * FROM client WHERE email = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, email);
        ResultSet rs = preparedStatement.executeQuery();
        List<Client> clients = new ArrayList<>();
        while (rs.next()) {
            Client client = new Client();
            Role role = new Role();
            client.setId_role(role);
            client.setId_client(rs.getInt("id_client"));
            client.setEmail(rs.getString("email"));
            client.setPassword(rs.getString("Password"));
            clients.add(client);
        }
        return clients;
    }

    @Override
    public List<Client> afficherClient2() {
        List<Client> list = new ArrayList<>();

        try {
            String req = "SELECT client.email, "
                    + " role.libelle AS role_libelle, "
                    + " utilisateur.cin, utilisateur.nom, utilisateur.prenom "
                    + "FROM utilisateur "
                    + "JOIN role ON utilisateur.id_user = role.id_user "
                    + "JOIN client ON role.id_role = client.id_role ";

            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Client loc = new Client();
                loc.setEmail(RS.getString("email"));

                Role role = new Role();
                loc.setId_role(role);
                role.setLibelle(RS.getString("role_libelle"));

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setCin(RS.getString("cin"));
                utilisateur.setNom(RS.getString("nom"));
                utilisateur.setPrenom(RS.getString("prenom"));
           

                role.setId_user(utilisateur);
                loc.setId_role(role);

                list.add(loc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Client> afficherClient3() {
        List<Client> list = new ArrayList<>();

        try {
            String req = "SELECT client.img,client.gsm,client.email, "
                    + " role.libelle AS role_libelle, "
                    + " utilisateur.cin, utilisateur.nom, utilisateur.prenom "
                    + "FROM utilisateur "
                    + "JOIN role ON utilisateur.id_user = role.id_user "
                    + "JOIN client ON role.id_role = client.id_role ";

            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Client loc = new Client();
                loc.setImg(RS.getString("img"));
                loc.setTel(RS.getInt("gsm"));
                loc.setEmail(RS.getString("email"));

                Role role = new Role();
                loc.setId_role(role);
                role.setLibelle(RS.getString("role_libelle"));
//
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setCin(RS.getString("cin"));
                utilisateur.setNom(RS.getString("nom"));
                utilisateur.setPrenom(RS.getString("prenom"));
             

                role.setId_user(utilisateur);
                loc.setId_role(role);

                list.add(loc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public void upDateStatus(int i) {
        String req = "UPDATE `client` SET etat='accepted' where id_client=?";
        try {
            stee = conn.prepareStatement(req);
            stee.setInt(1, i);
            stee.executeUpdate();
            System.out.println("User Approuved");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Image getUserImageFromDatabase(int id_client) throws SQLException, IOException {
    String sql = "SELECT img FROM client WHERE id_client = ?";
 
         PreparedStatement stmt = conn.prepareStatement(sql) ;
        stmt.setInt(1, id_client);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                byte[] imageData = rs.getBytes("img");
                return new Image(new ByteArrayInputStream(imageData));
            }
        }
    
    return null;
}
    
     public void disableClient(String email) {
        try {
            String query = "UPDATE client SET etat = 'disabled' WHERE email = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, email);
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Client account disabled successfully.");
            } else {
                System.out.println("Error: Client account not found.");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
