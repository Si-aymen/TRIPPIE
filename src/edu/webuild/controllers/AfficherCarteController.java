/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;
import edu.webuild.interfaces.InterfaceCarte;
import edu.webuild.model.abonnement;
import edu.webuild.model.cartefidelite;
import edu.webuild.services.AbonnementCRUD;

import edu.webuild.services.CartefideliteCRUD;
import edu.webuild.utils.MyConnection;
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
 *
 * @author mtirn
 */
public class AfficherCarteController implements Initializable {
    
    
    
     /**
     * Initializes the controller class.
     */
   @FXML
    private ListView<cartefidelite> listView;
    
      @FXML
    private Button btnEdit;
 
    
    @FXML
            private Button btndelete;
    
    
    int id_cf;
    String pointMerci;
    
    
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ListView<cartefidelite> list =(ListView<cartefidelite>)listView;
        
        CartefideliteCRUD abonnementCRUD = new CartefideliteCRUD();
        List<cartefidelite>list2=abonnementCRUD.affichercarte();
        for(int i=0; i<list2.size();i++)
        {cartefidelite a =list2.get(i);
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
    cartefidelite selectedEntity = listView.getSelectionModel().getSelectedItem();

    // Check if an entity is selected
    if (selectedEntity != null) {

        // Display a dialog to edit the selected entity
        Dialog<cartefidelite> dialog = new Dialog<>();
        dialog.setTitle("Edit Entity");
        dialog.setHeaderText("Edit the selected entity:");

        // Set the dialog content
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

    

      TextField typeField = new TextField(selectedEntity.getPointMerci());
grid.add(new Label("Point Merci:"), 0, 0);
grid.add(typeField, 1, 0);


        TextField id_cfField = new TextField();
        grid.add(new Label("ID carte:"), 0, 2);
        grid.add(id_cfField, 1, 2);

        dialog.getDialogPane().setContent(grid);

        // Add buttons to the dialog
        ButtonType saveButtonType = new ButtonType("Save", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        // Set the result converter for the dialog
dialog.setResultConverter(dialogButton -> {
    if (dialogButton == saveButtonType) {
        // If the Save button is clicked, update the selected entity
        selectedEntity.setPointMerci(typeField.getText());
        return selectedEntity;
    }
    return null;
});
        // Show the dialog and wait for the user's input
        Optional<cartefidelite> result = dialog.showAndWait();

        // If the user clicked the Save button, update the entity in the list view and the database
        result.ifPresent(entity -> {
            // Update the entity in the list view
            listView.refresh();

            // Prompt the user for the id_cf value
            TextInputDialog id_cfInputDialog = new TextInputDialog();
            id_cfInputDialog.setTitle("Enter ID");
            id_cfInputDialog.setHeaderText("Please enter the card's ID value:");
            Optional<String> id_cfResult = id_cfInputDialog.showAndWait();

            // If the user entered an id_cf value, update the entity in the database
            id_cfResult.ifPresent(id_cf -> {
                int id_cfInt = Integer.parseInt(id_cf);
   
            CartefideliteCRUD cartefideliteCRUD = new CartefideliteCRUD();
            cartefideliteCRUD.modifiercarte(selectedEntity, id_cfInt);
            });
            Alert alert = new Alert(AlertType.INFORMATION);

        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("card updated successfully!");
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
    private void back_btn(MouseEvent event) {
    }

    @FXML
    private void supprimerabonnement(ActionEvent event) {
    }
    
}
