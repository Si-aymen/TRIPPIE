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
 

    public Role() {
    }
    
    
      public Role(int id_role,String libelle) {
          this.id_role=id_role;
        this.libelle = libelle;
    }
    

    public Role(String libelle) {
        this.libelle = libelle;
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

    @Override
    public String toString() {
        return "Role{" + "id_role=" + id_role + ", libelle=" + libelle + '}';
    }

   

   
    
    
    
    
}
