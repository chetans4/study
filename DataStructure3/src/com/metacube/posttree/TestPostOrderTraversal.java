package com.metacube.posttree;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPostOrderTraversal {

	@Test
	public void testPostOrderTraversalSuccess() {
		BinaryTree tree = new BinaryTree();
		PostOrderTree postOrder = new PostOrderTree();
		tree.insert(6);
	    tree.insert(4);
	    tree.insert(8);
	    tree.insert(3);
	    tree.insert(5);
	    tree.insert(7);
	    tree.insert(9);
	    postOrder.printPostOrder(tree.root);
	    int expected[] = {3,5,4,7,9,8,6};
	    assertArrayEquals(expected, postOrder.postOrderArray);
	}

}
