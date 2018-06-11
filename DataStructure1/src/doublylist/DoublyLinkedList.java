package doublylist;

import java.util.Scanner;

/**
 * Class name-DoublyLinkedList
 * 
 * @version 1.0
 * @author Jaya Bapna
 */

public class DoublyLinkedList {
	static int size = 0;
	Node head = null;							//Points to the first node in the Linked List.
	/**
	 * Below function inserts node in the Linked list.
	 * @param element
	 */
	public void insertion(int element) {
		Node node = new Node(element);
		if( head == null ) {
			head = node;
			size++;
		}
		else {
			Node q = head;
			while ( q.next != null ) {
				q = q.next;
			}
			q.next = node;
			node.prev = q;
			size++;
		}
		display();
	}
	
	/**
	 * Below function inserts the particular element at specific location.
	 * @param element
	 * @param location
	 */
	public void insertAtLocation(int element, int location) {
		Node node = new Node(element);
		if ( location == 0) {
			node.next = head;
			head = node; 
			size++;
		}
		else {
		Node q, p = null;
		q = head;
		int loc = 1;
		while ( q != null ) {
			if ( loc == location){
				break;
			}
			else{
			p = q;
			q = q.next;
			}
			loc++;
		}
			node.next = p.next;
			p.next = node;
			size++;
		}	
		display();
	}
	
	/**
	 * Below function removes the particular element from the Linked list.
	 * @param element
	 */
	public void removeElement (int element) {
		if ( head == null) {
			System.out.println("List is empty");
		}
		else if ( head.data == element) {
			head = head.next;
		}
		else {
			Node q, current = null;
			q = head;
			current = q.next;
			while ( q != null ) {
				if ( current.data == element) {
					q.next = current.next;
				}
				q = q.next;
				current = current.next;
			}
		}
		display();
	}
	
	/**
	 * Below function removes the element on the basis of its location specified.
	 * @param location
	 */
	public void removeAtLocation (int location) {
		if ( head == null) {
			System.out.println("List is empty");
		}
		else if (location == 0) {
			head = head.next;
		}
		else{
			Node q, current = null;
			q = head;
			current = q.next;
			int loc = 1;
			while ( q != null) {
				if( loc == location) {
					q.next = current.next;
				}
				q = q.next;
				current = current.next;
				loc++;
			}
		}
		display();
	}
	
	/**
	 * Below function retrieves element on basis of location.
	 */
	public void retrieveElement(int location) {
		if ( location == 0 ){
			System.out.println(head.data);
		}
		else {
			int loc = 1;
			Node q = head;
			while ( loc != location) {
				q = q.next;
				loc++;
			}
			System.out.println(q.data);
		}
	}
	/**
	 * Below function reverse the Linked list.
	 */
	public void reverseList() {
		Node p = null, q = null,  current = head;
		while( current != null) {
			q = current.next;
			current.next = p;
			p = current;
			current = q;
		}
		head = p;
		display();
	}
	
	/**
	 * Below function displays elements in the list.
	 */
	public void display() {
		Node q = head;
		while( q != null) {
			System.out.println(q.data);
			q = q.next;
		}
	}	
	
	public static void main(String args[]) {
		DoublyLinkedList doublyLikedListInstance = new DoublyLinkedList();
		Scanner scan = new Scanner(System.in);
		int element, location;
		do{
			int choice;
			System.out.println("***Menu***");
			System.out.println("1. Insert element ");
			System.out.println("2. Inserting element at particular location");
			System.out.println("3. Remove element");
			System.out.println("4. Removing element at particular location");
			System.out.println("5. Reverse list");
			System.out.println("6. Retrieve element on basis of location");
			System.out.println("7. Sort list");
			choice = scan.nextInt();
			switch(choice) {
				case 1: System.out.println("Enter element");
						element = scan.nextInt();
						doublyLikedListInstance.insertion(element);
						break;
				case 2: System.out.println("Enter element");
						element = scan.nextInt();
						System.out.println("Enter location");
						location = scan.nextInt();
						doublyLikedListInstance.insertAtLocation(element, location);
						break;
				case 3:System.out.println("Enter element");
					   element = scan.nextInt();
					   doublyLikedListInstance.removeElement(element);
					   break;
				case 4:System.out.println("Enter location");
					   location = scan.nextInt();
					   doublyLikedListInstance.removeAtLocation(location);
					   break;
				case 5: doublyLikedListInstance.reverseList();
					   break;
				case 6:System.out.println("Enter location");
			           location = scan.nextInt();
				       doublyLikedListInstance.retrieveElement(location);
				       break;
				default:
					    System.out.println("Please enter a valid option");   	   
			}
		}while(true);	
	}
}