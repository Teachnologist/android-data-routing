package com.data.router;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class sharedFragActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_frag1);
    }
}
