/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceLocateurCRUD;
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
                    String prenom = rs.getString("prenom");
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
    
    @Override
    public List<Locateur> afficherLocateur2() {
        List<Locateur> list = new ArrayList<>();

        try {
            String req = "SELECT locateur.nom_agence,locateur.email, "
                    + " role.libelle AS role_libelle, "
                    + " utilisateur.cin, utilisateur.nom, utilisateur.prenom,utilisateur.sexe "
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
                utilisateur.setSexe(RS.getString("sexe"));
               
                role.setId_user(utilisateur);
                loc.setId_role(role);

                list.add(loc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

}
