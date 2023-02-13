/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

/**
 *
 * @author HP
 */
public class cadeau {
    private int id_cadeau;
    private String nom_cadeau;
    private int recurrence;

    public cadeau(int id_cadeau, String nom_cadeau, int recurrence) {
        this.id_cadeau = id_cadeau;
        this.nom_cadeau = nom_cadeau;
        this.recurrence = recurrence;
    }

    public cadeau(String nom_cadeau, int recurrence) {
        this.nom_cadeau = nom_cadeau;
        this.recurrence = recurrence;
    }

    public int getId_cadeau() {
        return id_cadeau;
    }

    
    public String getNom_cadeau() {
        return nom_cadeau;
    }

    public int getRecurrence() {
        return recurrence;
    }

   
 public void setId_cadeau(int id_cadeau) {
        this.id_cadeau = id_cadeau;
    }

    

    public void setNom_cadeau(String nom_cadeau) {
        this.nom_cadeau = nom_cadeau;
    }

    public void setRecurrence(int recurrence) {
        this.recurrence = recurrence;
    }

    @Override
    public String toString() {
        return "cadeau{" + "id_cadeau=" + id_cadeau + ", nom_cadeau=" + nom_cadeau + ", recurrence=" + recurrence + '}';
    }
    
}
