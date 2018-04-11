package de.orioncraft.commands;

import de.orioncraft.utils.YoutubeApi;
import de.orioncraft.utils.numbers;
import net.minecraft.server.v1_12_R1.EnumDirection;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class subcount implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            countCube(p, YoutubeApi.getSubCount(YoutubeApi.getChannelIdByUsername(strings[0])));
            p.teleport(p.getLocation().add(0.0,10,0.0));
            countCube(p, 155);
            p.teleport(p.getLocation().add(0.0,10,0.0));
            countCube(p, 455);
            p.teleport(p.getLocation().add(0.0,10,0.0));
            countCube(p, 555);
            p.teleport(p.getLocation().add(0.0,10,0.0));
            countCube(p, 115);
            p.teleport(p.getLocation().add(0.0,10,0.0));
            countCube(p, 111);

        }else{
            commandSender.sendMessage("Du musst ein Spieler sein");
        }

        return true;
    }
    int a = -2;
    public void countCube(Player p, int subs){

        p.sendMessage("a");
        Location l = p.getLocation();

        double x = 0.0;
        double z = 0.0;
        switch (EnumDirection.fromAngle(90.0F*a)){
            case NORTH:
                x=1;
                break;
            case WEST:
                z=-1;
                break;
            case EAST:
                z=1;
                break;
            case SOUTH:
                x=-1;
                break;

            default:
                break;
        }
        int length = getBlockLength(subs);
        System.out.println(length);

        p.sendMessage(String.valueOf(90.0F*a));
        l = l.add(x*length/2, 0.0, z*length/2);
        l = l.add(z*length/2, 0.0, -x*length/2);
        int i = 0;
        int j = 0;
        int le = 2;
        int len = 0;
        for(char c :(subs+"").toCharArray()) {
            List<char[]> list = new ArrayList<>();
            for (int is = numbers.getByInt(Integer.valueOf(c + "")).getValue().length - 1; is >= 0; is--) {
                list.add(numbers.getByInt(Integer.valueOf(c + "")).getValue()[is]);
            }
            for (char[] n : list) {

                for (char m : n) {
                    Block b = l.getWorld().getBlockAt((int) (l.getBlockX() + -x * i + -x * le), l.getBlockY() + j, (int) (l.getBlockZ() + -z * i + -z * le));
                    if (m == 'x') {
                        b.setType(Material.GOLD_BLOCK);
                    } else if (m == 'o') {
                        b.setType(Material.AIR);
                    }
                    i++;
                }
                j++;
                len = i;
                i = 0;
            }
            le += len + 1;
            len = 0;
            j = 0;
        }
        p.sendMessage("c");
        if(a<1){
            a++;
            countCube(p, subs);
        }else{
            a=-2;
        }
    }

    int getBlockLength(int subs){
        int length = 2;
        for (char c :String.valueOf(subs).toCharArray()) {
            length += numbers.getByInt(Integer.valueOf(c+"")).getLength() + 1;
        }
        System.out.println(length);
        return length;
    }
}
