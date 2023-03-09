package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceParticipation;
import edu.webuild.model.Participation;
import edu.webuild.services.ParticipationCrud;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Part_cov_backController implements Initializable {

    @FXML
    private Label nmbr_place_Lab;
    @FXML
    private ChoiceBox<Integer> nmbr_place_part;
    private final Integer[] nmbr_place_list = {1, 2, 3, 4, 5, 6};

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nmbr_place_part.getItems().addAll(nmbr_place_list);

        nmbr_place_Lab.setText(Show_cov_backController.nmbr_place);
        // TODO
    }

    @FXML
    private void add_part(ActionEvent event) {
        int nmbr_place_prat = nmbr_place_part.getValue();
        System.out.println(Show_cov_backController.id_co);
        InterfaceParticipation inter_part = new ParticipationCrud();
        Participation part = new Participation(nmbr_place_prat, Integer.parseInt(Show_cov_backController.nmbr_place));
        int nmbr_place_cov =  Integer.parseInt(Show_cov_backController.nmbr_place);

        if (nmbr_place_prat > nmbr_place_cov) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("la nmbr des place est incorrect ");
            alert.show();
        } else if ((nmbr_place_prat < nmbr_place_cov) || (nmbr_place_prat > 0)) {
            inter_part.ajouterParticipation(part);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Participation insérée avec succés!");
            alert.show();

        }

        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Back/Show_cov_back.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void back_btn(MouseEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Back/Show_cov_back.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
