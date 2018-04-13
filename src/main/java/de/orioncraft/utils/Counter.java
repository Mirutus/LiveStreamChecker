package de.orioncraft.utils;

import de.orioncraft.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitTask;

import java.io.Serializable;

public class Counter implements Serializable {

    SimpleLocation l;
    String channelId;
    String username;
    Material m;
    String name;
    int id;

    public Counter(Location l, String channelId, String username, Material m, String name){
        this.name = name;
        this.l = new SimpleLocation(l);
        this.channelId = channelId;
        this.username = username;
        this.m = m;
    }

    public Location getL() {
        return l.getLocation();
    }

    public String getChannelId() {
        return channelId;
    }

    public String getUsername() {
        return username;
    }

    public Material getM(){ return m; }

    public String getName() { return name; }

    public BukkitTask start(){
        return Bukkit.getScheduler().runTaskTimerAsynchronously(Main.main, new Runnable() {
            @Override
            public void run() {
                SubCount.countCube(l.getLocation(), YoutubeApi.getSubCount(channelId), username);
            }
        }, 1, 30);
    }

    public void delete(){
        Location loc = l.getLocation().clone();
        int len = (Math.max(SubCount.getBlockLength(String.valueOf(YoutubeApi.getSubCount(channelId))), SubCount.getBlockLength(username))/2)+3;
        loc.add(-len, -2.0, -len);
        for(int x = 0; x<= len*2; x++){
            for(int z = 0; z<= len*2; z++){
                for(int y = 0; y<= len*2; y++){
                    Block b = loc.clone().add(x, y, z).getBlock();
                    if(b.hasMetadata("isCounterBlock")){
                        b.removeMetadata("isCounterBlock", Main.main);
                        b.setType(Material.AIR);
                    }
                }
            }
        }
        Config.save();
        Config.count.delete(name);
    }

}
