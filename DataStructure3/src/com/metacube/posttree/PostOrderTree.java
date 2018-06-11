package com.metacube.posttree;

/*
 * Class name-PostOrderTree
 * This class do the traversal of tree in post order.
 */
public class PostOrderTree {
	int [] postOrderArray = new int[7];					//Array to store values as tree is traversed.
	static int i = 0;
	/**
	 * Below functions performs the post order traversal of the tree.
	 * @param node
	 */
	public void printPostOrder(Node node) {
		if ( node == null ) {
			return;
		}
		
		printPostOrder(node.left);
		printPostOrder(node.right);
		postOrderArray[i] = node.data;				//Stores the value in array.
		i++;
	}
}
