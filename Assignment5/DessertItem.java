package Assignment5;

public abstract class DessertItem extends java.lang.Object{
    protected String name;

    public DessertItem() {
        name = null;
    }

    public DessertItem(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public abstract int getCost() ;


}
