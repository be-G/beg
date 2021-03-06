package beg.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import beg.activity.R;
import beg.model.User;

import java.util.ArrayList;

public class ListUserAdapter extends ArrayAdapter<User> {

    private ArrayList<User> listUser;

    public ListUserAdapter(Context context, int resource, ArrayList<User> items) {
        super(context, resource, items);

        this.listUser = items;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View userView = LayoutInflater.from(getContext()).inflate(R.layout.map_list_item, null);

        getListItemButton(userView).configureButton(this.listUser, position);

        ((TextView) userView.findViewById(R.id.listitem_name_text)).setText(getUser(position).getName());

        ((TextView) userView.findViewById(R.id.listitem_decription_text)).setText(getUser(position).getDescription());

        ((TextView) userView.findViewById(R.id.listitem_distance_text)).setText(getUser(position).getDistance()+"");

        //TODO manca gestione cambio immagine sul touch sfera

        return userView;

    }

    private ListItemButton getListItemButton(View userView) {
        return (ListItemButton) userView.findViewById(R.id.list_item_button);
    }

    private User getUser(int position) {
        return listUser.get(position);
    }
}