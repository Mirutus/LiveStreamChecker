package de.orioncraft.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockBreakEvent implements Listener {
    @EventHandler
    public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent e){
        if(e.getBlock().hasMetadata("isCounterBlock")){
            e.setCancelled(true);
        }
    }
}
