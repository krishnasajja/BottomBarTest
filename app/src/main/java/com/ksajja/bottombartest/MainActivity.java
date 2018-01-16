package com.ksajja.bottombartest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.ksajja.bottombartest.fragments.FragmentA;
import com.ksajja.bottombartest.fragments.FragmentB;
import com.ksajja.bottombartest.fragments.FragmentC;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    selectedFragment = getSupportFragmentManager().findFragmentByTag(FragmentA.TAG);
                    if (selectedFragment == null) {
                        selectedFragment = new FragmentA();
                    }
                    break;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    selectedFragment = getSupportFragmentManager().findFragmentByTag(FragmentB.TAG);
                    if (selectedFragment == null) {
                        selectedFragment = new FragmentB();
                    }
                    break;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    selectedFragment = getSupportFragmentManager().findFragmentByTag(FragmentC.TAG);
                    if (selectedFragment == null) {
                        selectedFragment = new FragmentC();
                    }
                    break;
            }
            if (selectedFragment != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout, selectedFragment, selectedFragment.getTag());
                ft.addToBackStack(null);
                ft.commit();
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
