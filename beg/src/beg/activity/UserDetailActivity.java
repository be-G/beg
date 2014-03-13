package beg.activity;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import beg.model.User;

import java.util.List;

public class UserDetailActivity extends BegActivity {

    private List<User> users;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_screen_slide);

        users = getUsers();
        mPager = (ViewPager) findViewById(R.id.pager);

        FragmentStatePagerAdapter mPagerAdapter = new FragmentStatePagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int pos) {
                return UserDetailFragment.create(pos,users);
            }

            @Override
            public int getCount() {
                return users.size();
            }
        };

        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(getItemPosition());

        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                invalidateOptionsMenu();
            }
        });
    }

    private List<User> getUsers() {
        return (List<User>) getExtras().getSerializable("Users");
    }

    private int getItemPosition() {
        return getExtras().getInt("ItemPos");
    }

    private Bundle getExtras() {
        return getIntent().getExtras();
    }


}