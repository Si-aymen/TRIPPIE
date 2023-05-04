/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceRoleCRUD;
import edu.webuild.services.roleCRUD;
import edu.webuild.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class Stat_utilisateurController implements Initializable {

    @FXML
    private PieChart pie;
  
    @FXML
    private Button cov_btu1;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PieChart pieChart = pie;
        int totalCount = 0;
        Connection conn = MyConnection.getInstance().getConn();
        InterfaceRoleCRUD inter_co = new roleCRUD();
        //nmbr_cov.setText(inter_co.count_CoVoiturage());

        // Retrieve data from the database
        List<PieChart.Data> data = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT libelle, COUNT(*) as count FROM role GROUP BY libelle");
            while (rs.next()) {
                int count = rs.getInt("count");
                totalCount += count;
                data.add(new PieChart.Data(rs.getString("libelle"), rs.getInt("count")));
            }
            // conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Add percentage to the data labels
        for (PieChart.Data slice : data) {
            double percentage = (slice.getPieValue() / totalCount) * 100;
            slice.setName(slice.getName() + " (" + String.format("%.2f", percentage) + "%)");
        }

        // Create the pie chart and add the data to it
        pie.getData().addAll(data);

        // Set the title of the pie chart
        pieChart.setTitle("Roles");

    }

    @FXML
    private void cov_btu(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("/edu/webuild/gui/Menu_User.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ChoixResetController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
