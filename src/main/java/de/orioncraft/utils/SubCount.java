package de.orioncraft.utils;

import de.orioncraft.Main;
import net.minecraft.server.v1_12_R1.EnumDirection;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class SubCount {
    public static void addSubCount(Counter c) {

        Config.count.add(
                c.getName()
                , c);
        Main.config.save();
        start();

    }

    static List<BukkitTask> runnables = new ArrayList<>();

    public static void start() {
        for (BukkitTask i : runnables) {
            i.cancel();
        }
        runnables.clear();
        for (Counter co : Config.count.getH().values()) {
            runnables.add(co.start());

        }

    }

    private static int a = -2;
    public static void countCube(Location loc, int subs, String username) {
        Location l = loc.clone();

        double x = 0.0;
        double z = 0.0;
        switch (EnumDirection.fromAngle(90.0F * a)) {
            case NORTH:
                x = 1;
                break;
            case WEST:
                z = -1;
                break;
            case EAST:
                z = 1;
                break;
            case SOUTH:
                x = -1;
                break;

            default:
                break;
        }
        int length = getBlockLength(String.valueOf(subs));

        l = l.add(x * length / 2, 0.0, z * length / 2);
        l = l.add(z * length / 2, 0.0, -x * length / 2);
        int i = 0;
        int j = 0;
        int le = 2;
        int len = 0;
        for (char c : (subs + "").toCharArray()) {
            List<char[]> list = new ArrayList<>();
            for (int is = numbers.getByChar(c).getValue().length - 1; is >= 0; is--) {
                list.add(numbers.getByChar(c).getValue()[is]);
            }
            for (char[] n : list) {

                for (char m : n) {
                    Block b = l.getWorld().getBlockAt((int) (l.getBlockX() + -x * i + -x * le), l.getBlockY() + j, (int) (l.getBlockZ() + -z * i + -z * le));
                    if (m == 'x') {
                        Bukkit.getScheduler().runTask(Main.main, new Runnable() {
                            @Override
                            public void run() {
                                b.setType(Material.GOLD_BLOCK);
                                b.setMetadata("isCounterBlock", new FixedMetadataValue(Main.main, "true"));

                            }
                        });
                    } else if (m == 'o') {
                        Bukkit.getScheduler().runTask(Main.main, new Runnable() {
                            @Override
                            public void run() {
                                b.setType(Material.AIR);

                            }
                        });
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
        if (a < 1) {
            a++;
            countCube(loc, subs, username);
        } else {
            a = -2;
        }
    }


    static int getBlockLength(String s) {
        int length = 2;
        for (char c : s.toCharArray()) {
            length += numbers.getByChar(c).getLength() + 1;
        }
        return length;
    }

}
