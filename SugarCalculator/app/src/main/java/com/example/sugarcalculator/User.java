package com.example.sugarcalculator;

import android.util.JsonReader;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class User {

    private int myAge;
    private int myWeight;
    private int myHeight;
    private String myName;
    //units of measure: either 't' for teaspoons or
    //'g' for grams
    //daily sugar intake IN GRAMS
    private long myTotal;
    private char mySex;

    // =====================================================
    // constructor
    // =====================================================
    public User(int age, int weight, int height, String name, char sex)
    {
        myAge = age;
        myWeight = weight;
        myHeight = height;
        myName = name;
        myTotal = 0;


    }

    public User()
    {

    }

    // =====================================================
    // void addSugar
    // adds amount to total daily sugar intake
    // ====================================================
    public void addSugar(long amount)
    {
        myTotal += amount;
    }

    // ====================================================
    // void resetTotal
    // sets daily sugar intake to zero
    // ====================================================
    public void resetTotal()
    {
        myTotal = 0;
    }

    // ====================================================
    // double getTotal
    // returns total sugar intake for the day
    // ====================================================
    public long getTotal()
    {
        return myTotal;
    }



}
