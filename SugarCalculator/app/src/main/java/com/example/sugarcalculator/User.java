package com.example.sugarcalculator;

public class User {

    private int myAge;
    private int myWeight;
    private int myHeight;
    //units of measure: either 't' for teaspoons or
    //'g' for grams
    private char myMode;
    //daily sugar intake IN GRAMS
    private long myTotal;

    // =====================================================
    // constructor
    // =====================================================
    public User(int age, int weight, int height, char mode)
    {
        myAge = age;
        myWeight = weight;
        myHeight = height;
        myMode = mode;
        myTotal = 0;
    }

    public User()
    {
        myMode = 't';
        myTotal = 0;
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
    public double getTotal()
    {
        return myTotal;
    }
}
