package com.metacube.posttree;

/*
 * Class name-Node
 * This class creates nodes for the binary tree.
 */
public class Node {
	int data;							//Stores the value of node
	Node left;							//Points to left node
	Node right;							//Points to right node
	public Node(int element) {
		data = element;
		left = null;
		right = null;
	}
}
