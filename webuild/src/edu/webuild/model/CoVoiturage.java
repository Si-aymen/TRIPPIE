/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

/**
 *
 * @author manou
 */
public class CoVoiturage {
    private int id_co;
    private String depart; 
    private String destinaion ; 
    private String date_dep ; 
    private int nmbr_place; 

    public CoVoiturage(int id_co, String depart, String destinaion, String date_dep, int nmbr_place) {
        this.id_co = id_co;
        this.depart = depart;
        this.destinaion = destinaion;
        this.date_dep = date_dep;
        this.nmbr_place = nmbr_place;
    }

    public CoVoiturage(String depart, String destinaion, String date_dep, int nmbr_place) {
        this.depart = depart;
        this.destinaion = destinaion;
        this.date_dep = date_dep;
        this.nmbr_place = nmbr_place;
    }


    public CoVoiturage() {
     
    }

    public int getId_co() {
        return id_co;
    }

    public void setId_co(int id_co) {
        this.id_co = id_co;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestinaion() {
        return destinaion;
    }

    public void setDestinaion(String destinaion) {
        this.destinaion = destinaion;
    }

    public String getDate_dep() {
        return date_dep;
    }

    public void setDate_dep(String date_dep) {
        this.date_dep = date_dep;
    }

    public int getNmbr_place() {
        return nmbr_place;
    }

    public void setNmbr_place(int nmbr_place) {
        this.nmbr_place = nmbr_place;
    }

    @Override
    public String toString() {
        return "CoVoiturage{" + "id_co=" + id_co + ", depart=" + depart + ", destinaion=" + destinaion + ", date_dep=" + date_dep + ", nmbr_place=" + nmbr_place + '}';
    }
    
            
    
}
