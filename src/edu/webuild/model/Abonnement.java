/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

/**
 *
 * @author mtirn
 */
public class Abonnement {
    private int idA;
    private String type,prix,dateAchat,dateExpiration;

    //constructeur par defaut
    public Abonnement() {
    }
    
    //constructur parametre 

    public Abonnement(int idA, String type, String prix, String dateAchat, String dateExpiration) {
        this.idA = idA;
        this.type = type;
        this.prix = prix;
        this.dateAchat = dateAchat;
        this.dateExpiration = dateExpiration;
    }

    public Abonnement(String type, String prix, String dateAchat, String dateExpiration) {
        this.type = type;
        this.prix = prix;
        this.dateAchat = dateAchat;
        this.dateExpiration = dateExpiration;
    }

    public int getIdA() {
        return idA;
    }

    public String getType() {
        return type;
    }

    public String getPrix() {
        return prix;
    }

    public String getDateAchat() {
        return dateAchat;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    @Override
    public String toString() {
        return "Abonnement{" + "idA=" + idA + ", type=" + type + ", prix=" + prix + ", dateAchat=" + dateAchat + ", dateExpiration=" + dateExpiration + '}';
    }

   
    
}
