package com.example.sugarcalculator;

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


    String item_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        Bundle b = getIntent().getExtras();
        item_id = b.getString("item_id");
        loadFood();
    }

    public void loadFood() {


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
                        handleJson(response);
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

    public void handleJson(JSONObject response) {
        JSONObject info;
        String food_title;
        String amount = "";
        JSONArray nutrients;
        String sugar = "";
        try {
            info = response.getJSONObject("report");
            nutrients = info.getJSONArray("foods");
            info = nutrients.getJSONObject(0);
            food_title = info.getString("name");
            amount = info.getString("measure");
            nutrients = info.getJSONArray("nutrients");
            info = nutrients.getJSONObject(0);
            sugar = info.getString("value");
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
        desc.setText("Serving Size: " + amount);


    }
}
