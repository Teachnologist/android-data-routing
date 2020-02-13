package com.data.router;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.leanback.app.BrowseSupportFragment;

import java.util.Timer;
import java.util.TimerTask;

public class mainActivityFragment extends BrowseSupportFragment {


    sharedFragment cf;
    Integer tick = 0;
    String data;
    String send_data="no data";
    Timer timerObj = new Timer();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*calls method in a different fragment class*/
        cf = (sharedFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.shared_fragment);
        cf.sharedWithMe("Activity Created");



        /*iterates and sets attributes of the children of a layout element (parent)*/
        LinearLayout view = requireActivity().findViewById(R.id.button_parent);
        Integer child_count = view.getChildCount();

        System.out.println("CHILD COUNT: "+child_count);
        /*iterate a list of children and listen to click*/
        for(int i=0;i<child_count;i++){

            System.out.println("CHILD : "+view.getChildAt(i).getId());

            Button button = (Button) view.getChildAt(i);

            if(i == 0){
                button.requestFocus();
            }


            button.setFocusable(true);
            button.setClickable(true);
            button.setId(i);

            Integer next_left = (i - 1 < 0) ? child_count - 1:i - 1;
            Integer next_right = (i + 1 > child_count - 1) ? 0:child_count - 1;

            button.setNextFocusLeftId(next_left);
            button.setNextFocusRightId(next_right);

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    tick = 0;
                    data = "Button Clicked: "+v.getId()+" first tick: "+tick;
                    streamData();

                }

            });
        }

    }



    private void streamData() {
        /*resets thread*/
        timerObj.cancel();
        timerObj = new Timer();

        TimerTask timerTaskObj = new TimerTask() {
            public void run() {
                //perform your action here
                String new_data = data+" AND we are on tick: "+tick;
                send_data=new_data;
                /*returns task to main ui thread*/
                requireActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        sendData();

                    }
                });
                tick++;
            }
        };
        timerObj.schedule(timerTaskObj, 0, 1000);
    }

    private void sendData() {

        cf.sharedWithMe(send_data);
    }


    }
