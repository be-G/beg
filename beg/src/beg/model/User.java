package beg.model;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class User implements Serializable {

    private String state;
    private String name;
    private String description;
    private float distance;

    public User(String state, String name, float distance, String description){
        this.state = state;
        this.name = name;
        this.description = description;
        this.distance = distance;
    }

    public User(JSONObject jsonObject) {
        try {
            this.state = jsonObject.getString("state");
            this.name = jsonObject.getString("name");
            this.description = jsonObject.getString("description");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.distance = 20;
    }

    public String getName() {return name;}

    public String getDescription() {return description;}

    public String getState() {return state;}

    public float getDistance() {return distance;}
}
