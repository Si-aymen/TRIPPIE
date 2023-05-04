/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.interfaces.InterfaceChauffeurCRUD;
import edu.webuild.model.Chauffeur;
import edu.webuild.model.Etat;
import edu.webuild.model.Role;
import edu.webuild.model.Utilisateur;
import edu.webuild.utils.MyConnection;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javax.swing.JOptionPane;

/**
 *
 * @author aymen
 */
public class ChauffeurCRUD implements InterfaceChauffeurCRUD {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    @Override
    public void ajouterChauffeur(Chauffeur c) {
        try {
            String req = "INSERT INTO `chauffeur`(`id_role`,`img`,`num_permis`,`gsm`,`email`,`password`)"
                    + " VALUES ('" + c.getId_role() + "','" + c.getImg() + "','" + c.getNum_permis() + "',"
                    + "'" + c.getTel() + "','" + c.getEmail() + "','" + c.getPassword() + "')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Chauffeur ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Chauffeur non ajouté");
        }
    }

    @Override
    public void ajouterChauffeur2(Chauffeur c) {
        try {
            String req = "INSERT INTO `chauffeur`(`img`,`num_permis`,`marque_voiture`,`couleur_voiture`,`immatriculation`,`email`,`password`)"
                    + " VALUES ('" + c.getImg() + "','" + c.getNum_permis() + "',"
                    + "'" + c.getEmail() + "','" + c.getPassword() + "')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Chauffeur ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Chauffeur non ajouté");
        }
    }

    @Override
    public void modifierChauffeur(Chauffeur ch) {
        try {
            String req = "UPDATE `chauffeur` SET `img` = '" + ch.getImg() + "',`num_permis` = '" + ch.getNum_permis() + "',"
                    + "`email` = '" + ch.getEmail() + "',`password` = '" + ch.getPassword() + "' WHERE `chauffeur`.`id_ch` = " + ch.getId_ch();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Chauffeur updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
      public List<Chauffeur> getChauffeurByEmail(String email) throws SQLException {
        String query = "SELECT * FROM chauffeur WHERE email = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, email);
        ResultSet rs = preparedStatement.executeQuery();
        List<Chauffeur> clients = new ArrayList<>();
        while (rs.next()) {
            Chauffeur client = new Chauffeur();
            Role role = new Role();
            client.setId_role(role);
            client.setId_ch(rs.getInt("id_ch"));
            client.setEmail(rs.getString("email"));
            client.setPassword(rs.getString("Password"));
            clients.add(client);
        }
        return clients;
    }

//    @Override
//    public void modifierChauffeur2(Chauffeur ch) {
//        try {
//            String req = "UPDATE `chauffeur` SET `marque_voiture` = '" + ch.getMarque_voiture() + "',`couleur_voiture` = '"
//                    + ch.getCouleur_voiture() + "',`immatriculation` = '" + ch.getImmatriculation() + "',`gsm` = '" + ch.getTel() + "',"
//                    + "`email` = '" + ch.getEmail() + "' WHERE `chauffeur`.`id_ch` = " + ch.getId_ch();
//            Statement st = conn.createStatement();
//            st.executeUpdate(req);
//            System.out.println("Chauffeur updated !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
    @Override
    public void supprimerChauffeur(int id_ch) {
        try {
            String req = "DELETE FROM `chauffeur` WHERE id_ch = " + id_ch;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Chauffeur deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Chauffeur> afficherChauffeur() {
        List<Chauffeur> list = new ArrayList<>();

        try {
            String req = "SELECT chauffeur.*, role.libelle FROM chauffeur INNER JOIN role ON chauffeur.id_role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Chauffeur ch = new Chauffeur();
                ch.setId_ch(RS.getInt(1));
                ch.setNum_permis(RS.getString(2));

                ch.setEmail(RS.getString(3));
                ch.setPassword(RS.getString(4));
                Role role = new Role();
                ch.setId_role(role);
                role.setLibelle(RS.getString(5));

                list.add(ch);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Chauffeur> getById(int id_ch) {
        List<Chauffeur> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `chauffeur` WHERE id_ch = " + id_ch;//"SELECT chauffeur. *, role.libelle FROM chauffeur INNER JOIN role ON chauffeur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Chauffeur ch = new Chauffeur();
                ch.setId_ch(RS.getInt(1));
                ch.setNum_permis(RS.getString(2));

                ch.setEmail(RS.getString(3));
                ch.setPassword(RS.getString(4));

                list.add(ch);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return list;
    }

    @Override
    public List<Chauffeur> FiltrerChauffeur(String f1, String f2) {
        List<Chauffeur> list = new ArrayList<>();
        try {
            if (f1.equals("id")) {
                int temp = Integer.parseInt(f2);
                String req = "SELECT * FROM `chauffeur` WHERE " + f1 + "=" + temp;
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    Chauffeur ch = new Chauffeur();
                    ch.setId_ch(RS.getInt(1));
                    ch.setNum_permis(RS.getString(2));

                    ch.setEmail(RS.getString(3));
                    ch.setPassword(RS.getString(4));

                    list.add(ch);
                }
            } else {
                String req = "SELECT * FROM `chauffeur` WHERE " + f1 + " =" + "\"" + f2 + "\"";
                Statement st = conn.createStatement();
                ResultSet RS = st.executeQuery(req);

                while (RS.next()) {
                    Chauffeur ch = new Chauffeur();
                    ch.setId_ch(RS.getInt(1));
                    ch.setNum_permis(RS.getString(2));

                    ch.setEmail(RS.getString(3));
                    ch.setPassword(RS.getString(4));

                    list.add(ch);

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return list;
    }

    @Override
    public List<Chauffeur> trierChauffeur() {
        List<Chauffeur> list = new ArrayList<>();
        try {
            String req = "Select * from chauffeur order by nom  DESC";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Chauffeur ch = new Chauffeur();
                ch.setId_ch(RS.getInt(1));
                ch.setNum_permis(RS.getString(2));

                ch.setEmail(RS.getString(3));
                ch.setPassword(RS.getString(4));

                list.add(ch);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public boolean FoundChauffeur(String email, String password) throws SQLException {
        String query = "SELECT COUNT(*) FROM chauffeur WHERE email = ? AND password = ?";
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

    public void resetPass(Chauffeur ch) {

        try {
            String req = "UPDATE `chauffeur` SET `password`=? WHERE email=? ";
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Chauffeur updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public Image afficher(String identifiant) {
        try (PreparedStatement ps = this.conn.prepareStatement("SELECT img "
                + "FROM utilisateur "
                + "JOIN role ON utilisateur.id_user = role.id_user "
                + "JOIN chauffeur ON role.id_role = chauffeur.id_role "
                + "WHERE email=? ")) {
            ps.setString(1, identifiant);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    byte[] data = rs.getBytes("img");
                    String cheminImage = "C:\\xampp\\htdocs\\" + identifiant;
                    try (FileOutputStream fos = new FileOutputStream(cheminImage)) {
                        fos.write(data);
                    }
                    return new Image("file:" + cheminImage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de l'affichage de l'image");
        }
        return null;
    }

    public Chauffeur getChauffeur(String email) throws SQLException {
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
                    String password=rs.getString("password");
                    Etat etat = Etat.valueOf(rs.getString("etat"));
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
                    Chauffeur client = new Chauffeur();

                    client.setEmail(email);
                    client.setImg(img);
                    client.setId_ch(id_client);
                    client.setPassword(password);
                    client.setId_role(role);
                    client.setEtat(etat);

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

    public Chauffeur getChauffeurCard(String num_permis) throws SQLException {
        String query = "SELECT * "
                + "FROM utilisateur "
                + "JOIN role ON utilisateur.id_user = role.id_user "
                + "JOIN chauffeur ON role.id_role = chauffeur.id_role "
                + "WHERE num_permis = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, num_permis);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String email = rs.getString("email");
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
                    Chauffeur client = new Chauffeur();
                    client.setNum_permis(num_permis);
                    client.setEmail(email);
                    client.setId_ch(id_client);
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
    
    
    
     public void changePassword(String mdp, String email) throws SQLException {
        String req = "UPDATE chauffeur SET password = ?  WHERE email = ?";
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

    public Chauffeur getChauffeurUpdate(String email) throws SQLException {
        String query = "SELECT * "
                + "FROM utilisateur "
                + "JOIN role ON utilisateur.id_user = role.id_user "
                + "JOIN chauffeur ON role.id_role = chauffeur.id_role "
                + "WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String cin = rs.getString("cin");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String img = rs.getString("img");
                    String num_permis = rs.getString("num_permis");
                    int id_role = rs.getInt("id_role");
                    int id_client = rs.getInt("id_ch");
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
                    Chauffeur client = new Chauffeur();
                    client.setNum_permis(num_permis);
                    client.setEmail(email);
                    client.setId_ch(id_client);
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

    public void changePassword2(String mdp, int gsm) throws SQLException {
        String req = "UPDATE chauffeur SET password = ?  WHERE gsm = ?";
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

    public void Update(int tel, String numPermis, String email, String cin, String nom, String prenom, int id_ch, int id_user) {
        try {
            String req = "UPDATE chauffeur "
                    + "SET  gsm = ?, num_permis = ?, email = ? "
                    + "WHERE id_ch = ?";

            PreparedStatement ps = conn.prepareStatement(req);

            ps.setInt(1, tel);
            ps.setString(2, numPermis);
            ps.setString(3, email);
            ps.setInt(4, id_ch);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated == 0) {
                throw new SQLException("La mise à jour du chauffeur a échoué, aucun enregistrement modifié.");
            }

            String req2 = "UPDATE utilisateur "
                    + "SET cin = ?, nom = ?, prenom = ? "
                    + "WHERE id_user = ? ";

            PreparedStatement ps2 = conn.prepareStatement(req2);
            ps2.setString(1, cin);
            ps2.setString(2, nom);
            ps2.setString(3, prenom);
            ps2.setInt(4, id_user);

            int rowsUpdated2 = ps2.executeUpdate();

            if (rowsUpdated2 == 0) {
                throw new SQLException("La mise à jour de l'utilisateur a échoué, aucun enregistrement modifié.");
            }

        } catch (SQLException ex) {
            System.out.println("Une erreur s'est produite lors de la mise à jour du chauffeur : " + ex.getMessage());
        }
    }

    public void UpdateJOIN(int tel, String numPermis, String email, String cin, String nom, String prenom, int id_ch) {
        try {
            String req = "UPDATE chauffeur "
                    + "INNER JOIN role ON chauffeur.id_role = role.id_role "
                    + "INNER JOIN utilisateur ON role.id_user = utilisateur.id_user "
                    + "SET chauffeur.gsm = ?, chauffeur.num_permis = ?, chauffeur.email = ?, "
                    + "utilisateur.cin = ?, utilisateur.nom = ?, utilisateur.prenom = ? "
                    + "WHERE chauffeur.id_ch = ? ";

            PreparedStatement ps = conn.prepareStatement(req);

            ps.setInt(1, tel);
            ps.setString(2, numPermis);
            ps.setString(3, email);
            ps.setString(4, cin);
            ps.setString(5, nom);
            ps.setString(6, prenom);
            ps.setInt(7, id_ch);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated == 0) {
                throw new SQLException("La mise à jour du chauffeur a échoué, aucun enregistrement modifié.");
            }

        } catch (SQLException ex) {
            System.out.println("Une erreur s'est produite lors de la mise à jour du chauffeur : " + ex.getMessage());
        }
    }

    public void UpdateCh(int gsm, String num_permis, String email, int id_ch) throws SQLException {
        try {
            String req = "UPDATE chauffeur SET gsm = ? , num_permis = ? , email = ? WHERE id_ch = ?";
            PreparedStatement pst = conn.prepareStatement(req);
            pst.setInt(1, gsm);
            pst.setString(2, num_permis);
            pst.setString(3, email);
            pst.setInt(4, id_ch);
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

    public void disableChauffeur(String num_permis) {
        try {
            String query = "UPDATE chauffeur SET etat = 'disabled' WHERE num_permis = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, num_permis);
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Chauffeur account disabled successfully.");
            } else {
                System.out.println("Error: Chauffeur account not found.");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<Chauffeur> afficherChauffeur2() {
        List<Chauffeur> list = new ArrayList<>();

        try {
            String req = "SELECT chauffeur.img,chauffeur.num_permis, "
                    + " chauffeur.email, chauffeur.password, role.libelle AS role_libelle,"
                    + " utilisateur.cin, utilisateur.nom, utilisateur.prenom "
                    + "FROM utilisateur "
                    + "JOIN role ON utilisateur.id_user = role.id_user "
                    + "JOIN chauffeur ON role.id_role = chauffeur.id_role ";

            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Chauffeur ch = new Chauffeur();
                ch.setImg(RS.getString("img"));
                ch.setNum_permis(RS.getString("num_permis"));

                ch.setEmail(RS.getString("email"));

                Role role = new Role();
                ch.setId_role(role);
                role.setLibelle(RS.getString("role_libelle"));

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setCin(RS.getString("cin"));
                utilisateur.setNom(RS.getString("nom"));
                utilisateur.setPrenom(RS.getString("prenom"));
               

                role.setId_user(utilisateur);
                ch.setId_role(role);

                list.add(ch);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public Chauffeur getChauffeur2(String email) throws SQLException {
        String query = "SELECT * FROM utilisateur WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Chauffeur ch = new Chauffeur();
                    ch.setId_ch(rs.getInt(1));
                    ch.setNum_permis(rs.getString(2));

                    ch.setEmail(rs.getString(3));
                    ch.setPassword(rs.getString(4));
                    int id_role = rs.getInt("id_role");
                    Role r = new Role();
                    r.setId_role(id_role);
                    ch.setId_role(r);

                    return ch;

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
    public int getById2(int id_ch) {

        try {
            String req = "SELECT * FROM `chauffeur` WHERE id_ch = " + id_ch;//"SELECT chauffeur. *, role.libelle FROM chauffeur INNER JOIN role ON chauffeur.role = role.id_role";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Chauffeur ch = new Chauffeur();
                ch.setId_ch(RS.getInt(1));
                ch.setNum_permis(RS.getString(2));

                ch.setEmail(RS.getString(3));
                ch.setPassword(RS.getString(4));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return id_ch;
    }

    @Override
    public List<Chauffeur> afficherChauffeur3() {
        List<Chauffeur> list = new ArrayList<>();

        try {
            String req = "SELECT chauffeur.img,chauffeur.gsm,chauffeur.num_permis,chauffeur.email, "
                    + " role.libelle AS role_libelle, "
                    + " utilisateur.cin, utilisateur.nom, utilisateur.prenom "
                    + "FROM utilisateur "
                    + "JOIN role ON utilisateur.id_user = role.id_user "
                    + "JOIN chauffeur ON role.id_role = chauffeur.id_role ";

            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Chauffeur loc = new Chauffeur();

                loc.setImg(RS.getString("img"));

                loc.setTel(RS.getInt("gsm"));
                loc.setNum_permis(RS.getString("num_permis"));
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

}
