package Assignment5;

public class Sundae extends IceCream {
    String topping;
    int top_cost;
    public Sundae(String name, int cost, String topping, int top_cost) {
        super(name, cost);
        this.topping = topping;
        this.top_cost = top_cost;
    }

    @Override
    public int getCost() {
        return super.getCost() + top_cost;
    }

    public String toString() {
        String output = "";

        output += topping + " Sundae with\n";
        if (getName().length() <= DessertShoppe.MAX_OF_ITEM_NAME) {
            output += getName();
            for (int i = 0; i < DessertShoppe.WIDTH_OF_RECEIPT - getName().length() - DessertShoppe.cents2dollarsAndCents(getCost()).length(); ++i)
                output += " ";
        }
        else {
            output += getName().substring(0, DessertShoppe.MAX_OF_ITEM_NAME-1) + "\n" + getName().substring(DessertShoppe.MAX_OF_ITEM_NAME);
            for (int i = 0; i < DessertShoppe.WIDTH_OF_RECEIPT - getName().length() - DessertShoppe.cents2dollarsAndCents(getCost()).length(); ++i)
                output += " ";
        }
        output += DessertShoppe.cents2dollarsAndCents(getCost()) + "\n";

        return output;
    }
}
