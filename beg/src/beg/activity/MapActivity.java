package beg.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
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
        getListView().setAdapter(new ArrayAdapter<String>(this,R.layout.list_item,R.id.rowText,getListOfNearUsers(location)));

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                checkLogin();
                //TODO to impl apro la pagina di dettaglio
            }
        });

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
        //TODO controllare se il network provider esiste nel caso non esista gestire l'ecccezione
        ((LocationManager)this.getSystemService(this.LOCATION_SERVICE)).requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

    }

    public List<String> getListOfNearUsers(Location location) {

        //TODO to impl now is stubbed
        //TODO chiamo il server per avere la lista di risultati delle persone vicine, lo chiamo solo se ho le informazioni sulla posizione in csocontrario richiedo la connessione alla rete o GPS

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

}