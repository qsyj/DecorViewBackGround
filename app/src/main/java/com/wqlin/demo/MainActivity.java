package com.wqlin.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int[] location = new int[2];
                View view=findViewById(R.id.tv2);
                view.getLocationOnScreen(location);
                Utils.WindowBackGroundInfo info = new Utils.WindowBackGroundInfo(0.7f, location[1] + view.getHeight(), Utils.getWindowHeight(MainActivity.this));
                Utils.setWindowBackGround(MainActivity.this,info,true);
            }
        }, 400);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Utils.setWindowBackGround(MainActivity.this,null,false);
            }
        }, 3400);
    }
}
