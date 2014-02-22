package beg.web_request;

import android.location.Location;
import beg.model.Color;
import beg.model.User;

import java.util.LinkedList;
import java.util.List;

public class AsyncRequest{


    public static List<User> getListOfNearUsers(Location location) {

        //TODO to impl now is stubbed
        //TODO chiamo il server per avere la lista di risultati delle persone vicine, lo chiamo solo se ho le informazioni sulla posizione in csocontrario richiedo la connessione alla rete o GPS

        List<User> list = new LinkedList<User>();

        list.add(new User(Color.BLUE, "Mateo Binda", 20,"solo negri"));
        list.add(new User(Color.RED, "Claudio Colombo",20,"amo i magrebini, mi trovate tutte le sere in centrale"));
        list.add(new User(Color.BLUE, "Walter Fabris",20,"desc"));
        list.add(new User(Color.YELLOW, "Federico Ferretti",20,"solo donzo"));
        list.add(new User(Color.ORANGE, "Andrea Esempio", 20,"solo ariani"));
        list.add(new User(Color.BLUE, "Andrea Nicoli",20,"froci filu"));
        list.add(new User(Color.BLUE, "Alberto Pelizzari",20,"l'Alberto!"));
        list.add(new User(Color.BLUE, "Fioravazzi Matteo",20,"agobubu"));
        list.add(new User(Color.BLUE, "Fabio Binda", 20,"popper"));
        list.add(new User(Color.BLUE, "Niccolò Galli", 20,"frocifilu Pem!!! Pem!! froci froci froci froci froci froci froci froci froci bellissimo blueh!!"));
        list.add(new User(Color.BLUE, "PemPem Froci", 20,"desc"));
        list.add(new User(Color.BLUE, "Froci Filù", 20,"desc"));

        return list;
    }


}
