package org.bot.model;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import org.bot.config.CrunchifyGetPropertyValues;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Holder for both the player and a track scheduler for one guild.
 */
public class GuildMusicManager {
    /**
     * Audio player for the guild.
     */
    public final AudioPlayer player;
    /**
     * Track scheduler for the player.
     */
    public final TrackScheduler scheduler;

    /**
     * Get private config
     */
    private final CrunchifyGetPropertyValues config;

    /**
     * Creates a player and a track scheduler.
     *
     * @param manager Audio player manager to use for creating the player.
     */
    public GuildMusicManager(AudioPlayerManager manager) {
        player = manager.createPlayer();
        scheduler = new TrackScheduler(player);
        player.addListener(scheduler);
        config = new CrunchifyGetPropertyValues();
    }

    /**
     * @return Wrapper around AudioPlayer to use it as an AudioSendHandler.
     */
    public AudioPlayerSendHandler getSendHandler() {
        return new AudioPlayerSendHandler(player);
    }

    public void searchOnYouTube(String searchKeyword) throws IOException {
        String keyword = searchKeyword.replace(" ", "+");
        String URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&q=" + keyword + "&key=" + config.getAPIkey();
        Document doc = Jsoup.connect(URL).timeout(10 * 1000).ignoreContentType(true).get();

        String getJson = doc.text();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) new JSONTokener(getJson).nextValue();
            Object json2 = jsonObject.getJSONArray("items").get(0);
            Class<?> clazz = json2.getClass();

            Field field = clazz.getField("videoId");
            Object fieldValue = field.get(json2);
            System.out.println(fieldValue);
        } catch (JSONException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
