/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

import java.util.Date;

/**
 *
 * @author belkn
 */
public class reclamation {

    private int id_rec;
    private String type_rec;
    private String commentaire;
    private String etat;
    private Date date_creation;
    private int id_utilisateur;
    private String url_image;

    public reclamation() {
    }

    public reclamation(int id_rec, String type_rec, String commentaire, String etat, Date date_creation, int id_utilisateur, String url_image) {
        this.id_rec = id_rec;
        this.type_rec = type_rec;
        this.commentaire = commentaire;
        this.etat = etat;
        this.date_creation = date_creation;
        this.id_utilisateur = id_utilisateur;
        this.url_image = url_image;
    }

    public reclamation(String type_rec, String commentaire, String etat, Date date_creation, int id_utilisateur, String url_image) {
        this.type_rec = type_rec;
        this.commentaire = commentaire;
        this.etat = etat;
        this.date_creation = date_creation;
        this.id_utilisateur = id_utilisateur;
        this.url_image = url_image;
    }

    @Override
    public String toString() {
        return "Type : " + type_rec + " || Commentaire : " + commentaire + " || Etat : " + etat;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

}