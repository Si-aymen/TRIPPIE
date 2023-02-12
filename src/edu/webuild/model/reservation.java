/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

/**
 *
 * @author belkn
 */
public class reservation {
    private int id ;
    private String date_debut, date_fin ;
    private int id_voiture;
    //constructeur par defaut
    public reservation() {
    }

    public reservation(String date_debut, String date_fin, int id_voiture) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_voiture = id_voiture;
    }
    
    
    
    //constructur parametre 

    public reservation(int id, String date_debut, String date_fin) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
   
    }

    public reservation(String date_debut, String date_fin) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

  

    @Override
    public String toString() {
        return "reservation{" + "id=" + id + ", date_debut=" + date_debut + ", date_fin=" + date_fin +", id_voiture=" + id_voiture + '}';
    }
    

   
   

    

}