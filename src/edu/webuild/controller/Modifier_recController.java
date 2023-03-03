/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controller;

import static edu.webuild.controller.ModifierAdminController.id_utilisateur;
import edu.webuild.model.reclamation;
import edu.webuild.services.reclamationCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Modifier_recController implements Initializable {

    
    @FXML
    private TextField modif_type;
    @FXML
    private TextArea modif_comm;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField modif_etat;
    
    public static int id_utilisateur = 1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        modif_type.setText(String.valueOf(ReclamationController.type_rec));
        modif_comm.setText(String.valueOf(ReclamationController.commentaire_rec));
        modif_etat.setText(String.valueOf(ReclamationController.etat_rec));
        
    }    

    @FXML
    private void modifier_rec(ActionEvent event) {
        
        try {
            int id;
            id = Integer.parseInt(String.valueOf(ReclamationController.id_rec));
            String type = modif_type.getText();
            String commentaire = modif_comm.getText();   
            LocalDate localDate = LocalDate.now();
            Date date_creation = Date.valueOf(localDate);
            
            reclamation r = new reclamation(type, commentaire, "non traité", date_creation, id_utilisateur, "");
            
            reclamationCRUD rc = new reclamationCRUD();
            
            rc.modifierReclamation(r, id);

            Notifications n = Notifications.create()
                .title("WeBuild")
                .text("Réclamation modifiée avec succé !")
                .graphic(null)
                .position(Pos.TOP_CENTER)
                .hideAfter(Duration.seconds(5));
        n.showInformation();
            
            
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Reclamation.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(Modifier_recController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void retour_reclamation(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Reclamation.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
}
