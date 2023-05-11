/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;


import javafx.scene.control.TextField;

/**
 *
 * @author HP
 */
public class cadeau {
    private int idcadeau;
    private String nom_cadeay;
    private int reccurence;
     private String description;
    private int valeur;
     private int coupon_id;

    public cadeau(String nom_cadeau, int recurrence, String description,int valeur, int id_coupon) {
        this.nom_cadeay = nom_cadeau;
        this.reccurence = recurrence;
        this.description=description;
        this.valeur=valeur;
        this.coupon_id = id_coupon;
    }

    

    public cadeau(int id_cadeau, String nom_cadeau, int recurrence,String description,int valeur,  int id_coupon) {
        this.idcadeau = id_cadeau;
        this.nom_cadeay= nom_cadeau;
        this.reccurence = recurrence;
        this.description=description;
        this.valeur=valeur;
        this.coupon_id = id_coupon;
    }

    public cadeau(int id, String nom, int recurrence) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public cadeau(int id_cadeau, String nom_cadeau, TextField reccuuM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public cadeau(int id_cadeau, String nom, int recurrence, String des, int val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
    public void setId_coupon(int id_coupon) {
        this.coupon_id = id_coupon;
    }

    public int getId_coupon() {
        return coupon_id;
    }

    public cadeau(String nom_cadeau, int recurrence,String description,int valeur) {
        this.nom_cadeay = nom_cadeau;
        this.reccurence = recurrence;
        this.description=description;
        this.valeur=valeur;
    }

    public cadeau() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public int getId_cadeau() {
        return idcadeau;
    }

    
    public String getNom_cadeau() {
        return nom_cadeay;
    }

    public int getRecurrence() {
        return reccurence;
    }

    public String getDescription() {
        return description;
    }

    public int getValeur() {
        return valeur;
    }

   
 public void setId_cadeau(int id_cadeau) {
        this.idcadeau = id_cadeau;
    }

    

    public void setNom_cadeau(String nom_cadeau) {
        this.nom_cadeay = nom_cadeau;
    }

    public void setRecurrence(int recurrence) {
        this.reccurence = recurrence;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return ""+ " nom_cadeay=" + nom_cadeay + ", reccurence=" + reccurence + ", description=" + description + ", valeur=" + valeur ;
    }

    public void setId_coupon(coupon c1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
   

   
}
