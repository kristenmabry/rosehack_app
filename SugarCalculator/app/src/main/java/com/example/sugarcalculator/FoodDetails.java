package com.example.sugarcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FoodDetails extends AppCompatActivity {

    String item_id = getIntent().getStringExtra("item_id");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
    }
}
