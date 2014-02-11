package beg.model;


public class User {

    private int color;
    private String name;
    private String description;
    private UserLocation userLocation;
    private boolean hasGPSLocation;
    private UserLocation lastGPSUserLocation;

    public User(int color, String name, UserLocation userLocation, String description, boolean hasGPSLocation){
        this.color = color;
        this.name = name;
        this.description = description;
        this.userLocation = userLocation;
        this.hasGPSLocation = hasGPSLocation;
        this.lastGPSUserLocation = lastGPSUserLocation;
    }

    public UserLocation getLastGPSUserLocation() {return this.lastGPSUserLocation;}

    public void setLastGPSUserLocation(UserLocation lastGPSUserLocation) {this.lastGPSUserLocation = lastGPSUserLocation;}

    public boolean isHasGPSLocation() {return hasGPSLocation;}

    public void setHasGPSLocation(boolean hasGPSLocation) {this.hasGPSLocation = hasGPSLocation;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserLocation getUserLocation() {return userLocation;}

    public void setUserLocation(UserLocation userLocation) {this.userLocation = userLocation;}

    public int getColor() {return color;}

    public void setColor(int color) {this.color = color;}
}
