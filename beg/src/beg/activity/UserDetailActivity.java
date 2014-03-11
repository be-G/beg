package beg.activity;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import beg.model.User;

import java.util.List;

public class UserDetailActivity extends Activity {

    private List<User> users;

    private ViewPager mPager;

    private FragmentStatePagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_screen_slide);

        users = (List<User>) getIntent().getExtras().getSerializable("Users");

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new FragmentStatePagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int pos) {
                return UserDetailFragment.create(pos, users);
            }

            @Override
            public int getCount() {
                return users.size();
            }
        };
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                invalidateOptionsMenu();
            }
        });
    }
}