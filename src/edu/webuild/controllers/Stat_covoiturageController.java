package edu.webuild.controllers;

import edu.webuild.interfaces.InterfaceCoVoiturage;
import edu.webuild.services.CoVoiturageCRUD;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class Stat_covoiturageController implements Initializable {

    @FXML
    private TextField search_bar;
    @FXML
    private PieChart pie;
    @FXML
    private PieChart pie2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PieChart pieChart = pie;
        PieChart pieChart2 = pie2;
        Connection conn = MyConnection.getInstance().getConn();
        InterfaceCoVoiturage inter_co = new CoVoiturageCRUD();
        //nmbr_cov.setText(inter_co.count_CoVoiturage());

        // Retrieve data from the database
        List<PieChart.Data> data = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT depart, COUNT(*) as count FROM co_voiturage GROUP BY depart");
            while (rs.next()) {
                data.add(new PieChart.Data(rs.getString("depart"), rs.getInt("count")));
            }
            // conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create the pie chart and add the data to it
        pie.getData().addAll(data);

        // Set the title of the pie chart
        pieChart.setTitle("Departure Locations");

        // Retrieve data from the database
        List<PieChart.Data> data2 = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            System.out.println("ok");
            ResultSet rs2 = stmt.executeQuery("SELECT destination, COUNT(*) as count FROM co_voiturage GROUP BY destination");
            while (rs2.next()) {
                data2.add(new PieChart.Data(rs2.getString("destination"), rs2.getInt("count")));
            }
            //conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create the pie chart and add the data to it
        pie2.getData().addAll(data2);

        // Set the title of the pie chart
        pieChart2.setTitle("Destination Locations");

        System.out.println(inter_co.count_CoVoiturage());
    }

}
