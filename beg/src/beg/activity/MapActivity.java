package beg.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.FloatMath;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class MapActivity extends Activity {

    protected static Location location;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.map);

        calculateLocation();

        getListView().setAdapter(new ArrayAdapter<String>(this,R.layout.row,R.id.row_text,sortByDistance(getListOfNearUsers())));

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                checkLogin();
                //TODO to impl apro la pagina di dettaglio
            }
        });

    }

    private List<String> sortByDistance(List<String> listOfNearUsers) {

        return listOfNearUsers;
    }

    private ListView getListView() {
        return (ListView)findViewById(R.id.map_listView);
    }

    private void checkLogin(){
        if (!isLogged()) {
            startActivity(new Intent(this, LoginActivity.class));
        }
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

    public List<String> getListOfNearUsers() {

        //TODO to impl now is stubbed
        //TODO chiamo il server per avere la lista di risultati delle persone vicine

        List<String> list = new LinkedList<String>();

        list.add("Mateo Binda");
        list.add("Claudio Colombo");
        list.add("Walter Fabris");
        list.add("Federico Ferretti");
        list.add("Andrea Esempio");
        list.add("Andrea Nicoli");
        list.add("Alberto Pelizzari");
        list.add("Fioravazzi Matteo");
        list.add("Fabio Binda");
        list.add("Niccolò Galli");
        list.add("PemPem Froci");
        list.add("Froci Filù");

        return list;
    }

    private double getDistanceInMeters(float lat_a, float lng_a, float lat_b, float lng_b) {
        float pk = (float) (180/3.14169);

        float a1 = lat_a / pk;
        float a2 = lng_a / pk;
        float b1 = lat_b / pk;
        float b2 = lng_b / pk;

        float t1 = FloatMath.cos(a1)*FloatMath.cos(a2)*FloatMath.cos(b1)*FloatMath.cos(b2);
        float t2 = FloatMath.cos(a1)*FloatMath.sin(a2)*FloatMath.cos(b1)*FloatMath.sin(b2);
        float t3 = FloatMath.sin(a1)*FloatMath.sin(b1);
        double tt = Math.acos(t1 + t2 + t3);

        return 6366000*tt;
    }

}