import java.util.Scanner;

public class WhatsForBreakfast {

	public static void main(String[] args) {
		
		//single line comment
		//create an object of type Scanner
		Scanner key = new Scanner(System.in);

		System.out.println("What do you want to have for breakfast: eggs on toast, bacon or pancakes?");
		
		String breakfast = key.nextLine();
		
		System.out.println("Enter a beverage of your choice:");
		
		String beverage = key.nextLine();
		
		System.out.println("You breakfast for today is "+breakfast+" with "+beverage+"!");
		
		//concatenation operator +
		
		String someValue; //declaring variable
		someValue = "Hi";	  //initializing the variable
		
		String someValue2 = "Hi";	//declare and initialize the variable
		
		
		
		/* Multi line
		 * Comment
		 */
		
	}
	
}
