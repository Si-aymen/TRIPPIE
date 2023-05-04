/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceLocateurCRUD;
import edu.webuild.model.Etat;
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
public class LocateurCRUD implements InterfaceLocateurCRUD {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    @Override
    public void ajouterLocateur(Locateur l) {
        try {
            String req = "INSERT INTO `locateur`(`id_loc`, `id_role`,`nom_agence`,`gsm`,`email`,`password`) VALUES ('" + l.getId_loc() + "','" + l.getId_role() + "','" + l.getNom_agence() + "','" + l.getTel() + "','" + l.getEmail() + "','" + l.getPassword() + "')";
            ste = conn.createStatement();
            ste.executeUpdate(req);

            System.out.println("Locateur ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Locateur non ajouté");
            System.out.println(ex);
        }
    }

    @Override
    public void modifierLocateur(Locateur loc) {
        try {
            String req = "UPDATE `locateur` SET `nom_agence` = '" + loc.getNom_agence() + "',`email` = '" + loc.getEmail() + "',`password` = '" + loc.getPassword() + "' WHERE `locateur`.`id_loc` = " + loc.getId_loc();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Locateur updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
     public void changePassword(String mdp, String email) throws SQLException {
        String req = "UPDATE locateur SET password = ?  WHERE email = ?";
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
     
     public List<Locateur> getLocateurByEmail(String email) throws SQLException {
        String query = "SELECT * FROM locateur WHERE email = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, email);
        ResultSet rs = preparedStatement.executeQuery();
        List<Locateur> clients = new ArrayList<>();
        while (rs.next()) {
            Locateur client = new Locateur();
            Role role = new Role();
            client.setId_role(role);
            client.setId_loc(rs.getInt("id_loc"));
            client.setEmail(rs.getString("email"));
            client.setPassword(rs.getString("Password"));
            clients.add(client);
        }
        return clients;
    }

    @Override
    public void supprimerLocateur(int id_loc) {
        try {
            String req = "DELETE FROM `locateur` WHERE id_loc = " + id_loc;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Role deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Locateur> afficherLocateur() {
        List<Locateur> list = new ArrayList<>();

        try {
            String req = "SELECT locateur.*, role.libelle FROM locateur INNER JOIN role ON locateur.id_role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Locateur ch = new Locateur();
                ch.setId_loc(RS.getInt(1));
                Role role = new Role();
                ch.setId_role(role);
                role.setLibelle(RS.getString(2));
                ch.setNom_agence(RS.getString(3));
                ch.setEmail(RS.getString(4));
                ch.setPassword(RS.getString(5));

                list.add(ch);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Locateur> getById(int id_loc) {
        List<Locateur> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `locateur` WHERE id_loc = " + id_loc;//"SELECT locateur. *, role.libelle FROM locateur INNER JOIN role ON locateur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Locateur loc = new Locateur();
                loc.setId_loc(RS.getInt(1));
                loc.setNom_agence(RS.getString(2));
                loc.setEmail(RS.getString(3));
                loc.setPassword(RS.getString(4));

                list.add(loc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return list;
    }

    @Override
    public List<Locateur> FiltrerLocateur(String f1, String f2) {
        List<Locateur> list = new ArrayList<>();
        try {
            if (f1.equals("id")) {
                int temp = Integer.parseInt(f2);
                String req = "SELECT * FROM `locateur` WHERE " + f1 + "=" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    Locateur loc = new Locateur();
                    loc.setId_loc(RS.getInt(1));
                    loc.setNom_agence(RS.getString(2));
                    loc.setEmail(RS.getString(3));
                    loc.setPassword(RS.getString(4));

                    list.add(loc);
                }
            } else {
                String req = "SELECT * FROM `locateur` WHERE " + f1 + " =" + "\"" + f2 + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);

                while (RS.next()) {
                    Locateur u = new Locateur();
                    Locateur loc = new Locateur();
                    loc.setId_loc(RS.getInt(1));
                    loc.setNom_agence(RS.getString(2));
                    loc.setEmail(RS.getString(3));
                    loc.setPassword(RS.getString(4));

                    list.add(loc);

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return list;
    }

    @Override
    public List<Locateur> trierLocateur() {
        List<Locateur> list = new ArrayList<>();
        try {
            String req = "Select * from locateur order by nom  DESC";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Locateur loc = new Locateur();
                loc.setId_loc(RS.getInt(1));
                loc.setNom_agence(RS.getString(2));
                loc.setEmail(RS.getString(3));
                loc.setPassword(RS.getString(4));

                list.add(loc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public boolean FoundLocateur(String email, String password) throws SQLException {
        String query = "SELECT COUNT(*) FROM locateur WHERE email = ? AND password = ?";
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

    public boolean FoundAdmin(String email, String password) throws SQLException {
        String query = "SELECT COUNT(*) FROM admin WHERE email = ? AND password = ?";
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

    public Locateur getLocateur(String email) throws SQLException {
        String query = "SELECT * "
                + "FROM utilisateur "
                + "JOIN role ON utilisateur.id_user = role.id_user "
                + "JOIN locateur ON role.id_role = locateur.id_role "
                + "WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    String img = rs.getString("img");
                    String prenom = rs.getString("prenom");
                    String password=rs.getString("password");
                    Etat etat = Etat.valueOf(rs.getString("etat"));
                    int id_role = rs.getInt("id_role");
                    int id_loc = rs.getInt("id_loc");
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

                    // Créer l'objet Locateur
                    Locateur client = new Locateur();
                    client.setImg(img);
                    client.setEmail(email);
                    client.setPassword(password);
                    client.setEtat(etat);
                    client.setId_loc(id_loc);
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
    public List<Locateur> afficherLocateur2() {
        List<Locateur> list = new ArrayList<>();

        try {
            String req = "SELECT locateur.nom_agence,locateur.email, "
                    + " role.libelle AS role_libelle, "
                    + " utilisateur.cin, utilisateur.nom, utilisateur.prenom "
                    + "FROM utilisateur "
                    + "JOIN role ON utilisateur.id_user = role.id_user "
                    + "JOIN locateur ON role.id_role = locateur.id_role ";

            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Locateur loc = new Locateur();
                loc.setNom_agence(RS.getString("nom_agence"));
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

    public void changePassword2(String mdp, int gsm) throws SQLException {
        String req = "UPDATE locateur SET password = ?  WHERE gsm = ?";
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

    public Locateur getLocateurUpdate(String email) throws SQLException {
        String query = "SELECT * "
                + "FROM utilisateur "
                + "JOIN role ON utilisateur.id_user = role.id_user "
                + "JOIN locateur ON role.id_role = locateur.id_role "
                + "WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String cin = rs.getString("cin");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String img = rs.getString("img");
                    String nom_agence = rs.getString("nom_agence");
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
                    Locateur client = new Locateur();
                    client.setNom_agence(nom_agence);
                    client.setEmail(email);
                    client.setId_loc(id_client);
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

    public void UpdateLoc(int gsm, String nom_agence, String email, int id_loc) throws SQLException {
        try {
            String req = "UPDATE locateur SET gsm = ? , nom_agence = ? , email = ? WHERE id_loc = ?";
            PreparedStatement pst = conn.prepareStatement(req);
            pst.setInt(1, gsm);
            pst.setString(2, nom_agence);
            pst.setString(3, email);
            pst.setInt(4, id_loc);
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

    @Override
    public List<Locateur> afficherLocateur3() {
        List<Locateur> list = new ArrayList<>();

        try {
            String req = "SELECT locateur.img , locateur.nom_agence , locateur.gsm , locateur.email , "
                    + " role.libelle AS role_libelle, "
                    + " utilisateur.cin, utilisateur.nom, utilisateur.prenom "
                    + "FROM utilisateur "
                    + "JOIN role ON utilisateur.id_user = role.id_user "
                    + "JOIN locateur ON role.id_role = locateur.id_role ";

            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Locateur loc = new Locateur();

                loc.setImg(RS.getString("img"));
                loc.setNom_agence(RS.getString("nom_agence"));
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

    public Locateur getLocateurCard(String nom_agence) throws SQLException {
        String query = "SELECT * "
                + "FROM utilisateur "
                + "JOIN role ON utilisateur.id_user = role.id_user "
                + "JOIN locateur ON role.id_role = locateur.id_role "
                + "WHERE nom_agence = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nom_agence);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String email = rs.getString("email");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");

                    String img = rs.getString("img");
                    int id_role = rs.getInt("id_role");
                    int id_loc = rs.getInt("id_loc");
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
                    Locateur client = new Locateur();
                    client.setNom_agence(nom_agence);
                    client.setEmail(email);
                    client.setId_loc(id_loc);
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

    public void disableLocateur(String nom_agence) {
        try {
            String query = "UPDATE locateur SET etat = 'disabled' WHERE nom_agence = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, nom_agence);
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Locateur account disabled successfully.");
            } else {
                System.out.println("Error: Locateur account not found.");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
