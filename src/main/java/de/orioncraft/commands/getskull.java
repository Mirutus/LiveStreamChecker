package de.orioncraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.map.MinecraftFont;
import de.orioncraft.utils.YoutubeApi;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class getskull implements CommandExecutor {

    private static HashMap<String, Image> images = new HashMap<>();
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            if(!images.containsKey(args[0])){
                images.put(args[0], YoutubeApi.getProfilePictureByChannelId(YoutubeApi.getChannelIdByUsername(args[0])));
            }
            Player p = (Player) sender;
            p.sendMessage("sasd");
            ItemStack is = new ItemStack(Material.MAP,1);
            MapView map = Bukkit.createMap(Bukkit.getServer().getWorlds().get(0));
            for(MapRenderer r :map.getRenderers())
                map.removeRenderer(r);

            map.addRenderer(new MapRenderer() {
                @Override
                public void render(MapView mapView, MapCanvas mapCanvas, Player player) {
                    try {

                        mapCanvas.drawText(1, 1, MinecraftFont.Font, args[0]);
                        mapCanvas.drawImage(1, 9,  images.get(args[0]));
                    }catch (Exception e){
                      //  e.printStackTrace();
                    }
                }
            });
            is.setDurability(map.getId());
            p.getInventory().addItem(is);

        }else{
            sender.sendMessage("Du musst ein Spieler sein");
        }
        return true;
    }
    public static BufferedImage scale(BufferedImage imageToScale, int dWidth, int dHeight) {
        BufferedImage scaledImage = null;
        if (imageToScale != null) {
            scaledImage = new BufferedImage(dWidth, dHeight, imageToScale.getType());
            Graphics2D graphics2D = scaledImage.createGraphics();
            graphics2D.drawImage(imageToScale, 0, 0, dWidth, dHeight, null);
            graphics2D.dispose();
        }
        return scaledImage;
    }
}
