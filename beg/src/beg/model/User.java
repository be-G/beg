package beg.model;


import java.io.Serializable;

public class User implements Serializable {

    private int state;
    private String name;
    private String description;
    private float distance;

    public User(int state, String name, float distance, String description){
        this.state = state;
        this.name = name;
        this.description = description;
        this.distance = distance;
    }

    public String getName() {return name;}

    public String getDescription() {return description;}

    public int getState() {return state;}

    public float getDistance() {return distance;}
}
