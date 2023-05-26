//Paksh Patel

public class GroceryItem {
	private String name;
	private double value;

	public GroceryItem() {
		this.name = "none";
		this.value = 0;
	}
	// constructor that sets the name and value to given values
	public GroceryItem(String name, double value) {
		this.name = (name != null) ? name : "none";
		this.value = (value >= 0) ? value : 0;
	}
	// getter method to retrieve the name of the grocery item
	public String getName() {
		return name;
	}
	// setter method to set the name of the grocery item
	public void setName(String name) {
		this.name = (name != null) ? name : "none";
	}
	// getter method to retrieve the value of the grocery item
	public double getValue() {
		return value;
	}
	// setter method to set the value of the grocery item
	public void setValue(double value) {
		this.value = (value >= 0) ? value : 0;
	}
	// override the toString method to return the name and value of the grocery item
	@Override
	public String toString() {
		return "Grocery Item Name: " + name + " Value: " + value;
	}
	// equals method to check if two grocery items are the same
	public boolean equals(GroceryItem other) {
		return this.name.equals(other.getName()) && this.value == other.getValue();
	}
}
