package Assignment5;

public class Candy extends DessertItem {
    double weight;
    int pricePerPound;
    public Candy(String name, double weight, int pricePerPound) {
        super(name);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    @Override
    public int getCost() {
        return (int)Math.round(weight * pricePerPound);
    }

    public String toString() {
        String output = "";

        output += weight + " lbs. @ ";
        output += DessertShoppe.cents2dollarsAndCents(pricePerPound) + " /lb.\n";
        if (getName().length() <= DessertShoppe.MAX_OF_ITEM_NAME) {
            output += getName();
            for (int i = 0; i < DessertShoppe.WIDTH_OF_RECEIPT - getName().length() - DessertShoppe.cents2dollarsAndCents(getCost()).length(); ++i)
                output += " ";
        }
        else {
            output += getName().substring(0, DessertShoppe.MAX_OF_ITEM_NAME - 1) + "\n" + getName().substring(DessertShoppe.MAX_OF_ITEM_NAME);
            for (int i = 0; i < DessertShoppe.WIDTH_OF_RECEIPT - getName().length() - DessertShoppe.cents2dollarsAndCents(getCost()).length(); ++i)
                output += " ";
        }
        output += DessertShoppe.cents2dollarsAndCents(getCost()) + "\n";

        return output;
    }
}
