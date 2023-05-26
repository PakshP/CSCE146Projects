//Paksh Patel

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SheepSheeringSchedule {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// loop to allow user to run program again with a different file
		do {
			System.out.print("Enter the name of the sheep scheduling file: ");
			String filename = input.nextLine();
			try {
				List<Sheep> sheeps = readSheepsFromFile(filename);
				List<Sheep> schedule = generateSheepShearingSchedule(sheeps);
				printSchedule(schedule);
			} catch (IOException e) {
				System.out.println("Error reading file");
			}
			System.out.print("Would you like to run the program again? (y/n): ");
		} while (input.nextLine().equalsIgnoreCase("y"));
		input.close();
	}

	// method to read sheep data from input file and sort by arrival time
	private static List<Sheep> readSheepsFromFile(String filename) throws IOException {
		List<Sheep> sheeps = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(filename))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] tokens = line.split("\t");
				String name = tokens[0];
				int shearingTime = Integer.parseInt(tokens[1]);
				int arrivalTime = Integer.parseInt(tokens[2]);
				sheeps.add(new Sheep(name, shearingTime, arrivalTime));
			}
		}
		sheeps.sort(Comparator.comparingInt(Sheep::getArrivalTime));
		return sheeps;
	}

	// method to generate the sheep shearing schedule using a MinHeap
	private static List<Sheep> generateSheepShearingSchedule(List<Sheep> sheeps) {
		List<Sheep> schedule = new ArrayList<>();
		int currentTime = sheeps.get(0).getArrivalTime();
		Sheep currentSheep = null;
		MinHeap<Sheep> sheepWaitHeap = new MinHeap<>(
				Comparator.comparing(Sheep::getShearingTime).thenComparing(Sheep::getName));
		for (Sheep sheep : sheeps) {
			 // if the current time is earlier than the sheep's arrival time, move the current time to the sheep's arrival time
			if (currentTime < sheep.getArrivalTime()) {
				currentTime = sheep.getArrivalTime();
			}
			// if there is no current sheep being sheared, start shearing the current sheep
			if (currentSheep == null) {
				currentSheep = sheep;
			} else {
				sheepWaitHeap.add(sheep);
			}
			while (!sheepWaitHeap.isEmpty() && currentSheep.isFinished(currentTime)) {
				currentSheep = sheepWaitHeap.remove();
			}
			if (currentSheep != null) {
				currentTime += currentSheep.getShearingTime();
				schedule.add(currentSheep);
				currentSheep = null;
			}
		}
		return schedule;
	}

	private static void printSchedule(List<Sheep> schedule) {
		System.out.println("Sheep Shearing Schedule:");
		for (Sheep sheep : schedule) {
			System.out.printf("Name: %s, Shearing Time: %d, Arrival Time: %d%n", sheep.getName(),
					sheep.getShearingTime(), sheep.getArrivalTime());
		}
		System.out.println();
	}

	private static class Sheep {
		private final String name;
		private final int shearingTime;
		private final int arrivalTime;

		public Sheep(String name, int shearingTime, int arrivalTime) {
			this.name = name;
			this.shearingTime = shearingTime;
			this.arrivalTime = arrivalTime;
		}

		public String getName() {
			return name;
		}

		public int getShearingTime() {
			return shearingTime;
		}

		public int getArrivalTime() {
			return arrivalTime;
		}

		public boolean isFinished(int currentTime) {
			return currentTime >= arrivalTime + shearingTime;
		}
	}
}
