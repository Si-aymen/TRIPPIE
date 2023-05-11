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
public class Client {

    int id_client;
    Role id_role;
    String img;
    int tel;
    String email;
    String password;
    Etat etat;

    public Client(int id_client, Role id_role, String img, int tel, String email, String password) {
        this.id_client = id_client;
        this.id_role = id_role;
        this.img = img;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }

    public Client(Role id_role, String img, int tel, String email, String password) {
        this.id_role = id_role;
        this.img = img;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }

    public Client(String img, int tel, String email, String password) {
        this.img = img;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }

    public Client() {
    }

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Role getId_role() {
        return id_role;
    }

    public void setId_role(Role id_role) {
        this.id_role = id_role;
    }

    public String getEmail() {
        return email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
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

    public Client(Role id_role, int tel, String email, String password) {
        this.id_role = id_role;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client + ", id_role=" + id_role + ", img=" + img + ", tel=" + tel + ", email=" + email + ", password=" + password + '}';
    }

}
