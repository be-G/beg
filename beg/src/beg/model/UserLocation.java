package beg.model;

public class UserLocation {

    private Double latitude;
    private Double longitude;
    private String distanceInMeter;

    public UserLocation(Double latitude, Double longitude, String distanceInMeter) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.distanceInMeter = distanceInMeter;
    }

    public String getDistanceInMeter() {
        return distanceInMeter;
    }

    public void setDistanceInMeter(String distanceInMeter) {
        this.distanceInMeter = distanceInMeter;
    }

    public Double getLatitude() {return latitude;}

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
