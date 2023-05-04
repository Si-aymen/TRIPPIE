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
public class Participation {

    private int id_part;

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    private int nmbr_place_part;
    private int id_co;
    private int id_client; 

    public Participation(int id_part, int nmbr_place_part, int id_co, int id_client) {
        this.id_part = id_part;
        this.nmbr_place_part = nmbr_place_part;
        this.id_co = id_co;
        this.id_client = id_client;
    }

    public Participation() {

    }

    public int getId_part() {
        return id_part;
    }

    public void setId_part(int id_part) {
        this.id_part = id_part;
    }

    public int getNmbr_place_part() {
        return nmbr_place_part;
    }

    public void setNmbr_place_part(int nmbr_place_part) {
        this.nmbr_place_part = nmbr_place_part;
    }

    public int getId_co() {
        return id_co;
    }

    public void setId_co(int id_co) {
        this.id_co = id_co;
    }

    public Participation(int nmbr_place_part, int id_co, int id_client) {
        this.nmbr_place_part = nmbr_place_part;
        this.id_co = id_co;
        this.id_client = id_client;
    }


    public Participation(int nmbr_place_part, int id_co) {
        this.nmbr_place_part = nmbr_place_part;
        this.id_co = id_co;
    }

    @Override
    public String toString() {
        return "Participation{" + "id_part=" + id_part + ", nmbr_place_part=" + nmbr_place_part + ", id_co=" + id_co + '}' + "\n";
    }

}
