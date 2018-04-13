package de.orioncraft.commands;

import de.orioncraft.utils.Config;
import de.orioncraft.utils.Counter;
import de.orioncraft.utils.SubCount;
import de.orioncraft.utils.YoutubeApi;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class subcount implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(args.length > 0){
                if(args[0].equalsIgnoreCase("create")){
                    if(p.hasPermission("createSubCount")){
                        if(args.length>2){
                            Counter c = new Counter(p.getLocation(), YoutubeApi.getChannelIdByUsername(args[2]), args[2], Material.DIAMOND_BLOCK, args[1]);
                            p.sendMessage(c.getChannelId()+"\n"+c.getName()+"\n"+c.getUsername()+"\n"+c.getM()+"\n"+c.getL());
                            SubCount.addSubCount(c);
                        }
                    }
                }else if(args[0].equalsIgnoreCase("delete")){
                    Config.count.getH().get(args[1]).delete();
                    SubCount.start();

                }
            }



        }else{
            commandSender.sendMessage("Du musst ein Spieler sein");
        }

        return true;
    }
}
