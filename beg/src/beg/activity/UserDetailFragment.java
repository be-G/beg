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

    public static final String USER = "user";

    private static User user;

    public static Fragment create(int position, List<User> users) {

        Bundle args = new Bundle();
        args.putSerializable(USER, users.get(position));

        Fragment fragment = new UserDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = (User) getArguments().getSerializable(USER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.user, container, false);

        ((TextView) rootView.findViewById(R.id.user_name_text)).setText(user.getName());
        ((TextView) rootView.findViewById(R.id.user_description_text)).setText(user.getDescription());
        rootView.findViewById(R.id.user_marble_imageView).setBackgroundResource(user.getState());
        ((TextView) rootView.findViewById(R.id.user_distance_text)).setText(user.getDistance() + " m");

        return rootView;
    }

}
