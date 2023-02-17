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
public class abonnement {
    private int idA ;
    private String type, dateExpiration , dateAchat ;
        private int prix;
    //constructeur par defaut
    public abonnement() {
    }
    
    //constructur parametre 

    public abonnement(int idA, String type, String dateExpiration, String dateAchat, int prix) {
        this.idA = idA;
        this.type = type;
        this.dateExpiration = dateExpiration;
        this.dateAchat = dateAchat;
        this.prix = prix;
    }

    public abonnement(String type, String dateExpiration, String dateAchat) {
        this.type = type;
        this.dateExpiration = dateExpiration;
        this.dateAchat = dateAchat;
    }

    public int getIdA() {
        return idA;
    }

    public String getType() {
        return type;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public String getDateAchat() {
        return dateAchat;
    }

    public int getPrix() {
        return prix;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "abonnement{" + "idA=" + idA + ", type=" + type + ", dateExpiration=" + dateExpiration + ", dateAchat=" + dateAchat + ", prix=" + prix + '}';
    }

    
    

 
    
    

   

    

}