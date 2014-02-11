package beg.web_request;

import android.location.Location;
import beg.model.Color;
import beg.model.User;
import beg.model.UserLocation;

import java.util.LinkedList;
import java.util.List;

public class AsyncRequest {

    public static List<User> getListOfNearUsers(Location location) {

        //TODO to impl now is stubbed
        //TODO chiamo il server per avere la lista di risultati delle persone vicine, lo chiamo solo se ho le informazioni sulla posizione in csocontrario richiedo la connessione alla rete o GPS

        List<User> list = new LinkedList<User>();

        list.add(new User(Color.BLUE, "Mateo Binda",new UserLocation(1.0,1.0),new UserLocation(1.0,1.0),"desc",true));
        list.add(new User(Color.RED, "Claudio Colombo",new UserLocation(1.0,1.0),new UserLocation(1.0,1.0),"desc",true));
        list.add(new User(Color.BLUE, "Walter Fabris",new UserLocation(1.0,1.0),new UserLocation(1.0,1.0),"desc",true));
        list.add(new User(Color.BLUE, "Federico Ferretti",new UserLocation(1.0,1.0),new UserLocation(1.0,1.0),"desc",true));
        list.add(new User(Color.BLUE, "Andrea Esempio",new UserLocation(1.0,1.0),new UserLocation(1.0,1.0),"desc",true));
        list.add(new User(Color.BLUE, "Andrea Nicoli",new UserLocation(1.0,1.0),new UserLocation(1.0,1.0),"desc",true));
        list.add(new User(Color.BLUE, "Alberto Pelizzari",new UserLocation(1.0,1.0),new UserLocation(1.0,1.0),"desc",true));
        list.add(new User(Color.BLUE, "Fioravazzi Matteo",new UserLocation(1.0,1.0),new UserLocation(1.0,1.0),"desc",true));
        list.add(new User(Color.BLUE, "Fabio Binda",new UserLocation(1.0,1.0),new UserLocation(1.0,1.0),"desc",true));
        list.add(new User(Color.BLUE, "Niccolò Galli",new UserLocation(1.0,1.0),new UserLocation(1.0,1.0),"desc",true));
        list.add(new User(Color.BLUE, "PemPem Froci",new UserLocation(1.0,1.0),new UserLocation(1.0,1.0),"desc",true));
        list.add(new User(Color.BLUE, "Froci Filù",new UserLocation(1.0,1.0),new UserLocation(1.0,1.0),"desc",true));

        return list;
    }

}
