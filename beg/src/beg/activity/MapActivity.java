package beg.activity;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import beg.model.User;
import beg.web_request.UsersTask;
import beg.widget.ListUserAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MapActivity extends BegActivity {

    protected static Location location;
    private ArrayList<User> users;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.map);

        //TODO controllare  se la connessione è attiva nel caso segnalare all'utente di attivare la connessione
        calculateLocation();

        createUserList();

    }

    private void createUserList() {

        refreshUsers();
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
        ((LocationManager)this.getSystemService(this.LOCATION_SERVICE)).requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }

    public void refreshUsers() {

        showProgressDialog();

        new UsersTask() {
            @Override
            public void onFailure() {
                Log.d("DEBUG", "onFailure");
                hideProgressDialog();
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);

                hideProgressDialog();

                if (o == null) {
                    Log.e("Error!!!", "users response is null");
                } else {
                    setMapListAdapter((JSONArray) o);
                }

            }
        }.execute();

    }

    private void setMapListAdapter(JSONArray jsonArray) {
        getListView().setAdapter(new ListUserAdapter(this, R.layout.map_list_item, getUsersFromJsonArray(jsonArray)));
    }

    private ArrayList<User> getUsersFromJsonArray(JSONArray users)
    {

        ArrayList<User> result = new ArrayList<User>();

        for (int i=0; i<users.length(); i++) {
            try {
                result.add(new User((JSONObject) users.get(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}