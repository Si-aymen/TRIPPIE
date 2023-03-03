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
public class Locateur {
    int id_loc;
    Role id_role;
    int tel;

    public Locateur(int id_loc, Role id_role, int tel, String nom_agence, String email, String password) {
        this.id_loc = id_loc;
        this.id_role = id_role;
        this.tel = tel;
        this.nom_agence = nom_agence;
        this.email = email;
        this.password = password;
    }
    String nom_agence;
    String email;
    String password;

    public Locateur() {
    }

    public Locateur(int id_loc, Role id_role,String nom_agence, String email, String password) {
        this.id_loc = id_loc;
        this.id_role = id_role;
        this.nom_agence = nom_agence;
        this.email = email;
        this.password = password;
    }

    public Locateur(Role id_role, String nom_agence, String email, String password) {
        this.id_role = id_role;
        this.nom_agence = nom_agence;
        this.email = email;
        this.password = password;
    }

    public Locateur(int id_loc, String nom_agence, String email, String password) {
        this.id_loc = id_loc;
        this.nom_agence = nom_agence;
        this.email = email;
        this.password = password;
    }
    
    

    public int getId_loc() {
        return id_loc;
    }

    public void setId_loc(int id_loc) {
        this.id_loc = id_loc;
    }

   

    public Role getId_role() {
        return id_role;
    }

    public void setId_role(Role id_role) {
        this.id_role = id_role;
    }

    public String getNom_agence() {
        return nom_agence;
    }

    public void setNom_agence(String nom_agence) {
        this.nom_agence = nom_agence;
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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Locateur{" + "id_loc=" + id_loc + ", id_role=" + id_role + ", tel=" + tel + ", nom_agence=" + nom_agence + ", email=" + email + ", password=" + password + '}';
    }

    public Locateur(Role id_role, int tel, String nom_agence, String email, String password) {
        this.id_role = id_role;
        this.tel = tel;
        this.nom_agence = nom_agence;
        this.email = email;
        this.password = password;
    }
    

   
   
  
    
    
}
