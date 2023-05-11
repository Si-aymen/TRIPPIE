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
    private int id_client;

    public abonnement() {
    }
// Constructor with type parameter
    public abonnement(String type) {
        setType(type);
        setPrix(type);
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

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    
   // Getters and setters
    public String getType() {
        return type;
    }
//I added a new constructor that takes a type parameter and sets the corresponding prix value using the setPrix method
    public void setType(String type) {
        this.type = type;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    // Method to set the prix value based on the type value
    //I also added a setPrix method that sets the prix value based on the type value using a switch statement.
    public void setPrix(String type) {
        switch (type) {
            case "Gold":
                this.prix = 1070;
                break;
            case "Platinium":
                this.prix = 700;
                break;
            case "Bronze":
                this.prix = 400;
                break;
            default:
                this.prix = 0;
                break;
        }
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    @Override
    public String toString() {
        return "abonnement{" + "idA=" + idA + ", type=" + type + ", dateExpiration=" + dateExpiration + ", dateAchat=" + dateAchat + ", prix=" + prix + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

   

    
    
      
       
 
}


 
    
    

   

    

