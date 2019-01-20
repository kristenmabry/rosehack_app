package com.example.sugarcalculator;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NavigationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_screen);

    }

    public void toSearch(View view) {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }


    public void toCapture(View view) {
        //Intent intent = new Intent(this, Capture.class);
        //startActivity(intent);
    }

    public void toSettings(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }


    public void toCalendar(View view) {
        Intent intent = new Intent(this, DailySugar.class);
        intent.putExtra("amount", 0.0);
        startActivity(intent); // help me. merge please
    }

}
