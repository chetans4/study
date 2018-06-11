package doublylist;

/*
 * Class name-Node
 * This class creates node for the list.
 */
public class Node {
	Node prev;						//Points to the previous node in the list
	int data;						//Stores the value of node
	Node next;						//Points to the next node in the list
	public Node(int element) {
		prev = null;
		data = element;
		next = null;
	}
}