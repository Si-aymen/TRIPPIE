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
public class Cartefidelite {
    
    private int id_cf;
    private String pointMerci,dateExpiration;
    private int idA;

    //constructeur par defaut
    public Cartefidelite() {
    }
    
    //constructur parametre 

    public Cartefidelite(int id_cf, String pointMerci, String dateExpiration, int idA) {
        this.id_cf = id_cf;
        this.pointMerci = pointMerci;
        this.dateExpiration = dateExpiration;
        this.idA = idA;
    }

    public Cartefidelite(String pointMerci, String dateExpiration) {
        this.pointMerci = pointMerci;
        this.dateExpiration = dateExpiration;
    }

    public int getId_cf() {
        return id_cf;
    }

    public String getPointMerci() {
        return pointMerci;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public int getIdA() {
        return idA;
    }

    public void setId_cf(int id_cf) {
        this.id_cf = id_cf;
    }

    public void setPointMerci(String pointMerci) {
        this.pointMerci = pointMerci;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    @Override
    public String toString() {
        return "Cartefidelite{" + "id_cf=" + id_cf + ", pointMerci=" + pointMerci + ", dateExpiration=" + dateExpiration + ", idA=" + idA + '}';
    }

   
    
    
}
