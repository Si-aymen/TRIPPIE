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
public class abonnement {
    private int idA ;
    private String type;
    private Date dateExpiration , dateAchat ;
    private int prix;

    public abonnement() {
    }

    public abonnement(int idA, String type, Date dateExpiration, Date dateAchat, int prix) {
        this.idA = idA;
        this.type = type;
        this.dateExpiration = dateExpiration;
        this.dateAchat = dateAchat;
        this.prix = prix;
    }

    public abonnement(String type, Date dateExpiration, Date dateAchat, int prix) {
        this.type = type;
        this.dateExpiration = dateExpiration;
        this.dateAchat = dateAchat;
        this.prix = prix;
    }

    public abonnement(String type,int prix, Date dateAchat, Date dateExpiration) {
        this.type = type;
          this.prix = prix;
                  this.dateAchat = dateAchat;

        this.dateExpiration = dateExpiration;
      
    }
    public abonnement(String type, Date dateExpiration, Date dateAchat) {
        this.type = type;
        this.dateExpiration = dateExpiration;
        this.dateAchat = dateAchat;
    }

    public abonnement(String type, int prix) {
        this.type = type;
        this.prix = prix;
    }
    

    public abonnement(Date dateExpiration, Date dateAchat) {
        this.dateExpiration = dateExpiration;
        this.dateAchat = dateAchat;
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

    public int getPrix() {
        return prix;
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

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "abonnement{" + "type=" + type + ", dateExpiration=" + dateExpiration + ", dateAchat=" + dateAchat + ", prix=" + prix + '}';
    }

    
    
      
       
 
}


 
    
    

   

    

