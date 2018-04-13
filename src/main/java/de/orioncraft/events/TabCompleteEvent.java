package de.orioncraft.events;

import de.orioncraft.utils.Config;
import de.orioncraft.utils.Counter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabCompleteEvent implements Listener {
    @EventHandler
    public void onTabComplete(org.bukkit.event.server.TabCompleteEvent e){
        String[] s = e.getBuffer().split(" ");
        e.getSender().sendMessage(e.getBuffer()+"asdisdaio");
        if(e.getBuffer().endsWith(" ")){
            List<String> li = new ArrayList<>();
            e.getSender().sendMessage("jajja");
            for(String str : s){
                li.add(str);
            }
            li.add(" ");
            String st = "";
            for (String str : li){
                st+=str+"\n";
            }
            s=st.split("\n");
            e.getSender().sendMessage(st.replace("\n", "\nhaha"));
        }
        e.getSender().sendMessage(Arrays.toString(s));
        e.getSender().sendMessage(s.length+"");
        if(s.length > 1){
            if(s[0].equalsIgnoreCase("/subcount")){
                List<String> l = new ArrayList<>();
                e.getSender().sendMessage("HI");
                switch (s.length){
                    case 2:
                        String[] strings = new String[]{"create", "delete", "modify", "reload"};
                        e.getSender().sendMessage(Arrays.toString(strings));
                        for (String string : strings){
                            e.getSender().sendMessage(string);
                            if(string.startsWith(s[1])|s[1].equals(" ")){
                                l.add(string);
                            }
                        }

                        break;

                    case 3:
                        switch (s[1]){


                            case "delete":
                                for(Counter st : Config.count.getH().values()){
                                    e.getSender().sendMessage(st.getName());
                                    if(st.getName().startsWith(s[1])|s[1].equals(" ")){
                                        l.add(st.getName());
                                    }
                                }
                                break;
                            case "modify":
                                for(Counter st : Config.count.getH().values()){
                                    e.getSender().sendMessage(st.getName());
                                    if(st.getName().startsWith(s[1])|s[1].equals(" ")){
                                        l.add(st.getName());
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                        break;

                    case 4:

                        break;

                    default:
                        e.getSender().sendMessage("Ne");
                        break;
                }
                e.getSender().sendMessage(Arrays.toString(l.toArray()));
                e.setCompletions(l);
            }
        }
    }
}
