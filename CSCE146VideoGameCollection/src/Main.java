//Paksh Patel

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VideoGameCollection collection = null;
		while (true) {
			//options given to user
			System.out.println("Select an option:");
			System.out.println("1. Load game collection file");
			System.out.println("2. Search for games");
			System.out.println("3. Quit");
			int choice = scanner.nextInt();
			scanner.nextLine();
			if (choice == 1) {
				//user inputed file
				System.out.print("Enter filename: ");
				String filename = scanner.nextLine();
				collection = new VideoGameCollection(filename);
				System.out.println("Game collection loaded.");
			} else if (choice == 2) {
				if (collection == null) {
					System.out.println("Please load a game collection file first.");
					continue;
				}
				//Search for the loaded file
				System.out.print("Enter search term: ");
				String term = scanner.nextLine().toLowerCase();
				System.out.print("Search by title (t), console (c), or both (b)? ");
				String searchBy = scanner.nextLine().toLowerCase();
				boolean searchTitle = false;
				boolean searchConsole = false;
				if (searchBy.equals("t") || searchBy.equals("b")) {
					searchTitle = true;
				}
				if (searchBy.equals("c") || searchBy.equals("b")) {
					searchConsole = true;
				}
				SearchResults results = collection.searchGames(term, searchTitle, searchConsole);
				if (results.size() == 0) {
					System.out.println("No results found.");
					continue;
				}
				System.out.println("Search results:");
				for (Game game : results) {
					System.out.println(game.getTitle() + " (" + game.getConsole() + ")");
				}
				//file printing
				System.out.print("Print results to file (y/n)? ");
				String printToFile = scanner.nextLine().toLowerCase();
				if (printToFile.equals("y")) {
					System.out.print("Enter file name: ");
					String fileName = scanner.nextLine();
					//append or overwrite
					System.out.print("Overwrite file (y/n)? ");
					String overwrite = scanner.nextLine().toLowerCase();
					boolean append = true;
					if (overwrite.equals("y")) {
						append = false;
					}
					results.printToFile(fileName, append);
					System.out.println("Results printed to file.");
				}
			} else if (choice == 3) {
				System.out.println("Goodbye!");
				break;
			} else {
				System.out.println("Invalid option. Please try again.");
			}
		}
		scanner.close();
	}
}
