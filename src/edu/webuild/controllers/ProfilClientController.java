/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.frog.Menu;
import edu.webuild.interfaces.InterfaceClientCRUD;
import edu.webuild.model.Client;
import edu.webuild.model.Role;
import edu.webuild.services.ClientCRUD;
import edu.webuild.services.reclamationCRUD;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import edu.webuild.controllers.Main;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProfilClientController implements Initializable {

    public static int client_id;
    public static int var_client_id;
    private Pane root;
    private Button startButton;
    private Button howItWorksButton;
    private AnimationTimer timer;

    private Label quoteLabel;
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

    public static int id_util;

    public static Role role = new Role();

    public void setEmail_lbl(String email) throws SQLException, IOException {
        this.email_lbl.setText(email);
        ClientCRUD u = new ClientCRUD();
        Client p = u.getClient(email);
        client_id = p.getId_client();
        System.out.println("client id " + client_id);
        email_lbl.setText(email);
        nom_lbl.setText(p.getId_role().getId_user().getNom());
        genre_lbl.setText(p.getId_role().getId_user().getPrenom());
        String fullurl = "C:\\xampp\\htdocs\\" + p.getImg();
        File file = new File(fullurl);
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
        System.out.println("client id " + client_id);

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

    private void cov_btu(MouseEvent event) {
        System.out.println("now 2");
        System.out.println("client id " + client_id);
        var_client_id = client_id;

        try {
            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Front/Market_cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProfilClientController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void RentCar(MouseEvent event) {
        System.out.println("now 2");
        System.out.println("client id " + client_id);
        var_client_id = client_id;

        try {
            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Market_voitureclientfront.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProfilClientController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void Reclamation(MouseEvent event) throws IOException {

        id_util = client_id;

        Client cl = new Client();

        reclamationCRUD rc = new reclamationCRUD();

        cl = rc.getByIdClient(id_util);

        role = cl.getId_role();

        Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Rec_Front.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Game(MouseEvent event) throws Exception {
        Menu main = new Menu();
        main.start(new Stage());
    }

    @FXML
    private void Wheel(MouseEvent event) {
        Main main = new Main();
          main.start(new Stage());
    }

}
