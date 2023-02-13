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
public class reclamation {
    private int id_rec;
    private String type_rec;
    private String commentaire;

    public reclamation() {
    }

    public reclamation(String type_rec, String commentaire) {
        this.type_rec = type_rec;
        this.commentaire = commentaire;
    }

    public reclamation(int id_rec, String type_rec, String commentaire) {
        this.id_rec = id_rec;
        this.type_rec = type_rec;
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "reclamation{" + "id_rec=" + id_rec + ", type_rec=" + type_rec + ", commentaire=" + commentaire + '}';
    }

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public String getType_rec() {
        return type_rec;
    }

    public void setType_rec(String type_rec) {
        this.type_rec = type_rec;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    
   

    

}