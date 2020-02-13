package com.data.router;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

public class mainActivity extends FragmentActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    public void xmlClick(View view){
        int id = view.getId();
        sharedFragment cf = (sharedFragment) getSupportFragmentManager().findFragmentById(R.id.shared_fragment);

        cf.sharedWithMe(id+": is id of the last clicked button - method declared in activity, listened to by XML");
    }
}
