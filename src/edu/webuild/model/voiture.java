/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

import edu.webuild.interfaces.InterfaceCRUD;

/**
 *
 * @author belkn
 */
public class voiture {

    private int id;
    private String matricule, marque, puissance/*,etat*/;
    private int prix_jours;
    private String image_voiture , energie , etat ;
   private int  id_locateur ; 

    //constructeur par defaut
    public voiture() {
    }

    //constructur parametre 

//locateur 
    public voiture(String matricule, String marque, String puissance, int prix_jours, String image_voiture, String energie, int id_locateur) {
     this.matricule=matricule ;
     this.marque=marque ; 
     this.puissance=puissance ; 
     this.prix_jours=prix_jours ; 
     this.image_voiture=image_voiture ; 
     this.energie=energie ; 
     this.id_locateur=id_locateur ; 
    }
    //admin 
     public voiture(String matricule, String marque, String puissance, int prix_jours, String image_voiture, String energie) {
     this.matricule=matricule ;
     this.marque=marque ; 
     this.puissance=puissance ; 
     this.prix_jours=prix_jours ; 
     this.image_voiture=image_voiture ; 
     this.energie=energie ; 
 
    }
// constructeur modifier voiture
    public voiture(int id, String matricule, String marque, String puissance, int prix_jours, String image_voiture, String energie) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
        this.puissance = puissance;
        this.prix_jours = prix_jours;
        this.image_voiture = image_voiture;
        this.energie = energie;
 
    }
     
    

   
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public int getPrix_jours() {
        return prix_jours;
    }

    public void setPrix_jours(int prix_jours) {
        this.prix_jours = prix_jours;
    }

    public String getImage_voiture() {
        return image_voiture;
    }

    public void setImage_voiture(String image_voiture) {
        this.image_voiture = image_voiture;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getId_locateur() {
        return id_locateur;
    }

    public void setId_locateur(int id_locateur) {
        this.id_locateur = id_locateur;
    }

    @Override
    public String toString() {
        return "voiture{" + "matricule=" + matricule + ", marque=" + marque + ", puissance=" + puissance + ", prix_jours=" + prix_jours + ", image_voiture=" + image_voiture + ", energie=" + energie + '}';
    }

  
    
    

  
    

    

}
