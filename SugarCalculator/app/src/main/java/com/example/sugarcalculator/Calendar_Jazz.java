package com.example.sugarcalculator;


import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Calendar_Jazz extends AppCompatActivity {
    //CalendarView calendarView;
    //TextView myDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_screen);

        //calendarView = (CalendarView) findViewById(R.id.calendarView);
        //myDate = (TextView) findViewById(R.id.myDate);

        /*
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1 + 1) + " / " + i2 + " / " + i;
                myDate.setText(date);
            }
        }); */
    }
}