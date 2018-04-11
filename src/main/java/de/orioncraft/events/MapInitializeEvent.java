package de.orioncraft.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class MapInitializeEvent implements Listener {
    @EventHandler
    public void oninit(org.bukkit.event.server.MapInitializeEvent e){
        for(MapRenderer r :e.getMap().getRenderers())
            e.getMap().removeRenderer(r);

        e.getMap().addRenderer(new MapRenderer() {
            @Override
            public void render(MapView mapView, MapCanvas mapCanvas, Player player) {
                Image i= null;
                try {
                    i = ImageIO.read(new URL("https://yt3.ggpht.com/-Odn-BrNMHNg/AAAAAAAAAAI/AAAAAAAAAAA/BT3_uPMoBdc/s240-c-k-no-mo-rj-c0xffffff/photo.jpg"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                mapCanvas.drawImage(0,0, i);

            }
        });
    }
}
