/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;
import java.util.Date;

/**
 *
 * @author mtirn
 */
//to represent the result of the join query
public class AbonnementCarteFidelite {
    private int idA;
    private String type;
    private Date dateExpiration;
    private Date dateAchat;
    private double prix;
    private int id_cf;
    private int pointMerci;
    // getters and setters

    public AbonnementCarteFidelite() {
    }

    public AbonnementCarteFidelite(int idA, String type, Date dateExpiration, Date dateAchat, double prix, int id_cf, int pointMerci) {
        this.idA = idA;
        this.type = type;
        this.dateExpiration = dateExpiration;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.id_cf = id_cf;
        this.pointMerci = pointMerci;
    }

    public AbonnementCarteFidelite(String type, Date dateExpiration, Date dateAchat, double prix, int pointMerci) {
        this.type = type;
        this.dateExpiration = dateExpiration;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.pointMerci = pointMerci;
    }

    public int getIdA() {
        return idA;
    }

    public String getType() {
        return type;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public int getId_cf() {
        return id_cf;
    }

    public int getPointMerci() {
        return pointMerci;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setId_cf(int id_cf) {
        this.id_cf = id_cf;
    }

    public void setPointMerci(int pointMerci) {
        this.pointMerci = pointMerci;
    }

    @Override
    public String toString() {
        return "AbonnementCarteFidelite{" + "type=" + type + ", dateExpiration=" + dateExpiration + ", dateAchat=" + dateAchat + ", prix=" + prix + ", pointMerci=" + pointMerci + '}';
    }
    
}
