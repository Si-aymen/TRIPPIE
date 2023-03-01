/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.model.Chauffeur;
import edu.webuild.services.ChauffeurCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProfilChauffeurController implements Initializable {

    @FXML
    private Label nom_lbl;
    @FXML
    private Label genre_lbl;
    @FXML
    private Label email_lbl;
    @FXML
    private Button exitBtn;
    @FXML
    private Button btn;


//    public void setEmail_lbl(String email) throws SQLException {
//        this.email_lbl.setText(email);
//        // TODO
//                ChauffeurCRUD u = new ChauffeurCRUD();
//         Chauffeur p = u.getChauffeur(email);
//         email_lbl.setText(email);
//      
//        System.out.println(email);
//        nom_lbl.setText(p.getId_role().getId_user().getNom());  // Récupérer l'utilisateur connecté
//        genre_lbl.setText(p.getId_role().getId_user().getPrenom());
//        
//        
//        
//    }   
    public void setEmail_lbl(String email) throws SQLException {
        this.email_lbl.setText(email);
        ChauffeurCRUD u = new ChauffeurCRUD();
        Chauffeur p = u.getChauffeur(email);
        email_lbl.setText(email);
        nom_lbl.setText(p.getId_role().getId_user().getNom());  // Récupérer l'utilisateur connecté
        genre_lbl.setText(p.getId_role().getId_user().getPrenom());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void exit(ActionEvent event) {
        exitBtn.setOnAction(e -> Platform.exit());
    }

    @FXML
    private void details(ActionEvent event) throws IOException {
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/edu/webuild/gui/ProfilLocateur.fxml"));
                    Parent root3 = loader3.load();
                    DetailsChauffeurController lc = loader3.getController();
                    email_lbl.getScene().setRoot(root3);      
                    lc.setEmail(email);
                    Scene scene3 = new Scene(root3);
                    Stage stage3 = (Stage) btn.getScene().getWindow();
                    stage3.setScene(scene3);
                    stage3.show();
    }

}
