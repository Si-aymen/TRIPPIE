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
    private String cin;
    private String nom,prenom;
    private int role;
   

    //constructeur par defaut
    public Utilisateur() {
    }
    
    //constructur parametre 

    public Utilisateur(String cin, String nom, String prenom, int role) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
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
    
    public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }

    @Override
    public String toString() {
        return "Utilisateur{" + "cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", role=" + role + '}';
    }



    
   

    
   
    
    
    
}
