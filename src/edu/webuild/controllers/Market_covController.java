package edu.webuild.controllers;

import edu.webuild.controllers.Item_covController.MyListener;
import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.model.CoVoiturage;
import edu.webuild.services.CoVoiturageCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import edu.webuild.controllers.Menu_CoVoiturageController;

public class Market_covController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label fruitNameLable;
    @FXML
    private Label fruitPriceLabel;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    private List<CoVoiturage> covDataList = FXCollections.observableArrayList();
    private InterfaceCoVoiturage coVoiturageCRUDService = new CoVoiturageCRUD();
    @FXML
    private TextField search_bar;
    @FXML
    private ImageView det_cov_img;
    @FXML
    private Label det_dep;
    @FXML
    private Label det_dest;

    private MyListener myListener;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("hello");
        covDataList.addAll(coVoiturageCRUDService.afficherCoVoiturage());
        System.out.println("load data");
        if (covDataList.size() > 0) {
            setChosenCov(covDataList.get(0));
            myListener = new MyListener() {
                @Override
                public void onClick(CoVoiturage cov) {
                    System.out.println("mouse clicked");
                    setChosenCov(cov);
                }
            };
        }

        int column = 0;
        int row = 3;
        for (int i = 0; i < covDataList.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/Item_cov.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                Item_covController item = fxmlLoader.getController();
                System.out.println("cov details name " + covDataList.get(i).getDepart() + " url : C:\\xampp\\htdocs\\image_trippie_cov\\" + covDataList.get(i).getCov_img());
                item.setData(covDataList.get(i).getDepart(), covDataList.get(i).getDestination(), covDataList.get(i).getDate_dep(), covDataList.get(i).getCov_img(), Integer.toString(covDataList.get(i).getNmbr_place()));
                //item.setData(covDataList.get(i).getDepart(), covDataList.get(i).getDestination(), covDataList.get(i).getDate_dep());

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                System.out.println("problem");
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void search_btu(ActionEvent event) {
    }

    @FXML
    private void details_btu(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Details_Cov.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu_CoVoiturageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void setChosenCov(CoVoiturage co) {
        det_dep.setText(co.getDepart());
        det_dest.setText(co.getDestination());

    }

}
