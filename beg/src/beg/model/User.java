package beg.model;


import java.io.Serializable;

public class User implements Serializable {

    private int color;
    private String name;
    private String description;
    private float distance;

    public User(int color, String name, float distance, String description){
        this.color = color;
        this.name = name;
        this.description = description;
        this.distance = distance;
    }

    public String getName() {return name;}

    public String getDescription() {return description;}

    public int getColor() {return color;}

    public float getDistance() {return distance;}
}
