package com.javarush.gaidamashko.data;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private static final String rus = "ЁЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
    private static final String lat = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String symbols = "\n.,\"><:;-!? ";

    public static final char[] chars = (lat + lat.toLowerCase() + rus + rus.toLowerCase() + symbols).toCharArray();
    public final static Map<Character, Integer> index = new HashMap<>();

    static {
        for (int i = 0; i < chars.length; i++) {
            index.put(chars[i], i);
        }
    }
}
