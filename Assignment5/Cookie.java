package Assignment5;

public class Cookie extends DessertItem{
    int number;
    int pricePerDozen;
    public Cookie(String name, int number, int pricePerDozen) {
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    public int getCost() {
        return (int)Math.round(number * pricePerDozen / 12);
    }

    public String toString() {
        String output = "";

        output += Integer.toString(number) + " @ ";
        output += DessertShoppe.cents2dollarsAndCents(pricePerDozen) + " /dz.\n";
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
