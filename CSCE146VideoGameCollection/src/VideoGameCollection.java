//Paksh Patel

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class VideoGameCollection {
    private LinkedList<Game> games;

    public VideoGameCollection(String fileName) {
        games = new LinkedList<Game>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\t");
                if (tokens.length == 2) {
                    games.add(new Game(tokens[0], tokens[1]));
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public SearchResults searchGames(String term, boolean searchTitle, boolean searchConsole) {
        SearchResults results = new SearchResults();
        for (Game game : games) {
            if (searchTitle && game.getTitle().toLowerCase().contains(term)) {
                results.add(game);
            }
            if (searchConsole && game.getConsole().toLowerCase().contains(term)) {
                results.add(game);
            }
        }
        return results;
    }
}
