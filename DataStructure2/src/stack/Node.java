package stack;

/*
 * Class name- Node
 * This class creates node for Stack.
 */
public class Node {
	int data;						//Stores the value of node
	Node next;						//Points to the next node in the list
	public Node(int element) {
		data = element;
		next = null;
	}
}
