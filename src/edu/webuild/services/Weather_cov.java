/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author manou
 */
public class Weather_cov {

    private static final String API_KEY = "c254001f0f2a23d71745d80d4fd561bc";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    public String setTemp(String cityInput) throws MalformedURLException, IOException {
        String city = cityInput;
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
        String Final_temp = temperature;
        return Final_temp;
        //String final_weather = weather;
    }

    public String setWeather(String cityInput) throws MalformedURLException, IOException {
        String city = cityInput;
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
        //String Final_temp = temperature ;
        String final_weather = weather;
        return final_weather;
    }
}
