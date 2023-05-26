//Paksh Patel

//Step 1: Define Class
public class Cat {

	//Step 2: Data
	//Instance Variables
	//Class Constants
	private String name;
	private double weight;
	private int numberOfLegs;
	
	//Step 3: Constructors
	//default constructor
	public Cat() {
		this.name = "unknown";
		this.weight = 1.0;
		this.numberOfLegs = 4;
	}
	
	//Paramaters
	public Cat(String aN, double aW, int aL) {
		//call mutators
		this.setName(aN);
		this.setWeight(aW);
		this.setNumberOfLegs(aL);
	}
	
	//Step 4: Accessors/Getter
	public String getName() {
		return this.name;
	}
	public double getWeight() {
		return this.weight;
	}
	public double getNumberOfLegs() {
		return this.numberOfLegs;
	}
	
	//Step 5: Mutator/Setter
	public void setName(String name) {
		if(name == null)
			this.name = "unknown";
		else
			this.name = name;
	}
	public void setWeight(double aW) {
		if(aW > 0.0)
			this.weight = aW;
		else
			this.weight = 1.0;
	}
	public void setNumberOfLegs(int aL) {
		if(aL >= 0 && aL <= aL)
			this.numberOfLegs = aL;
		else
			this.numberOfLegs = 4;
		
	}
	
	//Step 6: Other Useful Methods
	public String toString() {
		return "Name: "+this.name+" Weight: "+this.weight+" Number of Legs: "+this.numberOfLegs;
	}
	public boolean equals(Cat aC) {
		return aC != null &&
				this.name.equals(aC.getName()) && 
				this.weight == aC.getWeight() && 
				this.numberOfLegs == aC.getNumberOfLegs();
	}
	
}
