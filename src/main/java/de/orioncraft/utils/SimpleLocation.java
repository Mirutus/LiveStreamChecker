package de.orioncraft.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.Serializable;

public class SimpleLocation implements Serializable {

    String world;
    double x;
    double z;
    double y;

    public SimpleLocation(Location loc){
        world=loc.getWorld().getName();
        x=loc.getX();
        z=loc.getZ();
        y=loc.getY();
    }

    public Location getLocation(){
        return new Location(Bukkit.getWorld(world), x, y, z);
    }

}
