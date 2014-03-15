package beg.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import beg.activity.R;


public class ListChatAdapter extends ArrayAdapter{

    public ListChatAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return LayoutInflater.from(getContext()).inflate(R.layout.chat_list_item, null);

    }

}
