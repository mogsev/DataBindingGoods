package com.mogsev.application.databindinggoods;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mogsev.application.databindinggoods.fragment.MainActivityFragment;
import com.mogsev.application.databindinggoods.fragment.UserFragment;

public class MainActivity extends AppCompatActivity implements UserFragment.OnUserFragmentListener {
    private static final String TAG = "MainActivity";

    private static final String MAIN_ACTIVITY_FRAGMENT = "MainActivityFragment";

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        runFragmentTransaction(MainActivityFragment.newInstance(), MAIN_ACTIVITY_FRAGMENT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean runFragmentTransaction(@NonNull Fragment fragment, @NonNull String fragmentTag) {
        Log.i(TAG, "runFragmentTransaction");
        getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.flFragmentsContainer, fragment, fragmentTag)
                .addToBackStack(fragmentTag)
                .commit();
        return true;
    }

    @Override
    public void onChange(View view) {
        Log.i(TAG, "onChange");
    }

    public boolean onFilter() {
        Log.i(TAG, "onFilter");
        return true;
    }
}
