/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import static edu.webuild.controllers.Add_CovController.url_image;
import edu.webuild.controllers.Menu_CoVoiturageController;
import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.model.CoVoiturage;
import edu.webuild.services.CoVoiturageCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Mod_CovController implements Initializable {

    @FXML
    private Button cov_btu;
    @FXML
    private Button valider;
    @FXML
    private TextField depart_TF;
    @FXML
    private TextField destination_TF;
    @FXML
    private TextField nmbr_place_TF;
    @FXML
    private TextField id_co_TF;
    @FXML
    private DatePicker Date_PK;
    @FXML
    private Button cov_btu1;
    @FXML
    private ImageView imageView;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        //System.out.println(Afficher_CovController.url_img);
        id_co_TF.setText(String.valueOf(Afficher_CovController.id_co));
        depart_TF.setText(String.valueOf(Afficher_CovController.depart));
        destination_TF.setText(String.valueOf(Afficher_CovController.destination));
        Date_PK.setPromptText(Afficher_CovController.date_dep.toString());
        nmbr_place_TF.setText(String.valueOf(Afficher_CovController.nmbr_place));

    }

    @FXML
    private void cov_btu(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Menu_Cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void mod(ActionEvent event) {
        int id_co = Integer.parseInt(id_co_TF.getText());
        String depart = depart_TF.getText();
        String destination = destination_TF.getText();
        Date date_dep = java.sql.Date.valueOf(Date_PK.getValue());
        int nmbr_place = Integer.parseInt(nmbr_place_TF.getText());
        System.out.println(Integer.parseInt(Afficher_CovController.id_co));
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();

        //CoVoiturage co = new CoVoiturage(depart, destination, date_dep, nmbr_place);
        if (nmbr_place > 7 || nmbr_place == 0 || nmbr_place < 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("la nmbr des place est incorrect ");
            alert.show();
        } else if (depart.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("label de depart est vide ");
            alert.show();
        } else if (destination.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("label de destination est vide ");
            alert.show();
        } else {
            CoVoiturage cov = new CoVoiturage(depart, destination, date_dep, nmbr_place);
            inter_co.modifierCoVoiturage(cov, Integer.parseInt(Afficher_CovController.id_co));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Co_voiturage updated!");
            alert.show();
            try {

                Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Afficher_Cov.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }

    @FXML
    private void stats(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Piechart.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void img_btu(ActionEvent event) {
    }

}
