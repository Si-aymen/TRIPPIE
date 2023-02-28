/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.CoVoiturage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

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
    private CoVoiturage cov ;

    /**
     * Initializes the controller class.
     */
    public void setData(String departt, String destinationn, Date d) {
        depart.setText(departt);
        destination.setText(destinationn);
        temps.setText(d.toString());
        // Uncomment the following lines if you want to set an image
        //String fullurl = "C:\\xampp\\htdocs\\image_trippie_cov\\" + url;
        //Image image = new Image(getClass().getResourceAsStream("C:\\Users\\manou\\Desktop\\TRIPPIE-co_voiturage\\205.jpg"));
        //Image image = new Image("C:\\Users\\manou\\Desktop\\TRIPPIE-co_voiturage\\205.jpg");
        //img.setImage(image);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Uncomment the following line if you want to set a default image
        //img.setImage(new Image("C:\\Users\\manou\\Desktop\\TRIPPIE-co_voiturage\\205.jpg"));
    }

    @FXML
    public void onClick() {
        myListener.onClick(cov);
    }

    public void setMyListener(MyListener myListener) {
        this.myListener = myListener;
    }

    public interface MyListener {
        void onClick(CoVoiturage cov);
    }

}
