package beg.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class MapActivity extends Activity {

    protected static Location location;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!isLogged()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        setContentView(R.layout.map);

        calculateLocation();
        //TODO chiamo il server per avere la lista di risultati delle persone vicine

    }

    private boolean isLogged() {

        SharedPreferences pref = getSharedPreferences("Preferences",MODE_PRIVATE);
        String foo = pref.getString("LOGGED", "NO");
        return "YES".equals(foo);
    }

    private void calculateLocation() {

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                Log.d("DEBUG","Location changed " + location );
                MapActivity.location = location;
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}
        };

        ((LocationManager)this.getSystemService(this.LOCATION_SERVICE)).requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

    }
}