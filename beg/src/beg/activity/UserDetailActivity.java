package beg.activity;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_chat:
                goToChat();
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToChat() {
        startActivity(new Intent(this,ChatActivity.class));
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