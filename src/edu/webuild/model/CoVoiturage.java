/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.model;

import java.util.Date;

/**
 *
 * @author manou
 */
public class CoVoiturage {

    private int id_co;
    private String depart;
    private String destination;
    private Date date_dep;
    private int nmbr_place;

    public CoVoiturage(int id_co, String depart, String destinaion, Date date_dep, int nmbr_place) {
        this.id_co = id_co;
        this.depart = depart;
        this.destination = destinaion;
        this.date_dep = date_dep;
        this.nmbr_place = nmbr_place;
    }

    public CoVoiturage(String depart, String destinaion, Date date_dep, int nmbr_place) {
        this.depart = depart;
        this.destination = destinaion;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate_dep() {
        return date_dep;
    }

    public void setDate_dep(Date date_dep) {
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
        return "CoVoiturage{" + "id_co=" + id_co + ", depart=" + depart + ", destinaion=" + destination + ", date_dep=" + date_dep + ", nmbr_place=" + nmbr_place + '}' + "\n";
    }

}
