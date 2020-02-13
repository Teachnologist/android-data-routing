package com.data.router;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.leanback.app.BrowseSupportFragment;

public class sharedFragment extends BrowseSupportFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void sharedWithMe(String text){
        TextView tv = requireActivity().findViewById(R.id.tvid);
        tv.setText(text);

    }
}
