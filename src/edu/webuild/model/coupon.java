/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author HP
 */
public class coupon {

    public static void remove(coupon selectedCoupon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Iterator<coupon> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     private int id_coupon;
    private Date date_debut;
    private Date date_experation;
    private int taux_reduction;
    private String code_coupon;
     private int nbr_utilisation;
     private String type;
   
   

    public coupon(int id_coupon, Date date_debut, Date date_experation, int taux_reduction, String code_coupon, int nbr_utilisation, String type) {
        this.id_coupon = id_coupon;
        this.date_debut = date_debut;
        this.date_experation = date_experation;
        this.taux_reduction = taux_reduction;
        this.code_coupon = code_coupon;
        this.nbr_utilisation = nbr_utilisation;
        this.type = type;
    }

    public coupon(Date date_debut, Date date_experation, int taux_reduction, String code_coupon, int nbr_utilisation, String type) {
        this.date_debut = date_debut;
        this.date_experation = date_experation;
        this.taux_reduction = taux_reduction;
        this.code_coupon = code_coupon;
        this.nbr_utilisation = nbr_utilisation;
        this.type = type;
    }

    public coupon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
    public int getId_coupon() {
        return id_coupon;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_experation() {
        return date_experation;
    }

    public int getTaux_reduction() {
        return taux_reduction;
    }

    public String getCode_coupon() {
        return code_coupon;
    }

    public int getNbr_utilisation() {
        return nbr_utilisation;
    }

    public String getType() {
        return type;
    }

    public void setId_coupn(int id_coupon) {
        this.id_coupon = id_coupon;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_experation(Date date_experation) {
        this.date_experation = date_experation;
    }

    public void setTaux_reducton(int taux_reduction) {
        this.taux_reduction = taux_reduction;
    }

    public void setCode_coupon(String code_coupon) {
        this.code_coupon = code_coupon;
    }

    public void setNbr_utilisation(int nbr_utilisation) {
        this.nbr_utilisation = nbr_utilisation;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "coupon{" + "id_coupon=" + id_coupon + ", date_debut=" + date_debut + ", date_experation=" + date_experation + ", taux_reduction=" + taux_reduction + ", code_coupon=" + code_coupon + ", nbr_utilisation=" + nbr_utilisation + ", type=" + type + '}';
    }


     
}
