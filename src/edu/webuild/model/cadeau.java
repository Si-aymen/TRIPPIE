/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

import java.util.Date;

/**
 *
 * @author HP
 */
public class cadeau {
    private int id_cadeau;
    private String nom_cadeau;
    private int recurrence;
     private int id_coupon;

    public cadeau(String nom_cadeau, int recurrence, int id_coupon) {
        this.nom_cadeau = nom_cadeau;
        this.recurrence = recurrence;
        this.id_coupon = id_coupon;
    }

    

    public cadeau(int id_cadeau, String nom_cadeau, int recurrence, int id_coupon) {
        this.id_cadeau = id_cadeau;
        this.nom_cadeau = nom_cadeau;
        this.recurrence = recurrence;
        this.id_coupon = id_coupon;
    }

    public cadeau(int id, String nom, int recurrence) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public cadeau(int id_coupon, Date date_debut, Date date_experation, int taux_reduction, String code_coupon, int nbr_utilisation, String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void setId_coupon(int id_coupon) {
        this.id_coupon = id_coupon;
    }

    public int getId_coupon() {
        return id_coupon;
    }

    public cadeau(String nom_cadeau, int recurrence) {
        this.nom_cadeau = nom_cadeau;
        this.recurrence = recurrence;
    }

    public cadeau() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public int getId_cadeau() {
        return id_cadeau;
    }

    
    public String getNom_cadeau() {
        return nom_cadeau;
    }

    public int getRecurrence() {
        return recurrence;
    }

   
 public void setId_cadeau(int id_cadeau) {
        this.id_cadeau = id_cadeau;
    }

    

    public void setNom_cadeau(String nom_cadeau) {
        this.nom_cadeau = nom_cadeau;
    }

    public void setRecurrence(int recurrence) {
        this.recurrence = recurrence;
    }

    @Override
    public String toString() {
        return "cadeau{" + "id_cadeau=" + id_cadeau + ", nom_cadeau=" + nom_cadeau + ", recurrence=" + recurrence + ", id_coupon=" + id_coupon + '}';
    }

   
}
