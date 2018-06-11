package stack;

/**
 * Class name-StackMain
 * 
 * @version 1.0
 * @author Jaya Bapna
 */

import java.util.Scanner;

public class StackMain {
	public static void main(String args[]) {
		Stack stackInstance = new Stack();
		Scanner scan = new Scanner(System.in);
		int element;
		do{
			int choice;
			System.out.println("***Menu***");
			System.out.println("1. Push element ");
			System.out.println("2. Pop element");
			System.out.println("3. Display");
			choice = scan.nextInt();
			switch(choice) {
				case 1: System.out.println("Enter element");
						element = scan.nextInt();
						stackInstance.push(element);
						break;
				case 2: stackInstance.pop();
						break;
				case 3: stackInstance.display();
						break;
				default: System.out.println("Please enter a valid option");   	   
			}
		}while(true);
	}
}
