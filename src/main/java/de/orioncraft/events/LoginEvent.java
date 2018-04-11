package de.orioncraft.events;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.Scanner;

public class LoginEvent implements Listener {
    static boolean isLive = false;


    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        if (!e.getPlayer().hasPermission("livestreamchecker.join")) {
            try {
                String channelId = "UClu8v8jbCAJ7PlVR8uhQhtA";
                URL url = new URL("https://www.googleapis.com/youtube/v3/search?part=snippet&channelId=" + channelId + "&type=video&eventType=live&key=AIzaSyDk1gXj2uFbrqSL7Wj8zzUMO_2XKYxKTVM");
                Scanner scan = new Scanner(new BufferedInputStream(url.openStream()));
                String JsonString = "";
                do {
                    JsonString += scan.next() + "\n";
                } while (scan.hasNext());
                scan.close();
                System.out.println(JsonString);

                JsonObject json = (JsonObject) new JsonParser().parse(JsonString);
                if (json.getAsJsonArray("items").size() > 0) {
                    if (json.getAsJsonArray("items").get(0).getAsJsonObject().getAsJsonObject("snippet").get("liveBroadcastContent").getAsString().equals("live")) {
                        isLive = true;
                    }

                }
                if(!isLive){
                    e.getPlayer().kickPlayer("ssad");
                }

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
