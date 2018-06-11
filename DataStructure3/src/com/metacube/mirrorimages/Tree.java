package com.metacube.mirrorimages;

/*
 * Class name-BinaryTree
 * This class creates a binary tree.
 */
public class Tree {
	Node root = null;														//Points to the root node of the tree.
	
	/**
	 * Below functions creates binary tree by comparing value with the root node of current node.
	 * If value of current node is smaller than its root, then create left node.
	 * If value of current node is grater than its root, then create right node.
	 * @param current
	 * @param element
	 * @return current node
	 */
	public Node createTree( Node current, int element) {
		Node node = new Node(element);
		if ( current == null ) {
			return new Node(element);
		}
		if( element < current.data ) {
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
	
	/**
	 * Below functions creates reverse binary tree by comparing value with the root node of current node.
	 * If value of current node is greater than its root, then create left node.
	 * If value of current node is smaller than its root, then create right node.
	 * @param current
	 * @param element
	 * @return current node
	 */
	public Node createReverseTree( Node current, int element) {
		Node node = new Node(element);
		if ( current == null ) {
			return new Node(element);
		}
		if( element < current.data ) {
			current.right = createReverseTree(current.right, element);
		}
		else if( element > current.data) {
			current.left = createReverseTree(current.left, element);
		}
		else {
			return current;
		}
		return current;
	}
	
	public void insert(int value) {
		root = createTree(root, value);
	}
	
	public void insertReverse(int value) {
		root = createReverseTree(root, value);
	}
}
