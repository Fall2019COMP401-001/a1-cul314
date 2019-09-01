package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int itemCount = scan.nextInt();
		String[] itemNames = new String[itemCount];
		double[] itemPrices = new double[itemCount];
		
		// Store item names and prices in arrays
		for (int i = 0; i < itemCount; i++) {
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
		}
		
		int customerCount = scan.nextInt();
		String[] firstNames = new String[customerCount];
		String[] lastNames = new String[customerCount];
		double[] totals = new double[customerCount];
		
		// Store names of customers and their totals in arrays
		for (int i = 0; i < customerCount; i++) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			int numberOfItemsBought = scan.nextInt();
			
			for (int j = 0; j < numberOfItemsBought; j++) {
				int quantity = scan.nextInt();
				totals[i] += quantity * getItemPrice(itemNames, itemPrices, scan.next());
			}
		}
		
		// Find and display the customer with the biggest and smallest total 
		// and the average total.
		int index = findBiggest(totals);
		System.out.println("Biggest: " + firstNames[index] + " " + lastNames[index]
				+ " (" + String.format("%.2f", totals[index]) + ")");
		index = findSmallest(totals);
		System.out.println("Smallest: " + firstNames[index] + " " + lastNames[index]
				+ " (" + String.format("%.2f", totals[index]) + ")");
		System.out.printf("Average: %.2f", findAverage(totals));
		
		// Close the Scanner object
		scan.close();
		
	}
	
	// Returns the price of the item with the same name as the String item
	static double getItemPrice(String[] names, double[] prices, String item) {
		for (int i = 0; i < names.length; i++) {
			if (item.equals(names[i])) {
				return prices[i];
			}
		}
		return 0.0;
	}
	
	// Returns the index of the biggest number in the array of doubles nums
	static int findBiggest(double[] nums) {
		int biggest = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nums[biggest]) {
				biggest = i;
			}
		}
		return biggest;
	}
	
	// Returns the index of the smallest number in the array of doubles nums
	static int findSmallest(double[] nums) {
		int smallest = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < nums[smallest]) {
				smallest = i;
			}
		}
		return smallest;
	}
	
	// Returns the average of the array of doubles nums
	static double findAverage(double[] nums) {
		double total = 0.0;
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
		}
		return total / nums.length;
	}
}
