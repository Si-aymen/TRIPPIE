/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.model.CoVoiturage;
import edu.webuild.services.CoVoiturageCRUD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Item_covController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label depart;
    @FXML
    private Label destination;
    @FXML
    private Label temps;
    private MyListener myListener;
    private CoVoiturage cov;
    @FXML
    private Label nb_plc;

    static CoVoiturage covt = new CoVoiturage();
    @FXML
    private Label id_co;

//    private void CLick(MouseEvent actionEvent) {
//        
//    }
    /**
     * Initializes the controller class.
     */
    public void setData(int id_coo, String departt, String destinationn, Date d, String url, String nmbr_place, MyListener myListener) {

        this.myListener = myListener;
        this.id_co.setText(Integer.toString(id_coo));
        depart.setText(departt);
        destination.setText(destinationn);
      //  temps.setText(d.toString());
        String fullurl = "C:\\xampp\\htdocs\\image_trippie_cov\\" + url;
        System.out.println("full url " + fullurl);
        nb_plc.setText(nmbr_place);
//        Image image = new Image(fullurl);
//        //Image image = new Image("C:\\Users\\manou\\Desktop\\TRIPPIE-co_voiturage\\205.jpg");
//        img.setImage(image);

        try {
            img.setImage(new Image(new FileInputStream(fullurl)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Uncomment the following line if you want to set a default image
        //img.setImage(new Image("C:\\Users\\manou\\Desktop\\TRIPPIE-co_voiturage\\205.jpg"));
    }

    public void onClick() {
        myListener.onClick(cov);
    }

    public void setMyListener(MyListener myListener) {
        this.myListener = myListener;
    }

    @FXML
    private void Click(MouseEvent event) {
        InterfaceCoVoiturage inter = new CoVoiturageCRUD();
        List<CoVoiturage> L = new ArrayList<>();
        myListener.onClick(cov);
        //covt.setId_co(Integer.parseInt(id_co.getText()));
        L = inter.rechCoVoiturage(Integer.parseInt(id_co.getText()));
        covt.setId_co(L.get(0).getId_co());
        covt.setDepart(L.get(0).getDepart());
        covt.setDestination(L.get(0).getDestination());
        covt.setNmbr_place(L.get(0).getNmbr_place());
        covt.setDate_dep(L.get(0).getDate_dep());
        System.out.println(L.get(0).getCov_img());
        covt.setCov_img(L.get(0).getCov_img());
        System.out.println(covt.getCov_img());
    }

    public interface MyListener {

        void onClick(CoVoiturage cov);
    }

}
