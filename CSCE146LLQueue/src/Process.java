//Paksh Patel

public class Process {
	// Private instance variables to store the name and completion time of the
	// process.
	private String name;
	private double completionTime;

	// Constructor for the process that takes in the name and completion time as
	// arguments and initializes the instance variables.
	public Process(String name, double completionTime) {
		this.name = name;
		this.completionTime = completionTime;
	}

	// Getter method to get the name of the process.
	public String getName() {
		return name;
	}

	// Getter method to get the completion time of the process.
	public double getCompletionTime() {
		return completionTime;
	}

	// Setter method to set the completion time of the process.
	public void setCompletionTime(double time) {
		completionTime = time;
	}

	// toString method to represent the process as a string in the format "name
	// (completionTime)".
	public String toString() {
		return name + " (" + completionTime + ")";
	}

}
