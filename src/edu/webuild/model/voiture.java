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

    //constructeur par defaut
    public voiture() {
    }

    //constructur parametre 
    public voiture(int id, String matricule, String marque, String puissance, int prix_jours
           ) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
        this.puissance = puissance;
        this.prix_jours = prix_jours;
  
    }

    public voiture(String matricule, String marque, String puissance, int prix_jours/*,String etat*/) {
        this.matricule = matricule;
        this.marque = marque;
        this.puissance = puissance;
        this.prix_jours = prix_jours;
        // this.etat=etat;
    }

    public voiture( String matricule, String marque, String puissance, int prix_jours, String image_voiture) {
     
        this.matricule = matricule;
        this.marque = marque;
        this.puissance = puissance;
        this.prix_jours = prix_jours;
        this.image_voiture = image_voiture;
    }

    public voiture(String matricule, String marque, String puissance, int prix_jours, String image_voiture, String energie) {
        this.matricule = matricule;
        this.marque = marque;
        this.puissance = puissance;
        this.prix_jours = prix_jours;
        this.image_voiture = image_voiture;
        this.energie = energie;
    }   

    public voiture(int id, String matricule, String marque, String puissance, int prix_jours, String energie) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
        this.puissance = puissance;
        this.prix_jours = prix_jours;
        this.energie = energie;
    }

    public voiture(String matricule, String marque, String puissance, int prix_jours, String image_voiture, String energie, String etat) {
        this.matricule = matricule;
        this.marque = marque;
        this.puissance = puissance;
        this.prix_jours = prix_jours;
        this.image_voiture = image_voiture;
        this.energie = energie;
        this.etat = etat;
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

    @Override
    public String toString() {
        return "voiture{" + "marque=" + marque + ", puissance=" + puissance + ", prix_jours=" + prix_jours + ", energie=" + energie + ", etat=" + etat + '}';
    }
    

  
    

    

}
