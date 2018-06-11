package singlylist;

/*
 * Class name-Node
 * This class creates node for the list.
 */
public class Node {
	int data;						//Stores the value of node
	Node next;						//Points to the next node in the list
	public Node(int element) {
		data = element;
		next = null;
	}
}
