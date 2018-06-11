package stack;

/*
 * Class name- Stack
 * This class implements stack functions using Linked List.
 */
public class Stack {
	Node head = null;								//Points to the first node in stack.
	/**
	 * Below functions pushes element at top of the stack.
	 * @param element
	 */
	 public void push( int element ) {
		 Node node = new Node(element);
			if( head == null ) {
				head = node;
			}
			else {
				Node q = head;
				while ( q.next != null ) {
					q = q.next;
				}
				q.next = node;
			}
	 }
	 
	 /**
	  * Below function pops the top element from the stack.
	  */
	 public void pop () {
		 Node q = head , p = null;
		 while( q.next != null ) {
			 p = q;
			 q = q.next;
		 }
		 System.out.println("Popped element is : " + q.data);
		 p.next = null;
	 }
	 
	 /**
	  * Below function displays all the elements of the stack.
	  */
	 public void display() {
			Node q = head;
			while( q != null) {
				System.out.println(q.data);
				q = q.next;
			}
		}
}
