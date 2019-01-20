package com.example.sugarcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FoodDetails extends AppCompatActivity {


    double sugar;
    long total_sugar_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        Bundle b = getIntent().getExtras();
        String item_id = b.getString("item_id");
        loadFood(item_id);
    }

    public void loadFood(final String item_id) {


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        //"https://api.nal.usda.gov/ndb/nutrients/?ndbno=01009&format=json&api_key=DEMO_KEY&nutrients=269&nutrients=204&nutrients=208"

        String API_KEY = "DOy3CHZrrH9NL9yA3ogpIl2mlnnTdrT2QSRxAyFc";
        String API_URL = "https://api.nal.usda.gov/ndb/nutrients/?";
        String url = API_URL + "ndbno=" + item_id + "&nutrients=269" + "&api_key=" + API_KEY;

        // Request a string response from the provided URL.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        handleJson(response, item_id);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        // Access the RequestQueue through your singleton class.
        queue.add(jsonObjectRequest);
    }

    public void handleJson(JSONObject response, String item_id) {
        JSONObject info;
        String food_title;
        String amount = "";
        JSONArray nutrients;
        sugar = 0;
        try {
            info = response.getJSONObject("report");
            nutrients = info.getJSONArray("foods");
            info = nutrients.getJSONObject(0);
            food_title = info.getString("name");
            amount = info.getString("measure");
            nutrients = info.getJSONArray("nutrients");
            info = nutrients.getJSONObject(0);
            sugar = Double.valueOf(info.getString("value"));
        }
        catch (JSONException e) {
            food_title = "Error";
            amount = item_id;
        }
        TextView title = findViewById(R.id.food_name);
        String[] food_parts = food_title.split(",");
        food_parts = food_parts[0].split("\\(");
        food_title = food_parts[0];
        title.setText(food_title);

        TextView desc = findViewById(R.id.serving_size);
        String newText = "Serving Size: " + amount;
        desc.setText(newText);



    }

    public void getSugar(View v) {
        TextView serving_input = findViewById(R.id.serving_input);
        String input = serving_input.getText().toString();
        Double servings = Double.parseDouble(input);
        TextView sugar_total = findViewById(R.id.sugar_total);
        total_sugar_amount = Math.round(sugar * servings / 4.2 * 100) / 100;
        String newText = getResources().getText(R.string.total_sugar_amount_tsp)
                + Long.toString(total_sugar_amount);
        sugar_total.setText(newText);

    }

    public void toUserInfo(View v) {



        Intent intent = new Intent(this, FoodDetails.class);
        startActivity(intent);
    }
}
