package Assignment5;

public class DessertShoppe {
    public static final String STORE_NAME = "M & M Dessert Shoppe";
    public static final double TAX_RATE = 0.065;
    public static final int MAX_OF_ITEM_NAME = 25;
    public static final int WIDTH_OF_RECEIPT= 35;
    public static String cents2dollarsAndCents(int cents) {
        //105-->"1.05"
        String dollars = "";
        dollars = "" + cents / 100.00;
        return dollars;
    }

}
