package practice;

import java.util.Scanner;

/** A program that calculates the time on a clock in some number of weeks, days, hours, and minutes.
 * 
 * (We will ignore things like Daylight Savings Time and assume that all days have 24 hours.)
 */

public class ClockCalculator {
	
	// Name constants for the program
	// avoids having "magic numbers" in our program
	static final int HOURS_ON_CLOCK = 12;
	static final int MINUTES_IN_HOUR = 60;
	
	
	/** Accepts user input and returns in an int[]
	 * Without knowing object-oriented programming, there is no good way to 
	 * return multiple values. Therefore, we are using an int[] for now.
	 */
	static int[] acceptInput(Scanner scanner) {
		// Prompt user for input:
		System.out.println("Enter the current time on the clock.");
		System.out.print("Hours: ");
		int hoursHand = scanner.nextInt();
		
		// Validate the input for 'hoursHand' so that it is between 1 and 12, inclusive.
		while (hoursHand < 1 || hoursHand > 12) {
			System.out.println("Error: please enter a value between 1 and 12:");
			hoursHand = scanner.nextInt();
		}
		
		System.out.print("Minutes: ");
		int minutesHand = scanner.nextInt();
		
		/* ***********************************************************************
		 * FILL IN (#1):
		 * Validate the input for 'minutesHand' so that it is between 0 and 59, inclusive.
		 * Use the code for validating 'hoursHand' as a guide.
		 * ***********************************************************************
		 */
		 
		// None of this has to be validated
		System.out.println("Enter the amount of elapsed time.");
		// Hours
		System.out.print("Number of hours: ");
		int hoursFromNow = scanner.nextInt();
		// Minutes
		System.out.print("Number of minutes: ");
		int minutesFromNow = scanner.nextInt();
		
		return new int[] {hoursHand, minutesHand, hoursFromNow, minutesFromNow}; // Java array literal
	}
	
	/** Computes and UPDATES the new position of the minute hand
	 * RETURNS the number of hours that have elapsed
	 * 
	 * Again, we have to return multiple values using an array here.
	 */
	static int[] computeMinutes(int minutesHand, int minutesFromNow) {
		/* ***********************************************************************
		 * FILL IN (#2):
		 * Compute the number of hours that elapsed and new position of the minutes hand.
		 * 
		 * Hint: These correspond to the quotient and remainder (respectively) when 
		 * you divide the total number of minutes by the number of minutes in an hour.
		 * 
		 * Style Tip: Don't use a "magic number!" Use the named constant from above.
		 * ***********************************************************************
		 */
		
		
		// Return the elapsed hours and new position of the minutes hand using a Java array literal 
		return new int[] {elapsedHours, minutesHand};
	}
	
	/** Uses the value in 'hours' to calculate the new value of 'hoursHand' and updates it.
	 * Returns void for consistency with the 'computeMinutes()' method.
	 */
	static int computeHours(int hoursHand, int hoursFromNow) {
		/* ***********************************************************************
		 * FILL IN (#3):
		 * Compute and return the new position of the hours hand.
		 * 
		 * Hint: Use the Java modulo operator (%) with the number of hours on the clock.
		 * ***********************************************************************
		 */
	}
	
	/** Prints the solution with correct formatting */
	static void printAnswer(int hours, int minutes) {
		// For single-digit numbers of minutes, we write a '0' in front of the number
		if (minutes < 10)
			System.out.println("The new time is " + hours + ":0" + minutes);
		else
			System.out.println("The new time is " + hours + ":" + minutes);
	}
	
	public static void main(String[] args) {
		// Initialize
		boolean done = false;
		Scanner scanner = new Scanner(System.in);
		
		// Loop to allow repeated runs
		do {
			int[] input = acceptInput(scanner);
			
			// Extract values from output array ("multiple outputs")
			int hoursHand = input[0];
			int minutesHand = input[1];
			int hoursFromNow = input[2];
			int minutesFromNow = input[3];
			 
			int[] result = computeMinutes(minutesHand, minutesFromNow);
			
			// Extract values from output array ("multiple outputs")
			hoursFromNow += result[0];
			minutesHand = result[1]; // set minutes hand
			
			hoursHand = computeHours(hoursHand, hoursFromNow); // sets the hours hand
			
			// Rename "0 o'clock" as 12 o'clock
			if (hoursHand == 0)
				hoursHand = 12;
			
			/* Print answer:
			 * hoursHand now contains the new position of the hours hand
			 * minutesHand now contains the new position of the minutes hand
			 */
			
			printAnswer(hoursHand, minutesHand);
			
			System.out.println("Go again? y/n");
			String answer = scanner.next();
			System.out.println(); // blank line
			
			/* ***********************************************************************
			 * FILL IN (#4):
			 * If 'answer' is "y", set 'done' to 'false'.
			 * If 'answer' is "n", set 'done' to 'true'.
			 * ***********************************************************************
			 */
			
		} while(!done);
		
		scanner.close();
	}
}
