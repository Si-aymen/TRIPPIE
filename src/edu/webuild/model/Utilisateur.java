package edu.webuild.model;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author aymen
 */
public class Utilisateur {
    public int id_user;
    private String cin;
    private String nom,prenom,sexe,img;
    
 
  
   

    //constructeur par defaut
    public Utilisateur() {
    }

    public Utilisateur(int id_user) {
        this.id_user = id_user;
    }

    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    
    //constructur parametre 

    public Utilisateur(int id_user, String cin, String nom, String prenom, String sexe) {
        this.id_user = id_user;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
      
        
    }

    public Utilisateur(String cin, String nom, String prenom, String sexe, String img) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.img = img;
    }
    

    public Utilisateur(String cin, String nom, String prenom, String sexe) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        
      
    }

    

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

 
    @Override
    public String toString() {
        return "Utilisateur{" + "id_user=" + id_user + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe +  '}';
    }

   
  

   



    
   

    
   
    
    
    
}
