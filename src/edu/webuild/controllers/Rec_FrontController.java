/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.controllers.Item_recController.MyListener;
import edu.webuild.gui.LoginController;
import edu.webuild.model.reclamation;
import edu.webuild.services.reclamationCRUD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class Rec_FrontController implements Initializable {

    private List<reclamation> recDataList = FXCollections.observableArrayList();
    private reclamationCRUD rec = new reclamationCRUD();
    private MyListener myListener;
    
    @FXML
    private TextField search_bar;
    @FXML
    private ImageView det_rec_img;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Label type_r;
    @FXML
    private Label etat_r;
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label fruitNameLable;
    @FXML
    private Label fruitPriceLabel;
    
    public static int id_util;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if (LoginController.test == 1)
            {
                id_util = ProfilClientController.role.getId_role();
            }
            else if (LoginController.test == 2)
            {
                id_util = ProfilChauffeurController.role.getId_role();
            }
            else if (LoginController.test == 3)
            {
                id_util = ProfilLocateurController.role.getId_role();
            }
        
        recDataList.addAll(rec.afficherReclamation(id_util));
        if (recDataList.size() > 0) {
            setChosenRec(recDataList.get(0));
            myListener = new MyListener() {

                public void onClick(reclamation re) {
                    System.out.println("mouse clicked");
                    setChosenRec(re);
                }
            };
        }

        int column = 0;
        int row = 3;
        for (int i = 0; i < recDataList.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/Item_rec.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                Item_recController item = fxmlLoader.getController();
                System.out.println("reclamation details name " + recDataList.get(i).getEtat()+ " url : C:\\xampp\\htdocs\\image_trippie_cov" + recDataList.get(i).getUrl_image());
                item.setData(recDataList.get(i).getId_rec(), recDataList.get(i).getType_rec(), recDataList.get(i).getCommentaire(), recDataList.get(i).getEtat(), recDataList.get(i).getId_utilisateur(), recDataList.get(i).getDate_creation(), recDataList.get(i).getUrl_image(), myListener);
                //item.setData(covDataList.get(i).getDepart(), covDataList.get(i).getDestination(), covDataList.get(i).getDate_dep());

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                System.out.println("problem");
            }
        }
    }

    private void setChosenRec(reclamation r) {

        System.out.println(Item_recController.r.getType_rec());
        System.out.println(Item_recController.r.getEtat());
        type_r.setText(Item_recController.r.getType_rec());
        etat_r.setText(Item_recController.r.getEtat());
        String imagePath = "C:\\xampp\\htdocs\\image_trippie_reclamation\\" + Item_recController.r.getUrl_image();
        try {
            det_rec_img.setImage(new Image(new FileInputStream(imagePath)));
        } catch (FileNotFoundException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }

    }

    @FXML
    private void search_btu(ActionEvent event) {
    }

    @FXML
    private void details_btu(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/details.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);

        }
    }



    @FXML
    private void ajouter(MouseEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ajouter_front.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);

        }
    }

    @FXML
    private void Added_cov(MouseEvent event) {
    }

    @FXML
    private void retour(MouseEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/ProfilClient.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
   
}
