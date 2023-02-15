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
    int id_client,id_user,id_role;
    String email;
    String password;
    

    public Client() {
    }

    public Client(int id_client ,int id_role, int id_user, String email, String password) {
        this.id_client = id_client;
        this.id_role = id_role;
        this.id_user = id_user;
        this.email = email;
        this.password = password;
     
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
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
        return "Client{" + "id_client=" + id_client + ",id_role=" + id_role + ", id_user=" + id_user + ",  email=" + email + ", password=" + password +  '}';
    }

   
   
    
    
}
