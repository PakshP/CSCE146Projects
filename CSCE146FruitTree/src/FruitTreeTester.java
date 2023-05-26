//Paksh Patel

import java.util.Scanner;
import java.io.*;
public class FruitTreeTester {

	public static void main(String[] args) {
		System.out.println("Welcome to the fruit tree!\nPlease enter a Fruit File Name.");
		Scanner key = new Scanner(System.in);
		String fileName = key.nextLine();
		System.out.println("Populating tree file");
		
		//connecting BST to Main tester
		FruitBST<Fruit> fTree = new FruitBST<Fruit>();
		try
		{
			//read file specified
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine())
			{
				//separate words and numbers in file
				String current = fileScanner.nextLine();
				String[] split = current.split("\t");
				if(split.length == 2)
				{
					Fruit f = new Fruit(Double.parseDouble(split[1]), split[0]);
					fTree.add(f);
				}
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Printing the in-order traversal");
		fTree.printInorder();
		
		System.out.println("\nPrinting the pre-order traversal");
		fTree.printPreorder();
		
		System.out.println("\nPrinting the post-order traversal");
		fTree.printPostorder();
		
		System.out.println(fTree.search(new Fruit(0.006167454282033358, "Banana")));
		
		System.out.println("\nDeleating Banana - 0.006167454282033358");
		fTree.remove(new Fruit(0.006167454282033358, "Banana"));
		
		System.out.println("Printing in-order traversal");
		fTree.printInorder();
	
	key.close();
	}
}