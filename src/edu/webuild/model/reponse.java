/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

/**
 *
 * @author guerf
 */
public class reponse {

    private int id_rep;
    private String reponse;
    private int id_rec;
    private String etat;

    public reponse() {
    }

    public reponse(String reponse, int id_rec, String etat) {
        this.reponse = reponse;
        this.id_rec = id_rec;
        this.etat = etat;
    }

    public reponse(int id_rep, String reponse, int id_rec, String etat) {
        this.id_rep = id_rep;
        this.reponse = reponse;
        this.id_rec = id_rec;
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reponse : " + reponse + " || Etat=" + etat;
    }

    public int getId_rep() {
        return id_rep;
    }

    public void setId_rep(int id_rep) {
        this.id_rep = id_rep;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

}
