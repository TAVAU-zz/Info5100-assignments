package Assignment5;

public class IceCream extends DessertItem{
    int cost;
    public IceCream(String name, int cost) {
        super(name);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }

    public String toString() {
        String output = "";

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
