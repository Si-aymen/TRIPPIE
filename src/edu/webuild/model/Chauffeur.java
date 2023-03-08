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
    int id_ch;
    Role   id_role;
    String img;
    String num_permis;
    int tel;
    String email;
    String password;
    Etat etat;

    public Chauffeur() {
    }

    public Chauffeur(int id_ch, Role id_role, String img, String num_permis, int tel, String email, String password) {
        this.id_ch = id_ch;
        this.id_role = id_role;
        this.img = img;
        this.num_permis = num_permis;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }

    public Chauffeur(Role id_role, String img, String num_permis, int tel, String email, String password) {
        this.id_role = id_role;
        this.img = img;
        this.num_permis = num_permis;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }

    public Chauffeur(String img, String num_permis, int tel, String email, String password) {
        this.img = img;
        this.num_permis = num_permis;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }

 
    
    public Chauffeur(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

  

    public int getId_ch() {
        return id_ch;
    }

    public void setId_ch(int id_ch) {
        this.id_ch = id_ch;
    }


    public Role getId_role() {
        return id_role;
    }

    public void setId_role(Role id_role) {
        this.id_role = id_role;
    }

    public String getNum_permis() {
        return num_permis;
    }

    public void setNum_permis(String num_permis) {
        this.num_permis = num_permis;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Chauffeur{" + "id_ch=" + id_ch + ", id_role=" + id_role + ", img=" + img + ", num_permis=" + num_permis + ", tel=" + tel + ", email=" + email + ", password=" + password + '}';
    }

  

   

  
    
    
    
    
}
