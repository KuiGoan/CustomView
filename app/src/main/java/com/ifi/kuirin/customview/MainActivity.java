package com.ifi.kuirin.customview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ifi.kuirin.customview.base.BaseCustomVerticalView;
import com.ifi.kuirin.customview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);

        //Add item view
        LinearLayout mLayoutItems = activityMainBinding.layoutItem;
        mLayoutItems.removeAllViews();
        for (int i = 0; i < 3; i++) {
            if (i < 2) {
                BaseCustomVerticalView view = new BaseCustomVerticalView(this, null, 0,
                        R.style.BaseCustomVerticalView);
//            LinearLayout.LayoutParams params = LinearLayout.();
//            if (params != null) {
//                params.width = 100;
//                params.height = 200;
//            } else {
                LinearLayout.LayoutParams params = new LinearLayout
                        .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup
                        .LayoutParams.WRAP_CONTENT, 1.0f);
                view.setLayoutParams(params);
                mLayoutItems.addView(view);
//            }
            } else {
                View view = new View(this);
                LinearLayout.LayoutParams params = new LinearLayout
                        .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup
                        .LayoutParams.WRAP_CONTENT, 1.0f);
                view.setLayoutParams(params);
                mLayoutItems.addView(view);
            }
        }
    }
}
