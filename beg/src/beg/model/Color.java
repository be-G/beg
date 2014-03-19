package beg.model;

import beg.activity.R;

import java.util.HashMap;

public class Color {

    private static int BLUE = R.drawable.sphere_blue;
    private static int YELLOW = R.drawable.sphere_yellow;
    private static int ORANGE = R.drawable.sphere_orange;
    private static int RED = R.drawable.sphere_red;

    private static HashMap<String, Integer> colorMap = new HashMap<String, Integer>();

    static {
        colorMap.put("BLUE",BLUE);
        colorMap.put("YELLOW",YELLOW);
        colorMap.put("ORANGE",ORANGE);
        colorMap.put("RED",RED);
    }

    public static int getMarbleResource(String color)
    {
        return colorMap.get(color);
    }

}
