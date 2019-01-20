package com.example.sugarcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class DailySugar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_sugar);

        Bundle b = getIntent().getExtras();
        String amount = b.getString("amount");
        if (amount == null) {
            amount = "0.0";
        }
        TextView totalText = findViewById(R.id.displayTotal);
        totalText.setText(amount + " tsp / 8 tsp");
    }

    public void toCalendar(View v) {
        Intent intent = new Intent(this, NavigationScreen.class);
        startActivity(intent);
    }
}
