package com.metacube.pretree;

/*
 * Class name-PreOrderTree
 * This class do the traversal of tree in pre order.
 */
public class PreOrderTree {
	int preOrderArray[] = new int[7];					//Array to store values as tree is traversed.
	static int i = 0;
	/**
	 * Below functions performs the post order traversal of the tree.
	 * @param node
	 */
	public void printPreOrder( Node node ) {
		if ( node == null ) {
			return;
		}
		
		preOrderArray[i++] = node.data;				//Stores the value in array.
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

}
