/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.frog.Menu;
import edu.webuild.gui.LoginController;
import edu.webuild.interfaces.InterfaceClientCRUD;
import edu.webuild.model.Client;
import edu.webuild.services.ClientCRUD;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProfilClientController implements Initializable {

    @FXML
    private Button exitBtn;
    @FXML
    private Label nom_lbl;
    @FXML
    private Label email_lbl;
    @FXML
    private Label genre_lbl;
    @FXML
    private Button deco;
    @FXML
    private Button modif;
    static String url;
    @FXML
    private ImageView fximg;
    private List<Client> clientDataList = FXCollections.observableArrayList();

    private InterfaceClientCRUD ClientCRUD = new ClientCRUD();

    public void setEmail_lbl(String email) throws SQLException, IOException {
        this.email_lbl.setText(email);
        // TODO
        ClientCRUD u = new ClientCRUD();
        Client p = u.getClient(email);

        email_lbl.setText(email);
        System.out.println(email);
        nom_lbl.setText(p.getId_role().getId_user().getNom());  // Récupérer l'utilisateur connecté
        genre_lbl.setText(p.getId_role().getId_user().getPrenom());
        String fullurl = "C:\\xampp\\htdocs\\" + p.getImg();
        System.out.println(p.getImg());
        File file = new File(fullurl);
        System.out.println(p.getImg());
        FileInputStream fileInputStream = new FileInputStream(file);
        Image image = new Image(fileInputStream);
        fximg.setImage(image);
        // Créer un objet Circle avec le rayon et la position souhaités
        Circle circle = new Circle();
        circle.setRadius(fximg.getFitWidth() / 2);
        circle.setCenterX(fximg.getFitWidth() / 2);
        circle.setCenterY(fximg.getFitHeight() / 2);

// Utiliser le Circle comme clip
        fximg.setClip(circle);

// Définir la taille de l'ImageView pour qu'elle soit égale au diamètre du cercle
        fximg.setFitWidth(circle.getRadius() * 2);
        fximg.setFitHeight(circle.getRadius() * 2);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//          
//            String email = null;
//            this.email_lbl.setText(email);
//          
//            ClientCRUD u = new ClientCRUD();
//            Client p = u.getClient(email);
//            System.out.println(p);
//            clientDataList.add(p);
//            
//            int column = 0;
//            int row = 3;
//            for (int i = 0; i < clientDataList.size(); i++) {
//                try {
//                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/ClientCardFront.fxml"));
//                    AnchorPane anchorPane = fxmlLoader.load();
//                    
//                    ClientCardFrontController item = fxmlLoader.getController();
//                    
//                    item.setDataClient(clientDataList.get(i).getId_role().getId_user().getNom(),clientDataList.get(i).getId_role().getId_user().getPrenom(), clientDataList.get(i).getImg());
//                    
//                    if (column == 1) {
//                        column = 0;
//                        row++;
//                    }
//                    
//                    grid.add(anchorPane, column++, row);
//                    grid.setMinWidth(Region.USE_COMPUTED_SIZE);
//                    grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
//                    grid.setMaxWidth(Region.USE_PREF_SIZE);
//                    grid.setMinHeight(Region.USE_COMPUTED_SIZE);
//                    grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
//                    grid.setMaxHeight(Region.USE_PREF_SIZE);
//                    
//                    GridPane.setMargin(anchorPane, new javafx.geometry.Insets(10));
//                } catch (IOException e) {
//                    System.out.println("problem");
//                    e.printStackTrace();
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ProfilClientController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    private void exit(ActionEvent event) {
        exitBtn.setOnAction(e -> Platform.exit());
    }

    @FXML
    private void deco(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Login.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProfilClientController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void Update(ActionEvent event) throws SQLException {
        try {
            String email = email_lbl.getText();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/UpdateProfilCl.fxml"));
            Parent root = loader.load();
            UpdateProfilClController controller = loader.getController();
            // set any necessary information in the controller
            email_lbl.getScene().setRoot(root);
            controller.setClient(email);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProfilClientController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void Car_pool_front(MouseEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Front/Market_cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ChoixResetController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void Rent_car_front(MouseEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/marketvoiturefront.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ChoixResetController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void Reclamation(MouseEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Rec_Front.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ChoixResetController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @FXML
    private void Membership_front(MouseEvent event) throws Exception {
        Menu main = new Menu();
        main.start(new Stage());
    }

}
