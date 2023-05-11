/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.reclamation;
import edu.webuild.services.reclamationCRUD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class Item_recController implements Initializable {

    @FXML
    private ImageView img;

    private MyListener myListener;
    private reclamation re;
    static reclamation r = new reclamation();
    private int id;
    @FXML
    private Label date;
    @FXML
    private Label type_rec;
    @FXML
    private Label etat_rec;
    @FXML
    private Label commentaire_rec;

    public void setData(int id_rec, String type, String commentaire, String etat, int id_utilisateur, Date date_creation, String url, MyListener myListener) {

        this.id = id_rec;
        this.myListener = myListener;
        type_rec.setText(type);
        etat_rec.setText(etat);
        if (date_creation != null) {
            date.setText(date_creation.toString());
        } else {
            date.setText(""); // Ou vous pouvez mettre un texte différent pour représenter une date null
        }
        String fullurl = "C:\\xampp\\htdocs\\image_trippie_reclamation\\" + url;
        System.out.println("full url " + fullurl);
        commentaire_rec.setText(commentaire);
//        Image image = new Image(fullurl);
//        //Image image = new Image("C:\\Users\\manou\\Desktop\\TRIPPIE-co_voiturage\\205.jpg");
//        img.setImage(image);

        try {
            img.setImage(new Image(new FileInputStream(fullurl)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void onClick() {
        myListener.onClick(re);
    }

    public void setMyListener(MyListener myListener) {
        this.myListener = myListener;
    }

    @FXML
    private void Click(MouseEvent event) {
        reclamationCRUD rc = new reclamationCRUD();
        List<reclamation> L = new ArrayList<>();
        myListener.onClick(re);
        //covt.setId_co(Integer.parseInt(id_co.getText()));
        L = rc.rechReclamation(id);
        r.setId_rec(L.get(0).getId_rec());
        r.setType_rec(L.get(0).getType_rec());
        r.setCommentaire(L.get(0).getCommentaire());
        r.setEtat(L.get(0).getEtat());
        r.setId_utilisateur(Rec_FrontController.id_util);
        r.setDate_creation(L.get(0).getDate_creation());
        r.setUrl_image(L.get(0).getUrl_image());
    }

    public interface MyListener {

        void onClick(reclamation re);
    }

}
