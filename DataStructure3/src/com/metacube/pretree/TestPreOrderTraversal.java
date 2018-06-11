package com.metacube.pretree;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.posttree.BinaryTree;
import com.metacube.posttree.PostOrderTree;

public class TestPreOrderTraversal {

	@Test
	public void testPreOrder() {
		BinaryTrees tree = new BinaryTrees();
		PreOrderTree preOrder = new PreOrderTree();
		tree.insert(6);
	    tree.insert(4);
	    tree.insert(8);
	    tree.insert(3);
	    tree.insert(5);
	    tree.insert(7);
	    tree.insert(9);
	    preOrder.printPreOrder(tree.root);
	    int expected[] = {6,4,3,5,8,7,9};
	    assertArrayEquals(expected, preOrder.preOrderArray);
	}

}
