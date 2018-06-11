package com.metacube.pretree;

/*
 * Class name-BinaryTree
 * This class creates a binary tree.
 */
public class BinaryTrees {
	Node root = null;											//Points to the root node of the tree.
	/**
	 * Below functions creates binary tree by comparing value with the root node of current node.
	 * If value of current node is smaller than its root, then create left node.
	 * If value of current node is grater than its root, then create right node.
	 * @param current
	 * @param element
	 * @return current node
	 */
	public Node createTree(Node current, int element)  {
		 Node node = new Node(element);
		 if ( current == null ) {
			return new Node(element); 
		 }	 
		if ( element < current.data) {								//Compares value of current node with its root
			current.left = createTree(current.left, element);
		}
		else if( element > current.data) {
			current.right = createTree(current.right, element);
		}
		else {
			return current;
		}
		return current;
	}
	
	public void insert(int value) {
	    root = createTree(root, value);
	}
	
}
