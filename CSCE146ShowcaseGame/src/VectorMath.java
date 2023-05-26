//Paksh Patel
import java.util.Scanner;

public class VectorMath {
	
	private static int getVectorSize(Scanner input) {
		System.out.print("Enter the size of the vector: ");
		int size = input.nextInt();
		if (size < 1) {
			System.out.println("Error: vector size > or = 1.");
			return 0;
		}
		return size;
	}
	
	private static double[] getVectorValues(Scanner input, int size) {
		System.out.println("Enter the values of the vector:");
		double[] vector = new double[size];
		for (int i = 0; i < size; i++) {
			vector[i] = input.nextDouble();
		}
		return vector;
	}
	
	private static String arrayToString(double[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i < arr.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		while (choice != 4) {
			System.out.println("\nChose the Vector Operation:");
			System.out.println("1. Add two vectors");
			System.out.println("2. Subtract two vectors");
			System.out.println("3. Find magnitude of a vector");
			System.out.println("4. Exit");
			choice = input.nextInt();
			
			switch (choice) {	
			case 1:
				addVectors(input);
				break;
			case 2:
				subtractVectors(input);
				break;
			case 3:
				findMagnitude(input);
				break;
			case 4:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}
	private static void addVectors(Scanner input) {
		int size = getVectorSize(input);
		if (size == 0) {
			return;
		}
		double[] vector1 = getVectorValues(input, size);
		double[] vector2 = getVectorValues(input, size);
		
		double[] result = new double[size];
		for (int i = 0; i < size; i++) {
			result[i] = vector1[i] + vector2[i];
		}
		
		System.out.println("Resultant vector: " + arrayToString(result));
	}
	
	private static void subtractVectors(Scanner input) {
		int size = getVectorSize(input);
		if (size == 0) {
			return;
		}
		double[] vector1 = getVectorValues(input, size);
		double[] vector2 = getVectorValues(input, size);
		
		double[] result = new double[size];
		for (int i = 0; i < size; i++) {
			result[i] = vector1[i] - vector2[i];
		}
		
		System.out.print("Resultant vector: ");
		for (int i = 0; i < size; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
	
	private static void findMagnitude(Scanner input) {
		int size = getVectorSize(input);
		if (size == 0) {
			return;
		}
		double[] vector = getVectorValues(input, size);
		
		double sum = 0;
		for (int i = 0; i < size; i++) {
			sum += vector[i] * vector[i];
		}
		
		System.out.println("Magnitude: " + Math.sqrt(sum));
	}	
}