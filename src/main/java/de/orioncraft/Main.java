package de.orioncraft;

import de.orioncraft.commands.getskull;
import de.orioncraft.commands.subcount;
import de.orioncraft.events.BlockBreakEvent;
import de.orioncraft.events.MapInitializeEvent;
import de.orioncraft.events.TabCompleteEvent;
import de.orioncraft.utils.Config;
import de.orioncraft.utils.SubCount;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main main;
    public static Config config;

    @Override
    public void onEnable() {
        config = new Config();
        main = (Main) this.getServer().getPluginManager().getPlugin("YoutubeLiveStreamChecker");
        config.load();
        SubCount.start();









        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {

    }

    public void registerCommands(){
        getCommand("skull").setExecutor(new getskull());
        getCommand("subcount").setExecutor(new subcount());

    }

    public void registerEvents(){
        PluginManager pm = getServer().getPluginManager();
        //pm.registerEvents(new LoginEvent(), this);
        pm.registerEvents(new MapInitializeEvent(), this);
        pm.registerEvents(new TabCompleteEvent(), this);
        pm.registerEvents(new BlockBreakEvent(), this);
    }
}
