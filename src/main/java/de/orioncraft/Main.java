package de.orioncraft;

import de.orioncraft.commands.getskull;
import de.orioncraft.commands.subcount;
import de.orioncraft.events.MapInitializeEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main main;

    @Override
    public void onEnable() {
        main = (Main) this.getServer().getPluginManager().getPlugin("YoutubeLiveStreamChecker");











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
    }
}
