package com.example.ps3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (fragment == null) {
            fragment = createFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame, fragment)
                    .commit();
        }
    }

    public Fragment getFragment() {
        return fragment;
    }
}
