package uk.co.halfninja.randomnames;

import java.util.Map;
import java.util.HashMap;

public class database { 
    private static HashMap<String, Integer> mathscore = new HashMap<String, Integer>();
    private static HashMap<String, Integer> engscore = new HashMap<String, Integer>();

    public static int geteng(String stname) { 
        return engscore.get(stname);
    }

    public static int getmath(String stname) { 
        return mathscore.get(stname);
    }

    public static void inputengscore(String name, int score) { 
        engscore.put(name, score);
    }

    public static void inputmathscore(String name, int score) { 
        mathscore.put(name, score);
    }
    //
    // =======================================================
}
