package de.orioncraft.utils;

import java.util.Arrays;
import java.util.HashMap;

public class C{
    public void setH(HashMap<String, Counter> h) {
        this.h = h;
    }

    private HashMap<String, Counter> h;

    public C(HashMap<String, Counter> h) {
        setH(h);
    }

    public HashMap<String, Counter> getH() {
        return h;

    }

    public void delete(String s){
        h.remove(s);
    }

    public void add(String s, Counter c){
        h.put(s, c);
    }


}
