/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;
import edu.webuild.interfaces.InterfaceAbonnement;
import edu.webuild.model.abonnement;
import edu.webuild.services.AbonnementCRUD;
import edu.webuild.gui.afficherAbonnement;
import java.io.IOException;

import java.util.Date;

import java.net.URL;
import java.util.List;
import java.util.Optional;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author mtirn
 */
public class AfficherAbonnementController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
    private ListView<abonnement> listView;
    
    @FXML
    private ListView<abonnement> affichageabonnement;
      @FXML
    private Button btnEdit;
       @FXML
    private Button btnDelete;
    
    
    
    
    //VARIABLES
    static int idA,prix ;
    static String type;
    static Date dateAchat;
    static Date dateExpiration;

   
    static abonnement abonnement;


      
          
       /**
     * Initializes the controller class.
     */
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ListView<abonnement> list =(ListView<abonnement>)listView;
        
        AbonnementCRUD abonnementCRUD = new AbonnementCRUD();
        List<abonnement>list2=abonnementCRUD.afficherabonnement();
        for(int i=0; i<list2.size();i++)
        {abonnement a =list2.get(i);
        list.getItems().add(a);
        }
 
    }    
    
      private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    
       @FXML   
       private void modifierabonnement(ActionEvent event)
       {
          
    abonnement selectedEntity = listView.getSelectionModel().getSelectedItem();
    
    // Check if an entity is selected
    if (selectedEntity != null) {
        // Display a dialog to edit the selected entity
        Dialog<abonnement> dialog = new Dialog<>();
        dialog.setTitle("Edit Entity");
        dialog.setHeaderText("Edit the selected entity:");

        // Set the dialog content
        // For example, you can use a form to display the fields of the entity
        // and allow the user to edit them
        // Here's an example using a GridPane to display the fields of the entity
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nameField = new TextField(selectedEntity.getType());
        grid.add(new Label("Type:"), 0, 0);
        grid.add(nameField, 1, 0);

        

        dialog.getDialogPane().setContent(grid);

        // Add buttons to the dialog
        ButtonType saveButtonType = new ButtonType("Save", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        // Set the result converter for the dialog
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                // If the Save button is clicked, update the selected entity
                selectedEntity.setType(nameField.getText());
            
                return selectedEntity;
            }
            return null;
        });

        // Show the dialog and wait for the user's input
        Optional<abonnement> result = dialog.showAndWait();

        // If the user clicked the Save button, update the entity in the list view
        result.ifPresent(entity -> {
            // Update the entity in the list view
            listView.refresh();
            
            // Call your CRUD method to update the entity in the database
            // For example:
            // entity.update();
        });
    } else {
        // If no entity is selected, display an error message
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("No entity selected");
        alert.setContentText("Please select an entity to edit.");
        alert.showAndWait();
    }
       }
           
           
           
       
    
}
