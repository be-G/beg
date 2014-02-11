package beg.activity;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import beg.web_request.AsyncRequest;
import beg.widget.ListUserAdapter;



public class MapActivity extends BegActivity {

    protected static Location location;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.map);

        //TODO controllare  se la connessione è attiva nel caso segnalare all'utente di attivare la connessione
        calculateLocation();

        getListView().setAdapter(new ListUserAdapter(this,R.layout.list_item, AsyncRequest.getListOfNearUsers(location)));

        removeListLineSeparator();

    }

    private void removeListLineSeparator() {
        getListView().setDivider(null);
        getListView().setDividerHeight(0);
    }

    private ListView getListView() {
        return (ListView)findViewById(R.id.map_listView);
    }

    private void calculateLocation() {

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                Log.d("DEBUG","UserLocation changed " + location );
                MapActivity.location = location;
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}
        };

        //TODO controllare se il network provider esiste nel caso non esista gestire l'ecccezione
        ((LocationManager)this.getSystemService(this.LOCATION_SERVICE)).requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

    }

}