//Paksh Patel
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ShowcaseGame {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);
		File prize = new File("./Prize File.txt");
		Scanner fileInput = new Scanner(prize);

		int Count = 0;
		//declaring 2 different arrays
		String[] Prizes = new String[100];
		int[] Prices = new int[100];
		//splits the names and prices by a tab (\t)
		while (fileInput.hasNextLine()) {
			String line = fileInput.nextLine();
			String[] parts = line.split("\t");
			if (parts.length == 2) {
				Prizes[Count] = parts[0];
				Prices[Count] = Integer.parseInt(parts[1]);
				Count++;
			}
		}
		//creates the arrays with a length of 5
		//this one creates the array for the prices
		int[] prizePrice = new int[5];
		//this one creates the array for the names
		String[] prizeNames = new String[5];
		int prizeValues = 0;
		
		//selects 5 random prizes from list
		for (int i = 0; i < 5; i++) {
			int randomIndex = (int) (Math.random() * Count);
			prizePrice[i] = Prices[randomIndex];
			prizeNames[i] = Prizes[randomIndex];
			prizeValues += prizePrice[i];
			Prices[randomIndex] = Prices[Count - 1];
			Prizes[randomIndex] = Prizes[Count - 1];
			Count--;
		}

		System.out.println("The 5 Showcase Prizes Are:");
		for (int i = 0; i < 5; i++) {
			System.out.println(prizeNames[i]);
		}

		System.out.println("Enter your total price guess:");
		int guess = userInput.nextInt();
		//User wins only if the value guessed is within total and total minus 1300
		if (guess >= prizeValues - 1300 && guess <= prizeValues) {
			System.out.println("You won! :)");
		} else {
			System.out.println("You lose. :(");
		}
		userInput.close();
		fileInput.close();
	}
}
