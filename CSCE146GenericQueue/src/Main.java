//Paksh Patel

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	// The main method that starts the program
	public static void main(String[] args) {
		// Creates a new scanner to read input from the console
		Scanner sc = new Scanner(System.in);

		// Loop that continues until the user chooses to quit the program
		while (true) {
			// Prompt the user to enter the filename for the board
			System.out.println("Enter board filename:");
			String boardFilename = sc.nextLine();
			// Read in the board from the file
			Board board = readBoard(boardFilename);
			// Check if the board is valid; if not, prompt the user to try again
			if (board == null) {
				System.out.println("Invalid board filename, please try again.\n");
				continue;
			}

			// Prompt the user to enter the filename for the robot commands
			System.out.println("Enter robot commands filename:");
			String commandsFilename = sc.nextLine();
			// Read in the commands from the file
			GenericQueue<String> commands = readCommands(commandsFilename);
			// Check if the commands are valid; if not, prompt the user to try again
			if (commands == null) {
				System.out.println("Invalid robot commands filename, please try again.\n");
				continue;
			}

			// Create a new robot simulation with the board
			RobotSimulation robotSimulation = new RobotSimulation(board);
			// Run the simulation with the commands and get the result
			boolean success = robotSimulation.run(commands);
			// Print a message indicating whether the simulation succeeded or failed
			if (success) {
				System.out.println("Simulation completed successfully!");
			} else {
				System.out.println("Simulation failed due to collision or out of bounds.");
			}

			// Prompt the user to either quit the program or start over
			System.out.println("Press Q to quit or any other key to restart.");
			String input = sc.nextLine();
			if (input.equals("Q") || input.equals("q")) {
				break;
			}
		}

		// Close the scanner
		sc.close();
	}

	private static Board readBoard(String filename) {
		try {
			Scanner sc = new Scanner(new File(filename));

			char[][] data = new char[Board.HEIGHT][Board.WIDTH];

			for (int i = 0; i < Board.HEIGHT; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < Board.WIDTH; j++) {
					char c = line.charAt(j);
					if (c == Board.OBSTACLE_CHAR || c == Board.EMPTY_CHAR) {
						data[i][j] = c;
					} else {
						sc.close();
						return null;
					}
				}
			}

			sc.close();
			return new Board(data);
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	private static GenericQueue<String> readCommands(String filename) {
		try {
			Scanner sc = new Scanner(new File(filename));
			GenericQueue<String> commands = new GenericQueue<>();

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.equals("Move Up") || line.equals("Move Down") || line.equals("Move Left")
						|| line.equals("Move Right")) {
					commands.enqueue(line);
				}
			}

			sc.close();
			return commands;
		} catch (FileNotFoundException e) {
			return null;
		}
	}
}

class RobotSimulation {
	private Board board;
	private int x;
	private int y;

	public RobotSimulation(Board board) {
		this.board = board;
		this.x = 0;
		this.y = 0;
	}

	public boolean run(GenericQueue<String> commands) {
		board.print();
		while (!commands.isEmpty()) {
			String command = commands.dequeue();
			switch (command) {
			case "Move Up":
				if (y > 0 && board.get(x, y - 1) != Board.OBSTACLE_CHAR) {
					y--;
				} else {
					System.out.println("CRASH");
					return false;
				}
				break;
			case "Move Down":
				if (y < Board.HEIGHT - 1 && board.get(x, y + 1) != Board.OBSTACLE_CHAR) {
					y++;
				} else {
					System.out.println("CRASH");
					return false;
				}
				break;
			case "Move Left":
				if (x > 0 && board.get(x - 1, y) != Board.OBSTACLE_CHAR) {
					x--;
				} else {
					System.out.println("CRASH");
					return false;
				}
				break;
			case "Move Right":
				if (x < Board.WIDTH - 1 && board.get(x + 1, y) != Board.OBSTACLE_CHAR) {
					x++;
				} else {
					System.out.println("CRASH");
					return false;
				}
				break;
			}
			board.update(x, y);
			board.print();
		}
		return true;
	}
}

class Board {
	public static final int HEIGHT = 10;
	public static final int WIDTH = 10;
	public static final char EMPTY_CHAR = '_';
	public static final char OBSTACLE_CHAR = 'X';
	private char[][] data;

	public Board(char[][] data) {
		this.data = data;
	}

	public char get(int x, int y) {
		return data[y][x];
	}

	public void update(int x, int y) {
		data[y][x] = 'R';
	}

	public void print() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
