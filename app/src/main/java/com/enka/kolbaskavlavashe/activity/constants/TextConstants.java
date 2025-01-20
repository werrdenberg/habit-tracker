package com.enka.kolbaskavlavashe.activity.constants;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TextConstants {

    public static List<String> citations = new ArrayList<>();

    public static List<String> facts = new ArrayList<>();

    public static void loadConstants(Context context) throws IOException {
        AssetManager assetManager = context.getAssets();

        BufferedReader reader = new BufferedReader(new InputStreamReader(assetManager.open("citations.txt")));
        while (reader.ready()){
            citations.add(reader.readLine());
        }

        reader = new BufferedReader(new InputStreamReader(assetManager.open("facts.txt")));
        while (reader.ready()){
            facts.add(reader.readLine());
        }
        reader.close();
    }

    public static String getRandomCitation(){
        if (citations.isEmpty()){
            return null;
        }
        return citations.get((int)(Math.random() * citations.size()));
    }

    public static String getRandomFact(){
        if (facts.isEmpty()){
            return null;
        }
        return facts.get((int)(Math.random() * facts.size()));
    }

}
