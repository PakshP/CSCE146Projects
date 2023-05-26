//Paksh Patel	
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOSolutions {
	// method to change is to was or to past tense
	public static void pastTense(String ItIs, String ItWas) {
		try (BufferedReader reader = new BufferedReader(new FileReader(ItIs));
				FileWriter writer = new FileWriter(ItWas)) {
			String line;
			while ((line = reader.readLine()) != null) {
				// splits each words
				String[] words = line.split("[ \\t\\n\\r]+");
				for (String word : words) {
					String newWord = word.toLowerCase().equals("is") ? "was" : word;
					System.out.println(newWord);
					writer.write(newWord + System.lineSeparator());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// setting variable for PI
	private static final double PI = 3.14159265359;

	// method to calculate total volume
	public static double totalTubeVolume(String Tubes) {
		double totalVolume = 0.0;
		try (BufferedReader br = new BufferedReader(new FileReader(Tubes))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split("\t");
				if (values.length == 3) {
					try {
						double radius = Double.parseDouble(values[1]);
						double height = Double.parseDouble(values[2]);
						// calculation for volume
						totalVolume += PI * radius * radius * height;
					} catch (NumberFormatException e) {
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalVolume;
	}
}
