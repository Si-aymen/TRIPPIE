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
import edu.webuild.utils.MyConnection;
import java.io.IOException;

import java.util.Date;


import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
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
    private Button btnEdit;
 
    
    @FXML
            private Button btndelete;
    
    
    //VARIABLES
    int idA ;
   String type;
  

   
  


      
          
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
private void modifierabonnement(ActionEvent event) {
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    abonnement selectedEntity = listView.getSelectionModel().getSelectedItem();

    // Check if an entity is selected
    if (selectedEntity != null) {

        // Display a dialog to edit the selected entity
        Dialog<abonnement> dialog = new Dialog<>();
        dialog.setTitle("Edit Entity");
        dialog.setHeaderText("Edit the selected entity:");

        // Set the dialog content
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

    

      TextField typeField = new TextField(selectedEntity.getType());
grid.add(new Label("Type:"), 0, 0);
grid.add(typeField, 1, 0);

TextField prixField = new TextField(String.valueOf(selectedEntity.getPrix()));
grid.add(new Label("Prix:"), 0, 1);
grid.add(prixField, 1, 1);

        TextField idAField = new TextField();
        grid.add(new Label("IDA:"), 0, 2);
        grid.add(idAField, 1, 2);

        dialog.getDialogPane().setContent(grid);

        // Add buttons to the dialog
        ButtonType saveButtonType = new ButtonType("Save", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        // Set the result converter for the dialog
dialog.setResultConverter(dialogButton -> {
    if (dialogButton == saveButtonType) {
        // If the Save button is clicked, update the selected entity
        selectedEntity.setType(typeField.getText());
        selectedEntity.setPrix(Integer.parseInt(prixField.getText()));
        return selectedEntity;
    }
    return null;
});
        // Show the dialog and wait for the user's input
        Optional<abonnement> result = dialog.showAndWait();

        // If the user clicked the Save button, update the entity in the list view and the database
        result.ifPresent(entity -> {
            // Update the entity in the list view
            listView.refresh();

            // Prompt the user for the idA value
            TextInputDialog idAInputDialog = new TextInputDialog();
            idAInputDialog.setTitle("Enter IDA");
            idAInputDialog.setHeaderText("Please enter the IDA value:");
            Optional<String> idAResult = idAInputDialog.showAndWait();

            // If the user entered an idA value, update the entity in the database
            idAResult.ifPresent(idA -> {
                int idAInt = Integer.parseInt(idA);
                AbonnementCRUD abonnementCRUD = new AbonnementCRUD(conn);
                abonnementCRUD.modifierabonnement(idAInt, selectedEntity);
            });
            Alert alert = new Alert(AlertType.INFORMATION);

        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("membership updated successfully!");
        alert.show();
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



       @FXML
private void supprimerabonnement(ActionEvent event) {
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    abonnement selectedEntity = listView.getSelectionModel().getSelectedItem();
    
    // Check if an entity is selected
    if (selectedEntity != null) {
        // Display a confirmation dialog
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Delete the selected entity?");
        alert.setContentText("Are you sure you want to delete the selected entity?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // If the user confirmed, delete the selected entity from the list view and the database
            listView.getItems().remove(selectedEntity);

            // Delete the selected entity from the database
            System.out.println("Connection object in event handler: " + conn.toString()); // Debugging statement
            AbonnementCRUD abonnementCRUD = new AbonnementCRUD(conn);
            System.out.println("AbonnementCRUD object created with connection: " + abonnementCRUD.toString()); // Debugging statement
            abonnementCRUD.supprimerabonnement(selectedEntity.getIdA());
        }
    } else {
        // If no entity is selected, display an error message
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("No entity selected");
        alert.setContentText("Please select an entity to delete.");
        alert.showAndWait();
    }
}

    @FXML
    private void back_btn(MouseEvent event) {
    }

    
}
