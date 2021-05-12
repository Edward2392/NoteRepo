package com.example.mynote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;

import com.example.mynote.domain.Record;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnRecordClicked {

    private boolean isLandscape = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isLandscape = getResources().getBoolean(R.bool.isLandscape);
        if (!isLandscape) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            Fragment fragment = fragmentManager.findFragmentById(R.id.container);

            if (fragment == null) {
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new ListFragment())
                        .commit();
            }
        }
    }

    @Override
    public void onRecordClicked(Record record) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (isLandscape) {
            fragmentManager.beginTransaction()
                    .replace(R.id.details_fragment, DetailsFragment.newInstance(record))
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, DetailsFragment.newInstance(record))
                    .addToBackStack(null)
                    .commit();
        }

    }
}