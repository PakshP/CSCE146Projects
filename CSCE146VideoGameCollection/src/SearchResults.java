//Paksh Patel

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class SearchResults extends LinkedList<Game> {

    public void printToFile(String fileName, boolean append) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName, append));
            for (Game game : this) {
                pw.println(game.getTitle() + " (" + game.getConsole() + ")");
            }
            pw.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
