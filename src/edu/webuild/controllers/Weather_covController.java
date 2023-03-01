package edu.webuild.controllers;

import edu.webuild.model.APIConnector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.json.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Weather_covController implements Initializable {

    @FXML
    private TextField cityInput;

    @FXML
    private TextArea weatherText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
//
//    private final String cityAPI = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=de35640ce835464292a140436230103";
//    private final String weatherAPI = "https://api.openweathermap.org/data/2.5/weather?id=%s&appid=de35640ce835464292a140436230103";

    private final String cityAPI = "https://www.metaweather.com/api/location/search/?query=";
    private final String weatherAPI = "https://www.metaweather.com/api/location/";

    @FXML
    private void getWeatherData(ActionEvent event) throws MalformedURLException {
        JSONObject todaysWeather = GetTodaysWeatherInformation(getWoeid());

        System.out.println(todaysWeather);

        weatherText.setText(
                "Min temperature: " + todaysWeather.get("min_temp")
                + "\nCurrent temperature: " + todaysWeather.get("the_temp")
                + "\nMax temperature: " + todaysWeather.get("max_temp")
        );
    }

    public String getWoeid() throws MalformedURLException {
        APIConnector apiConnectorCity = new APIConnector(cityAPI);
        System.out.println("City input: " + cityInput.getText());
        JSONArray jsonArray = apiConnectorCity.getJSONArray(cityInput.getText());
        System.out.println("City API response: " + jsonArray);

        JSONObject jsonData = (JSONObject) (apiConnectorCity.getJSONArray(cityInput.getText())).get(0);

        System.out.println("okok");

        return jsonData.get("woeid").toString();
    }

    public JSONObject GetTodaysWeatherInformation(String woeid) throws MalformedURLException {
        APIConnector apiConnectorWeather = new APIConnector(weatherAPI);

        JSONObject weatherJSONObject = apiConnectorWeather.getJSONObject(woeid + "/");

        JSONArray weatherArray = (JSONArray) weatherJSONObject.get("consolidated_weather");

        return (JSONObject) weatherArray.get(0);
    }
}
