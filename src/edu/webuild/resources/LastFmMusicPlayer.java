package edu.webuild.resources;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LastFmMusicPlayer {
    private final LastFmClient client;

    public LastFmMusicPlayer() {
        client = new LastFmClient();
    }

    public void playTrack(JSONArray tracks, double volume) throws IOException, JSONException {
    if (tracks.length() > 0) {
        JSONObject track = tracks.getJSONObject(0);
        String artist = track.getString("artist");
        String title = track.getString("name");
        String url = track.getString("url");
        String streamUrl = track.getJSONArray("streamable").getJSONObject(0).getString("#text");

        System.out.println(String.format("Playing \"%s\" by %s", title, artist));

        Media sound = new Media(streamUrl);
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    } else {
        System.out.println("No tracks found for query.");
    }
}

}
