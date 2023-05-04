/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

import java.sql.Date;

/**
 *
 * @author belkn
 */
public class reservation {
    private int id ;
    private Date date_debut, date_fin ;
    private voiture v ;
    private int id_client ; 

    
    //constructeur par defaut
    public reservation() {
    }   
    //constructur parametre 

    public reservation(int id, Date date_debut, Date date_fin, voiture v) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.v = v;
    }

    public reservation(Date date_debut, Date date_fin, voiture v) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.v = v;
    }

    public reservation( Date date_debut, Date date_fin, voiture v, int id_client) {
       
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.v = v;
        this.id_client = id_client;
    }
    

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    

   

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public voiture getV() {
        return v;
    }

    public void setV(voiture v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "reservation{" + "id=" + id + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", v=" + v + ", id_client=" + id_client + '}';
    }



 
    

   
   

    

}