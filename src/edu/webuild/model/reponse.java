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
    int id_rep;
    String reponse;

    public reponse() {
    }

    public reponse(String reponse) {
        this.reponse = reponse;
    }

    public reponse(int id_rep, String reponse) {
        this.id_rep = id_rep;
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return "reponse{" + "id_rep=" + id_rep + ", reponse=" + reponse + '}';
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
    
    
}
