public class GroceryItem {
    private String name;
    private double value;

    public GroceryItem(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public GroceryItem() {
        this("", 0.0); // Default constructor with no name and zero value
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + ": $" + String.format("%.2f", value);
    }
}