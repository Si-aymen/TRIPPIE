package edu.webuild.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Weather_covController implements Initializable {

    private static final String API_KEY = "c254001f0f2a23d71745d80d4fd561bc";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    @FXML
    private Label temperatureLabel;
    @FXML
    private Label weatherLabel;
    @FXML
    private TextField cityInput;
    @FXML
    private TextArea weatherText;

    public void setWeather() throws MalformedURLException, IOException {
        String city = cityInput.getText();
        String apiUrl = String.format(API_URL, city, API_KEY);

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);

        }

        // Parse the JSON response to extract the weather information
        JSONObject jsonObj;
        jsonObj = new JSONObject(response.toString());

        JSONObject mainObj = jsonObj.getJSONObject("main");

        JSONArray weatherArr = jsonObj.getJSONArray("weather");

        JSONObject weatherObj = weatherArr.getJSONObject(0);

        String temperature = String.valueOf(mainObj.getDouble("temp"));
        String weather = weatherObj.getString("description");

        // Update the UI with the weather information
        temperatureLabel.setText("Temperature: " + temperature);
        weatherLabel.setText("Weather: " + weather);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize method is empty as there's nothing to do on initialization
    }

    @FXML
    private void getWeatherData(ActionEvent event) {
        try {
            setWeather();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
