package de.orioncraft.utils;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Config {
    public static File file = new File("C:\\Users\\lukas\\Desktop\\h.json");
    public static List<Counter> l;
    public static void main(String[] args){
        new Config();
    }
    public Config(){
        try {
            file.createNewFile();
            l = (List<Counter>) new Gson().fromJson(new JsonParser().parse(new BufferedReader(new FileReader(file))), Counter.class);
            if(l==null){
                l =new ArrayList<>();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(){
        try {
            PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            p.print(new Gson().toJson(l));
            p.flush();
            p.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
