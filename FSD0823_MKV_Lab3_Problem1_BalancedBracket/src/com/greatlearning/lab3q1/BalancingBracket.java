//Solution Write up
//This code defines a class BalancingBracket that contains methods for determining 
//whether a string of brackets is balanced or not. The user inputs a string through the 
//console, and the program checks to ensure that the string contains only the 
//characters (, ), {, }, [, and ]. If the string is valid, the program uses a Stack to 
//ensure that each opening bracket has a corresponding closing bracket in the correct order. 
//If the brackets are balanced, a message is printed indicating so; otherwise, a message 
//indicates that the brackets are not balanced. The program ensures resource  management 
//by closing the Scanner object after use.

// Declare the package this class is part of
package com.greatlearning.lab3q1;

// Import necessary classes from the Java API
import java.util.Scanner;
import java.util.Stack;

// Define a public class named BalancingBracket
public class BalancingBracket {
	// The main method - entry point of the program
	public static void main(String[] args) {
		// Create a Scanner object to read input from the console
		Scanner scanner = new Scanner(System.in);
		// Prompt the user to enter a string consisting only of brackets and no spaces
		System.out.println("Enter string having ([{}]) and no space:");
		// Read the user input and store it in a variable
		String bracketExpression = scanner.nextLine();

		// Call the isValidInput method to ensure the input string only contains
		// brackets
		if (isValidInput(bracketExpression)) {
			// Call the isBracketIsBalanced method to check if the brackets are balanced
			boolean result = isBracketIsBalanced(bracketExpression);

			// Output the result based on the boolean value returned
			if (result == true) {
				System.out.println("The entered String " + bracketExpression + " has Balanced Brackets");
			} else {
				System.out.println("The entered String " + bracketExpression + " doesn't have Balanced Brackets.");
			}
		} else {
			// If invalid input, print an error message
			System.out.println("Invalid Input: The string should only contain brackets ([{}]).");
		}
		// Close the Scanner object to prevent resource leak
		scanner.close();
	}

	// Method to check if the brackets in the string are balanced
	private static boolean isBracketIsBalanced(String bracketExpression) {
		// Initialize a stack to keep track of opening brackets
		Stack<Character> stack = new Stack<>();
		// Iterate over each character in the string
		for (int i = 0; i < bracketExpression.length(); i++) {
			// Get the current character
			char character = bracketExpression.charAt(i);
			// If it's an opening bracket, push it onto the stack
			if (character == '(' || character == '{' || character == '[') {
				stack.push(character);
				continue;
			}
			// If the stack is empty when expecting to pop, return false (unbalanced)
			if (stack.isEmpty())
				return false;
			// Variable to store the popped character
			char c;
			// Use a switch-case to handle the closing brackets
			switch (character) {
			case ')':
				c = stack.pop();
				// If the popped character isn't a matching opening bracket, return false
				if (c == '{' || c == '[')
					return false;
				break;
			case ']':
				c = stack.pop();
				// If the popped character isn't a matching opening bracket, return false
				if (c == '{' || c == '(')
					return false;
				break;
			case '}':
				c = stack.pop();
				// If the popped character isn't a matching opening bracket, return false
				if (c == '(' || c == '[')
					return false;
				break;
			default:
				break;
			}
		}
		// If the stack is empty after processing all characters, brackets are balanced
		return stack.isEmpty();
	}

	// Method to validate the input string to ensure it only contains brackets
	public static boolean isValidInput(String str) {
		// Use regular expression to match strings that only contain the specified
		// brackets and no
		// other characters
		return str.matches("[\\[\\]\\(\\){}]*");
	}
}
