/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import edu.webuild.inter.interfacecoupon;
import edu.webuild.model.coupon;
import edu.webuild.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class couponCrud implements interfacecoupon {

    Connection cnx2 = MyConnection.getInstance().getConn();

    public couponCrud() {
        Connection cnx2 = MyConnection.getInstance().getConn();
    }

    @Override
    public void ajoutercoupon() {

        try {
            String requete = "INSERT INTO coupon (date_debut,date_experatio,taux,code_coupon,nbr_utilisation,type)" + "values ('2023-02-14','2023-03-01','20','Valentin10','10','vip')";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("coupon ajoutee aves success ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void ajouterpersonne2(coupon c) {

        //interdit de faire la meme code_coupon dans l'ajout on a fait dans bd  alter table coupon ADD CONSTRAINT uniq_code_coupon UNIQUE (code_coupon);
        try {

            String requete2 = "INSERT INTO coupon (date_debut,date_experatio,taux,code_coupon,nbr_utilisation,type)" + "values (?,?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date_Debut = dateFormat.format(c.getDate_debut());
            pst.setString(1, date_Debut);

            String date_experatio = dateFormat.format(c.getDate_experation());
            pst.setString(2, date_experatio);

            pst.setInt(3, c.getTaux_reduction());

            pst.setString(4, c.getCode_coupon());

            pst.setInt(5, c.getNbr_utilisation());
            pst.setString(6, c.getType());
            pst.executeUpdate();
            System.out.println("votre coupon est ajouteessss ");
        } catch (SQLException ex) {
            System.err.println("Le code_coupon est déjà utilisé !");
        }

    }

    @Override
    public List<coupon> displayCoupon() {
        List<coupon> couponList = new ArrayList<>();
        try {
            String query = "SELECT * FROM coupon";

            Statement stmt = cnx2.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id =rs.getInt("id");
                Date date_debut = rs.getDate("date_debut");
                Date date_experatio = rs.getDate("date_experatio");
                int taux = rs.getInt("taux");
                String code_coupon = rs.getString("code_coupon");
                int nbr_utilisation = rs.getInt("nbr_utilisation");
                String type = rs.getString("type");
                coupon k = new coupon(id,date_debut, date_experatio, taux, code_coupon, nbr_utilisation, type);
                couponList.add(k);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return couponList;

    }

    public int Supprimer(String codecoupon) {

        try {

            String sql = "DELETE FROM coupon WHERE code_coupon = ?";
            PreparedStatement pstmt = cnx2.prepareStatement(sql);
            pstmt.setString(1, codecoupon);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Le coupon a été supprimé avec succès.");
            } else {
                System.out.println("Aucun coupon n'a été supprimé.");
            }
        } catch (SQLException ex) {
            System.out.println("Une erreur s'est produite lors de la suppression du coupon : " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public void modifier(coupon c) {

        try {

            String requete = "UPDATE coupon SET date_debut=?, date_experatio=?,taux=?,code_coupon=?,nbr_utilisation=?,type=? WHERE id =?";
            PreparedStatement st = cnx2.prepareStatement(requete);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date_Debut = dateFormat.format(c.getDate_debut());
            st.setString(1, date_Debut);

            String date_experatio = dateFormat.format(c.getDate_experation());
            st.setString(2, date_experatio);

            st.setInt(3, c.getTaux_reduction());

            st.setString(4, c.getCode_coupon());

            st.setInt(5, c.getNbr_utilisation());
            st.setString(6, c.getType());
            st.setInt(7, c.getId_coupon());

            st.executeUpdate();
            System.out.println("coupon modifiée avec succès !");
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la modification de la personne: " + ex.getMessage());

        }
    }

    @Override
    public List<coupon> rech(int id1) {
        List<coupon> couponList = new ArrayList<>();
        try {
            String query = "SELECT * FROM coupon WHERE code_coupon= " + id1;
            Statement stmt = cnx2.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                Date date_debut = rs.getDate("date_debut");
                Date date_experatio = rs.getDate("date_experatio");
                int taux = rs.getInt("taux");
                String code_coupon = rs.getString("code_coupon");
                int nbr_utilisation = rs.getInt("nbr_utilisation");
                String type = rs.getString("type");

                coupon c = new coupon(id, date_debut, date_experatio, taux, code_coupon, nbr_utilisation, type);
                couponList.add(c);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return couponList;
    }

    //triiii
    @Override
    public List<coupon> sortCoupons(String column, String order) {
        List<coupon> couponList = new ArrayList<>();
        try {
            String query = "SELECT * FROM coupon ORDER BY " + column + " " + order;
            Statement stmt = cnx2.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                Date date_debut = rs.getDate("date_debut");
                Date date_experatio = rs.getDate("date_experatio");
                int taux = rs.getInt("taux");
                String code_coupon = rs.getString("code_coupon");
                int nbr_utilisation = rs.getInt("nbr_utilisation");
                String type = rs.getString("type");

                coupon c = new coupon(id, date_debut, date_experatio, taux, code_coupon, nbr_utilisation, type);
                couponList.add(c);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return couponList;
    }

    //controle saisie 
    public boolean validateCoupon(coupon coupon) {

        if (coupon.getDate_debut().after(coupon.getDate_experation())) {
            System.out.println("La date de début doit être antérieure à la date d'expiration.");
            return false;
        }

        if (coupon.getTaux_reduction() < 0 || coupon.getTaux_reduction() >= 100) {
            System.out.println("Le taux de réduction doit être compris entre 0 et 100.");
            return false;
        }

        if (coupon.getCode_coupon().length() == 0) {
            System.out.println("Le code coupon ne peut pas être vide.");
            return false;
        }

        if (coupon.getNbr_utilisation() < 0) {
            System.out.println("Le nombre d'utilisation doit être un entier positif.");
            return false;
        }

        if (coupon.getType().length() == 0) {
            System.out.println("Le type ne peut pas être vide.");
            return false;
        }

        return true;
    }

    @Override
    public List<coupon> Filter_Coupon(String S, String SS) {
        List<coupon> list = new ArrayList<>();
        try {
            if (S.equals("type") || S.equals("code_coupon")) {
                int temp = Integer.parseInt(SS);
                String req = "SELECT * FROM `coupon` WHERE " + S + " =" + temp;
                Statement st = cnx2.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    coupon v = new coupon();
                    v.setId_coupon(RS.getInt("id"));
                    v.setDate_debut(RS.getDate("date_debut"));
                    v.setDate_experation(RS.getDate("date_experatio"));
                    v.setTaux_reducton(RS.getInt("taux"));
                    v.setCode_coupon(RS.getString("code_coupon"));
                    v.setNbr_utilisation(RS.getInt("nbr_utilisation"));
                    v.setType(RS.getString("type"));
                    list.add(v);
                }
            } else {
                String req = "SELECT * FROM `coupon` WHERE " + S + " =" + "\"" + SS + "\"";
                Statement st = cnx2.createStatement();
                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    coupon v = new coupon();
                    v.setId_coupon(RS.getInt("id"));
                    v.setDate_debut(RS.getDate("date_debut"));
                    v.setDate_experation(RS.getDate("date_experatio"));
                    v.setTaux_reducton(RS.getInt("taux"));
                    v.setCode_coupon(RS.getString("code_coupon"));
                    v.setNbr_utilisation(RS.getInt("nbr_utilisation"));
                    v.setType(RS.getString("type"));

                    list.add(v);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;

    }

    @Override
    public int Supprimer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getPrix(int id){
        int prix = 0;
        try {
            String query = "SELECT * FROM voiture WHERE id= " + id;
            Statement stmt = cnx2.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                prix = rs.getInt("prix_jours");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return prix;
    }

}
