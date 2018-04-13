package de.orioncraft.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YoutubeApi {
    public static String getChannelIdByUsername(String Username){
        try {
            URL url = new URL("https://www.googleapis.com/youtube/v3/search?type=channel&q="+ Username +"&part=snippet&key=AIzaSyDk1gXj2uFbrqSL7Wj8zzUMO_2XKYxKTVM");
            URLConnection s =url.openConnection();
            s.connect();
            Scanner scan = new Scanner(new BufferedInputStream(s.getInputStream()));
            String JsonString = "";
            do {
                JsonString += scan.next() + "\n";
            } while (scan.hasNext());
            scan.close();

            JsonObject json = (JsonObject) new JsonParser().parse(JsonString);
            if (json.getAsJsonArray("items").size() > 0) {
                List<String> l = new ArrayList<>();

                for(JsonElement ob : json.getAsJsonArray("items")){
                    if(ob.getAsJsonObject().getAsJsonObject("snippet").get("channelTitle").getAsString().equalsIgnoreCase(Username)){
                        return ob.getAsJsonObject().getAsJsonObject("snippet").get("channelId").getAsString();
                    }
                }


            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return "";
    }
    public static int getSubCount(String channelId){
        try {
            URL url = new URL("https://www.googleapis.com/youtube/v3/channels?part=statistics&id="+channelId+"&key=AIzaSyDk1gXj2uFbrqSL7Wj8zzUMO_2XKYxKTVM");
            URLConnection s =url.openConnection();
            s.connect();
            Scanner scan = new Scanner(new BufferedInputStream(s.getInputStream()));
            String JsonString = "";
            do {
                JsonString += scan.next() + "\n";
            } while (scan.hasNext());
            scan.close();

            JsonObject json = ((JsonObject) new JsonParser().parse(JsonString)).get("items").getAsJsonArray().get(0).getAsJsonObject();
            return Integer.valueOf(json.get("statistics").getAsJsonObject().get("subscriberCount").getAsString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Image getProfilePictureByChannelId(String channelId){
        try {
            URL url = new URL("https://www.googleapis.com/youtube/v3/channels?part=snippet&id="+channelId+"&key=AIzaSyDk1gXj2uFbrqSL7Wj8zzUMO_2XKYxKTVM");
            URLConnection s =url.openConnection();
            s.connect();
            Scanner scan = new Scanner(new BufferedInputStream(s.getInputStream()));
            String JsonString = "";
            do {
                JsonString += scan.next() + "\n";
            } while (scan.hasNext());
            scan.close();

            JsonObject json = ((JsonObject) new JsonParser().parse(JsonString)).get("items").getAsJsonArray().get(0).getAsJsonObject().get("snippet").getAsJsonObject().get("thumbnails").getAsJsonObject().get("high").getAsJsonObject();
            Image i = ImageIO.read(new URL(json.get("url").getAsString().replace("s800","s126")));
            return  i;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isLive(String channelId){
        try {
            URL url = new URL("https://www.googleapis.com/youtube/v3/search?part=snippet&channelId="+channelId+"&type=video&eventType=live&key=AIzaSyDk1gXj2uFbrqSL7Wj8zzUMO_2XKYxKTVM");
            URLConnection s =url.openConnection();
            s.connect();
            Scanner scan = new Scanner(new BufferedInputStream(s.getInputStream()));
            String JsonString = "";
            do {
                JsonString += scan.next() + "\n";
            } while (scan.hasNext());
            scan.close();

            JsonObject json = (JsonObject) new JsonParser().parse(JsonString);
            if (json.getAsJsonArray("items").size() > 0) {
                if (json.getAsJsonArray("items").get(0).getAsJsonObject().getAsJsonObject("snippet").get("liveBroadcastContent").getAsString().equals("live")) {
                    return true;
                }

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
