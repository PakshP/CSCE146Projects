import java.io.*;
import java.util.Scanner;

class Game {
    String title;
    String console;

    Game(String title, String console) {
        this.title = title;
        this.console = console;
    }
}

class Node {
    Game data;
    Node next;

    Node(Game game) {
        data = game;
        next = null;
    }
}

class LinkedList {
    Node head;

    void append(Game game) {
        Node newNode = new Node(game);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    LinkedList search(String keyword, String field) {
        LinkedList results = new LinkedList();
        Node current = head;
        while (current != null) {
            if ((field.equals("title") && current.data.title.toLowerCase().contains(keyword.toLowerCase())) ||
                    (field.equals("console") && current.data.console.toLowerCase().contains(keyword.toLowerCase())) ||
                    keyword.equals("*")) {
                results.append(current.data);
            }
            current = current.next;
        }
        return results;
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data.title + "\t" + current.data.console);
            current = current.next;
        }
    }
}

public class VideoGameDatabase {
    public static void main(String[] args) {
        LinkedList gameList = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Load game collection from file");
            System.out.println("2. Search games");
            System.out.println("3. Print search results to console");
            System.out.println("4. Print search results to file");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the game collection file: ");
                    String fileName = scanner.nextLine();
                    gameList = readGameCollection(fileName);
                    break;
                case 2:
                    System.out.print("Enter the keyword: ");
                    String keyword = scanner.nextLine();
                    System.out.print("Search in title or console (title/console): ");
                    String field = scanner.nextLine();
                    LinkedList searchResults = gameList.search(keyword, field);
                    searchResults.display();
                    break;
                case 3:
                    System.out.println("Search results:");
                    gameList.display();
                    break;
                case 4:
                    System.out.print("Enter the file name to print results: ");
                    String resultFileName = scanner.nextLine();
                    System.out.print("Enter 'w' to overwrite or 'a' to append: ");
                    String mode = scanner.nextLine();
                    printToFile(gameList, resultFileName, mode);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }

    static LinkedList readGameCollection(String fileName) {
        LinkedList gameList = new LinkedList();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\t");
                if (data.length == 2) {
                    Game game = new Game(data[0], data[1]);
                    gameList.append(game);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return gameList;
    }

    static void printToFile(LinkedList results, String fileName, String mode) {
        try {
            FileWriter writer = new FileWriter(fileName, mode.equals("a"));
            Node current = results.head;
            while (current != null) {
                writer.write(current.data.title + "\t" + current.data.console + "\n");
                current = current.next;
            }
            writer.close();
            System.out.println("Results printed to file successfully.");
        } catch (IOException e) {
            System.out.println("Error printing to file.");
        }
    }
}
