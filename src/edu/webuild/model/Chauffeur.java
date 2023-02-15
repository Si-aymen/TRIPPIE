/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

/**
 *
 * @author aymen
 */
public class Chauffeur {
    int id_ch,id_user,id_role;
    String num_permis;
    String marque_voiture;
    String couleur_voiture;
    String immatriculation;
    String email;
    String password;

    public Chauffeur() {
    }

    public Chauffeur(int id_ch,  int id_role,int id_user, String num_permis, String marque_voiture, String couleur_voiture, String immatriculation, String email, String password) {
        this.id_ch = id_ch;
        this.id_role = id_role;
        this.id_user = id_user;
        
        this.num_permis = num_permis;
        this.marque_voiture = marque_voiture;
        this.couleur_voiture = couleur_voiture;
        this.immatriculation = immatriculation;
        this.email = email;
        this.password = password;
    }

    public int getId_ch() {
        return id_ch;
    }

    public void setId_ch(int id_ch) {
        this.id_ch = id_ch;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getNum_permis() {
        return num_permis;
    }

    public void setNum_permis(String num_permis) {
        this.num_permis = num_permis;
    }

    public String getMarque_voiture() {
        return marque_voiture;
    }

    public void setMarque_voiture(String marque_voiture) {
        this.marque_voiture = marque_voiture;
    }

    public String getCouleur_voiture() {
        return couleur_voiture;
    }

    public void setCouleur_voiture(String couleur_voiture) {
        this.couleur_voiture = couleur_voiture;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Chauffeur{" + "id_ch=" + id_ch + ", id_role=" + id_role + ", id_user=" + id_user + ", num_permis=" + num_permis + ", marque_voiture=" + marque_voiture + ", couleur_voiture=" + couleur_voiture + ", immatriculation=" + immatriculation + ", email=" + email + ", password=" + password + '}';
    }

   

  
    
    
    
    
}
