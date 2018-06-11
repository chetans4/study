package queue;

import java.util.Scanner;

/**
 * Class name-QueueMain
 * 
 * @version 1.0
 * @author Jaya Bapna
 */

public class QueueMain {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		Queue queueInstance = new Queue();
		System.out.println("Enter Maximum size of queue");
		queueInstance.size = scan.nextInt();
		int element;
		do{
			int choice;
			System.out.println("***Menu***");
			System.out.println("1. Enqueue ");
			System.out.println("2. Dequeue");
			System.out.println("3. Make empty ");
			System.out.println("4. Get front element");
			System.out.println("5. Display");
			choice = scan.nextInt();
			switch(choice) {
				case 1: System.out.println("Enter element");
						element = scan.nextInt();
						queueInstance.enqueue(element);
						break;
				case 2: int deletedElement = (int) queueInstance.dequeue();
						System.out.println(deletedElement);
						break;
				case 3: queueInstance.makeEmpty();
						break;
				case 4: int frontElement = (int) queueInstance.getFront();
						System.out.println(frontElement);
						break;
				case 5: queueInstance.display();
						break;
				default: System.out.println("Please enter a valid option");   	   
			}
		}while(true);
	}
}
