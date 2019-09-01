package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int itemCount = scan.nextInt();
		String[] itemNames = new String[itemCount];
		
		// Store item names and prices in arrays
		for (int i = 0; i < itemCount; i++) {
			itemNames[i] = scan.next();
			scan.nextDouble();
		}
		
		int customerCount = scan.nextInt();
		int[] customersPurchased = new int[itemCount]; // Number of different customers who bought a certain item
		int[] quantityPurchased = new int[itemCount];  // Total number of a certain type of item that was purchased
		
		// Calculate number of customers who bought each item and the total quantity bought of each item.
		for (int i = 0; i < customerCount; i++) {
			// Skip the customers names
			scan.next();
			scan.next();
			
			int numberOfItemsBought = scan.nextInt();
			
			// used to calculate a the number of customers who purchased each item
			int[] quantityChange = quantityPurchased.clone();
			
			for (int j = 0; j < numberOfItemsBought; j++) {
				int quantity = scan.nextInt();
				int itemIndex = getItemIndex(itemNames, scan.next());
				
				quantityPurchased[itemIndex] += quantity;
			}
			
			// Calculate which items a customer purchased
			for (int j = 0; j < itemCount; j++) {
				if(quantityPurchased[j] > quantityChange[j]) customersPurchased[j]++;
			}
		}
		
		// Display number of customers who bought each item and the total quantity bought of each item. 
		for (int i = 0; i < itemCount; i++) {
			if(customersPurchased[i] > 0) {
				System.out.println(customersPurchased[i] + " customers bought " + quantityPurchased[i]
						+ " " + itemNames[i]);
			} else {
				System.out.println("No customers bought " + itemNames[i]);
			}
		}
		
		// Close the Scanner Object
		scan.close();
	}
	
	// Returns the index of the String value in array names corresponding to the parameter String item
	static int getItemIndex(String[] names, String item) {
		for (int i = 0; i < names.length; i++) {
			if (item.equals(names[i])) {
				return i;
			}
		}
		return 0;
	}
	
}
