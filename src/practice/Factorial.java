package example;

import java.util.Scanner;

public class Factorial {
	
	/* Input: Nonnegative integer n
	 * Output: n!
	 * Iterative solution
	  */
	static int factorial(int n) {
		// Initialize "empty product"
		int toReturn = 1;
		
		/* Main loop
		 * On the last iteration, i == 1
		 * Note that if n == 0, the loop never executes and 'toReturn' remains 1
		 */
		for (int i = n; i > 0; i--)
			toReturn *= i; // Equivalent to toReturn = toReturn * i;
		
		return toReturn;
	}
	
	// Fact: any iterative algorithm can be rewritten using recursion and vice versa
	static int recursiveFactorial(int n) {
		/* For recursion, we need a recursive call to the method
		 * and a base case to stop the recursion.
		 */
		
		// Base case
		if (n == 0)
			return 1;
		// Recursive call
		else return n*recursiveFactorial(n-1);
	}
	
	
	public static void main(String[] args) {
		// Set up a scanner to accept user input
		Scanner scanner = new Scanner(System.in);
		
		// Prompt user for input
		System.out.println("Enter a positive integer:");
		int n = scanner.nextInt();
		
		// Compute and print factorial
		System.out.println(factorial(n));
		System.out.println(recursiveFactorial(n));
		
		scanner.close(); // closes the input stream and frees up system resources
	}

}