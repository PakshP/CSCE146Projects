//Paksh Patel

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Task {
	private String action;
	private int priority;

	public Task(String action, int priority) {
		this.action = action;
		this.priority = priority;
	}

	public String getAction() {
		return action;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return priority + "\t" + action + "\n";
	}
}

//GLL class
class TaskList {
	private LinkedList<Task>[] taskLists;

	public TaskList() {
		// Initialize the array of task lists
		taskLists = new LinkedList[5];
		for (int i = 0; i < 5; i++) {
			taskLists[i] = new LinkedList<>();
		}
	}

//add tasks
	public void addTask(Task task) {
		int priority = task.getPriority();
		LinkedList<Task> list = taskLists[priority];
		if (!list.contains(task)) {
			list.add(task);
		} else {
			System.out.println("Task already exists");
		}
	}

	// remove tasks
	public void removeTask(Task task) {
		int priority = task.getPriority();
		LinkedList<Task> list = taskLists[priority];
		if (list.remove(task)) {
			System.out.println("Task removed");
		} else {
			System.out.println("Task not found");
		}
	}

//printing tasks to console
	public void printTasks() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Priority " + i + ":");
			LinkedList<Task> list = taskLists[i];
			for (Task task : list) {
				System.out.print(task);
			}
			System.out.println();
		}
	}

//Load tasks from files
	public void loadTasksFromFile(String fileName) {
		File file = new File(fileName);
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split("\t");
				int priority = Integer.parseInt(parts[0]);
				String action = parts[1];
				Task task = new Task(action, priority);
				addTask(task);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

//Saving tasks to file
	public void saveTasksToFile(String fileName) {
		try {
			FileWriter writer = new FileWriter(fileName);
			for (int i = 0; i < 5; i++) {
				LinkedList<Task> list = taskLists[i];
				for (Task task : list) {
					writer.write(task.toString());
				}
			}
			writer.close();
			System.out.println("Tasks saved to file");
		} catch (IOException e) {
			System.out.println("Error saving tasks to file");
		}
	}
}

//main class - FrontEnd
public class TaskManager {
	private static Scanner scanner = new Scanner(System.in);
	private static TaskList taskList = new TaskList();

	public static void main(String[] args) {
		boolean exit = false;
		while (!exit) {
			System.out.println("\nTask Manager");
			System.out.println("1. Add Task");
			System.out.println("2. Remove Task");
			System.out.println("3. Print Tasks");
			System.out.println("4. Load Tasks from File");
			System.out.println("5. Save Tasks to File");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			String input = scanner.nextLine();

			// different cases for each option
			switch (input) {
			case "1":
				System.out.print("Enter task: ");
				String action = scanner.nextLine();
				int priority = -1;
				while (priority < 0 || priority > 4) {
					System.out.print("Enter priority (0-4): ");
					try {
						priority = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						priority = -1;
					}
				}
				Task task = new Task(action, priority);
				taskList.addTask(task);
				System.out.println("Task added");
				break;
			case "2":
				System.out.print("Enter task: ");
				action = scanner.nextLine();
				priority = -1;
				while (priority < 0 || priority > 4) {
					System.out.print("Enter priority (0-4): ");
					try {
						priority = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						priority = -1;
					}
				}
				task = new Task(action, priority);
				taskList.removeTask(task);
				break;
			case "3":
				taskList.printTasks();
				break;
			case "4":
				System.out.print("Enter file name: ");
				String fileName = scanner.nextLine();
				taskList.loadTasksFromFile(fileName);
				break;
			case "5":
				System.out.print("Enter file name: ");
				fileName = scanner.nextLine();
				taskList.saveTasksToFile(fileName);
				break;
			case "6":
				exit = true;
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
	}
}