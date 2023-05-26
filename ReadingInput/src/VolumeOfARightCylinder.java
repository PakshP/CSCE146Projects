import java.util.Scanner;

public class VolumeOfARightCylinder {

	public static final double PI = 3.14;
	
	public static void main(String[] args) {
		
		
		Scanner key = new Scanner(System.in);
		/*
		System.out.println("Enter the height (in inches) of the right cylinder:");
		
		double height = key.nextDouble();
		
		System.out.println("Enter the radius (in inches) of the right cylinder:");
		
		double radius = key.nextDouble();
		
		double volume = PI * Math.pow(radius, 2) * height;
		
		System.out.println("Volume = "+volume+" cubic inches");
		*/
		
		System.out.println("What is your favorite movie with a single word title?");
		
		String movie = key.next();
		
		System.out.println("How many times did you watch this movie?");
		
		int count = key.nextInt();
		
		System.out.println("You watched "+movie+" "+ count+" times!");
		
		System.out.println("Do you like to watch comedy movies? Enter true or false:");
		
		boolean userPreference = key.nextBoolean();
		
		System.out.println("Does the user like comedy movies? "+userPreference);

	}

}
