package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Number of customers
		int count = scan.nextInt();
		
		char[] firstInitial = new char[count];
		String[] lastName = new String[count];
		double[] total = new double[count];
		
		// Retrieve input and store in arrays
		
		for(int i = 0; i < count; i++) {
			firstInitial[i] = scan.next().charAt(0);
			lastName[i] = scan.next();
			
			// The number of different items
			int itemCount = scan.nextInt();
			
			for(int j = 0; j < itemCount; j++) {
				// The amount of a particular item being purchased
				int quantity = scan.nextInt();
				
				// Skip the item name
				scan.next();
				
				// The cost of the individual item
				double price = scan.nextDouble();
				
				total[i] += quantity * price;
			}
		}
		
		// Display name of each customer and the amount spent to the console
		
		for(int i = 0; i < count; i++) {
			System.out.printf("%c. %s: %.2f%n", firstInitial[i], lastName[i], total[i]);
		}
		
		// Close Scanner object
		scan.close();
		
	}
}
