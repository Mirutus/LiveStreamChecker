package de.orioncraft.utils;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.HashMap;

public class Config {
    public static File file = new File("plugins//YoutubeUtilities//SubCounters.json");
    public static C count;
    public static void main(String[] args){
        new Config();
    }
    public Config(){
        try {
            if(!file.exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
                count = new C(new HashMap<>());

                save();
            }
            count = (C) new Gson().fromJson(new JsonParser().parse(new BufferedReader(new FileReader(file))), C.class);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save(){
        try {
            for(Counter sss : count.getH().values()){
            }
            PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            p.print(new Gson().toJson(count));
            p.flush();
            p.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        try {
            file.createNewFile();

            count = (C) new Gson().fromJson(new JsonParser().parse(new BufferedReader(new FileReader(file))), C.class);
            if(count.getH()==null){
                count =new C(new HashMap<>());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
