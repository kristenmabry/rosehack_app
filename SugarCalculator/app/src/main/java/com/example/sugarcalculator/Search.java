package com.example.sugarcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
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

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }


    public void search(View v) {
        TextView searchBar = findViewById(R.id.search_bar);
        String search = searchBar.getText().toString();
        final TextView results = findViewById(R.id.name_header);


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);


        String API_KEY = "DOy3CHZrrH9NL9yA3ogpIl2mlnnTdrT2QSRxAyFc";
        String API_URL = "https://api.nal.usda.gov/ndb/search/?";
        String amount = "10";
        String url = API_URL + "q=" + search + "&max=" + amount
                + "&api_key=" + API_KEY;

        // Request a string response from the provided URL.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        JSONObject obj = new JSONObject();
                        try {
                            obj = response.getJSONObject("list");

                        }
                        catch (JSONException e) {
                            results.setText("Response: " + response.toString());
                        }
                        createRows(obj);
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

    public void createRows(JSONObject response) {
        TableLayout ll = findViewById(R.id.table);
        JSONArray arr = new JSONArray();
        try {
            arr = response.getJSONArray("item");
        }
        catch (JSONException e) {
            TextView results = findViewById(R.id.name_header);
            results.setText("Response: " + response.toString());
        }


        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj;
            int id = 1;
            String name = "name";
            try {
                obj = arr.getJSONObject(i);
                id = Integer.parseInt(obj.getString("ndbno"));
                name = obj.getString("name");

            } catch (JSONException e) {
                obj = new JSONObject();
            }
            TableRow tr = new TableRow(this);
            tr.setId(id);

            if (i % 2 == 0) {
                tr.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
            else {
                tr.setBackgroundColor(getResources().getColor(R.color.colorBackground));
            }


            TextView label = new TextView(this);
            label.setText(name);

            tr.addView(label);
            ll.addView(tr, i+1);
        }

    }


}
