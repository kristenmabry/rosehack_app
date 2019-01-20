public class User {

    private String myUser = "user";
    private String myPass = "pass";
    //units of measure: either 't' for teaspoons or
    //'g' for grams
    private char myMode = 't';
    //daily sugar intake IN GRAMS
    private double myTotal = 0;

    // =====================================================
    // constructor
    // =====================================================
    public User(String user, String pass, char mode)
    {
        myUser = user;
        myPass = pass;
        myMode = mode;
    }

    // =====================================================
    // void addSugar
    // adds amount to total daily sugar intake
    // ====================================================
    public void addSugar(double amount)
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
