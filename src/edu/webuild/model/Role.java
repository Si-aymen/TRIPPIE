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
public class Role  {
    private int id_role;
    private String libelle;
    private int id_user;
    
 

    public Role() {
    }

    public Role(String libelle) {
        this.libelle = libelle;
    }

    
    public Role(int id_role, String libelle) {
        this.id_role = id_role;
        this.libelle = libelle;
         
    }

    public Role(int id_role, String libelle, int id_user) {
        this.id_role = id_role;
        this.libelle = libelle;
        this.id_user = id_user;
    }
    
    

    

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    

    @Override
    public String toString() {
        return "Role{" + "id_role=" + id_role + ", libelle=" + libelle +", id_user=" + id_user + '}';
    }

   

    

    
   

   

   

   
    
    
    
    
}
