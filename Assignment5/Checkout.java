package Assignment5;

import java.util.*;

public class Checkout {
    private ArrayList<DessertItem> dessertItems;

    public Checkout(){
        dessertItems = new ArrayList<>();
    }

    public void enterItem(DessertItem item){
        dessertItems.add(item);
    }

    public void clear(){
        dessertItems = new ArrayList<>();
    }

    public int numberOfItems(){
        return dessertItems.size();
    }

    public int totalCost(){
        int sum = 0;
        for(DessertItem item : dessertItems){
            sum += item.getCost();
        }
        return sum;
    }

    public int totalTax(){
        return (int)Math.round(totalCost() * DessertShoppe.TAX_RATE);
    }

    @Override
    public String toString() {
        String res = "";
        System.out.println("        " + DessertShoppe.STORE_NAME); // try printf or string.format to leave space
        System.out.print("        ");
        for( int i = 0; i < DessertShoppe.STORE_NAME.length();i++){
            System.out.print("-");
        }
        System.out.print("\n\n");
        for (DessertItem di : dessertItems){
            System.out.print(di.toString());
        }
        res += "\nTax";
        for (int i = 0; i < DessertShoppe.WIDTH_OF_RECEIPT - 2 - DessertShoppe.cents2dollarsAndCents(totalCost()).length(); ++i)
            res += " ";
        res += DessertShoppe.cents2dollarsAndCents(totalTax()) + "\n" + "Total Cost";
        for (int i = 0; i < DessertShoppe.WIDTH_OF_RECEIPT - 10 - DessertShoppe.cents2dollarsAndCents(totalCost()).length(); ++i)
            res += " ";
        res += DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax()) + "\n";
        return res;
    }


}
