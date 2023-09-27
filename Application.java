/**
* Application class with isPalindrome method for determining if a String is a
* palindrome and main method to showcase the isPalindrome method. Method isPalindrome
* uses two stacks to compare the first and last half of the target String.
*
* @author aross-sermons
* @version 1.0
* CS215; Lab #2.2
* Fall 2023
*/

import java.util.Scanner;
import java.util.Stack;

public class Application {

	/**
	 * main method making use of ifPalindrome
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sysin = new Scanner(System.in);
		System.out.print("Enter the word or phrase you want to check: ");
		String word = sysin.nextLine(); //String to be checked
		
		System.out.print("\nIs \"" + word + "\" a palindrome? ");
		if(isPalindrome(word)) System.out.println("Yes!");
		else System.out.println("No.");
		
		sysin.close();
	}//end main
	
	/**
	 * The method isPalindrome uses two stacks to check the first
	 * and last half of a String for equality. 
	 *
	 * @param target
	 * @return true if target is a palindrome
	 */
	public static boolean isPalindrome(String target) {
		//Take spaces out of the target and converts it to lower-case.
		target = target.toLowerCase();
		target = target.replaceAll(" ", "");
		
		//Instantiate two stacks that will hold the first and second part of the String.
		Stack<Character> cStackOne = new Stack<Character>();
		Stack<Character> cStackTwo = new Stack<Character>();
		
		//Removes the middle 1 character if the target is uneven in length.
		//Removes the middle 2 characters if the target is even in length.
		target.replaceAll(String.valueOf(target.charAt(target.length()/2)), "");
		
		//Loop for populating the two stacks.
		for(int i = 0; i < (target.length()/2); i++) {
			cStackOne.push((Character)(target.charAt(i))); //Adds each character from the first half to the first stack.
			cStackTwo.push((Character)(target.charAt(target.length()-1-i))); //Adds each character from the second half to the second stack.
		}//end loop
		
		boolean isPalindrome = true;
		
		//Compares each Character object in the stacks.
		for(int i = 0; i < cStackOne.size(); i++) {
			if(cStackOne.peek() == cStackTwo.peek()) {
				cStackOne.pop();
				cStackTwo.pop();
			}else {
				isPalindrome = false;
			}//end if
		}//end loop
		
		return isPalindrome;
	}//end isPalindrome

}//end Application.java
