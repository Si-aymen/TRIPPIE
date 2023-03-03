/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import static edu.webuild.controller.Ajouter_recAdminController.id_utilisateur;
import edu.webuild.model.reclamation;
import edu.webuild.services.reclamationCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author guerf
 */
public class ModifierAdminController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField modif_type;
    @FXML
    private TextField modif_etat;
    @FXML
    private TextArea modif_comm;
    
    public static int id_utilisateur = 1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modif_type.setText(String.valueOf(AdminReclamationController.type_rec));
        modif_comm.setText(String.valueOf(AdminReclamationController.commentaire_rec));
        modif_etat.setText(String.valueOf(AdminReclamationController.etat_rec));
    }    

    @FXML
    private void modifier_rec(ActionEvent event) {
        
        try {
            int id;
            id = Integer.parseInt(String.valueOf(AdminReclamationController.id_rec));
            String type = modif_type.getText();
            String commentaire = modif_comm.getText();
            String etat = modif_etat.getText();   
            LocalDate localDate = LocalDate.now();
            Date date_creation = Date.valueOf(localDate);
            
            reclamation r = new reclamation(type, commentaire, etat, date_creation, id_utilisateur, "");
            
            reclamationCRUD rc = new reclamationCRUD();
            
            rc.modifierReclamation(r, id);

            Notifications n = Notifications.create()
                .title("WeBuild")
                .text("Réclamation modifiée avec succé !")
                .graphic(null)
                .position(Pos.TOP_CENTER)
                .hideAfter(Duration.seconds(5));
        n.showInformation();
            
            
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/adminReclamation.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void retour_reclamation(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/adminReclamation.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
}
