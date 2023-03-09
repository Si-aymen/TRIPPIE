package edu.webuild.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LastFmClient {
    private static final String API_KEY = "04fff53e0ce3de1671269c0c97c436a2";
    private static final String API_BASE_URL = "http://ws.audioscrobbler.com/2.0/";

    public JSONArray searchTrack(String query) throws IOException, JSONException {
        String url = String.format("%s?method=track.search&track=%s&api_key=%s&format=json", API_BASE_URL,
                query.replaceAll(" ", "+"), API_KEY);

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("GET");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = rd.readLine()) != null) {
            response.append(line);
        }

        rd.close();

        JSONObject json = new JSONObject(response.toString());
        JSONObject results = json.getJSONObject("results");
        return results.getJSONObject("trackmatches").getJSONArray("track");
    }
}
