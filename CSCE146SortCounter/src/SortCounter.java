import java.util.Scanner;

public class SortCounter {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strings = new String[1000];
        int[] sortCounts = new int[1000];
        int numStrings = 0;
        String userResponse = "Y";
        
        while (userResponse.equalsIgnoreCase("Y")) {
            System.out.println("Enter a string: ");
            String str = input.nextLine();
            strings[numStrings] = str;
            sortCounts[numStrings] = countSort(str);
            numStrings++;
            
            System.out.println("Do you want to enter another string? (Y/N)");
            userResponse = input.nextLine();
        }
        
        // sort the strings based on the corresponding sort counts
        for (int i = 0; i < numStrings - 1; i++) {
            for (int j = i + 1; j < numStrings; j++) {
                if (sortCounts[i] > sortCounts[j]) {
                    // swap the sort counts
                    int tempSortCount = sortCounts[i];
                    sortCounts[i] = sortCounts[j];
                    sortCounts[j] = tempSortCount;
                    // swap the strings
                    String tempString = strings[i];
                    strings[i] = strings[j];
                    strings[j] = tempString;
                }
            }
        }
        
        // print the sorted strings and their corresponding sort counts
        for (int i = 0; i < numStrings; i++) {
            System.out.println(strings[i] + " (" + sortCounts[i] + " SORTs)");
        }
    }
    
    // count the number of times "SORT" appears in the given string (case insensitive)
    private static int countSort(String str) {
        int count = 0;
        int index = 0;
        while ((index = str.toLowerCase().indexOf("sort", index)) != -1) {
            count++;
            index += 4;
        }
        return count;
    }
}
