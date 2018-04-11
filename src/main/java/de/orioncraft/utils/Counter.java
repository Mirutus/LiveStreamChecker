package de.orioncraft.utils;

import de.orioncraft.Main;
import org.bukkit.Location;
import org.bukkit.metadata.FixedMetadataValue;

public class Counter {

    Location l;
    String channelId;
    String username;


    public Counter(Location l, String channelId, String username){
        this.l = l;
        this.channelId = channelId;
        this.username = username;
        l.getBlock().setMetadata("isCounterBlock", new FixedMetadataValue(Main.main, "true"));

    }

    public Location getL() {
        return l;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getUsername() {
        return username;
    }

}
