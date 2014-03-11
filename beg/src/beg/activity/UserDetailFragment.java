package beg.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import beg.model.User;

import java.util.List;

public class UserDetailFragment extends Fragment {

    public static final String ARG_PAGE = "page";

    private static int position;
    private static List<User> users;

    public static Fragment create(int position, List<User> users) {

        UserDetailFragment.position = position;
        UserDetailFragment.users = users;

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, users.size());
        Fragment fragment = new UserDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.user, container, false);

        ((TextView) rootView.findViewById(R.id.user_name_text)).setText(users.get(position).getName());
        ((TextView) rootView.findViewById(R.id.user_description_text)).setText(users.get(position).getDescription());
        rootView.findViewById(R.id.user_marble_imageView).setBackgroundResource(users.get(position).getState());
        ((TextView) rootView.findViewById(R.id.user_distance_text)).setText(users.get(position).getDistance()+" m");

        return rootView;
    }

}
