/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class coupon {

    private int id;
    private Date date_debut;
    private Date date_experatio;
    private int taux;
    private String code_coupon;
    private int nbr_utilisation;
    private String type;

    public coupon(int id, Date date_debut, Date date_experatio, int taux, String code_coupon, int nbr_utilisation, String type) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_experatio = date_experatio;
        this.taux = taux;
        this.code_coupon = code_coupon;
        this.nbr_utilisation = nbr_utilisation;
        this.type = type;
    }

    public coupon(Date date_debut, Date date_experatio, int taux, String code_coupon, int nbr_utilisation, String type) {
        this.date_debut = date_debut;
        this.date_experatio = date_experatio;
        this.taux = taux;
        this.code_coupon = code_coupon;
        this.nbr_utilisation = nbr_utilisation;
        this.type = type;
    }

    public coupon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_coupon() {
        return id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_experation() {
        return date_experatio;
    }

    public int getTaux_reduction() {
        return taux;
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

    /* public void setId_coupn(int id_coupon) {
        this.id_coupon = id_coupon;
    }*/
    public void setId_coupon(int id) {
        this.id = id;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_experation(Date date_experatio) {
        this.date_experatio = date_experatio;
    }

    public void setTaux_reducton(int taux) {
        this.taux = taux;
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
        return "" + "   date_debut=" + date_debut + "  date_experation=" + date_experatio + "   taux_reduction=" + taux + " code_coupon=" + code_coupon + "  nbr_utilisation=" + nbr_utilisation + "   type=" + type;
    }

    public List<coupon> afficherCoupon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
